package ra.rekkei.demo_springsecurity.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.rekkei.demo_springsecurity.model.entity.Roles;
import ra.rekkei.demo_springsecurity.model.entity.Users;
import ra.rekkei.demo_springsecurity.repository.RoleRepository;
import ra.rekkei.demo_springsecurity.repository.UserRepository;

import javax.management.relation.Role;

@Repository
public class RoleResitoryImpl implements RoleRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Roles findRoleByRoleName(String roleName) {
        Session session = sessionFactory.openSession();
        try{
            Roles role = (Roles) session.createQuery("from Roles  where roleName = :roleName")
                    .setParameter("roleName",roleName)
                    .getSingleResult();
            return role;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
