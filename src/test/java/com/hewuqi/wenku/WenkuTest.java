package com.hewuqi.wenku;

import com.hewuqi.miniapp.baiduwenku.service.WenkuDownloadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author http://github.com/yaphone
 * @Date 2018/10/14 2:31 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WenkuTest {

    @Autowired
    private WenkuDownloadService wenkuDownloadService;

    @Test
    public void getVCodeIdTest() {
        String src = "https://wenku.baidu.com/view/6dbbdffb941ea76e58fa0440.html?from=search";
        String vCodeId = wenkuDownloadService.getVCodeId(src);
        System.out.println(vCodeId);

    }

    @Test
    public void getDownloadLink() {
        String src = "https://wenku.baidu.com/view/6dbbdffb941ea76e58fa0440.html?from=search";
        String downloadLink = wenkuDownloadService.getDownloadLink(src);
        System.out.println(downloadLink);

    }

    @Test
    public void downloadFile() {
        String src = "https://wenku.baidu.com/view/6dbbdffb941ea76e58fa0440.html?from=search";
        wenkuDownloadService.downloadFile(src);
    }
}
