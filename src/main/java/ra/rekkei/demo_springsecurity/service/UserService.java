package ra.rekkei.demo_springsecurity.service;

import ra.rekkei.demo_springsecurity.model.entity.Users;

public interface UserService {
    Users findUsersByUsername(String username);
}
