package com.example.demo.controller;

import com.example.demo.contants.GlobalContents;
import com.example.demo.Exception.ErrorCode;
import com.example.demo.base.BaseDto;
import com.example.demo.entity.ProUserAdminEntity;
import com.example.demo.service.ProUserService;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台用户controller
 */

@Controller
public class UserController {

    @Autowired
    private ProUserService userService;

    /**
     * 查询所有用户
     *
     * @param model
     * @param pageNo
     * @return
     */
    @GetMapping("/queryAll")
    String queryAll(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page, HttpServletRequest request) {
        List<ProUserAdminEntity> list = userService.queryALl(page);
        String pager = PageTool.getInstance().setData(list, request).render();
        model.addAttribute("pageInfo", list);
        model.addAttribute("page", pager);
        return "user/userList";
    }

    /**
     * 新增用户
     *
     * @return
     */
    @GetMapping("/addUser")
    String addUser() {
        return "/user/addUser";
    }

    /**
     * 修改用户
     *
     * @return
     */
    @GetMapping("/editUser")
    String editUser(Model model, String userId) {
        ProUserAdminEntity user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/editUser";
    }

    /**
     * 保存新用户
     *
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    @ResponseBody
    String saveUser(@Validated ProUserAdminEntity user, BindingResult errors) {
        BaseDto bd = new BaseDto();
        StringBuilder validErrors = new StringBuilder();
        try {
            int res = userService.addUser(user);
            bd.setSucceed(res > 0 ? GlobalContents.OPRATION_SUCESS : GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.SUCCESS.getCode());
            bd.setMsg(ErrorCode.SUCCESS.getMsg());
        } catch (DataIntegrityViolationException e) {
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
            bd.setSucceed(GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.ERROR.getCode());
            bd.setMsg(ErrorCode.ERROR.getMsg());
        }
        return GsonUtil.gson2String(bd);
    }

    /**
     * 保存修改后的用户
     *
     * @param user
     * @return
     */
    @PutMapping("/mergeUser")
    @ResponseBody
    String mergeUser(@Validated ProUserAdminEntity user, BindingResult errors) {
        BaseDto bd = new BaseDto();
        StringBuilder validErrors = new StringBuilder();
        try {
            int res = userService.mergeUser(user);
            bd.setSucceed(res > 0 ? GlobalContents.OPRATION_SUCESS : GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.SUCCESS.getCode());
            bd.setMsg(ErrorCode.SUCCESS.getMsg());
        } catch (DataIntegrityViolationException e) {
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
            bd.setSucceed(GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.ERROR.getCode());
            bd.setMsg(ErrorCode.ERROR.getMsg());
        }
        return GsonUtil.gson2String(bd);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/deleteUser")
    @ResponseBody
    String deleteUser(String userId) {
        BaseDto bd = new BaseDto();
        try {
            int res = userService.deleteUser(userId);
            bd.setSucceed(res > 0 ? GlobalContents.OPRATION_SUCESS : GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.SUCCESS.getCode());
            bd.setMsg(ErrorCode.SUCCESS.getMsg());
        } catch (Exception e) {
            bd.setSucceed(GlobalContents.OPRATION_FAILD);
            bd.setCode(ErrorCode.ERROR.getCode());
            bd.setMsg(ErrorCode.ERROR.getMsg());
        }
        return GsonUtil.gson2String(bd);
    }
}
