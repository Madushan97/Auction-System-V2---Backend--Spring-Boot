package com.madushan.Web.Based.Gem.Auction.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GemDTO {

    private int gemId;
    private String gemName;
    private String description;
    private ArrayList images;
    private String certification;
    private int startingBid;
    private int reservePrice;
    private int biddingIncrement;
    private double timeRemaining;
    private String sellerInformation;
    private String shippingDetails;
    private String paymentOption;
    private String auctionHistory;
    private int buyersPremium;
    private String bidNotification;
    private String auctionConditions;
}
