package com.madushan.Web.Based.Gem.Auction.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private int userId;
    private String firstName;
    private String lastName;
    private String NIC;
    private String address;
    private ArrayList contactNumbers;
    private String email;

}
