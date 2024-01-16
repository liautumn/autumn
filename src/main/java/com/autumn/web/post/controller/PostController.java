package com.autumn.web.post.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.autumn.common.result.Result;
import com.autumn.web.post.entity.PostInsertDto;
import com.autumn.web.post.entity.PostSelectDto;
import com.autumn.web.post.entity.PostUpdateDto;
import com.autumn.web.post.service.PostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

/**
 * @author lqz
 * @date 2023-06-19 09:56:30
 * 岗位信息 Controller
 */
@Validated
@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    /**
     * 岗位信息查询
     */
    @PostMapping("/select")
    @SaCheckPermission("post.select")
    public Result selectPost(@RequestBody PostSelectDto postSelectDto) {
        return postService.selectPost(postSelectDto);
    }

    /**
     * 所属岗位下拉数据
     */
    @PostMapping("/getPostList")
    public Result getPostList(@RequestBody PostSelectDto postSelectDto) {
        return postService.getPostList(postSelectDto);
    }

    /**
     * 岗位信息新增
     */
    @PostMapping("/insert")
    @SaCheckPermission("post.insert")
    public Result insertPost(@RequestBody @Validated PostInsertDto postInsertDto) {
        return postService.insertPost(postInsertDto);
    }

    /**
     * 岗位信息修改
     */
    @PostMapping("/update")
    @SaCheckPermission("post.update")
    public Result updatePost(@RequestBody @Validated PostUpdateDto postUpdateDto) {
        return postService.updatePost(postUpdateDto);
    }

    /**
     * 岗位信息删除
     */
    @GetMapping("/delete")
    @SaCheckPermission("post.delete")
    public Result deletePost(@RequestParam("ids") @NotBlank(message = "ids不能为空") String ids) {
        return postService.deletePost(ids);
    }

    /**
     * 岗位信息excel导出
     */
    @PostMapping("/export")
    @SaCheckPermission("post.export")
    public void exportPost(@RequestBody PostSelectDto postSelectDto, HttpServletResponse response) {
        postService.exportPost(postSelectDto, response);
    }

    /**
     * 岗位信息excel导入
     */
    @PostMapping("/import")
    @SaCheckPermission("post.import")
    public Result importPost(MultipartFile file) {
        return postService.importPost(file);
    }

}
