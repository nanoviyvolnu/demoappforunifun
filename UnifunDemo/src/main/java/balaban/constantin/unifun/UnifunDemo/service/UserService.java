package balaban.constantin.unifun.UnifunDemo.service;

import balaban.constantin.unifun.UnifunDemo.Repository.UserRepository;
import balaban.constantin.unifun.UnifunDemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> selectAllUsers(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.getOne(id);
    }

    public User saveUser(User user){
        return  userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public User findByName(Long id){
        return userRepository.getOne(id);
    }

    public List<User> searchByFirstAndLastName(String firstName, String lastName){
        return userRepository.searchByFirstAndLastName(firstName, lastName);
    }
}
