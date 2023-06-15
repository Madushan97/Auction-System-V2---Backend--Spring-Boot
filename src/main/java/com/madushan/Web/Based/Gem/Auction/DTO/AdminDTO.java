package com.madushan.Web.Based.Gem.Auction.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    private int adminId;
    private String firstName;
    private String lastName;
    private String NIC;
    private String address;
    private ArrayList contactNumbers;
    private String email;
}
