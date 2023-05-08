package com.example.Vendor.model;

import com.example.Vendor.model.Enum.Category;
import com.example.Vendor.model.Enum.Code;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Error {

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "code")
    private Code code;

    @Column(name = "details")
    private String details;

    @Column(name = "field")
    private String field;


}
