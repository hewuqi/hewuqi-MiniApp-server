package com.hewuqi.miniapp.free.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.hewuqi.miniapp.free.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/2 21:50
 */
@Slf4j
@Service
public class FreeServiceImpl implements FreeService{
    @Value("${aliyun.tianchi.api.appCode}")
    private String appCode;
    @Value("${aliyun.tianchi.api.ip.url}")
    private String ipUrl;
    @Value("${cell.api.url}")
    private String cellUrl;
    @Value("${bank.api.url}")
    private String bankUrl;

    HCB hcb = null;
    Header[] ipHeaders = null;

    @PostConstruct
    private void afterConstruct() throws Exception{
        hcb = HCB.custom().pool(10, 10).timeout(10000);
        ipHeaders = HttpHeader.custom().authorization("APPCODE " + appCode).build();
    }

    @Override
    public IpDto getIpDto(String ip) {
        IpDto ipDto = new IpDto();
        try {
            HttpConfig config = HttpConfig.custom().url(ipUrl + ip).headers(ipHeaders);
            String resp = HttpClientUtil.get(config);
            JSONObject json = JSONObject.parseObject(resp);
            JSONObject data = json.getJSONObject("data");
            ipDto = JSONObject.toJavaObject(data, IpDto.class);
        }catch (Exception e) {
            log.error("IP查询失败", e);
        }
        return ipDto;
    }

    @Override
    public CellDto getCellDto(String mnc, String lac, String ci) {
        CellDto cellDto = new CellDto();
        String url = String.format(cellUrl, mnc, lac, ci);
        try {
            HttpConfig config = HttpConfig.custom().url(url);
            String resp = HttpClientUtil.get(config);
            JSONObject json = JSONObject.parseObject(resp);
            cellDto = JSONObject.toJavaObject(json, CellDto.class);
        }catch (Exception e) {
            log.error("基站查询失败", e);
        }
        return cellDto;
    }

    @Override
    public BankCardDto getBankCardDto(String cardNo) {
        String url = bankUrl + cardNo;
        BankCardDto cardDto = new BankCardDto();
        try {
            HttpConfig config = HttpConfig.custom().url(url);
            String resp = HttpClientUtil.get(config);
            Document doc = Jsoup.parse(resp);
            Elements elements = doc.getElementsByTag("dt");
            cardDto.setArea(elements.get(1).text().substring(5));
            cardDto.setBankName(elements.get(2).text().substring(5));
            cardDto.setCardName(elements.get(3).text().substring(5));
            cardDto.setCardType(elements.get(4).text().substring(5));
            cardDto.setServiceNum(elements.get(5).text().substring(5));
            cardDto.setUrl(elements.get(6).text().substring(5));
        }catch (Exception e) {
            log.error("银行卡信息查询失败", e);
        }
        return cardDto;
    }

    @Override
    public MacDto getMacDto(String mac) {
        String url = "http://api.cellocation.com:81/wifi/?mac=" + mac + "&output=json";
        MacDto macDto = new MacDto();
        try {
            HttpConfig config = HttpConfig.custom().url(url);
            String resp = HttpClientUtil.get(config);
            macDto = JSON.toJavaObject(JSON.parseObject(resp), MacDto.class);
        } catch (Exception e) {
            log.error("MAC地址查询失败");
        }
        return macDto;
    }

    @Override
    public WhoisDto getWhoisDto(String address) {
        WhoisDto whoisDto = new WhoisDto();
        String appCode = "APPCODE 74cd59b9a2fc4ae1912c4a24b5363768";
        String url = "http://ali-beian.showapi.com/beian?domain=" + address;
        try {
            Header[] headers = HttpHeader.custom().authorization(appCode).build();
            HttpConfig config = HttpConfig.custom().url(url).headers(headers);
            String resp = HttpClientUtil.get(config);
            whoisDto = this.convertToWhoisDto(resp);
        } catch (Exception e) {
            log.error("网站Whois查询失败");
        }

        return whoisDto;
    }

    private WhoisDto convertToWhoisDto(String resp) {
        WhoisDto whoisDto = new WhoisDto();
        JSONObject json = JSON.parseObject(resp);
        JSONObject obj = json.getJSONObject("showapi_res_body").getJSONObject("obj");
        whoisDto.setAddress(obj.getString("address"));
        whoisDto.setNum(obj.getString("num"));
        whoisDto.setType(obj.getString("type"));
        whoisDto.setUpdateTime(obj.getString("update_time"));
        whoisDto.setComName(obj.getString("com_name"));
        whoisDto.setSysName(obj.getString("sys_name"));
        whoisDto.setDomain(obj.getString("domain"));

        return whoisDto;
    }
}
