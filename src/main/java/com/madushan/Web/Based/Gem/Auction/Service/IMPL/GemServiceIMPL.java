package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.GemDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.Gem;
import com.madushan.Web.Based.Gem.Auction.Repository.GemRepository;
import com.madushan.Web.Based.Gem.Auction.Service.GemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GemServiceIMPL implements GemService {

    @Autowired
    private GemRepository gemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<GemDTO> getAllGems() {
//        entity
        List<Gem> allGems = gemRepository.findAll();

        if (allGems.size() > 0 ) {

            List<GemDTO> gemDTOList = new ArrayList<>();

            for (Gem gem : allGems ) {
                GemDTO gemDTO = new GemDTO(
                  gem.getGemId(),
                  gem.getGemName(),
                  gem.getDescription(),
                  gem.getImages(),
                  gem.getCertification(),
                  gem.getStartingBid(),
                  gem.getReservePrice(),
                  gem.getBiddingIncrement(),
                  gem.getTimeRemaining(),
                  gem.getSellerInformation(),
                  gem.getShippingDetails(),
                  gem.getPaymentOption(),
                  gem.getAuctionHistory(),
                  gem.getBuyersPremium(),
                  gem.getBidNotification(),
                  gem.getAuctionConditions()
                );
                gemDTOList.add(gemDTO);
            }
            return gemDTOList;
        } else {
            throw new RuntimeException("No Data Found");
        }

    }
}
