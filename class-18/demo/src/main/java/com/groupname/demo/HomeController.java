package com.groupname.demo;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {
    // inside a controller class, you will add the endpoints (requests mapping)

    // as we have thymeleaf configuration, then the app expects to receive template names in responses

    // create an endpoint that corresponds to get requests
    // add an implementation to the function that will run when receiving a request on that path
    @GetMapping("/")    // localhost:8080    localhost:8080/
   // @ResponseBody       // include the return value as is in the response body
    public String getHome(Model m,Principal p){
        // if no user is logged in, principal is null ..
        try {
            m.addAttribute("username", p.getName());
        } catch (NullPointerException ex) {
//            m.addAttribute("user", p);
            System.out.println("No user is logged in ... ");
            m.addAttribute("username", "visitor");
        } finally {
            return "template.html";
        }
    }

    @GetMapping("/adminpanel")
    public String getAdminPage(){
        return "adminPage.html";
    }

    @GetMapping("/test")
    public String testTemplate(Model model){
        model.addAttribute("Name","Humam");
        model.addAttribute("Age", 25);
        return "template.html";
    }


}
