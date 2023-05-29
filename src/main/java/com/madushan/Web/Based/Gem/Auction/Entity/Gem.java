package com.madushan.Web.Based.Gem.Auction.Entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;

@Entity
@Table(name = "gems")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gem {

    @Id
    @Column(name = "gem_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gemId;

    @Column(name = "gem_name", length = 100, nullable = false)
    private String gemName;

    @Column(name = "description", length = 400, nullable = false)
    private String description;

//    works to do
    @Type(type = "json")
    @Column(name = "images", length = 100, nullable = false, columnDefinition = "json")
    private ArrayList images;

    @Column(name = "certification", length = 100, nullable = false)
    private String certification;

//    The minimum bidding amount required to participate in the auction.
    @Column(name = "starting_bid", length = 100, nullable = false)
    private int startingBid;

//    The minimum price set by the seller at which they are willing to sell the gemstone
    @Column(name = "reserve_price", length = 100)
    private int reservePrice;

//    The minimum amount by which a bidder must increase the current bid.
    @Column(name = "bidding_increment", length = 100)
    private int biddingIncrement;

//    The duration remaining for the auction to end, displayed as a countdown timer.
    @Column(name = "time_remaining", length = 100, nullable = false)
    private double timeRemaining;

    @Column(name = "seller_information", length = 100, nullable = false)
    private String sellerInformation;

    @Column(name = "shipping_details", length = 100, nullable = false)
    private String shippingDetails;

//    Accepted methods of payment for the auction, such as credit cards, online payment platforms, or wire transfers
    @Column(name = "payment_option", length = 100, nullable = false)
    private String paymentOption;

//    A log of previous bids, including the bidder's username and the amount bid, to track the bidding activity and competitiveness
    @Column(name = "auction_history", length = 100)
    private String auctionHistory;

//    An additional percentage or fee added to the final bid price, payable by the winning bidder as a commission to the auction platform
    @Column(name = "buyers_premium", length = 100, nullable = false)
    private int buyersPremium;

//    Options for receiving notifications or alerts when a bid is placed or when the auction is about to end
    @Column(name = "bid_notification", length = 100)
    private String bidNotification;

    @Column(name = "auction_conditions", length = 100)
    private String auctionConditions;



}
