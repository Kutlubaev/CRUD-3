package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.entity.User;
import web.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(String name, String surname, int age) {
        return userRepository.save(new User(name, surname, age));
    }

    @Override
    public User update(String name, String surname, int age) {
        return userRepository.save(new User(name, surname, age));
    }

    @Override
    public String delete(long id) {
        userRepository.deleteById(id);
        return null;
    }
}
