package com.madushan.Web.Based.Gem.Auction.Service;

import com.madushan.Web.Based.Gem.Auction.DTO.AdminDTO;

import java.util.List;

public interface AdminService {

    String saveAdmin(AdminDTO adminDTO);

    AdminDTO updateAdmin(AdminDTO adminDTO);

    List<AdminDTO> getAllAdmins();

    AdminDTO getAdminById(int adminId);

    String removeAdmin(int adminId);
}
