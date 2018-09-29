package soal.tutorial.satu.service;

import soal.tutorial.satu.model.User;
import soal.tutorial.satu.model.mapper.UserMapper;
import soal.tutorial.satu.util.Hasher;

/**
 * Created by agungwb on 11/02/2017.
 */
public class UserService {
    private UserMapper penggunaMapper;


    public User getUserByUsernameAndPassword(String username, String hashedPassword){

        User pengguna = penggunaMapper.getUserByUsernameAndHashedPassword(username, hashedPassword);
        return pengguna;

    }

    public Boolean validateUser(String username, String password){

        User pengguna = getUserByUsername(username);

        if (pengguna == null) return false;

        Boolean validation = false;
        try {
            validation = Hasher.validatePassword(password, pengguna.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validation;

    }

    public User getUserByUsername(String username){
        User pengguna = penggunaMapper.getUserByUsername(username);
        return pengguna;
    }

}
