package com.athome.feel.model.mapper;

import com.athome.feel.model.FollowDto;
import com.athome.feel.model.LoginDto;
import com.athome.feel.model.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    void insertMember(LoginDto loginDto);

    MemberDto findByAccountId(String accountId);

    List<MemberDto> findFollowee(int memberId);

    List<MemberDto> findFollower(int memberId);

    void addFollow(FollowDto followDto);

    void deleteFollow(FollowDto followDto);

    List<MemberDto> findByNameLike(String name);
}
