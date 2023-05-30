package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateUserDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.Request.UserDTO;
import com.madushan.Web.Based.Gem.Auction.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seller")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

//    save user
    @PostMapping("/saveuser")
    public String saveUser(@RequestBody UserDTO sellerDTO) {

        userService.saveUser(sellerDTO);
        return "Done saving";
    }

//    get all users
    @GetMapping("/getallusers")
    public List<UserDTO> getUsers() {

        List<UserDTO> allUsers = userService.getUsers();
        return allUsers;
    }

//    update user
    @PutMapping("/update")
    public UserDTO updateUser(@RequestBody UpdateUserDTO updateUserDTO) {

        UserDTO userDTO = userService.updateUser(updateUserDTO);
        return userDTO;
    }

//    get by ID
    @GetMapping(value = "/getById/{id}")
    public UserDTO userGetById(@PathVariable(value = "id") int userId) {

        return userService.getUserById(userId);

    }

//    delete user
    @DeleteMapping(
            path = "/delete",
            params = {"id"}
    )
    public String deleteUser(@RequestParam(value = "id") int userId) {

        userService.removeUser(userId);
        return "User :"+ userId +" delete successfully";
    }

}
