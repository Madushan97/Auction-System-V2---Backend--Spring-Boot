package com.madushan.Web.Based.Gem.Auction.Entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity

@Table(name = "seller")
@TypeDefs(
        @TypeDef(name = "json", typeClass = JsonType.class)
)

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller {

    @Id
    @Column(name = "seller_id", length = 45)
    private String sellerId;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "nic", length = 15, nullable = false)
    private String NIC;

    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Type(type = "json")
    @Column(name = "contact_numbers", nullable = false, columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "seller_status", columnDefinition = "TINYINT default 0")
    private boolean isActive;

}
