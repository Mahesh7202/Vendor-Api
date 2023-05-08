package com.example.Vendor.repository;

import com.example.Vendor.model.VendorApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendorApiRepository extends JpaRepository<VendorApi, String> {
    public VendorApi findByVendorId(String vendore_id);
}
