package win.und.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class UserController {
    @RequestMapping("/user1/{id}")
    private String user(@PathVariable String id){
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "user id : " + id;
    }
}
