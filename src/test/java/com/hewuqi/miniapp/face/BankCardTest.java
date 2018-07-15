package com.hewuqi.miniapp.face;


import com.alibaba.fastjson.JSON;
import com.hewuqi.miniapp.free.dto.BankCardDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/3 20:39
 */
public class BankCardTest {
    public static void main(String[] args) {
        BankCardDto cardDto = new BankCardDto();
        try {
            File file = new File("C:\\Users\\zhouy\\Desktop\\test\\bankCard.html");
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements elements = doc.getElementsByTag("dt");
            cardDto.setArea(elements.get(1).text().substring(5));
            cardDto.setBankName(elements.get(2).text().substring(5));
            cardDto.setCardName(elements.get(3).text().substring(5));
            cardDto.setCardType(elements.get(4).text().substring(5));
            cardDto.setServiceNum(elements.get(5).text().substring(5));
            cardDto.setUrl(elements.get(6).text().substring(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf(JSON.toJSONString(cardDto));
    }
}
