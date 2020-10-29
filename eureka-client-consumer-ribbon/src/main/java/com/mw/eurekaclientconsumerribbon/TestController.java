package com.mw.eurekaclientconsumerribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Value("${server.port}")
    String port;

    @Autowired
    RestTemplate restTemplate;

    // 提供的方法
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(@RequestParam String name) {
        String result = restTemplate.getForObject("http://EUREKA-CLIENT-PROVIDER/hi?name="+name,String.class)+";I,m ribbon "+port;
        System.out.println(result);
        return result;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!;I,m ribbon hystrix "+port;
    }

}
