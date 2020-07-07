package com.lixin.demo.test.work;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BugNumberOutUtil {


    @Test
    public void out(){
        String[] bugIds={"A03188",
                "A00005",
                "A00065",
                "A00004",
                "A03143",
                "A03137",
                "A01466",
                "A02767",
                "A00639",
                "A02281",
                "A00953",
                "A02960",
                "777777",
                "9019",
                "A12345",
                "A01580",
                "9003",
                "9004",
                "9026",
                "9027",
                "9028",
                " 9030",
                "9033",
                "9037",
                "9038",
                "001663",
                " 001843",
                "001737",
                "002036",
                "9005",
                "9006",
                "9011",
                "9018",
                "9022",
                "9023",
                "9024",
                "9039",
                "9042",
                "9052",
                "9100",
                "9020",
                "9021",
                "9040",
                "901101",
                "9050",
                "2c908b1d72c58bd50172c734bcdc0021",
                "9051",
                "90051",
                "9007",
                "9010",
                "9013",
                "9014",
                "9015",
                " 9016",
                "9048",
                "A03223",
                "9025",
                "9032",
                "9035",
                "9036",
                "9041",
                "903501",
                "9062",
                "9045",
                "9054",
                "9973",
                "9056",
                "9058",
                "9975",
                "9055",
                "9974",
                "9064",
                "9059",
                "9060",
                "9061",
                "90618",
                "A01580",
                "9063",
                "9065",
                "9066",
                "9081",
                "9084",
                "9089",
                " 9091",
                "9071",
                "9093",
                "9096",
                " 9098",
                "9099",
                "9097",
                "9068",
                " 9083",
                "9094",
                "9102",
                "9082",
                " 9086",
                "9095",
                " 9073",
                "9078",
                "9076",
                " 9077",
                "9080",
                " 9069",
                "9070",
                "9067",
                "9079",
                "9085",
                " 9087",
                "9088",
                "9101",
                " 9072",
                "9074",
                "9075",
                "9090",
                "9092"
        };

        for (int i = 0; i < bugIds.length; i++) {
//            if (i==bugIds.length-1) {
                String s=bugIds[i].trim();
                System.out.print("\""+s+"\""+",");
//                continue;
//            }
//            System.out.print("\"+bugIds[i].trim()+"\,");
        }
    }

    @Test
    public void testDate(){
        String start="08:33";
        String end="08:30";
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:ss");
        Date d1=null;
        Date d2=null;
        try {
            d1=dateFormat.parse(start);
            d2=dateFormat.parse(end);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(d1.compareTo(d2));
    }

    @Test
    public void test(){
        if (1==1){
            throw new RuntimeException();
        }
        try {
            System.out.println("处理异常");
        }catch (Exception e){
            System.out.println("异常了");
        }finally {
            System.out.println(123456);
        }
    }
}
