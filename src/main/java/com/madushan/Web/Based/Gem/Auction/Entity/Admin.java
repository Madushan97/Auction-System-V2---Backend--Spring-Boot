package com.madushan.Web.Based.Gem.Auction.Entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "admins")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @Column(name = "admin_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "nic", length = 15, nullable = false)
    private String NIC;

    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Type(type = "json")
    @Column(name = "contact_numbers", columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name = "email", length = 50, nullable = false)
    private String email;
}
