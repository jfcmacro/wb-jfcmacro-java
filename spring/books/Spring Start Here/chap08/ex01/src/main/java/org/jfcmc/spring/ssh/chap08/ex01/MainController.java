package org.jfcmc.spring.ssh.chap08.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(Model page) {
        page.addAttribute("username", "Katy")
            .addAttribute("color", "red");

        return "home.html";
    }
}
