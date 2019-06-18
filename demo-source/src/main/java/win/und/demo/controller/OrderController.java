package win.und.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private RemoteTokenServices tokenServices;
    @RequestMapping("/order/{id}")
    private String user(@PathVariable String id){
        String  user  = (String) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return JSONObject.toJSONString(user);
    }
}
