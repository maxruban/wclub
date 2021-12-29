package com.service.impl;

//import com.config.security.EncoderConfig;
import com.domain.User;
import com.repository.UserRepository;
import com.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

//    PasswordEncoder encoder;

    UserRepository repository;

    @Override
    public void add(User user) {
        String password = user.getPassword();
//        String encodedPassword = encoder.encode(password);
//        user.setPassword(encodedPassword);
        repository.save(user);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return repository.findById(id);
    }

}
