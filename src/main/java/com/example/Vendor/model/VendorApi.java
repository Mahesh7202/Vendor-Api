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
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VendorApi {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "idempotency_key")
    private String idempotency_key;

    @Embedded
    @Column(name = "Vendor")
    private Vendor vendor;

    @Column(name = "cursor")
    private String cursor;

    @Embedded
    @ElementCollection
    @CollectionTable(name="VendorApi_error",joinColumns=@JoinColumn(name="idempotency_key"))
    @Column(name = "Error")
    private List<Error> errors;

    public VendorApi(String idempotency_key, Vendor vendor) {
        this.idempotency_key = idempotency_key;
        this.vendor = vendor;
    }
}
