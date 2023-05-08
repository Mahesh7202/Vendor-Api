package com.example.Vendor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;



@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VendorAddress {


    @Column(name = "address_line_1")
    private String address_line_1;

    @Column(name = "address_line_2")
    private String address_line_2;

    @Column(name = "address_line_3")
    private String address_line_3;

    @Column(name = "administrative_level_1")
    private String administrative_level_1;

    @Column(name = "country")
    private String country;

    @Column(name = "locality")
    private String locality;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "sublocality")
    private String sublocality;

}
