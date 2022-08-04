package com.varxyz.javacafe.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Menu {
	private String name;
	private int price;
	private String categoryName;
}
