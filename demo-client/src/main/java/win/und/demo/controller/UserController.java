package win.und.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // sso测试接口
    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        return authentication;

    }
}
