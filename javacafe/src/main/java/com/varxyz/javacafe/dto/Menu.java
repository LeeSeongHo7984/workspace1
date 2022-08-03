package com.varxyz.javacafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Menu {
	private String name;
	private int price;
	private String categoryName;
}
