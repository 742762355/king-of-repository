package jf.controller;

import com.jfinal.core.Controller;

/**
 * @author:lixin
 * @date:2020/7/21  13:39
 * @description: JFinal 测试类
 */
public class HelloController extends Controller {

    public void index(){
        renderText("Hello hanpi world!");
    }

    public void word(){
        renderText("hello jfinal world to word page!");
    }

    public void page(){
        render("list.html");
    }
}
