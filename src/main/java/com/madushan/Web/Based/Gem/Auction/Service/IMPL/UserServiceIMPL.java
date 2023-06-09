package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateUserDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.UserDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.User;
import com.madushan.Web.Based.Gem.Auction.Repository.UserRepository;
import com.madushan.Web.Based.Gem.Auction.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveUser(UserDTO userDTO) {

        User user = modelMapper.map(userDTO, User.class);

        userRepository.save(user);
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
//          Entity
        List<User> allUsers = userRepository.findAll();

        if (allUsers.size() > 0 ) {

            List<UserDTO> sellerDTOList = new ArrayList<>();

//          convert to DTO
            for (User seller : allUsers) {
                UserDTO sellerDTO = modelMapper.map(seller, UserDTO.class);

                sellerDTOList.add(sellerDTO);
            }
            return sellerDTOList;
        } else {
            throw new RuntimeException("No Sellers in database");
        }
    }

    @Override
    public UserDTO updateUser(UpdateUserDTO updateUserDTO) {

        if (userRepository.existsById(updateUserDTO.getUserId())) {

            User updateUser = userRepository.getReferenceById(updateUserDTO.getUserId());

            updateUser.setFirstName(updateUserDTO.getFirstName());
            updateUser.setLastName(updateUserDTO.getLastName());
            updateUser.setEmail(updateUserDTO.getEmail());

            userRepository.save(updateUser);

            UserDTO userDTO = modelMapper.map(updateUser, UserDTO.class);

            return userDTO;
        } else {
            throw new RuntimeException("There is no user call "+ updateUserDTO.getFirstName() + " " + updateUserDTO.getLastName());
        }
    }

    @Override
    public UserDTO getUserById(int userId) {

        if (userRepository.existsById(userId)) {

            User getUserById = userRepository.getReferenceById(userId);

            UserDTO userDTO = modelMapper.map(getUserById, UserDTO.class);

            return userDTO;
        } else {
            throw new RuntimeException("There is no user for :" + userId);
        }
    }

    @Override
    public String removeUser(int userId) {

        if (userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        } else {
            throw new RuntimeException("User not found");
        }
        return null;
    }

    @Override
    public UserDTO updateAllFields(UserDTO userDTO) {

        if (userRepository.existsById(userDTO.getUserId())) {

            User user = userRepository.getReferenceById(userDTO.getUserId());

            User updateUser = modelMapper.map(userDTO, User.class);
            userRepository.save(updateUser);

            UserDTO userDTO1 = modelMapper.map(updateUser, UserDTO.class);
            return userDTO1;
        } else {

            throw new RuntimeException("No user for ID : " + userDTO.getUserId());
        }
    }
}
