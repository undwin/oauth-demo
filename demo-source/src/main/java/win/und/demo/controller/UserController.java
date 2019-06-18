package win.und.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user/{id}")
    private String user(@PathVariable String id){
        //for debug
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "user id : " + id;
    }
}
