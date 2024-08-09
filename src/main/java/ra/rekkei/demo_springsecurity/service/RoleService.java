package ra.rekkei.demo_springsecurity.service;

import ra.rekkei.demo_springsecurity.model.entity.Roles;

public interface RoleService {
    Roles findRoleByRoleName(String roleName);
}
