package com.example.demo.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 菜单表
 *
 * @date 2019-02-16 09:28:53
 */

public class MenuEntity implements Serializable {

    /**
     * 菜单ID
     */
    private Integer id;
    /**
     * 菜单名称
     */
    @Valid
    @NotNull(message = "菜单名称不能为空")
    private String menuName;
    /**
     * 菜单url
     */
    @Valid
    @NotNull(message = "菜单url不能为空")
    private String menuUrl;
    /**
     * 菜单路径后面跟的参数
     */
    private String menuParam;
    /**
     * 菜单验证规则
     */
    @Valid
    @NotNull(message = "验证规则不能为空")
    private String menuRole;
    /**
     * 请求方式
     */
    @Valid
    @NotNull(message = "请求方式不能为空")
    private String acessType;
    /**
     * 状态  0:隐藏 1:显示
     */
    private Integer menuState;
    /**
     * 是否是菜单头部 1:是 0:不是
     */
    private Integer isHeader;
    /**
     * 父级菜单ID
     */
    @Valid
    @NotNull(message = "父级菜单不能为空")
    private Integer pid;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 菜单备注
     */
    private String menuRemark;
    /**
     * 菜单显示顺序
     */
    @Valid
    @NotNull(message = "显示顺序不能为空")
    private Integer menuOrder;
    /**
     * 菜单类型 0:可视化界面菜单 1:非可视化菜单
     */
    private Integer menuType;
    /**
     * 菜单位置 0:左侧显示 1:顶部显示
     */
    private Integer menuPosation;

    /**
     * 设置：菜单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：菜单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取：菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置：菜单url
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 获取：菜单url
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置：菜单路径后面跟的参数
     */
    public void setMenuParam(String menuParam) {
        this.menuParam = menuParam;
    }

    /**
     * 获取：菜单路径后面跟的参数
     */
    public String getMenuParam() {
        return menuParam;
    }

    /**
     * 设置：菜单验证规则
     */
    public void setMenuRole(String menuRole) {
        this.menuRole = menuRole;
    }

    /**
     * 获取：菜单验证规则
     */
    public String getMenuRole() {
        return menuRole;
    }

    /**
     * 设置：请求方式
     */
    public void setAcessType(String acessType) {
        this.acessType = acessType;
    }

    /**
     * 获取：请求方式
     */
    public String getAcessType() {
        return acessType;
    }

    /**
     * 设置：状态  0:隐藏 1:显示
     */
    public void setMenuState(Integer menuState) {
        this.menuState = menuState;
    }

    /**
     * 获取：状态  0:隐藏 1:显示
     */
    public Integer getMenuState() {
        return menuState;
    }

    /**
     * 设置：是否是菜单头部 1:是 0:不是
     */
    public void setIsHeader(Integer isHeader) {
        this.isHeader = isHeader;
    }

    /**
     * 获取：是否是菜单头部 1:是 0:不是
     */
    public Integer getIsHeader() {
        return isHeader;
    }

    /**
     * 设置：父级菜单ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取：父级菜单ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置：菜单图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * 获取：菜单图标
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置：菜单备注
     */
    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }

    /**
     * 获取：菜单备注
     */
    public String getMenuRemark() {
        return menuRemark;
    }

    /**
     * 设置：菜单显示顺序
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * 获取：菜单显示顺序
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * 设置：菜单类型 0:可视化界面菜单 1:非可视化菜单
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取：菜单类型 0:可视化界面菜单 1:非可视化菜单
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 设置：菜单位置 0:左侧显示 1:顶部显示
     */
    public void setMenuPosation(Integer menuPosation) {
        this.menuPosation = menuPosation;
    }

    /**
     * 获取：菜单位置 0:左侧显示 1:顶部显示
     */
    public Integer getMenuPosation() {
        return menuPosation;
    }
}
