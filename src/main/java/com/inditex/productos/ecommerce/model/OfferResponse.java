package com.inditex.productos.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alberto Conejero Hernandez
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {
	
	
	private String productId;
	
	private String groupId;
	
	private String rateToAply;
	
	private String endToRate;
	
	private String startToRate;
	
	private String finalPrice;
}
