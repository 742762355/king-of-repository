package com.lixin.demo.spring_test;

import com.alibaba.fastjson.JSON;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleTest {

    @Test
    public void upperCase(){
        System.out.println(StringUtils.uncapitalize("ResId"));
        System.out.println(StringUtils.capitalize("redId"));
    }

    @Test
    public void resolveXml() throws ParserConfigurationException, IOException, SAXException, DocumentException {
        Element root = DocumentHelper.createElement("data");
        Document document = DocumentHelper.createDocument(root);
//        Element head = root.addElement("head");
//        head.addText("这是一个请求头");
//        String xml1="<?xml version=\"1.0\" encoding=\"UTF-8\"?><data><head>这是一个请求头</head></data>";
//        ByteArrayInputStream bin1=new ByteArrayInputStream(xml1.getBytes());
//        SAXReader reader1=new SAXReader();
//        Document read1 = reader1.read(bin1);

        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ServiceId><sub>xxx</sub>123</ServiceId>";
        ByteArrayInputStream bin=new ByteArrayInputStream(xml.getBytes());
        SAXReader reader=new SAXReader();
        Document read = reader.read(bin);

        document.getRootElement().appendContent(read);

        System.out.println(document.asXML());
    }

    @Test
    public void findAbstractClass(){
        Map map=new HashMap();
        map.put("name","123");
        JSON.toJSONString(map);
    }
}
