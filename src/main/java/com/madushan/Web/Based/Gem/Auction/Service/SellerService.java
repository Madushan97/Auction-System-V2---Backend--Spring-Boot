package com.madushan.Web.Based.Gem.Auction.Service;

import com.madushan.Web.Based.Gem.Auction.DTO.SellerDTO;

import java.util.List;

public interface SellerService {

    public String saveSeller (SellerDTO sellerDTO);

    List<SellerDTO> getSellers();
}
