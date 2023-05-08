package com.example.Vendor.services;


import com.example.Vendor.model.Enum.BulkVendorApi;
import com.example.Vendor.model.Vendor;
import com.example.Vendor.model.VendorApi;
import com.example.Vendor.repository.VendorApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class VendorApiService {
    @Autowired
    private VendorApiRepository vendorApiRepository;


    public VendorApi createVendor(String idempotency_key, Vendor vendor) {
        return vendorApiRepository.save(new VendorApi(idempotency_key,vendor));

    }

    public VendorApi retrieveVendor(String vendor_id) {
        return vendorApiRepository.findByVendorId(vendor_id);
    }

    public VendorApi updateVendor(String vendor_id, String idempotency_key, Vendor vendor) {

        VendorApi tmp= vendorApiRepository.findByVendorId(vendor_id);
        if(tmp == null) {
            return null;
        }
        tmp.setIdempotency_key(idempotency_key);
        tmp.setVendor(vendor);

        vendorApiRepository.save(tmp);
        return tmp;
    }

    public BulkVendorApi bukCreateVendor(Map<String,Vendor> vendors) {

        Set<Map.Entry<String, Vendor>> entrySet = vendors.entrySet();
        Iterator<Map.Entry<String, Vendor>> entrySetIterator = entrySet.iterator();

        Map<String,Map<String,Vendor>> vendorMap = new HashMap<>();

        String str = null;
        while(entrySetIterator.hasNext())
        {
            Map.Entry<String, Vendor> e = entrySetIterator.next();
            str = e.getKey();
            createVendor(e.getKey(),e.getValue());
        }

        vendorMap.put(str,vendors);

        return new BulkVendorApi(vendorMap);
    }

    public BulkVendorApi bukRetrieveVendor(String[] vendor_ids) {
        Map<String,Vendor> vendorMap = new HashMap<>();
        Map<String,Map<String,Vendor>> retrieveVendor = new HashMap<>();
        for(String id:vendor_ids){
            vendorMap.put(id,retrieveVendor(id).getVendor());
        }

        retrieveVendor.put(vendor_ids[0],vendorMap);

        return new BulkVendorApi(retrieveVendor);
    }

    public BulkVendorApi bukUpdateVendor(Map<String, Vendor> vendors) {
        Set<Map.Entry<String, Vendor>> entrySet = vendors.entrySet();
        Iterator<Map.Entry<String, Vendor>> entrySetIterator = entrySet.iterator();

        Map<String,Map<String,Vendor>> vendorMap = new HashMap<>();

        String str = null;
        while(entrySetIterator.hasNext())
        {
            Map.Entry<String, Vendor> e = entrySetIterator.next();
            str = e.getKey();
            updateVendor(e.getValue().getId(),e.getKey(),e.getValue());
        }

        vendorMap.put(str,vendors);
        return new BulkVendorApi(vendorMap);
    }
}
