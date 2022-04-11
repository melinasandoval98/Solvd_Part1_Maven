package com.solvd.maven_project_ok.online_shopping.payment_method;

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
