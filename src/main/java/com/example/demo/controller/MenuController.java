package com.example.demo.controller;

import com.example.demo.Exception.ErrorCode;
import com.example.demo.base.BaseDto;
import com.example.demo.contants.GlobalContents;
import com.example.demo.entity.MenuEntity;
import com.example.demo.entity.ProUserAdminEntity;
import com.example.demo.pojo.TreeBaseData;
import com.example.demo.service.MenuService;
import com.example.demo.util.GsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单controller
 */

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单
     *
     * @param model
     * @return
     */
    @GetMapping("/queryAllMenu")
    String queryALlMenu(Model model) {
        List<MenuEntity> menuList = menuService.queryAllMenu();
        model.addAttribute("data", GsonUtil.gson2String(menuList));
        return "menu/menuList";
    }

    /**
     * 选择父级菜单
     *
     * @param model
     * @return
     */
    @GetMapping("/getParentMenu")
    @ResponseBody
    String getParentMenu(Model model) {
        List<MenuEntity> menuList = menuService.queryParentMenu();
        List<TreeBaseData> data = new ArrayList<>();
        TreeBaseData root = new TreeBaseData();
        root.setId(0);
        root.setName("根目录");
        data.add(root);

        //获取所有一级菜单
        List<MenuEntity> rootMenu = menuList.stream().filter(item -> item.getPid() == 0).collect(Collectors.toList());

        for (MenuEntity menu : rootMenu) {
            TreeBaseData treeBaseData = new TreeBaseData();
            treeBaseData.setId(menu.getId());
            treeBaseData.setName(menu.getMenuName());
            List<TreeBaseData> childMenu = getChildMenu(menu, menuList);
            treeBaseData.setChildren(childMenu);
            data.add(treeBaseData);
        }
        return GsonUtil.gson2String(data);
    }


    /**
     * 递归查找下级菜单
     *
     * @param menu
     * @param menuList
     * @return
     */
    private List<TreeBaseData> getChildMenu(MenuEntity menu, List<MenuEntity> menuList) {
        List<MenuEntity> list = menuList.stream().filter(item -> item.getPid() == menu.getId()).collect(Collectors.toList());

        //查找下级节点
        List<TreeBaseData> childList = new ArrayList<>();
        for (MenuEntity child : list) {
            TreeBaseData childData = new TreeBaseData();
            childData.setId(child.getId());
            childData.setName(child.getMenuName());
            childData.setUrl(child.getMenuUrl());
            childData.setIcon(menu.getMenuIcon());
            childData.setChildren(getChildMenu(child, menuList));
            childList.add(childData);
        }

        if (null == list || list.isEmpty())
            return null;
        return childList;
    }


    /**
     * 新增菜单
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/addMenu")
    String addMenu(Model model, @Param("id") Integer id) {
        return "menu/addMenu";
    }

    /**
     * 左侧菜单
     *
     * @return
     */
    @GetMapping("/navMenu")
    String navMenu(Model model) {
        List<MenuEntity> menuList = menuService.queryParentMenu();

        List<TreeBaseData> data = new ArrayList<>();
        //获取所有一级菜单
        List<MenuEntity> rootMenu = menuList.stream().filter(item -> item.getPid() == 0)
                .filter(item -> item.getMenuPosation() == 0)
                .collect(Collectors.toList());
        for (MenuEntity menu : rootMenu) {
            TreeBaseData treeBaseData = new TreeBaseData();
            treeBaseData.setId(menu.getId());
            treeBaseData.setName(menu.getMenuName());
            treeBaseData.setUrl(menu.getMenuUrl());
            treeBaseData.setIcon(menu.getMenuIcon());
            List<TreeBaseData> childMenu = getChildMenu(menu, menuList);
            treeBaseData.setChildren(childMenu);
            data.add(treeBaseData);
        }

        model.addAttribute("data", data);
        return "/menu/navMenu";
    }

    @GetMapping("/editMenu")
    String editMenu(Model model, @Param("id") Integer id) {
        MenuEntity menu = menuService.queryMenuById(id);
        model.addAttribute("menu", menu);
        return "menu/editMenu";
    }

    /**
     * 保存新赠菜单信息
     *
     * @param user
     * @return
     */
    @PostMapping("/saveMenu")
    @ResponseBody
    String saveMenu(@Validated MenuEntity menu, BindingResult errors) {
        BaseDto bd = new BaseDto();
        StringBuilder validErrors = new StringBuilder();
        try {
            int res = menuService.saveMenu(menu);
            bd.setSucceed(res > 0 ? GlobalContents.OPRATION_SUCESS : GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.SUCCESS.getCode());
            bd.setMsg(ErrorCode.SUCCESS.getMsg());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            if (errors.hasErrors()) {
                if (errors != null) {
                    List<ObjectError> allErrors = errors.getAllErrors();
                    for (ObjectError error : allErrors) {
                        String message = error.getDefaultMessage();
                        validErrors.append(message).append(",");
                        System.out.printf(validErrors.toString());
                    }
                }
            }
            bd.setSucceed(GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.ERROR.getCode());
            bd.setMsg(validErrors.toString());
        } catch (Exception e) {
            e.printStackTrace();
            bd.setSucceed(GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.ERROR.getCode());
            bd.setMsg(ErrorCode.ERROR.getMsg());
        }
        return GsonUtil.gson2String(bd);
    }

    /**
     * 保存新赠菜单信息
     *
     * @param user
     * @return
     */
    @PutMapping("/saveEditMenu")
    @ResponseBody
    String saveEditMenu(@Validated MenuEntity menu, BindingResult errors) {
        BaseDto bd = new BaseDto();
        StringBuilder validErrors = new StringBuilder();
        try {
            int res = menuService.saveEditMenu(menu);
            bd.setSucceed(res > 0 ? GlobalContents.OPRATION_SUCESS : GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.SUCCESS.getCode());
            bd.setMsg(ErrorCode.SUCCESS.getMsg());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            if (errors.hasErrors()) {
                if (errors != null) {
                    List<ObjectError> allErrors = errors.getAllErrors();
                    for (ObjectError error : allErrors) {
                        String message = error.getDefaultMessage();
                        validErrors.append(message).append(",");
                        System.out.printf(validErrors.toString());
                    }
                }
            }
            bd.setSucceed(GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.ERROR.getCode());
            bd.setMsg(validErrors.toString());
        } catch (Exception e) {
            e.printStackTrace();
            bd.setSucceed(GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.ERROR.getCode());
            bd.setMsg(ErrorCode.ERROR.getMsg());
        }
        return GsonUtil.gson2String(bd);
    }

}
