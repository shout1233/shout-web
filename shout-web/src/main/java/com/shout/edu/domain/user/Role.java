package com.shout.edu.domain.user;

import com.shout.edu.domain.EnumGetter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role implements EnumGetter {
	GUEST("ROLE_GUEST", "방문자"),
	USER("ROLE_USER", "일반 사용자");
	
	private final String key;
	private final String title;

	@Override
	public String getCode() {
		return this.name();
	}
	
	@Override
	public String getKey() {
		return this.key;
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}
}
