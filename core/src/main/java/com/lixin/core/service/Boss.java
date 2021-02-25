package com.lixin.core.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @author:lixin
 * @date:2020/4/26  10:51
 * @description: 测试spring的@autowired
 * 如果同时有@autowired修饰的构造和无参  优先使用构造
 * 如果构造多个(多个的话都得加上required=false,不然会报错)  则使用参数最多的(俺也不确定,测试是每次都会调用最多参数的,具体的得看spring源码中如何设计,如何调用)
 * 如果参数最多的构造函数同时有多个 则可能根据spring获取构造函数的顺序调用(测试是一直会调用写在最后的构造,所以更改方法的前后位置就会导致调用不同的构造)
 */
@Component
public class Boss {

//    @Autowired
    private Worker worker;

//    @Autowired
    private Manager manager;

    private Worker1 worker1;

//    @Autowired(required = false)
//    public Boss(){
//        System.out.println("无参构造");
//    }

//    @Autowired(required = false)
    public Boss(Worker worker){
        this.worker=worker;
        System.out.println("参数为worker的构造");
    }

//    public void setManager(Manager manager) {
//        this.manager = manager;
//        System.out.println(this.manager);
//    }

//    @Autowired(required = false)
//    public Boss(Manager manager){
//        this.manager=manager;
//        System.out.println("参数为manager的构造");
//    }

//    @Autowired(required = false)
//    public Boss(Worker1 worker1,Manager manager){
//        this.worker1=worker1;
//        this.manager=manager;
//        System.out.println("参数为worker1+manager的构造");
//    }


//    @Autowired(required = false)
//    public Boss(Worker worker,Manager manager){
//        this.worker=worker;
//        this.manager=manager;
//        System.out.println("参数为worker1+manager的构造");
//    }



//    @Autowired(required = false)
//    public Boss(Worker worker,Worker1 worker1,Manager manager){
//        this.worker=worker;
//        this.manager=manager;
//        this.worker1=worker1;
//        System.out.println("参数为3的构造");
//    }
}
