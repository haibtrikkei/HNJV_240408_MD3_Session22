package ra.rekkei.demo_springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.rekkei.demo_springsecurity.model.entity.Users;
import ra.rekkei.demo_springsecurity.repository.UserRepository;
import ra.rekkei.demo_springsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users findUsersByUsername(String username) {
        return userRepository.findUsersByUsername(username);
    }
}
