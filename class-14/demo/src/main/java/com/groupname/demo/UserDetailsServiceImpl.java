package com.groupname.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Dependency Injection & IoC
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    // Polymorphism
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

        // Error handling ... the user is equal to null (doesn't exist in the database)
        if(applicationUser == null){
            throw  new UsernameNotFoundException("The user "+ username + " does not exist");
        }
        return applicationUser;
    }
}
