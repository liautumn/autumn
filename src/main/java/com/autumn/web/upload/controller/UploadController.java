package com.autumn.web.upload.controller;

import com.autumn.common.minio.MinioUtil;
import com.autumn.common.result.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liqiuzhuang
 * @date 2023-06-11 9:49
 */
@Validated
@RestController
@RequestMapping("/file")
public class UploadController {

    @Resource
    private MinioUtil minioUtil;

    @GetMapping("/delete")
    public Result delete(@RequestParam("filesId") @NotBlank(message = "filesId不能为空") String filesId) {
        Boolean remove = minioUtil.remove(filesId);
        return remove ? Result.success() : Result.fail();
    }

    @GetMapping("/download")
    public void download(@RequestParam("filesId") @NotBlank(message = "filesId不能为空") String filesId, HttpServletResponse response) {
        minioUtil.download(filesId, response);
    }

    @PostMapping("/upload")
    public Result img(MultipartFile file) {
        return Result.successData(minioUtil.uploadWeb(file));
    }

    @GetMapping("/parse")
    public Result parse(@RequestParam("fileIds") @NotBlank(message = "fileIds不能为空") String fileIds) throws Exception {
        Map res = new HashMap();
        res.put("list", minioUtil.parse(fileIds));
        return Result.successData(res);
    }

}
