package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.User;
import academy.devdojo.springboot2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public String login(User user) {
        String token;
        Optional<User> userDb = userRepository.findByEmail(user.getEmail());

        if (userDb.isPresent()){
            if(userDb.get().getPassword().equals(CriptoService.encrypt(user.getPassword()))){
                token = CriptoService.encrypt(new Date().toString() + userDb.get().getId().toString());
                userDb.get().setToken(token);
                userRepository.save(userDb.get());
                return token;
            }
        }
        return null;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public String logout(String token) {
        Optional<User> userDb = userRepository.findByToken(token);

        if (userDb.isPresent()){
            userDb.get().setToken(null);
            userRepository.save(userDb.get());
            return "removed";
        }
        return null;
    }

    public String validSession(String token) {
        Optional<User> userDb = userRepository.findByToken(token);

        if (userDb.isPresent()){
            return "valid token";
        }
        return "invalid token";
    }
}
