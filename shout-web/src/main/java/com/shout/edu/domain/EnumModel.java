package com.shout.edu.domain;

import lombok.Getter;

@Getter
public class EnumModel {
	private String code;
	private String data;
	
	public EnumModel(EnumGetter enumGetter) {
		this.code = enumGetter.getCode();
		this.data = enumGetter.getTitle();
	}
}
