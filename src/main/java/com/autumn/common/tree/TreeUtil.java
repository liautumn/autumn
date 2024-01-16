package com.autumn.common.tree;

import com.autumn.common.dictionary.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    //建立树形结构
    public static <T extends TreePublic> List<? extends TreePublic> buildTree(List<? extends TreePublic> list) {
        List<TreePublic> treeMenus = new ArrayList<>();
        for (TreePublic menuNode : getRootNode(list)) {
            menuNode = buildChildTree(menuNode, list);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private static TreePublic buildChildTree(TreePublic pNode, List<? extends TreePublic> list) {
        List<TreePublic> childMenus = new ArrayList<>();
        for (TreePublic menuNode : list) {
            if (menuNode.getParentId().equals(pNode.getId())) {
                childMenus.add(buildChildTree(menuNode, list));
            }
        }
        if (childMenus != null) {
            pNode.setChildren(childMenus);
            pNode.setChildrenNum(childMenus.size());
        }
        return pNode;
    }

    //获取根节点
    private static List<? extends TreePublic> getRootNode(List<? extends TreePublic> list) {
        List<TreePublic> rootMenuLists = new ArrayList<>();
        for (TreePublic menuNode : list) {
            if (menuNode.getParentId().equals(Dictionary.ROOTID)) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

    /**
     * 将树状结构转换为平铺数据结构(将含有children的树状结构转换为仅有节点和父节点的对象列表)
     *
     * @param list 树状结构数据列表
     * @param <T>  任意类型参数
     * @return 平铺数据结构列表
     */
    public static <T extends TreePublic> List<? extends TreePublic> convertToObjList(List<? extends TreePublic> list) {
        List<TreePublic> treeMenus = new ArrayList<>();
        for (TreePublic menuNode : list) {
            if (menuNode.getChildren() != null) {
                treeMenus.add(menuNode);
                convertToObjList(menuNode.getChildren(), treeMenus);
            } else {
                treeMenus.add(menuNode);
            }
        }
        return treeMenus;
    }

    private static <T extends TreePublic> void convertToObjList(List<? extends TreePublic> source, List<TreePublic> outList) {
        if (outList == null) {
            outList = new ArrayList<>();
        }
        for (TreePublic tTreeStructure : source) {
            if (tTreeStructure.getChildren() != null) {
                outList.add(tTreeStructure);
                convertToObjList(tTreeStructure.getChildren(), outList);
            } else {
                outList.add(tTreeStructure);
            }
        }
    }

}
