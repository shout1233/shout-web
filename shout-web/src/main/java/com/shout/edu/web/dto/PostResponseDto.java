package com.shout.edu.web.dto;

import com.shout.edu.domain.post.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;

	public PostResponseDto(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.author = post.getContent();
	}
}
