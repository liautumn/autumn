package com.autumn.web.menu.entity;

import com.autumn.common.page.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuTreeDto extends Page implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 菜单ID
     */
    private String id;
    /**
     * 父菜单ID
     */
    private String parentId;
    /**
     * 菜单类型（0目录 1菜单 2按钮）
     */
    private List<String> menuType;
    /**
     * 是否隐藏（0是 1否）
     */
    private String isHide;
    /**
     * 是否停用（0是 1否）
     */
    private String status;
    /**
     * 是否要根节点
     */
    private Boolean isGetRoot = false;
}
