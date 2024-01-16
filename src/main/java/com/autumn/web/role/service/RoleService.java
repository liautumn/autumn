package com.autumn.web.role.service;

import com.autumn.common.result.Result;
import com.autumn.web.role.entity.Role;
import com.autumn.web.role.entity.RoleInsertDto;
import com.autumn.web.role.entity.RoleSelectDto;
import com.autumn.web.role.entity.RoleUpdateDto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lqz
 * @date 2023-07-09 19:34:33
 * 角色信息 Service
 */
public interface RoleService extends IService<Role> {

    /**
     * 角色信息查询
     */
    Result selectRole(RoleSelectDto roleSelectDto);

    /**
     * 角色信息新增
     */
    Result insertRole(RoleInsertDto roleInsertDto);

    /**
     * 角色信息修改
     */
    Result updateRole(RoleUpdateDto roleUpdateDto);

    /**
     * 角色信息删除
     */
    Result deleteRole(String ids);

    /**
     * 角色信息excel导出
     */
    void exportRole(RoleSelectDto roleSelectDto, HttpServletResponse response);

    /**
     * 角色信息excel导入
     */
    Result importRole(MultipartFile file);

    /**
     * 获取所属角色下拉数据
     */
    Result getRoleList(RoleSelectDto roleSelectDto);
}
