package ra.rekkei.demo_springsecurity.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.rekkei.demo_springsecurity.model.entity.Users;
import ra.rekkei.demo_springsecurity.repository.UserRepository;
@Repository
public class UserResitoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Users findUsersByUsername(String username) {
        Session session = sessionFactory.openSession();
        try{
            Users user = (Users) session.createQuery("from Users  where username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
            return user;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
