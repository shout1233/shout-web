package com.shout.edu.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.shout.edu.domain.post.Post;
import com.shout.edu.domain.post.PostRepository;
import com.shout.edu.web.dto.PostSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private PostRepository postRepo;
	
	@Test
	public void test() throws Exception {
		String title = "제목";
		String content = "내용";
		String author = "성진";
		
		PostSaveRequestDto reqDto = PostSaveRequestDto.builder()
													.title(title)
													.content(content)
													.author(author)
													.build();
		
		String url = "http://localhost:" + port + "/api/v1/post";
		
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, reqDto, Long.class);
	
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<Post> postList = postRepo.findAll();
		assertThat(postList.get(0).getTitle()).isEqualTo(title);
	}
	
	@Test
	public void Post_수정된다() {
		Post savedPost = postRepo.save(Post.builder()
				.title("title")
				.content("content")
				.author("author")
				.build());
		
		Long updateId = savedPost.getId();
		String expectedTitle = "updatedTitle";
		String expectedContent = "updatedContent";
		
		PostSaveRequestDto reqDto = PostSaveRequestDto.builder()
												.title(expectedTitle)
												.content(expectedContent)
												.build();
		
		String url = "http://localhost:" + port + "/api/v1/post/" + updateId;
		
		HttpEntity<PostSaveRequestDto> requestEntity = new HttpEntity<PostSaveRequestDto>(reqDto);
		
		ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class);
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<Post> postList = postRepo.findAll();
		assertThat(postList.get(0).getTitle()).isEqualTo(expectedTitle);
		assertThat(postList.get(0).getContent()).isEqualTo(expectedContent);
	}
}
