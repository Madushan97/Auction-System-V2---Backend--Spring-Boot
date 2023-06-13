package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.GemDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateGemDTO;
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
//     save gem
    @PostMapping( path = "/save-gem")
    public ResponseEntity<StandardResponse> saveGem(GemDTO gemDTO) {

        gemService.saveGem(gemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Created", gemDTO), HttpStatus.CREATED
        );
    }


//    update all gem attributes
    @PutMapping(path = "/update-gem-details")
    public ResponseEntity<StandardResponse> updateGem(@RequestBody GemDTO gemDTO) {

        GemDTO gemDTO1 = gemService.updateGem(gemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(208, "Successfully Updated", gemDTO1), HttpStatus.CREATED
        );
    }

//        update only Gem details
    @PutMapping(path = "/update-gem-only")
    public ResponseEntity<StandardResponse> updateGemDetails(@RequestBody UpdateGemDTO updateGemDTO) {

        GemDTO updateGemDTO1 = gemService.updateGemDetails(updateGemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(208, "Successfully Updated", updateGemDTO1), HttpStatus.CREATED
        );
    }

//    remove gem
    @DeleteMapping(path = "/delete-gem/{id}")
    public ResponseEntity<StandardResponse> deleteGemById (@PathVariable(value = "id") int gemId) {

        String deleted = gemService.deleteGemById(gemId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Deleted", deleted), HttpStatus.OK
        );
    }





}
