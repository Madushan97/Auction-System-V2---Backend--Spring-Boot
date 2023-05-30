package com.madushan.Web.Based.Gem.Auction.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
}
