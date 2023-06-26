package com.inditex.productos.ecommerce.entity;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PricesPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "BRAND_ID")
	private BigInteger brandId;

	@Column(name = "PRICE_LIST")
	private BigInteger priceList;

	@Column(name = "PRODUCT_ID")
	private BigInteger productId;
}
