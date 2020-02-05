package com.shout.edu.domain.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
	@Autowired
	PostRepository postRepo;
	
	@Test
	public void test() {
		//given
		String title = "테스트 게시글";
		String content = "테스트 본문";

		postRepo.save(Post.builder()
				.title(title)
				.content(content)
				.build());
		
		//when
		List<Post> postList = postRepo.findAll();
		
		Post post = postList.get(0);
		assertThat(post.getTitle()).isEqualTo(title);
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		LocalDateTime now = LocalDateTime.of(2020, 1, 24, 0, 0, 0);
		postRepo.save(Post.builder()
							.title("title")
							.content("content")
							.author("author")
							.build());
		
		List<Post> postList = postRepo.findAll();
		
		Post post = postList.get(0);
		
		System.out.println(">>>>>>>>>>> createDate="+post.getCreatedDateTime()+", modifiedDate="+post.getUpdatedDateTime());
		
		assertThat(post.getCreatedDateTime()).isAfter(now);
		assertThat(post.getUpdatedDateTime()).isAfter(now);
	}
}
