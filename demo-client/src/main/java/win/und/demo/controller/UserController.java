package win.und.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // sso测试接口
    @GetMapping("/")
    public String getInfo(Authentication authentication) {
        return "hello";

    }
    @GetMapping("/user")
    public String getUser(Authentication authentication) {
        return "hello";

    }
}
