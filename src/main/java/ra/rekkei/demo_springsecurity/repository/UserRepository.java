package ra.rekkei.demo_springsecurity.repository;

import ra.rekkei.demo_springsecurity.model.entity.Users;

public interface UserRepository {
    Users findUsersByUsername(String username);
}
