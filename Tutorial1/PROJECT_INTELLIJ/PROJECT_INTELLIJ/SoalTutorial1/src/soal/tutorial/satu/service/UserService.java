package soal.tutorial.satu.service;

import soal.tutorial.satu.model.User;
import soal.tutorial.satu.model.mapper.UserMapper;
import soal.tutorial.satu.util.Hasher;

/**
 * Created by agungwb on 11/02/2017.
 */
public class UserService {
    private UserMapper userMapper;


    public User getUserByUsernameAndPassword(String username, String hashedPassword){

        User user = userMapper.getUserByUsernameAndHashedPassword(username, hashedPassword);
        return user;

    }

    public Boolean validateUser(String username, String password){

        User user = getUserByUsername(username);

        if (user == null) return false;

        Boolean validation = false;
        try {
            validation = Hasher.validatePassword(password, user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validation;

    }

    public User getUserByUsername(String username){
        User user = userMapper.getUserByUsername(username);
        return user;
    }

}
