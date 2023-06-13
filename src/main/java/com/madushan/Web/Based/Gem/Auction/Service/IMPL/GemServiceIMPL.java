package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.GemDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.Gem;
import com.madushan.Web.Based.Gem.Auction.Repository.GemRepository;
import com.madushan.Web.Based.Gem.Auction.Service.GemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GemServiceIMPL implements GemService {

    @Autowired
    private GemRepository gemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveGem(GemDTO gemDTO) {

        Gem gem = modelMapper.map(gemDTO, Gem.class);
        gemRepository.save(gem);
        return null;
    }

    @Override
    public GemDTO gemGetById(int gemId) {

        if (gemRepository.existsById(gemId)) {

            Gem gem = gemRepository.getReferenceById(gemId);
            GemDTO gemGetById = modelMapper.map(gem, GemDTO.class);
            return gemGetById;
        } else {
            throw new RuntimeException("Gem not found for ID : " + gemId);
        }
    }

    @Override
    public List<GemDTO> getAllGems() {
//        entity
        List<Gem> allGems = gemRepository.findAll();

        if (allGems.size() > 0 ) {

            List<GemDTO> gemDTOList = new ArrayList<>();

            for (Gem gem : allGems ) {
                GemDTO gemDTO = modelMapper.map(allGems,GemDTO.class);
                gemDTOList.add(gemDTO);
            }
            return gemDTOList;
        } else {
            throw new RuntimeException("No Data Found");
        }

    }



}
