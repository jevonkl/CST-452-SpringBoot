package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Games")
public class ProductEntity {

	@Id
	Long id;

	@Column("GAME_NO")
	String gameNo;

	@Column("GAME_NAME")
	String gameName;

	@Column("PRICE")
	float price;

	@Column("QUANTITY")
	int quantity;

	/**
	 * Default Constructor
	 */
	public ProductEntity() {

	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param id
	 * @param gameNo
	 * @param gameName
	 * @param price
	 * @param quantity
	 */
	public ProductEntity(Long id, String gameNo, String gameName, float price, int quantity) {
		this.id = id;
		this.gameNo = gameNo;
		this.gameName = gameName;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the orderNo
	 */
	public String getGameNo() {
		return gameNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setGameNo(String gameNo) {
		this.gameNo = gameNo;
	}

	/**
	 * @return the productName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", gameNo=" + gameNo + ", gameName=" + gameName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
