package com.inditex.productos.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alberto Conejero Hernandez
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest {

	private String brandId;
	
	private String productId;
	
	private String dateApp;
	
}
