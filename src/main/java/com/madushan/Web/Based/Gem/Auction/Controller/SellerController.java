package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.SellerDTO;
import com.madushan.Web.Based.Gem.Auction.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/seller")
@CrossOrigin
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public String saveSeller(@RequestBody SellerDTO sellerDTO) {

        sellerService.saveSeller(sellerDTO);
        return "Done saving";
    }

}
