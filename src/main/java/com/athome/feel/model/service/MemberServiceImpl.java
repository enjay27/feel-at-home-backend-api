package com.athome.feel.model.service;

import com.athome.feel.model.FollowDto;
import com.athome.feel.model.LoginDto;
import com.athome.feel.model.MemberDto;
import com.athome.feel.model.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public MemberDto findMemberByAccountId(LoginDto loginDto) {
        return sqlSession.getMapper(MemberMapper.class).findByAccountId(loginDto.getId());
    }

    @Override
    public void register(LoginDto loginDto) {
        sqlSession.getMapper(MemberMapper.class).insertMember(loginDto);
    }

    @Override
    public List<MemberDto> findFollowee(int memberId) {
        return sqlSession.getMapper(MemberMapper.class).findFollowee(memberId);
    }

    @Override
    public List<MemberDto> findFollower(int memberId) {
        return null;
    }

    @Override
    public void follow(FollowDto followDto) {
        sqlSession.getMapper(MemberMapper.class).addFollow(followDto);
    }

    @Override
    public void unfollow(FollowDto followDto) {
        sqlSession.getMapper(MemberMapper.class).deleteFollow(followDto);
    }

    @Override
    public List<MemberDto> searchName(String name) {
        return sqlSession.getMapper(MemberMapper.class).findByNameLike(name);
    }
}
