package web.service;

import org.springframework.stereotype.Component;
import web.entity.User;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> getAll();

    Optional<User> getById(long id);

    User save(String name, String surname, int age);

    User update(String name, String surname, int age);

    String delete(long id);
}
