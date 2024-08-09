package ra.rekkei.demo_springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.rekkei.demo_springsecurity.model.entity.Roles;
import ra.rekkei.demo_springsecurity.repository.RoleRepository;
import ra.rekkei.demo_springsecurity.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Roles findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }
}
