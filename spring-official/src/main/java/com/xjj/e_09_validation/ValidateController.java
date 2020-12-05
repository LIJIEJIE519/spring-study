package com.xjj.e_09_validation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

/**
 * @Author LJ
 * @Date 2020/11/27
 * msg
 */

@Controller
public class ValidateController implements WebMvcConfigurer {

    // 参数是传给view的
    @GetMapping("/validate")
    public String showForm(Person person) {
        return "validation";
    }

    @PostMapping("validate")
    public String checkPersonInfo(@Valid Person person, BindingResult result) {
        if (result.hasErrors())
            return "validation";
        return "redirect:/";
    }
}
