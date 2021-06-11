package nLayeredArchitectureDemo.dataAccess.concretes;

import nLayeredArchitectureDemo.business.concretes.UserManager;
import nLayeredArchitectureDemo.dataAccess.abstracts.UserDao;
import nLayeredArchitectureDemo.entities.concretes.User;

import java.util.List;

public class HibernateUserDao implements UserDao {

    @Override
    public void save(User user) {

        System.out.println(user.getFirstName()+" "+ user.getLastName()+" : added.");
    }

    @Override
    public void delete(User user) {

        System.out.println(user.getFirstName()+" "+ user.getLastName()+" : deleted.");
    }

    @Override
    public void update(User user) {

        System.out.println(user.getFirstName()+" "+ user.getLastName()+" : updated.");
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
