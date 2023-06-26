package com.inditex.productos.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.productos.ecommerce.model.OfferRequest;
import com.inditex.productos.ecommerce.model.OfferResponse;
import com.inditex.productos.ecommerce.service.PriceService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Alberto Conejero Hernandez
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/prices/")
@Slf4j
public class PricesController {

	@Autowired
	private PriceService pricesService;

	/**
	 * @param offerRequest: data to ask for the price lists
	 * @return OfferResponse: response with data for the prices lists
	 * @throws Exception 
	 */
	@GetMapping("offers")
	public ResponseEntity<OfferResponse> getOffersToProduct(@RequestBody OfferRequest offerRequest) throws Exception {

		try {
			return new ResponseEntity<OfferResponse>(pricesService.getOffersToProduct(offerRequest), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
		

	}

}
