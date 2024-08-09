package ra.rekkei.demo_springsecurity.repository;


import ra.rekkei.demo_springsecurity.model.entity.Roles;

public interface RoleRepository {
    Roles findRoleByRoleName(String roleName);
}
