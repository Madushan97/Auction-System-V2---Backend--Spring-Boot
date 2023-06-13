package com.madushan.Web.Based.Gem.Auction.Service.IMPL;

import com.madushan.Web.Based.Gem.Auction.DTO.GemDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateGemDTO;
import com.madushan.Web.Based.Gem.Auction.Entity.Gem;
import com.madushan.Web.Based.Gem.Auction.Repository.GemRepository;
import com.madushan.Web.Based.Gem.Auction.Service.GemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public GemDTO updateGem(GemDTO gemDTO) {

        if (gemRepository.existsById(gemDTO.getGemId())) {

            Gem gem = gemRepository.getReferenceById(gemDTO.getGemId());

            Gem gem1 = modelMapper.map(gemDTO, Gem.class);
            gemRepository.save(gem1);
            GemDTO gemDTO1 = modelMapper.map(gem1, GemDTO.class);
            return gemDTO1;

        } else {
            throw new RuntimeException("Can't find");
        }
    }

    @Override
    public GemDTO updateGemDetails(UpdateGemDTO updateGemDTO) {

        if (gemRepository.existsById(updateGemDTO.getGemId())) {

            Gem gem = gemRepository.getReferenceById(updateGemDTO.getGemId());

            gem.setGemName(updateGemDTO.getGemName());
            gem.setDescription(updateGemDTO.getDescription());
            gem.setImages(updateGemDTO.getImages());
            gem.setCertification(updateGemDTO.getCertification());
            gem.setStartingBid(updateGemDTO.getStartingBid());
            gem.setReservePrice(updateGemDTO.getReservePrice());
            gem.setBiddingIncrement(updateGemDTO.getBiddingIncrement());
            gem.setTimeRemaining(updateGemDTO.getTimeRemaining());

            gemRepository.save(gem);
            GemDTO gemDTO = modelMapper.map(gem, GemDTO.class);

            return gemDTO;
        }

        return null;
    }

    @Override
    public String deleteGemById(int gemId) {

        if (gemRepository.existsById(gemId)) {
            gemRepository.deleteById(gemId);
            return "done";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gem does not found");
        }
    }

    @Override
    public List<GemDTO> getAllGems() {
//        entity
        List<Gem> allGems = gemRepository.findAll();

        if (allGems.size() > 0 ) {

            List<GemDTO> gemDTOList = new ArrayList<>();

            for (Gem gem : allGems ) {
                GemDTO gemDTO = modelMapper.map(gem,GemDTO.class);
                gemDTOList.add(gemDTO);
            }
            return gemDTOList;
        } else {
            throw new RuntimeException("No Data Found");
        }

    }

}
