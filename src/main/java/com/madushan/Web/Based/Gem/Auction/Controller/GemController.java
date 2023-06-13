package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.GemDTO;
import com.madushan.Web.Based.Gem.Auction.Service.GemService;
import com.madushan.Web.Based.Gem.Auction.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/gems")
@CrossOrigin("http://localhost:3000")
public class GemController {

    @Autowired
    private GemService gemService;

//    get all gems
    @GetMapping(path = "/allgems")
    public ResponseEntity<StandardResponse> getAllGems() {

        List<GemDTO> gemDTOList = gemService.getAllGems();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "All gems are Fetching successfully", gemDTOList), HttpStatus.OK
        );
    }

//    gem get by ID
    @GetMapping(
            path = "/gem-get-by-id",
            params = {"id"}
    )
    public ResponseEntity<StandardResponse> gemGetById(@RequestParam(value = "id") int gemId) {

         GemDTO gemDTO = gemService.gemGetById(gemId);
         return new ResponseEntity<StandardResponse> (
                 new StandardResponse(200, "Gem Id :" + gemId + " Details Getting successfully", gemDTO), HttpStatus.OK
                 );
    }


//    update gem



//    remove gem



//    save gem


}
