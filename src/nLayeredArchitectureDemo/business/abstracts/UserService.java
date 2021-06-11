package nLayeredArchitectureDemo.business.abstracts;

import nLayeredArchitectureDemo.entities.concretes.User;

public interface UserService {
    void signIn(String email,String password);
    void register(User user);
}
