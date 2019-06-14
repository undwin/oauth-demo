package win.und.demo.oauth.support;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author yuit
 * @date time 2018/10/11  9:13
 *
 **/
@Component
public final class BootUserDetailService implements UserDetailsService {

//    @Autowired
//    private IUserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
////        User user= this.userService.findByUserName(username);
////
////        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
////
////        List <GrantedAuthority>authorities = new ArrayList<>();
////        authorities.add(authority);
////        user.setAuthorities(authorities);
////
////        if(user==null) {
////            throw new UsernameNotFoundException("用户名不存在");
////        }
////
////        return user;
//    }
@Override
public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    if ("admin".equalsIgnoreCase(name)) {
        User user = mockUser();
        return user;
    }
    throw new UsernameNotFoundException("用户不存在");
}
    private User mockUser() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        String pwd = passwordEncoder.encode("123456");
        User user = new User("admin",pwd,authorities);
        return user;
    }
}
