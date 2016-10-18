package com.sallskapsresan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class webController {
    @GetMapping("/")
    public ModelAndView goToLoginAndRegister() {
        return new ModelAndView("/loginAndRegister");
    }
}
