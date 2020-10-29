package com.mw.eurekaclientconsumerfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    String port;

    @Autowired
    private TestService testService;

    // 提供的方法
    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        String result = testService.hi(name)+";I,m feign "+port;
        System.out.println(result);
        return result;
    }

}
