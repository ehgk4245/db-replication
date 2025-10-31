package com.dbreplication.domain.post.post.service;

import com.dbreplication.domain.post.post.entity.Post;
import com.dbreplication.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post write(String title, String content) {
        return postRepository.save(new Post(title, content));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
