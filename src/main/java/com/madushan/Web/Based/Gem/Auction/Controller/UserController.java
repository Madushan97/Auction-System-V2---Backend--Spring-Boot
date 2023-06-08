package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateUserDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.Request.UserDTO;
import com.madushan.Web.Based.Gem.Auction.Service.UserService;
import com.madushan.Web.Based.Gem.Auction.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seller")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

//    save user
    @PostMapping("/save-user")
    public ResponseEntity<StandardResponse> saveUser(@RequestBody UserDTO sellerDTO) {

        userService.saveUser(sellerDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Created", sellerDTO),HttpStatus.CREATED
                );
    }

//    get all users
    @GetMapping("/get-all-users")
    public ResponseEntity<StandardResponse> getUsers() {

        List<UserDTO> allUsers = userService.getUsers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", allUsers), HttpStatus.OK
        );
    }

//    update user's first,last name, email
    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {

        UserDTO userDTO = userService.updateUser(updateUserDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", userDTO), HttpStatus.OK
        );
    }
//    TODO -> must develop endpoint for update all the attributes
    @PutMapping("/update-all-fields")
    public ResponseEntity<StandardResponse> updateUserAllFields(@RequestBody UserDTO userDTO) {

        UserDTO userDTO1 = userService.updateAllFields(userDTO);

        return new ResponseEntity<StandardResponse>(
          new StandardResponse(200, "Successfully Updated", userDTO1), HttpStatus.OK
        );

    }

//    get by ID
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<StandardResponse> userGetById(@PathVariable(value = "id") int userId) {

        UserDTO userDTO = userService.getUserById(userId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", userDTO), HttpStatus.OK
        );

    }

//    delete user
    @DeleteMapping(
            path = "/delete",
            params = {"id"}
    )
    public ResponseEntity<StandardResponse> deleteUser(@RequestParam(value = "id") int userId) {

        String deleteMessage = userService.removeUser(userId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successfully Deleted", deleteMessage), HttpStatus.OK
        );
    }

}
