package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.SellerDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.Seller;
import com.madushan.Web.Based.Gem.Auction.Repository.SellerRepository;
import com.madushan.Web.Based.Gem.Auction.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                sellerDTO.getEmail()
        );

        sellerRepository.save(seller);
        return null;
    }

    @Override
    public List<SellerDTO> getSellers() {
//          Entity
        List<Seller> allSeller = sellerRepository.findAll();

        if (allSeller.size() > 0 ) {
            List<SellerDTO> sellerDTOList = new ArrayList<>();
//          convert to DTO
            for (Seller seller : allSeller) {
                SellerDTO sellerDTO = new SellerDTO(
                        seller.getSellerId(),
                        seller.getFirstName(),
                        seller.getLastName(),
                        seller.getNIC(),
                        seller.getAddress(),
                        seller.getContactNumbers(),
                        seller.getEmail()
                );

                sellerDTOList.add(sellerDTO);
            }
            return sellerDTOList;
        } else {
            throw new RuntimeException("No Sellers in database");
        }
    }
}
