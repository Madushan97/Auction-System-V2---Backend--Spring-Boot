package com.madushan.Web.Based.Gem.Auction.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerDTO {

    private String sellerId;
    private String firstName;
    private String lastName;
    private String NIC;
    private String address;
    private ArrayList contactNumbers;
    private String email;
    private boolean isActive;


}
