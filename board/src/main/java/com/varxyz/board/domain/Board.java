package com.varxyz.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private String num;
	private String title;
	private String content;
	private Date regDate;
}
