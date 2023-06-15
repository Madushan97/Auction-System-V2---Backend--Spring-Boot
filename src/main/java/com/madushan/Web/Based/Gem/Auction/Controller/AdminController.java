package com.madushan.Web.Based.Gem.Auction.Controller;

import com.madushan.Web.Based.Gem.Auction.DTO.AdminDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateUserDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.UserDTO;
import com.madushan.Web.Based.Gem.Auction.Service.AdminService;
import com.madushan.Web.Based.Gem.Auction.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    create admin
    @PostMapping("/save-admin")
    public ResponseEntity<StandardResponse> saveAdmin(AdminDTO adminDTO) {

        String message = adminService.saveAdmin(adminDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Created", message), HttpStatus.CREATED
        );
    }

//    TODO
//    update admin
    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateUser(@RequestBody AdminDTO adminDTO) {

        AdminDTO adminDTO1 = adminService.updateAdmin(adminDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Update", adminDTO1), HttpStatus.OK
        );
    }

//    delete admin
    @DeleteMapping(
            path = "/delete",
            params = {"id"}
    )
    public ResponseEntity<StandardResponse> deleteAdmin(@RequestParam(value = "id") int adminId) {

        String deleteMessage = adminService.removeAdmin(adminId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successfully Deleted", deleteMessage), HttpStatus.OK
        );
    }

//    get admin list
    @GetMapping("/get-admins")
    public ResponseEntity<StandardResponse> getAllAdmins() {

        List<AdminDTO> adminList =  adminService.getAllAdmins();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully fetching Admins", adminList), HttpStatus.OK
        );
    }

//    get admin by id
    @GetMapping(
            path = "get-by-id",
            params = {"id"}
    )
    public ResponseEntity<StandardResponse> getAdminById(@RequestParam(value = "id") int adminId) {

        AdminDTO adminDTO = adminService.getAdminById(adminId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", adminDTO), HttpStatus.OK
        );
    }

}
