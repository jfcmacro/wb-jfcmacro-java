package org.jfcmc.spring.ssh.chap09.ex01;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login() {
        String username = this.getUserName();
        String password = this.getPassword();

        if ("natalie".equals(username) &&
            "password".equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
