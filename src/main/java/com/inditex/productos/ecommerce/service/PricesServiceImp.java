package com.inditex.productos.ecommerce.service;

import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.productos.ecommerce.entity.Prices;
import com.inditex.productos.ecommerce.model.OfferRequest;
import com.inditex.productos.ecommerce.model.OfferResponse;
import com.inditex.productos.ecommerce.repository.PriceRepository;

/**
 * @author Alberto Conejero Hernandez
 *
 */
@Service
public class PricesServiceImp implements PriceService{

	@Autowired
	private PriceRepository priceRepository;

	/**
	 * This method invoke a sql for return the offers data
	 * 
	 * @param offerRequest: data for offers
	 * 
	 * @return OfferResponse: response with prices data and offers
	 * @throws Exception
	 */
	public OfferResponse getOffersToProduct(OfferRequest offerRequest) throws Exception {

		try {
			Optional<List<Prices>> listPrices = priceRepository
					.findFirstByPricesPkBrandIdAndPricesPkProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
							new BigInteger(offerRequest.getBrandId()), new BigInteger(offerRequest.getProductId()),
							LocalDateTime.parse(offerRequest.getDateApp()),
							LocalDateTime.parse(offerRequest.getDateApp()));
			if (listPrices != null && listPrices.isPresent() && !listPrices.get().isEmpty()) {

				OfferResponse offerResp = new OfferResponse(
						listPrices.get().get(0).getPricesPk().getProductId().toString(),
						listPrices.get().get(0).getPricesPk().getBrandId().toString(),
						listPrices.get().get(0).getPricesPk().getPriceList().toString(),
						listPrices.get().get(0).getStartDate().toString(),
						listPrices.get().get(0).getEndDate().toString(),
						listPrices.get().get(0).getPrice().toString() + " " + listPrices.get().get(0).getCurr());

				return offerResp;
			} else {
				throw new Exception("This search is empty, maybe try with other params");

			}

		} catch (NumberFormatException numExcp) {
			throw new NumberFormatException("Numeric parameters must be filled or have the correct format");
		} catch (DateTimeException dateExcep) {
			throw new DateTimeException("Not valid format date");
		}
	}

}
