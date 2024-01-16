package com.autumn.web.menu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 当前路由为详情页时，需要高亮的菜单
     */
    private String activeMenu;
    /**
     * 是否为外链
     */
    private String isLink;
    /**
     * 是否隐藏（0是 1否）
     */
    private Boolean isHide;
    /**
     * 是否全屏显示（0是 1否）
     */
    private Boolean isFull;
    /**
     * 是否固定页（0是 1否）
     */
    private Boolean isAffix;
    /**
     * 是否缓存（0是 1否）
     */
    private Boolean isKeepAlive;
}
