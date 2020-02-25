package com.example.demo.model;

import org.springframework.stereotype.Component;


public class City {
	private String city1;
    private String city2;
    private String city3;
    private String mint;
    private String seasonal;
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getCity3() {
		return city3;
	}
	public void setCity3(String city3) {
		this.city3 = city3;
	}
	public String getMint() {
		return mint;
	}
	public void setMint(String mint) {
		this.mint = mint;
	}
	public String getSeasonal() {
		return seasonal;
	}
	public void setSeasonal(String seasonal) {
		this.seasonal = seasonal;
	}
}
