package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.entity.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.getOne(id);
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Object save(String name, String surname, int age) {
        userRepository.saveAndFlush(new User(name, surname, age));
        return null;
    }

    @Override
    public Object update(User user) {
        userRepository.saveAndFlush(user);
        return null;
    }

    @Override
    public Object delete(long id) {
        userRepository.deleteById(id);
        return null;
    }

    public UserServiceImpl() {
    }
}
