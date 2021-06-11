package nLayeredArchitectureDemo.dataAccess.abstracts;

import nLayeredArchitectureDemo.entities.concretes.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void delete(User user);
    void update(User user);
    List<User> getAll();

}
