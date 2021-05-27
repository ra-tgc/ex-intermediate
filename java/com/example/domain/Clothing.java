package com.example.domain;

/**
 * 衣類を表すドメイン.
 * 
 * @author masaki.taguchi
 *
 */
public class Clothing {
	/** ID */
	private Integer id;
	/** カテゴリ */
	private String category;
	/** ジャンル */
	private String genre;
	/** 性別 0=Man 1=Woman */
	private Integer gender;
	/** 色 */
	private String color;
	/** 価格 */
	private Integer price;
	/** 大きさ */
	private String size;

	public Clothing() {
	}

	public Clothing(Integer id, String category, String genre, Integer gender, String color, Integer price,
			String size) {
		super();
		this.id = id;
		this.category = category;
		this.genre = genre;
		this.gender = gender;
		this.color = color;
		this.price = price;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Clothing [id=" + id + ", category=" + category + ", genre=" + genre + ", gender=" + gender + ", color="
				+ color + ", price=" + price + ", size=" + size + "]";
	}

}
