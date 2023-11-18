package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.InvalidCredentialException;
import com.scaler.BookMyShow.exception.UserAlreadyExistsException;
import com.scaler.BookMyShow.exception.UserNotFoundException;
import com.scaler.BookMyShow.models.User;
import com.scaler.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class UserServiceImpl implements UserService{



    //service layer depends on repository

    /*
    whenever we create userService object
    (i.e object of userService),then that object
    internally should have an object of userRepository

    here spring boot comes with an Inversion Of Control
    (IOC) container and dependency management control.

    userService is depenedent on userRepository and
    we dont need to worry about the dependency management

    Dependecy management is taken care by spring and
    spring will takes care of creation of dependent
    objects and injection of it

     */

    /*

    @Autowired means we are injecting userRepository
    in userService

    */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()){

            throw new UserNotFoundException("User with given mail does not exist: " + email);

        }

        User user = userOptional.get();

        if (user.getPassword().equals(password)){
            return user;
        }
        else{

            throw new InvalidCredentialException("Credentials are Invalid");

        }
    }

    @Override
    public User signup(String name, String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()){
            throw new UserAlreadyExistsException("User with given email is already exists");
        }

        User newUser = new User();
        newUser.setPassword(password);
        newUser.setName(name);
        newUser.setEmail(email);

        return userRepository.save(newUser);
    }
}
