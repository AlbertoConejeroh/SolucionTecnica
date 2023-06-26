package com.inditex.productos.ecommerce.entity;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "GROUPS")
public class Groups {

	@Id
	@Column(name = "BRAND_ID")
	private BigInteger brandId;

	@Id
	@Column(name = "GROUP_NAME")
	private String groupName;

	@OneToMany(mappedBy = "groups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Prices> listPrices;
}
