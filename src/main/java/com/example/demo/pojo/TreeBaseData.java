package com.example.demo.pojo;

import java.util.List;

/**
 * 树形下拉框数据结构
 */
public class TreeBaseData {
    private Integer id;
    private String name;
    private List<TreeBaseData> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<TreeBaseData> getChildren() {
        return children;
    }

    public void setChildren(List<TreeBaseData> children) {
        this.children = children;
    }
}
