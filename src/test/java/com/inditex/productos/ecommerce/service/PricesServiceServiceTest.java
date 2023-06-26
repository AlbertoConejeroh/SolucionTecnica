package com.inditex.productos.ecommerce.service;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.productos.ecommerce.entity.Prices;
import com.inditex.productos.ecommerce.entity.PricesPk;
import com.inditex.productos.ecommerce.model.OfferRequest;
import com.inditex.productos.ecommerce.repository.PriceRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PricesServiceServiceTest {
	@InjectMocks
	private PricesServiceImp pricesService;

	@Mock
	private PriceRepository priceRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	public void getPricesTest() throws Exception {

		OfferRequest request = new OfferRequest("1", "35455", "2020-06-14T10:00:00.0");
		List<Prices> prices = new ArrayList<>();
		Prices price = new Prices();
		price.setCurr("EUR");
		price.setEndDate(LocalDateTime.now());
		price.setGroups(null);
		price.setPrice(new BigDecimal("25.5"));
		PricesPk pricePk = new PricesPk(new BigInteger("1"), new BigInteger("1"), new BigInteger("35455"));
		price.setPricesPk(pricePk);
		price.setPriority(new BigInteger("0"));
		price.setStartDate(LocalDateTime.now());
		prices.add(price);
		Optional<List<Prices>> listPrices = Optional.of(prices);
		when(priceRepository
				.findFirstByPricesPkBrandIdAndPricesPkProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						new BigInteger(request.getBrandId()), new BigInteger(request.getProductId()),
						LocalDateTime.parse(request.getDateApp()), LocalDateTime.parse(request.getDateApp())))
				.thenReturn(listPrices);

		pricesService.getOffersToProduct(request);

	}

	@Test
	public void getPricesErrorNullTest() {

		OfferRequest request = new OfferRequest("1", "35455", "2020-06-14T10:00:00.0");

		when(priceRepository
				.findFirstByPricesPkBrandIdAndPricesPkProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						new BigInteger(request.getBrandId()), new BigInteger(request.getProductId()),
						LocalDateTime.parse(request.getDateApp()), LocalDateTime.parse(request.getDateApp())))
				.thenReturn(null);

		try {
			pricesService.getOffersToProduct(request);

		} catch (Exception e) {
			System.out.println("error: " + e);
		}

	}

	@Test
	public void getPricesNotFoundTest() {

		OfferRequest request = new OfferRequest("1", "35455", "2020-06-14T10:00:00.0");
		List<Prices> prices = new ArrayList<>();

		Optional<List<Prices>> listPrices = Optional.of(prices);

		try {

			when(priceRepository
					.findFirstByPricesPkBrandIdAndPricesPkProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
							new BigInteger(request.getBrandId()), new BigInteger(request.getProductId()),
							LocalDateTime.parse(request.getDateApp()), LocalDateTime.parse(request.getDateApp())))
					.thenReturn(listPrices);

			pricesService.getOffersToProduct(request);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}

	}

	@Test
	public void getPricesNumberFormatexcepTest() {

		OfferRequest request = new OfferRequest("", "35455", "2020-06-14T10:00:00.0");
		List<Prices> prices = new ArrayList<>();

		Optional<List<Prices>> listPrices = Optional.of(prices);

		try {

			when(priceRepository
					.findFirstByPricesPkBrandIdAndPricesPkProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
							Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
					.thenReturn(listPrices);

			pricesService.getOffersToProduct(request);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}

	}

	@Test
	public void getPricesDateFormatExcepTest() {

		OfferRequest request = new OfferRequest("1", "35455", "2020-06-1410:00:00.0");
		List<Prices> prices = new ArrayList<>();

		Optional<List<Prices>> listPrices = Optional.of(prices);

		try {

			when(priceRepository
					.findFirstByPricesPkBrandIdAndPricesPkProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
							Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
					.thenReturn(listPrices);

			pricesService.getOffersToProduct(request);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}

	}
}
