package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.AdminDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.Admin;
import com.madushan.Web.Based.Gem.Auction.Repository.AdminRepository;
import com.madushan.Web.Based.Gem.Auction.Service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
