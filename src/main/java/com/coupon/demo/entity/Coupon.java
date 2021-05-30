package com.coupon.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "coupon")
public class Coupon {

	@Id
	@Column (name="id")
	private Long id;
	@Column (name="use_min_amount")
	private Long useMinAmount;
	@Column (name="discount_amount")
	private Long discountAmount;
	@Column (name="usable_from")
	private Date usableFrom;
	@Column (name="usable_until")
	private Date usableUntil;
	@Column (name="status")
	private String status;
	
	public Long useCoupon(Long productAmount) {
		this.status = "USED";
		
		if(productAmount < discountAmount) {
			return productAmount;	
		}else {
			return discountAmount;	
		}
	}
}
