package win.und.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @Value("${client.resourceServerUrl}")
    String resourceServerUrl;

    @GetMapping("/demo/{id}")
    public String getDemoAuthResource(@PathVariable Long id){
        ResponseEntity<String> responseEntity = oAuth2RestTemplate.getForEntity(resourceServerUrl+"/order/"+id, String.class);
        return responseEntity.getBody();
    }
    @GetMapping("/callback")
    public String callback(){
        return "111";
    }

}
