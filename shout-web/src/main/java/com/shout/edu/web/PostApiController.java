package com.shout.edu.web;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shout.edu.domain.EnumGetter;
import com.shout.edu.domain.EnumModel;
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
	
	@SuppressWarnings("unchecked")
	@GetMapping("/api/v1/enum/{enumName}")
	public Map<String, Object> findRole(@PathVariable String enumName) {
		Map<String, Object> result = new LinkedHashMap<>();
		Class<? extends EnumGetter> commonEnum = null;
		String enumPath = "com.shout.edu.domain.user.";
		
		try {
			commonEnum = (Class<? extends EnumGetter>) Class.forName(enumPath + enumName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(commonEnum.isEnum()) {
			List<EnumModel> model = Arrays.stream(commonEnum.getEnumConstants()).map(EnumGetter -> new EnumModel(EnumGetter)).collect(Collectors.toList());
			result.put(enumName, model);
		}
		
		// 로컬에서 수정

		return result;
	}
}
