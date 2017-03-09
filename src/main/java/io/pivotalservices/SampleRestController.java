package io.pivotalservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class SampleRestController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
