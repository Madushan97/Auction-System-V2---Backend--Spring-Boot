package com.madushan.Web.Based.Gem.Auction.Service;

import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateUserDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.UserDTO;

import java.util.List;

public interface UserService {

    public String saveUser (UserDTO userDTO);

    List<UserDTO> getUsers();

    UserDTO updateUser(UpdateUserDTO updateUserDTO);

    UserDTO getUserById(int userId);

    String removeUser(int userId);

    UserDTO updateAllFields(UserDTO userDTO);
}
