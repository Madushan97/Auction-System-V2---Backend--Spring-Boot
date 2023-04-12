package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.SellerDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.Seller;
import com.madushan.Web.Based.Gem.Auction.Repository.SellerRepository;
import com.madushan.Web.Based.Gem.Auction.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;

@Service
public class SellerServiceIMPL implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public String saveSeller(SellerDTO sellerDTO) {

        Seller seller = new Seller(
                sellerDTO.getSellerId(),
                sellerDTO.getFirstName(),
                sellerDTO.getLastName(),
                sellerDTO.getNIC(),
                sellerDTO.getAddress(),
                sellerDTO.getContactNumbers(),
                sellerDTO.getEmail(),
                sellerDTO.isActive()
        );

        sellerRepository.save(seller);
        return null;
    }
}
