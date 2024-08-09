package ra.rekkei.demo_springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ra.rekkei.demo_springsecurity.model.entity.Roles;
import ra.rekkei.demo_springsecurity.model.entity.Users;
import ra.rekkei.demo_springsecurity.service.RoleService;
import ra.rekkei.demo_springsecurity.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findUsersByUsername(username);
        if(user!=null){
            CustomUserDetails customUserDetails = CustomUserDetails.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .authorities(mapRoleToAuthorities(user.getRoles()))
                    .status(user.getStatus())
                    .build();
            return customUserDetails;
        }
        return null;
    }

    private List<GrantedAuthority> mapRoleToAuthorities(List<Roles> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
