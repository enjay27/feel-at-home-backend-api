package com.athome.feel.model.service;


import com.athome.feel.model.FollowDto;
import com.athome.feel.model.LoginDto;
import com.athome.feel.model.MemberDto;
import com.athome.feel.model.MusicDto;

import java.util.List;

public interface MemberService {

    MemberDto findMemberByAccountId(LoginDto loginDto);

    void register(LoginDto loginDto);

    List<MemberDto> findFollowee(int memberId);

    List<MemberDto> findFollower(int memberId);

    void follow(FollowDto followDto);

    void unfollow(FollowDto followDto);

    List<MemberDto> searchName(String name);
    
    List<MusicDto> listLikeSongs(int memberId);
}
