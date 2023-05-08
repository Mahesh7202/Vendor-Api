package com.example.Vendor.model;

import com.example.Vendor.model.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;




@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vendor {



    @Column(name = "id")
    private String id;

    @Column(name = "account_number")
    private String account_number;

    @Embedded
    @ElementCollection
    @CollectionTable(name="Vendor_Contacts",joinColumns=@JoinColumn(name="id"))
    @Column(name = "contacts")
    private List<com.example.Vendor.model.VendorContact> contacts;

    @Column(name = "created_at")
    private String created_at;

    @Column(name="name")
    private String name;

    @Column(name = "note")
    private String note;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "version")
    private Integer version;


}
