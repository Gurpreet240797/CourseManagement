package com.CourseManagement.Management.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello There Changed Hot Reload";
    }

    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("/hello-jsp")
    public String sayHelloJSP() {
        return "sayHello";
    }
}
