package com.lixin.demo.test.others;

import com.lixin.core.utils.qrcode.QRCodeUtil;

public class QRcodeTest {

    public static void main(String[] args) throws Exception {

        //二维码的信息
        String url = "https://www.baidu.com";
        //logo的图案
        String img = "E:\\fileDownload\\pictureSave\\125722eh9nj87bq20eq2e8.jpg";
        //二维码生成的路径
        String saveUrl = "E:\\fileDownload\\pictureSave\\qr.jpg";
        //生成二维码
        QRCodeUtil.encode(url, img, saveUrl, true);
        //读取二维码中的信息
        System.out.println(QRCodeUtil.decode(saveUrl));
    }
}
