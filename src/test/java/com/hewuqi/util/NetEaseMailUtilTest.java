package com.hewuqi.util;

import com.hewuqi.utils.mail.NetEaseMailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @Description:
 * @Author http://github.com/yaphone
 * @Date 2018/10/14 6:23 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NetEaseMailUtilTest {

    @Autowired
    private NetEaseMailUtil netEaseMailUtil;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void simpleTest() {
        netEaseMailUtil.sendSimpleMail("304872433@qq.com","test simple mail","hello this is simple mail");
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="/Users/lili/Desktop/tmp/文本与说明书的区别.doc";
        netEaseMailUtil.sendAttachmentsMail("304872433@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath, "文本与说明书的区别.doc");
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("filename", "文本与说明书的区别");
        String emailContent = templateEngine.process("wenkuEmailTemplate", context);
        String filePath="/Users/lili/Desktop/tmp/文本与说明书的区别.doc";

        netEaseMailUtil.sendAttachmentsMail("304872433@qq.com","主题：这是模板邮件",emailContent, filePath, "文本与说明书的区别.doc");
    }
}
