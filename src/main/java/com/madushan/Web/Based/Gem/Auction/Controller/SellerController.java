package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.SellerDTO;
import com.madushan.Web.Based.Gem.Auction.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seller")
@CrossOrigin("http://localhost:3000")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/saveseller")
    public String saveSeller(@RequestBody SellerDTO sellerDTO) {

        sellerService.saveSeller(sellerDTO);
        return "Done saving";
    }

    @GetMapping("/getallsellers")
    public List<SellerDTO> getSellers() {

        List<SellerDTO> allSellers = sellerService.getSellers();
        return allSellers;
    }

}
