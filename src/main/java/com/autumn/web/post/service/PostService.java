package com.autumn.web.post.service;

import com.autumn.common.result.Result;
import com.autumn.web.post.entity.Post;
import com.autumn.web.post.entity.PostInsertDto;
import com.autumn.web.post.entity.PostSelectDto;
import com.autumn.web.post.entity.PostUpdateDto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lqz
 * @date 2023-06-19 09:56:30
 * 岗位信息 Service
 */
public interface PostService extends IService<Post> {

    /**
     * 岗位信息查询
     */
    Result selectPost(PostSelectDto postSelectDto);

    /**
     * 岗位信息新增
     */
    Result insertPost(PostInsertDto postInsertDto);

    /**
     * 岗位信息修改
     */
    Result updatePost(PostUpdateDto postUpdateDto);

    /**
     * 岗位信息删除
     */
    Result deletePost(String ids);

    /**
     * 岗位信息excel导出
     */
    void exportPost(PostSelectDto postSelectDto, HttpServletResponse response);

    /**
     * 岗位信息excel导入
     */
    Result importPost(MultipartFile file);

    /**
     * 所属岗位下拉数据
     */
    Result getPostList(PostSelectDto postSelectDto);
}
