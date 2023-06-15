package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.AdminDTO;
import com.madushan.Web.Based.Gem.Auction.Service.AdminService;
import com.madushan.Web.Based.Gem.Auction.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/save-admin")
    public ResponseEntity<StandardResponse> saveAdmin(AdminDTO adminDTO) {

        String message = adminService.saveAdmin(adminDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Created", message), HttpStatus.CREATED
        );
    }
}
