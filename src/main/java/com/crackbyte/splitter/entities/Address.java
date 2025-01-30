package com.crackbyte.splitter.entities;

import com.crackbyte.splitter.dto.AddressDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "user_id")
    private User user;

    public Address(AddressDTO addressDTO) {
        this.line1 = addressDTO.getLine1();
        this.line2 = addressDTO.getLine2();
        this.pincode = addressDTO.getPincode();
        this.district = addressDTO.getDistrict();
        this.city = addressDTO.getCity();
    }
}
