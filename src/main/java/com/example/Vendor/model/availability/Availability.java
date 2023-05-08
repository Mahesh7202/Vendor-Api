package com.example.Vendor.model.availability;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Availability {

    @Embedded
    @ElementCollection
    @CollectionTable(name="Vendor_Contacts",joinColumns=@JoinColumn(name="id"))
    @Column(name = "contacts")
    private List<com.example.Vendor.model.VendorContact> contacts;

}
