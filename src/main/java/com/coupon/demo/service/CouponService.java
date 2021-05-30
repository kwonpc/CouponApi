package com.coupon.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coupon.demo.entity.Coupon;
import com.coupon.demo.repository.CouponRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;
	
	public List<Coupon> CouponList(Long productAmount){

		Sort sort = Sort.by("usableUntil").and(Sort.by("discountAmount").descending());
		return couponRepository.findByStatusAndUseMinAmountLessThanEqualAndUsableFromLessThanAndUsableUntilGreaterThan("NORMAL" , productAmount, new Date(), new Date(), sort);
	}
	
	@Transactional
	public Long couponPayment(Long id, Long productAmount) {
		
		Coupon cpn = couponRepository.findByIdAndStatusAndUseMinAmountLessThanEqualAndUsableFromLessThanAndUsableUntilGreaterThan(id, "NORMAL" , productAmount, new Date(), new Date());
		
		if(cpn!=null) {
			return cpn.useCoupon(productAmount);
		}else {
			return new Long(0);
		}

	}
	
	
}
