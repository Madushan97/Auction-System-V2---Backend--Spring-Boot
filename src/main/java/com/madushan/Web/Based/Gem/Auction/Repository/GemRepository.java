package com.madushan.Web.Based.Gem.Auction.Repository;

import com.madushan.Web.Based.Gem.Auction.Entity.Gem;
import com.madushan.Web.Based.Gem.Auction.Service.GemService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemRepository extends JpaRepository<Gem, Integer> {


}
