package com.example.Vendor.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VendorContact {

    @Column(name = "id")
    private String id;

    @Column(name = "ordinal")
    private long ordinal;

    @Column(name = "email_address")
    private String email_address;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "removed")
    private Boolean removed;


}
