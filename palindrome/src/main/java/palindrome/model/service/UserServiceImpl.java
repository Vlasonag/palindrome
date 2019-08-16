package palindrome.model.service;

import org.springframework.stereotype.Service;

import palindrome.model.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setPassword("1234");
        return user;
    }

}