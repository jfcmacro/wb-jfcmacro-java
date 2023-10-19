package org.jfcmc.spring.ssh.chap08.ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(@RequestParam String color,
                       Model page) {
        page.addAttribute("username", "Katy")
            .addAttribute("color", color);

        return "home.html";
    }
}
