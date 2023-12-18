package com.orderInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.orderInventory.Dto.InventoryDto;
import com.orderInventory.entity.Inventory;
import com.orderInventory.exception.InventoryNotFoundException;
import com.orderInventory.service.InventoryService;

import jakarta.validation.Valid;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/inventory/{id}")
	public ResponseEntity<Inventory> getAllProductAndStoreDetails(@Valid @PathVariable("id")int inventoryId) throws InventoryNotFoundException
	{
		Inventory inventory=inventoryService.getAllProductAndStoreDetails(inventoryId);
		return new ResponseEntity<Inventory>(inventory,HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/inventory/{storeId}")
	public ResponseEntity<List<InventoryDto>> getInventoryByStoreId(@PathVariable int storeId) throws InventoryNotFoundException {
		
		List<InventoryDto> inventoryByStoreId = inventoryService.getInventoryByStoreId(storeId);
		
		return new ResponseEntity<List<InventoryDto>>(inventoryByStoreId,HttpStatus.OK);
		
		
	}

}
