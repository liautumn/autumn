package com.autumn.web.message.controller;

import com.autumn.common.result.Result;
import com.autumn.web.message.entity.MessageInsertDto;
import com.autumn.web.message.entity.MessageSelectDto;
import com.autumn.web.message.entity.MessageUpdateDto;
import com.autumn.web.message.service.MessageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lqz
 * @date 2023-07-31 20:57:25
 * 消息记录表 Controller
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 未读消息数量查询
     */
    @GetMapping("/getUnreadNum")
    public Result getUnreadNum() {
        return messageService.getUnreadNum();
    }

    /**
     * 消息记录表查询
     */
    @PostMapping("/select")
    public Result selectMessage(@RequestBody MessageSelectDto messageSelectDto) {
        return messageService.selectMessage(messageSelectDto);
    }

    /**
     * 消息记录表新增
     */
    @PostMapping("/insert")
    public Result insertMessage(@RequestBody @Validated MessageInsertDto messageInsertDto) {
        return messageService.insertMessage(messageInsertDto);
    }

    /**
     * 消息记录表修改
     */
    @PostMapping("/update")
    public Result updateMessage(@RequestBody @Validated MessageUpdateDto messageUpdateDto) {
        return messageService.updateMessage(messageUpdateDto);
    }

    /**
     * 消息记录表删除
     */
    @GetMapping("/delete")
    public Result deleteMessage(@RequestParam("ids") String ids) {
        return messageService.deleteMessage(ids);
    }

    /**
     * 消息记录表excel导出
     */
    @PostMapping("/export")
    public void exportMessage(@RequestBody MessageSelectDto messageSelectDto, HttpServletResponse response) {
        messageService.exportMessage(messageSelectDto, response);
    }

    /**
     * 消息记录表excel导入
     */
    @PostMapping("/import")
    public Result importMessage(MultipartFile file) {
        return messageService.importMessage(file);
    }

}
