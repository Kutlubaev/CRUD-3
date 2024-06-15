package web.DAO;

import web.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAll();

    User getById(long id);

    void add(User user);

    void update(User user);

    void delete(User user);
}
