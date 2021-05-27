package com.example.form;

import javax.validation.constraints.Pattern;

/**
 * ホテルの値段を受け取るフォーム.
 * 
 * @author masaki.taguchi
 *
 */
public class PriceForm {
	/** 値段 */
	@Pattern(regexp = "^\\d{0,6}$?", message = "0以上、100万未満で入力してください")
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PriceForm [price=" + price + "]";
	}

}
