package com.Narainox.SpringDevTools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        int a=10;
        int d=500;
        int b=200;
        int c=90;
        return "Thi is just test /t sum of a and b is "+(a+b+c+d);
    }
}
