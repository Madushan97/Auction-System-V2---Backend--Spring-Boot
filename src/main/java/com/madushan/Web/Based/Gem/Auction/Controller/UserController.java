package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.UserDTO;
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

    @PostMapping("/saveuser")
    public String saveSeller(@RequestBody UserDTO sellerDTO) {

        userService.saveUser(sellerDTO);
        return "Done saving";
    }

    @GetMapping("/getallusers")
    public List<UserDTO> getSellers() {

        List<UserDTO> allUsers = userService.getUsers();
        return allUsers;
    }

}
