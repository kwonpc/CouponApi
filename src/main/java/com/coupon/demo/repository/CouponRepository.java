package com.coupon.demo.repository;

import java.util.List;

import javax.persistence.LockModeType;

import java.util.Date;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.coupon.demo.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>{
	
	List<Coupon> findByStatusAndUseMinAmountLessThanEqualAndUsableFromLessThanAndUsableUntilGreaterThan(String status, Long useMinAmount, Date date, Date date2, Sort sort);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Coupon findByIdAndStatusAndUseMinAmountLessThanEqualAndUsableFromLessThanAndUsableUntilGreaterThan(Long id, String status, Long useMinAmount, Date date, Date date2);
}
