package com.example.Vendor.model.Enum;


import com.example.Vendor.model.Vendor;
import com.example.Vendor.model.VendorApi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BulkVendorApi {

    private Map<String, Map<String,Vendor>> response;

    public BulkVendorApi(Map<String, Map<String, Vendor>> response) {
        this.response = response;
    }

    private List<Error> errors;
}
