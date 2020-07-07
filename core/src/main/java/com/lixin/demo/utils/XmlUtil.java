package com.lixin.demo.utils;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlUtil {

    public static void main(String[] args) {

//        String xml = turnDocumentToString();
//        xml =xml.replace("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>", "");
//        xml = replaceBlank(xml);
        String xml="<root><returnContents><returnContent><test>大叔大婶</test><name>哥哥哥</name></returnContent><returnContent><test>大叔大婶11</test><name>哥哥哥22</name></returnContent></returnContents></root>";
//        OutApiController o=new OutApiController();
//        List<Map<String, String>> maps = o.xml2Map(xml);
        System.out.println(1);
//        HashMap<String,String> params=new HashMap<>();
//        params.put("sendXml",turnDocumentToString());
//        params.put("access_token","dada45b0-8a48-4369-93bf-bb5a355b123f");
//        String s = HttpRequest.sendPost("http://localhost:8080/outapi/sync/staff", params);
//        System.out.println(s);
    }

    private List<Map<String,String>> xml2Map(String xml){
        org.dom4j.Document document = XmlUtil.load(xml, "utf-8");
        List<Element> returnContents = document.getRootElement().element("returnContents").elements();
        List<Element> elements = document.getRootElement().element("returnContents").element("returnContent").elements();
        List<Map<String,String>> result=new LinkedList<>();

        for (Element element : returnContents) {
            List<Element> returnContent = element.content();
            HashMap<String, String> params = new HashMap<>();
            for (Element item:returnContent){
                String value = item.getText();
                String key = item.getName();
                params.put(key, value);
            }
            result.add(params);
        }
        return result;
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    //加载XML
    public static org.dom4j.Document load(String xml, String charsetName) {
        org.dom4j.Document document = null;
        try {
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes(charsetName));
            document = new SAXReader().read(inputStream);
        } catch (UnsupportedEncodingException | DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    private static String turnDocumentToString() {
        try {
            // 读取 xml 文件
            File fileinput = new File("E:/fileDownload/test.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileinput);


            // 方法1：将xml文件转化为String
            // StringWriter sw = new StringWriter();
            // TransformerFactory tf = TransformerFactory.newInstance();
            // Transformer transformer = tf.newTransformer();
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
            // "no");
            // transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            // transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            // transformer.transform(new DOMSource(doc), new StreamResult(sw));

            //方法2：和方法1类似
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            // 将转换过的xml的String 样式打印到控制台
            System.out.println(writer.toString());
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
