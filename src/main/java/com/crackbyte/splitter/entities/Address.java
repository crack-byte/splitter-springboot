package com.crackbyte.splitter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "address")
@Entity
@NoArgsConstructor
public class Address extends BaseEntity {


    private String line1;
    private String line2;
    private String pincode;
    private String district;
    private String city;
    @ManyToOne
    private User user;
    public Address(User user){
        this.user = user;
    }
}
