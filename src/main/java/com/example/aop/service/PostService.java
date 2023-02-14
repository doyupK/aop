package com.example.aop.service;

import com.example.aop.annotation.Point;
import com.example.aop.domain.Member;
import com.example.aop.domain.Post;
import com.example.aop.dto.PostDto;
import com.example.aop.repo.MemberRepo;
import com.example.aop.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.aop.annotation.Point.Type.*;

@Service
@RequiredArgsConstructor
public class PostService {
    private final MemberRepo memberRepo;
    private final PostRepo postRepo;

    @Point(type = CREATE)
    @Transactional
    public ResponseEntity<?> createPost(Member member, PostDto postDto) {

        Post post = Post.builder()
                .title(postDto.getTitle())
                .member(member).build();

        postRepo.save(post);

        return ResponseEntity.ok().body("ok");
    }

    @Point(type = DELETE)
    @Transactional
    public ResponseEntity<?> deletePost(Member member, Long seq) {
        postRepo.deleteById(seq);
        return ResponseEntity.ok().body("ok");
    }
}
