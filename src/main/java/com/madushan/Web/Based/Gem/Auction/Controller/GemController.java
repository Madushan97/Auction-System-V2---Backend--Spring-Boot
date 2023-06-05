package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.GemDTO;
import com.madushan.Web.Based.Gem.Auction.Service.GemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/gems")
@CrossOrigin("http://localhost:3000")
public class GemController {

    @Autowired
    private GemService gemService;

    @GetMapping(path = "/allgems")
    public List<GemDTO> getAllGems() {

        List<GemDTO> gemDTOList = gemService.getAllGems();
        return gemDTOList;
    }

    @PostMapping(path = "/savegem")
    public String saveGem(@RequestBody GemDTO gemDTO) {
        gemService.saveGem(gemDTO);
        return "Gem " + gemDTO.getGemId() + " is saved";
    }
}
