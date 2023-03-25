package balaban.constantin.unifun.UnifunDemo.Controller;

import balaban.constantin.unifun.UnifunDemo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import balaban.constantin.unifun.UnifunDemo.service.UserService;
import org.springframework.ui.Model;

import java.util.List;
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    public String findAllUsers(Model model){
        List<User> users = userService.selectAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/userCreate")
    public String createUserForm(User user){
        return "userCreate";
    }

    @PostMapping("/userCreate")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/userList";
    }

    @GetMapping("/userDelete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/userList";
    }

    @GetMapping("/userUpdate/{id}")
    public String createUserFormUpdate(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/userUpdate";
    }

    @PostMapping("/userUpdate")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/userList";
    }

    @GetMapping("/userSearch")
    public String findUserByNameForm(User user, Model model){
        List<User> users = userService.selectAllUsers();
        model.addAttribute("users", users);
        return "/userSearch";
    }

    @PostMapping("/userSearch")
    public String search(User user,
                         @RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         Model model){
        List<User> users = userService.searchByFirstAndLastName(firstName,lastName);
        model.addAttribute("users", users);
        return "/userSearch";
    }
}
