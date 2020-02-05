package com.shout.edu.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shout.edu.service.PostService;
import com.shout.edu.web.dto.PostResponseDto;
import com.shout.edu.web.dto.PostSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {
	private final PostService postService;
	
	@PostMapping("/api/v1/post")
	public Long save(@RequestBody PostSaveRequestDto reqDto) {
		return postService.save(reqDto);
	}
	
	@PostMapping("/api/v1/post/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostSaveRequestDto reqDto) {
		return postService.update(id, reqDto);
	}
	
	@GetMapping("/api/v1/post/{id}")
	public PostResponseDto findById(@PathVariable Long id) {
		return postService.findById(id);
	}
}
