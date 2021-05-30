package com.coupon.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coupon.demo.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	
    @Autowired
    private CouponService couponService;
	
	@GetMapping(value="/availableCouponList/{amount}", produces="application/json; charset=UTF-8")
	public ResponseEntity availableCouponList (@PathVariable("amount") Long productAmount ) throws IOException {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("couponList", couponService.CouponList(productAmount));
		}catch(Exception e) {
			e.printStackTrace();
			result.put("resultMsg","Coupon List Error");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		result.put("resultMsg","OK");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value="/couponPayment/{id}/{amount}", produces="application/json; charset=UTF-8")
	public ResponseEntity couponPayment (@PathVariable("id") Long id, @PathVariable("amount") Long productAmount ) throws IOException {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			Long discountAmount = couponService.couponPayment(id, productAmount);
			if(discountAmount > 0) {
				result.put("productAmount", productAmount);
				result.put("paymentAmount", productAmount-discountAmount);
				result.put("discountAmount", discountAmount);
			}else {
				result.put("resultMsg","No Coupon Available");
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			result.put("resultMsg","Coupon Payment Error");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		result.put("resultMsg","OK");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
