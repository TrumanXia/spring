package com.xyg.learn.spring.redis;

import com.xyg.learn.spring.pojo.MyUser;
import com.xyg.learn.spring.service.SpringCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("single") // 设置profile
public class SpringCacheTests {

    @Autowired
    SpringCacheService springCacheService;

    // ---------------spring cache注解演示
    // get
    @Test
    public void springCacheTest() throws Exception {
        MyUser user = springCacheService.findUserById("tony");
        System.out.println(user);
    }

    // update
    @Test
    public void springCacheTest2() throws Exception {
        springCacheService.updateUser(new MyUser("hhhhhhh-2", "tony"));
        MyUser user = springCacheService.findUserById("tony");
        System.out.println(user);
    }

    @Test
    public void springCacheTest4() throws Exception {
        springCacheService.updateUser(new MyUser("12", "sss"));
//        User user = springCacheService.findUserById("tony");
//        System.out.println(user);
    }

    @Test
    public void springCacheTest5() throws Exception {
        springCacheService.updateUser2(new MyUser("12-2", "ssseee"));
//        User user = springCacheService.findUserById("tony");
//        System.out.println(user);
    }



    // delete
    @Test
    public void springCacheTest3() throws Exception {
        springCacheService.deleteUserById("tony");
    }
}
