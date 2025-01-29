package com.crackbyte.splitter.dto;

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

    private String line1;
    private String line2;
    private String pincode;
    private String district;
    private String city;
}
