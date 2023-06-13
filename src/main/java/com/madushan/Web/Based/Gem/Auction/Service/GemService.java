package com.madushan.Web.Based.Gem.Auction.Service;

import com.madushan.Web.Based.Gem.Auction.DTO.GemDTO;
import com.madushan.Web.Based.Gem.Auction.DTO.Request.UpdateGemDTO;

import java.util.List;

public interface GemService {

    List<GemDTO> getAllGems();

    String saveGem(GemDTO gemDTO);

    GemDTO gemGetById(int gemId);

    GemDTO updateGem(GemDTO gemDTO);

    String deleteGemById(int gemId);

    GemDTO updateGemDetails(UpdateGemDTO updateGemDTO);
}
