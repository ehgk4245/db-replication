package com.dbreplication.global.initData;

import com.dbreplication.domain.post.post.entity.Post;
import com.dbreplication.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Lazy
    @Autowired
    private BaseInitData self;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work1();
            self.work2();
        };
    }

    @Transactional
    public void work1() {
        if (postService.count() == 0) {
            Post post1 = postService.write("제목 1", "내용 1");
            Post post2 = postService.write("제목 2", "내용 2");
        }
    }

    @Transactional(readOnly = true)
    public void work2() {
        List<Post> posts = postService.findAll();
        posts.forEach(post -> System.out.println("post id: " + post.getId()));
    }
}
