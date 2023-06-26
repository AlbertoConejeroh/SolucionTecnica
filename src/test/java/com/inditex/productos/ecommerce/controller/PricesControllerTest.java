package com.inditex.productos.ecommerce.controller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.productos.ecommerce.model.OfferRequest;
import com.inditex.productos.ecommerce.service.PricesServiceImp;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PricesControllerTest {

	@Mock
	private PricesServiceImp productService;

	@InjectMocks
	private PricesController pricesController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void controllerTest()  {
		OfferRequest offerRequest = new  OfferRequest("1", "35455", "2020-06-14-10.00.00");
		try {
			pricesController.getOffersToProduct(offerRequest );
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}

	}
	@Test
	public void controllerExceptionTest()  {
		OfferRequest offerRequest = new  OfferRequest("", "35455", "2020-06-14-10.00.00");
		try {
			when(productService.getOffersToProduct(offerRequest)).thenThrow(Exception.class);
			
			pricesController.getOffersToProduct(offerRequest );
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}

	}
	

	
}
