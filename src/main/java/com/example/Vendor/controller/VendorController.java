package com.example.Vendor.controller;

import com.example.Vendor.model.ApiResponseBody;
import com.example.Vendor.model.Enum.BulkVendorApi;
import com.example.Vendor.model.Vendor;
import com.example.Vendor.model.VendorApi;
import com.example.Vendor.services.VendorApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.example.Vendor.model.Enum.ErrorConstants.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping(value = "/v2/vendors")
public class VendorController {

	@Autowired
	private VendorApiService vendorApiService;

	@PostMapping("/create")
	public ResponseEntity<?> createVendor(@RequestBody String idempotency_key, @RequestBody final Vendor vendor){

		if (vendor == null) {
			return ResponseEntity.badRequest().body(new ApiResponseBody(BAD_REQUEST.value(), ERROR_NO_BODY));
		}
		VendorApi vendorApi = vendorApiService.createVendor(idempotency_key,vendor);
		if (vendorApi == null) {
			return ResponseEntity.badRequest().body(new ApiResponseBody(BAD_REQUEST.value(), ERROR_CREATING_BOOKING));
		}
		return ResponseEntity.ok().body(vendorApi);
	}

	@GetMapping("/{vendor_id}")
	public ResponseEntity<?> retrieveVendor(@PathVariable String vendor_id){

		VendorApi vendorApi = vendorApiService.retrieveVendor(vendor_id);
		if (vendorApi == null) {
			return ResponseEntity.badRequest().body(new ApiResponseBody(BAD_REQUEST.value(), ERROR_NO_BOOKING_FOUND));
		}
		return ResponseEntity.ok().body(vendorApi);
	}

	@PutMapping("/{vendor_id}")
	public ResponseEntity<?> updateVendor(@PathVariable String vendor_id, @RequestBody String idempotency_key,@RequestBody Vendor vendor) {

		VendorApi vendorApi = vendorApiService.updateVendor(vendor_id,idempotency_key,vendor);
		if(vendorApi == null) {
			return ResponseEntity.badRequest().body(new ApiResponseBody(BAD_REQUEST.value(), ERROR_UPDATING_BOOKING));
		}
		return ResponseEntity.ok().body(vendorApi);
	}

	@PostMapping("/bulk-create")
	public ResponseEntity<?> bulkCreateVendor(@RequestBody Map<String,Vendor> vendors){

		BulkVendorApi bulkVendorApi = vendorApiService.bukCreateVendor(vendors);
		if(bulkVendorApi == null){
			return ResponseEntity.badRequest().body(new ApiResponseBody(BAD_REQUEST.value(), ERROR_CREATING_BOOKING));
		}
		return ResponseEntity.ok().body(bulkVendorApi);
	}

	@GetMapping("/bulk-retrieve")
	public ResponseEntity<?> bulkCreateVendor(@RequestBody String[] vendor_ids){

		BulkVendorApi bulkVendorApi = vendorApiService.bukRetrieveVendor(vendor_ids);
		if(bulkVendorApi == null){
			return ResponseEntity.badRequest().body(new ApiResponseBody(BAD_REQUEST.value(), ERROR_NO_BOOKING_FOUND));
		}
		return ResponseEntity.ok().body(bulkVendorApi);
	}

	@PutMapping("/bulk-create")
	public ResponseEntity<?> bulkUpdateVendor(@RequestBody Map<String,Vendor> vendors){

		BulkVendorApi bulkVendorApi = vendorApiService.bukUpdateVendor(vendors);
		if(bulkVendorApi == null){
			return ResponseEntity.badRequest().body(new ApiResponseBody(BAD_REQUEST.value(), ERROR_CREATING_BOOKING));
		}
		return ResponseEntity.ok().body(bulkVendorApi);
	}


}
