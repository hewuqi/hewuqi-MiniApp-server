package com.hewuqi.miniapp.baiduwenku.service.impl;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpCookies;
import com.hewuqi.miniapp.baiduwenku.service.WenkuDownloadService;
import com.hewuqi.utils.mail.NetEaseMailUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author http://github.com/yaphone
 * @Date 2018/10/14 1:44 PM
 */
@Service
@Slf4j
public class WenkuDownloadServiceImpl implements WenkuDownloadService {

    @Value("${wenku.username}")
    private String username;
    @Value("${wenku.password}")
    private String password;
    @Value("${wenku.savepath}")
    private String savepath;

    @Autowired
    private NetEaseMailUtil netEaseMailUtil;
    @Autowired
    private TemplateEngine templateEngine;

    HttpConfig config = null;

    @PostConstruct
    public void afterConstruct() {
        HCB hcb = HCB.custom();
        HttpClient client = hcb.build();

        HttpCookies cookies = HttpCookies.custom();
        config = HttpConfig.custom().context(cookies.getContext()).client(client);
    }

    @Override
    public String getVCodeId(String src) {
        String vCodeId = "";
        String url = "http://139.224.236.108/post1.php";

        Map<String, Object> params = new HashMap<>();
        params.put("usrname", username);
        params.put("usrpass", password);
        params.put("taskid", "up_down_doc1");
        params.put("docinfo", src);

        try {
            String html = HttpClientUtil.post(config.custom().url(url).map(params));
            vCodeId = html.substring(html.indexOf("id=") + 3);
        } catch (Exception e) {
            log.error("get vCodeId error");
        }
        return vCodeId;
    }

    @Override
    public String getDownloadLink(String src) {
        String downloadLink = "";
        String vCodeId = this.getVCodeId(src);
        String url = "http://www.blpack.com/downcode.php";

        Map<String, Object> params = new HashMap<>();
        params.put("vcodeid", vCodeId);
        params.put("taskid", "directDown");
        try {
            String html = HttpClientUtil.post(config.custom().url(url).map(params).encoding("utf-8"));
            downloadLink = new String(Base64.getDecoder().decode(html.substring(0, html.indexOf("----"))), "UTF-8");
        } catch (Exception e) {
            log.error("get downloadLink error");
        }
        return downloadLink;
    }

    @Override
    public void downloadFile(String src) {
        String downloadLink = this.getDownloadLink(src);
        String filename = this.getFilename(downloadLink);
        try {
            HttpClientUtil.down(config.custom().url(downloadLink).out(new FileOutputStream(savepath + filename))).close();
        } catch (Exception e) {
            log.error("download fail");
        }
        this.sendEmail(filename);

    }

    private String getFilename(String url) {
        String filename = "error";
        try {
            url = URLDecoder.decode(url, "UTF-8");
            int start = url.indexOf("filename=") + 10;
            int end = url.indexOf(";", start) - 1;
            filename = URLDecoder.decode(url.substring(start, end), "UTF-8");
        } catch (Exception e) {
            log.error("getFilename error" + url);
        }
        return filename;
    }

    private boolean sendEmail(String fileName) {

        //TODO get user from userService
        String to = "304872433@qq.com";
        String subject = fileName;

        //创建邮件正文
        Context context = new Context();
        context.setVariable("fileName", fileName);
        String emailContent = templateEngine.process("wenkuEmailTemplate", context);
        String filePath= savepath + fileName;

        try {
            netEaseMailUtil.sendAttachmentsMail(to, subject, emailContent, filePath, fileName);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
