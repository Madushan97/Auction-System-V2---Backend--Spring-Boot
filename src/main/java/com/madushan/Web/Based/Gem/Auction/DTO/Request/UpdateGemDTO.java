package com.madushan.Web.Based.Gem.Auction.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGemDTO {

    private int gemId;
    private String gemName;
    private String description;
    private ArrayList images;
    private String certification;
    private int startingBid;
    private int reservePrice;
    private int biddingIncrement;
    private double timeRemaining;

}
