package com.mw.eurekaclientconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client-provider", fallback = TestServiceHystric.class)
public interface TestService {

    @RequestMapping("/hi")
    String hi(@RequestParam String name);

}
