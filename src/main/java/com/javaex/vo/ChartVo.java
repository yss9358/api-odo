package com.javaex.vo;

public class ChartVo {

	private int onedayPrice;
	private int preonedayPrice;
	private int RePrice;
	private int preRePrice;
	
	public ChartVo() {
		super();
	}

	public ChartVo(int onedayPrice, int preonedayPrice, int rePrice, int preRePrice) {
		super();
		this.onedayPrice = onedayPrice;
		this.preonedayPrice = preonedayPrice;
		RePrice = rePrice;
		this.preRePrice = preRePrice;
	}

	public int getOnedayPrice() {
		return onedayPrice;
	}

	public void setOnedayPrice(int onedayPrice) {
		this.onedayPrice = onedayPrice;
	}

	public int getPreonedayPrice() {
		return preonedayPrice;
	}

	public void setPreonedayPrice(int preonedayPrice) {
		this.preonedayPrice = preonedayPrice;
	}

	public int getRePrice() {
		return RePrice;
	}

	public void setRePrice(int rePrice) {
		RePrice = rePrice;
	}

	public int getPreRePrice() {
		return preRePrice;
	}

	public void setPreRePrice(int preRePrice) {
		this.preRePrice = preRePrice;
	}

	@Override
	public String toString() {
		return "ChartVo [onedayPrice=" + onedayPrice + ", preonedayPrice=" + preonedayPrice + ", RePrice=" + RePrice
				+ ", preRePrice=" + preRePrice + "]";
	}
	
	
}
