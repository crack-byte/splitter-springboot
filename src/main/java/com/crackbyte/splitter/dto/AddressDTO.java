package com.crackbyte.splitter.dto;

import com.crackbyte.splitter.entities.Address;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;

    @NotBlank(message = "Line1 is required")
    private String line1;
    private String line2;
    @NotBlank(message = "Pincode is required")
    private String pincode;
    private String district;
    @NotBlank(message = "City is required")
    private String city;
    private String state;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.line1 = address.getLine1();
        this.line2 = address.getLine2();
        this.pincode = address.getPincode();
        this.district = address.getDistrict();
        this.city = address.getCity();
    }
}
