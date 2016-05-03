package id.posyandu.service;

import id.posyandu.domain.User;
import java.util.Collection;

public interface UserService {
    public User saveUser(User user);

    public Boolean deleteUser(String userId);

    public User editUser(User user);

    public User findUser(String userId);

    public Collection<User> getAllUsers();
}
