package web.service;

import org.springframework.stereotype.Component;
import web.entity.User;

import java.util.List;

@Component
public interface UserService {
    public List<User> getAll();
    public User getById(long id);
    public Object save(String name, String surname, int age);
    public Object update(User user);
    public Object delete(long id);
}
