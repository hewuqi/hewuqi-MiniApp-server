package com.hewuqi.wechat;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.ResourceUtils;

import java.io.File;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/4/14 18:06
 */
public class XmlTest {

    static SAXReader reader = new SAXReader();

    public static void main(String[] args) {
        try {
            String xml = "<xml>\n" +
                    "    <ToUserName>yaphone</ToUserName>\n" +
                    "    <FromUserName>lzz</FromUserName>\n" +
                    "    <CreateTime>1348831860</CreateTime>\n" +
                    "    <MsgType>text</MsgType>\n" +
                    "    <Content>Hello World</Content>\n" +
                    "    <MsgId>1234567890123456</MsgId>\n" +
                    "</xml>";
            stringXmlTest(xml);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fileXmlTest() throws Exception {
        File file = ResourceUtils.getFile("classpath:test.xml");
        Document doc = reader.read(file);
        Element root = doc.getRootElement();

        String toUserName = root.elementText("ToUserName");
        String fromUserName = root.elementText("FromUserName");

        System.out.println(toUserName);
        System.out.println(fromUserName);
    }

    public static void stringXmlTest(String xml) throws Exception{
        Document doc = DocumentHelper.parseText(xml);

        Element root = doc.getRootElement();

        String toUserName = root.elementText("ToUserName");
        String fromUserName = root.elementText("FromUserName");

        System.out.println(toUserName);
        System.out.println(fromUserName);
    }
}
