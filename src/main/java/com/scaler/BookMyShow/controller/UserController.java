package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.controller.utils.UserControllerUtils;
import com.scaler.BookMyShow.dto.UserSignUpRequestDTO;
import com.scaler.BookMyShow.dto.UserSignUpResponseDTO;
import com.scaler.BookMyShow.models.User;
import com.scaler.BookMyShow.service.UserService;
import com.scaler.BookMyShow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    /*
    * Controller is dependent on service
    *
    * Like phonepe / bank in dependency inversion principle,
    * wherever possible try to always depend on interface rather than depending on concrete class
    *
    * Always try to maintain loosely coupled as possible.
    *
    * so we are proceeding @Autowired interface UserService instead of UserServiceImpl concrete class
    */
//    @Autowired
//    private UserServiceImpl userService; //actual implementation concrete class

    /*

    Why AutoWired required?

    Before using @Autowired

    * Basically what Autowired does is that, usercontroller is dependent on userservice and
    * userService is dependent on userRepository. Imagine as a developer if you have to take care
    * for dependencies then what you do, first of all you will create the object of userRepository
    * then you will create the object of userService then you will inject the userRepository object
    * inside it then you will create userController object and then you will inject userService
    * object inside it. So you will manually create 3 seperate objects and 2 injections (repository
    * in service and service in controller). So developer/user need to do 5 tasks manually
    *

    After Using @Autowired

    * If we use @Autowired then we don't need to do anything manually, everything will be taken
    * care automatically, spring will take care of injection of objects. so when you say
    * userController @Autowired userService means userController is dependent on userService
    * object and spring will automatically takes care of creation of userService object and
    * injects userService object into the userController.
    *
    * So @Autowired is an annotation which takes care of dependency mgmt in spring and does
    * auto dependency mgmt for developers so that we as developer don't worry about all these
    * boiler plate codes & stuffs
    * */

    /*
    *
    * Example of @Autowired:
    *
    * Class UserController{
    *
    *      @Autowired
    *      private UserService userService;
    *
    * }
    *
    *  Above code tells that UserController is dependent on userService. If we put @Autowired
    *  in some class then it shows that class is dependent on other class
    *
    *
    *
    * */


    /*

    DTO

    * we need create DTO for user signup
    * DTOs won't take much time to create and it shows the class that what you need to create
    *
    * it is bad practice to use models as input and output
    *
    * */

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserService userService; // interface

    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO userSignUpRequestDTO){

        User user;

        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();

        try {

            /*

            first it validates the dto in UserControllerUtils.validateUserSignUPRequestDTO(userSignUpRequestDTO);
            and then it pass the data.

            we pass the data only after validating instead of passing data directly without validating

            Instead of actually passing the entire object, you validate the object and pass only
            required information to the service (specific object data)


            */


            UserControllerUtils.validateUserSignUPRequestDTO(userSignUpRequestDTO);
            user = userService.signup(userSignUpRequestDTO.getName(), userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getPassword());

            // method that converts internal models into DTOs

            responseDTO.setId(user.getId());
            responseDTO.setName(user.getName());
            responseDTO.setEmail(user.getEmail());
            responseDTO.setTickets(user.getTickets());
            responseDTO.setResponseCode(200);
            responseDTO.setResponseMessage("SUCCESS");
            return responseDTO;
        } catch (Exception e) {

            responseDTO.setResponseCode(500);
            responseDTO.setResponseMessage("Internal Server Error");
            return responseDTO;
        }
    }


}
