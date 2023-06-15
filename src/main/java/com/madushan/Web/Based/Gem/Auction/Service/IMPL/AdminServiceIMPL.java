package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.AdminDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.Admin;
import com.madushan.Web.Based.Gem.Auction.Repository.AdminRepository;
import com.madushan.Web.Based.Gem.Auction.Service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceIMPL implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveAdmin(AdminDTO adminDTO) {

        Admin admin = modelMapper.map(adminDTO, Admin.class);
        adminRepository.save(admin);
        return null;
    }

    @Override
    public AdminDTO updateAdmin(AdminDTO adminDTO) {

        if (adminRepository.existsById(adminDTO.getAdminId())) {
            Admin admin = adminRepository.getReferenceById(adminDTO.getAdminId());

            Admin admin1 = modelMapper.map(adminDTO, Admin.class);

            adminRepository.save(admin1);

            AdminDTO adminDTO1 = modelMapper.map(admin1, AdminDTO.class);
            return adminDTO1;
        } else {

            throw new RuntimeException("No Admin found");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmins() {

        List<Admin> admins = adminRepository.findAll();
        if (admins.size() > 0 ) {
            List<AdminDTO> adminList = new ArrayList<>();
            for (Admin admin : admins) {
                AdminDTO adminDTO = modelMapper.map(admin, AdminDTO.class);
                adminList.add(adminDTO);
            }
            return adminList;
        } else {
                throw new RuntimeException("There are no any Admins");
        }
    }

    @Override
    public AdminDTO getAdminById(int adminId) {

        if (adminRepository.existsById(adminId)) {
            Admin admin = adminRepository.getReferenceById(adminId);
            AdminDTO adminDTO = modelMapper.map(admin, AdminDTO.class);
            return adminDTO;
        } else {
            throw new RuntimeException("No user found");
        }
    }

    @Override
    public String removeAdmin(int adminId) {

        if (adminRepository.existsById(adminId)){
            adminRepository.deleteById(adminId);
        } else {
            throw new RuntimeException("User not found");
        }
        return null;
    }
}
