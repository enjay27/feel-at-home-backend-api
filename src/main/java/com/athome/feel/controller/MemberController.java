package com.athome.feel.controller;

import com.athome.feel.model.FollowDto;
import com.athome.feel.model.LoginDto;
import com.athome.feel.model.MemberDto;
import com.athome.feel.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        MemberDto memberDto = memberService.findMemberByAccountId(loginDto);
        if (memberDto == null) {
            memberService.register(loginDto);
            memberDto = memberService.findMemberByAccountId(loginDto);
        }
        return ResponseEntity.ok(memberDto);
    }

    @GetMapping("/follower/{memberId}")
    public ResponseEntity<?> follower(@PathVariable("memberId") int memberId) {
        List<MemberDto> follower = memberService.findFollower(memberId);
        return ResponseEntity.ok(follower);
    }

    @GetMapping("/following/{memberId}")
    public ResponseEntity<?> following(@PathVariable("memberId") int memberId) {
        List<MemberDto> followee = memberService.findFollowee(memberId);
        return ResponseEntity.ok(followee);
    }

    @PostMapping("/follow")
    public ResponseEntity<?> follow(@RequestBody FollowDto followDto) {
        memberService.follow(followDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/follow")
    public ResponseEntity<?> unfollow(@RequestBody FollowDto followDto) {
        memberService.unfollow(followDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> searchName(@RequestParam("name") String name) {
        List<MemberDto> memberDtos = memberService.searchName(name);
        return ResponseEntity.ok(memberDtos);
    }

}
