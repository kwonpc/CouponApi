package com.coupon.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class CouponApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
    @Test
    @Order(1)
    public void cpnlist1() throws Exception {
    	System.out.println("########### coupon list test 1 ############");
    	mockMvc.perform(get("/coupon/availableCouponList/0").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon list test 1 ############");
    }
    
    @Test
    @Order(2)
    public void cpnlist2() throws Exception {
    	System.out.println("########### coupon list test 2 ############");
    	mockMvc.perform(get("/coupon/availableCouponList/3000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon list test 2 ############");
    }
    
    @Test
    @Order(3)
    public void cpnpayment1() throws Exception {
    	System.out.println("########### coupon payment test 1 ############");
    	mockMvc.perform(get("/coupon/couponPayment/1002/3000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isBadRequest())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon payment test 1 ############");
    }

    @Test
    @Order(4)
    public void cpnpayment2() throws Exception {
    	System.out.println("########### coupon payment test 2 ############");
    	mockMvc.perform(get("/coupon/couponPayment/1001/3000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isBadRequest())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon payment test 2 ############");
    }
    
    @Test
    @Order(5)
    public void cpnpayment3() throws Exception {
    	System.out.println("########### coupon payment test 3 ############");
    	mockMvc.perform(get("/coupon/couponPayment/1001/5000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon payment test 3 ############");
    }
    
    @Test
    @Order(6)
    public void cpnpayment4() throws Exception {
    	System.out.println("########### coupon payment test 4 ############");
    	mockMvc.perform(get("/coupon/couponPayment/1005/3000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isOk())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon payment test 4 ############");
    }
    
    @Test
    @Order(7)
    public void cpnpayment41() throws Exception {
    	System.out.println("########### coupon payment test 4-1 ############");
    	mockMvc.perform(get("/coupon/couponPayment/1005/3000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isBadRequest())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon payment test 4-1 ############");
    }
    @Test
    @Order(8)
    public void cpnpayment42() throws Exception {
    	System.out.println("########### coupon payment test 4-2 ############");
    	mockMvc.perform(get("/coupon/couponPayment/1005/3000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isBadRequest())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon payment test 4-2 ############");
    }
    @Test
    @Order(9)
    public void cpnpayment43() throws Exception {
    	System.out.println("########### coupon payment test 4-3 ############");
    	mockMvc.perform(get("/coupon/couponPayment/1005/3000").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			    	.andExpect(status().isBadRequest())
			    	.andDo(print())
			    	.andReturn();   	
    	System.out.println("########### coupon payment test 4-3 ############");
    }
    
}
