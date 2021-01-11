package com.lixin.demo.spring_test;

import com.alibaba.fastjson.JSON;
import com.lixin.demo.utils.XmlUtil;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

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


    @Test
    public void res(){
        String xml="<root><acceptMessageResponse><acceptMessageResult>\n" +
                "<Response>\n" +
                "  <Head>\n" +
                "    <ResultCode>Success</ResultCode>\n" +
                "  </Head>\n" +
                "  <ExamFillResult>\n" +
                "    <ResultCode>Success</ResultCode>\n" +
                "    <FillerOrderNO>1443174</FillerOrderNO>\n" +
                "    <FillerPatientID>CT403150</FillerPatientID>\n" +
                "    <AccessionNumber>1443174</AccessionNumber>\n" +
                "    <ObservationLocation />\n" +
                "    <QueueNo />\n" +
                "  </ExamFillResult>\n" +
                "</Response></acceptMessageResult></acceptMessageResponse></root>";
        Document load = XmlUtil.load(xml, "utf-8");
        Element rootElement = load.getRootElement();
         List<Node> list =rootElement.selectNodes("//acceptMessageResponse//acceptMessageResult//Response//ExamFillResult");
        System.out.println(list);
    }


    /**
     * @author:lixin
     * @date:2020/12/21  11:14
     * @description: 测试switch能匹配那几种格式:
     * 'char, byte, short, int, Character,Byte, Short, Integer, String,enum'只有这几种类型能够使用switch
     */
    @Test
    public void testSwitchType(){
        byte a= '1';
        char b='1';
        Object[] infos={1.0f,"test",3.3d,2,5,false,"中"};

        Random random=new Random();
        int i = random.nextInt(6);
        System.out.println(infos[i]);

//        switch (1.0d){
//
//        }
    }

    /**
     * @author:lixin
     * @date:2020/12/21  11:43
     * @description: 测试float类型的自增
     */
    @Test
    public void testFloatType(){
//        float f=1.0f;
//        f+=1;
        float f=1.0f;
        f=f+1;
        System.out.println(f);
    }

    @Test
    public void testInterface(){
        Parent p=new Children();
        List<String> list = getList();
    }


    public LinkedList<String> getList(){
        return new LinkedList<>();
    }
}
interface Parent{

}

class Children implements Parent{

}