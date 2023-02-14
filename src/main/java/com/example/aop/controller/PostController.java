package com.example.aop.controller;

import com.example.aop.domain.Member;
import com.example.aop.dto.MemberModifyDto;
import com.example.aop.dto.PostDto;
import com.example.aop.repo.MemberRepo;
import com.example.aop.service.MemberService;
import com.example.aop.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final MemberRepo memberRepo;
    private final MemberService memberService;


    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody PostDto postDto) {
        Member member = memberRepo.findById(postDto.getSeq()).orElseThrow(
                ()->new IllegalArgumentException("유저없음")
        );
        return postService.createPost(member,postDto);

    }

    @DeleteMapping("/post")
    public ResponseEntity<?> delete(@RequestParam Long seq,
                                    @RequestParam Long memSeq) {
        Member member = memberRepo.findById(memSeq).orElseThrow(
                () -> new IllegalArgumentException("유저없음")
        );
        return postService.deletePost(member, seq);

    }


    @PutMapping("/modi")
    public ResponseEntity<?> modify(@RequestBody MemberModifyDto modifyDto){
        return memberService.modifyInfo(modifyDto);

    }
}
