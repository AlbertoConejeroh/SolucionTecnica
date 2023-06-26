package com.inditex.productos.ecommerce.service;

import com.inditex.productos.ecommerce.model.OfferRequest;
import com.inditex.productos.ecommerce.model.OfferResponse;

public interface PriceService {
	public OfferResponse getOffersToProduct(OfferRequest offerRequest) throws Exception;
}
