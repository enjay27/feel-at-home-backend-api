package com.athome.feel.model.mapper;

import com.athome.feel.model.FollowDto;
import com.athome.feel.model.LoginDto;
import com.athome.feel.model.MemberDto;
import com.athome.feel.model.MusicDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    void insertMember(LoginDto loginDto);

    MemberDto findByAccountId(String accountId);

    List<MemberDto> findFollowee(int memberId);

    List<MemberDto> findFollower(int memberId);

    int follow(FollowDto followDto);

    int deleteFollow(FollowDto followDto);

    List<MemberDto> findByNameLike(String name);

    void increaseFollowing(int memberId);

    void increaseFollower(int followId);

    void decreaseFollowing(int memberId);

    void decreaseFollower(int followId);

    List<MusicDto> listLikeSongs(int memberId);
}
