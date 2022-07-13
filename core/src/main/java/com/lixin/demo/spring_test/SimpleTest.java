package com.lixin.demo.spring_test;

import com.alibaba.fastjson.JSON;
import com.lixin.demo.utils.XmlUtil;
import common.utils.LogUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.xml.parsers.ParserConfigurationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;

public class SimpleTest {

    @Test
    public void upperCase() {
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

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ServiceId><sub>xxx</sub>123</ServiceId>";
        ByteArrayInputStream bin = new ByteArrayInputStream(xml.getBytes());
        SAXReader reader = new SAXReader();
        Document read = reader.read(bin);

        document.getRootElement().appendContent(read);

        System.out.println(document.asXML());
    }

    @Test
    public void findAbstractClass() {
        Map map = new HashMap();
        map.put("name", "123");
        JSON.toJSONString(map);
    }


    @Test
    public void res() {
        String xml = "<root><acceptMessageResponse><acceptMessageResult>\n" +
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
        List<Node> list = rootElement.selectNodes("//acceptMessageResponse//acceptMessageResult//Response//ExamFillResult");
        System.out.println(list);
    }


    /**
     * @author:lixin
     * @date:2020/12/21 11:14
     * @description: 测试switch能匹配那几种格式:
     * 'char, byte, short, int, Character,Byte, Short, Integer, String,enum'只有这几种类型能够使用switch
     */
    @Test
    public void testSwitchType() {
        byte a = '1';
        char b = '1';
        Object[] infos = {1.0f, "test", 3.3d, 2, 5, false, "中"};

        Random random = new Random();
        int i = random.nextInt(6);
        System.out.println(infos[i]);

//        switch (1.0d){
//
//        }
    }

    /**
     * @author:lixin
     * @date:2020/12/21 11:43
     * @description: 测试float类型的自增
     */
    @Test
    public void testFloatType() {
//        float f=1.0f;
//        f+=1;
        float f = 1.0f;
        f = f + 1;
        System.out.println(f);
    }

    @Test
    public void testInterface() {
        List<String> list = getList();
    }

    private LinkedList<String> getList() {
        return new LinkedList<>();
    }


    @Test
    public void Md5() {
        String string = DigestUtils.md5Hex("zysoft@2020");
        MessageDigest md5Digest = DigestUtils.getMd5Digest();

    }

    @Test
    public void testCatch() {
        try {
            m();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(1);
        }
    }

    private boolean m() {
        try {
            if (1 / 0 == 1) {
                System.out.println(122);
            }
            return true;
        } finally {
            System.out.println("xx");
        }
//        return false;
    }

    @Test
    public void integerTest() {
        Integer a = 222;
        Integer b = 222;
        System.out.println(a == b);
    }

    @Test
    public void MapForeachTest() {
        Map<String, Object> map = new HashMap<>();
        map.forEach((k, v) -> {

        });
    }


    @Test
    public void exceptionTest() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                if (i / 2 == 1) {
                    throw new RuntimeException("error");
                }
            } catch (Exception e) {
                LogUtil.error("error", e);
            }
        }
    }

    @Test
    public void timestamp() {
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void testEquals() {
        List<Entity> list = new ArrayList<>();

        Entity t1 = new Entity();
        t1.setId("1");
        t1.setName("n");

        Entity t2 = new Entity();
        t2.setId("1");
        list.add(t1);
        list.add(t2);
        List<Entity> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(1);
    }

    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Setter
    @Getter
    private static class Entity {
        private String name;
        @EqualsAndHashCode.Include
        private String id;
    }

    @Test
    public void testNullMessage() {
        try {
            if (1 == 1) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testValidate() {
        ValidateEntity v1 = new ValidateEntity();
        ValidateEntity v2 = new ValidateEntity();
        Set<ConstraintViolation<ValidateEntity>> validate = VALIDATOR.validate(v1);
        validate.forEach(v -> System.out.println(v.getMessage()));
    }

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    private class ValidateEntity {
        @NotNull
        private String name;
    }
}
