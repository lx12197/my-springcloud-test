package com.mw.eurekaclientprovider2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    String port;

    // 提供的方法
    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        String result = "hi " + name + " , i am from port:" + port;
        System.out.println(result);
        return result;
    }

}
