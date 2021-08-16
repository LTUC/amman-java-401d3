package com.groupname.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    DBUserRepository DBUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    @GetMapping("/login")
    public String getSignInPage(){
        return "signin.html";
    }

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value="username") String username, @RequestParam(value="password") String password/*, @RequestParam(value="authority") String authority*/){
        DBUser newUser = new DBUser(username,bCryptPasswordEncoder.encode(password),"ROLE_USER");
        DBUserRepository.save(newUser);

        //TODO: add automatic login
        return new RedirectView("/login");
    }

    @GetMapping("/profiles/{id}")
    public String getProfilePage(Principal p, Model m, @PathVariable Integer id){
        DBUser requiredProfile = DBUserRepository.findById(id).get();
        if(requiredProfile != null){
            m.addAttribute("requireduser", requiredProfile);
            String requiredProfileUserName = requiredProfile.getUsername();
            String loggedInUserName = p.getName();
            boolean isLoggedInUserPofile = requiredProfileUserName.equals(loggedInUserName);
            m.addAttribute("isLoggedInUserPofile", isLoggedInUserPofile);

        } else {
            // pass a message ,return error page ...
        }
        return "profile.html";
    }

}
