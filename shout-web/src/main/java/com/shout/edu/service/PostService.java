package com.shout.edu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shout.edu.domain.post.Post;
import com.shout.edu.domain.post.PostRepository;
import com.shout.edu.web.dto.PostResponseDto;
import com.shout.edu.web.dto.PostSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
	private final PostRepository postRepo;
	
	@Transactional
	public Long save(PostSaveRequestDto reqDto) {
		return postRepo.save(reqDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostSaveRequestDto reqDto) {
		Post post = postRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 Post는 존재하지 않습니다."));
		post.update(reqDto.getTitle(), reqDto.getContent());
		return post.getId();
	}
	
	public PostResponseDto findById(Long id) {
		Post post = postRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 Post는 존재하지 않습니다."));
		return new PostResponseDto(post);
	}
}
