package sh.satamahaku.web;


import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sh.satamahaku.domain.User;
import sh.satamahaku.domain.UserRepository;
import sh.satamahaku.domain.UserTypeRepository;



@Controller

public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTypeRepository userTypeRepository;


@GetMapping("/login") // This is just login page where you can ether login or signup
    public String loggingIn(){
        return"/loginpage"; //loginpage.htlm
    }

@GetMapping("/newuser") // signup page for new users
    public String makeNewUser(Model model){
        model.addAttribute("newuser", new User());
        return"/newuser"; //newuserform.html
    }

@PostMapping("/savenewuser")
    public String saveNewUser(@ModelAttribute User user){
        sh.satamahaku.domain.UserType userType = userTypeRepository.findByUserType("USER");
        user.setUserType(userType);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);
        userRepository.save(user);
        return"redirect:/harbourlist";
    }

}
