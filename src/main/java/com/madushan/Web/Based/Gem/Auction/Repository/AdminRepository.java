package com.madushan.Web.Based.Gem.Auction.Repository;

import com.madushan.Web.Based.Gem.Auction.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
