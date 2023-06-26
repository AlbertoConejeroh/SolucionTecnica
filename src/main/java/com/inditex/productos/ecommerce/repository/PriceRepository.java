package com.inditex.productos.ecommerce.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inditex.productos.ecommerce.entity.Prices;
import com.inditex.productos.ecommerce.entity.PricesPk;

/**
 * @author Alberto Conejero Hernandez
 *
 */
@Repository
public interface PriceRepository extends JpaRepository<Prices, PricesPk>{

	/**
	 * 
	 * This is a sql to ask the database for lists prices and rates
	 * 
	 * @param brandId
	 * @param productId
	 * @param startDate
	 * @param endDate
	 * @return List prices from offers
	 */
	Optional<List<Prices>> findFirstByPricesPkBrandIdAndPricesPkProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(BigInteger brandId, BigInteger productId, LocalDateTime startDate, LocalDateTime endDate);
	
}
