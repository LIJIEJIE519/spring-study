package com.xjj.e_06_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author LJ
 * @Date 2020/11/25
 * msg
 */

@Controller     // 支持MVC, restController不支持查找
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";      // Model 找html文件
    }

    @GetMapping("/jquery")
    public String jquery(Model model) {
        model.addAttribute("jquery");
        return "jquery";
    }
}
