package org.jfcmc.spring.ssh.chap08.ex04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @RequestMapping("/home/{color}")
    public String home(@PathVariable String color,
                       Model page) {
        page.addAttribute("username", "Kathy")
            .addAttribute("color", color);

        return "home.html";
    }
}
