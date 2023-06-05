package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

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
                UserDTO sellerDTO = modelMapper.map(allUsers, UserDTO.class);

                sellerDTOList.add(sellerDTO);
            }
            return sellerDTOList;
        } else {
            throw new RuntimeException("No Sellers in database");
        }
    }
}
