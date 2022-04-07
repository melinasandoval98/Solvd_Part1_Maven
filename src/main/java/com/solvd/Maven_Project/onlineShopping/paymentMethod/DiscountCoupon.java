package com.solvd.Maven_Project.onlineShopping.paymentMethod;

public class DiscountCoupon extends PaymentMethod {
	private long couponCode;
	private static int discountRate;
	
	public DiscountCoupon() {
		super();
	}
	
	public DiscountCoupon(long couponCode, int discountRate, double availableBalance) {
		this.couponCode = couponCode;
		DiscountCoupon.discountRate = discountRate;
		this.setAvailableBalance(availableBalance);
	}
	
	public long getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(long couponCode) {
		this.couponCode = couponCode;
	}
	
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		DiscountCoupon.discountRate = discountRate;
	}
	
}
