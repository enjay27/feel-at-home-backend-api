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
        return sqlSession.getMapper(MemberMapper.class).findFollower(memberId);
    }

    @Override
    public void follow(FollowDto followDto) {
        int updatedCount = sqlSession.getMapper(MemberMapper.class).follow(followDto);
        if (updatedCount != 0) {
            sqlSession.getMapper(MemberMapper.class).increaseFollowing(followDto.getMemberId());
            sqlSession.getMapper(MemberMapper.class).increaseFollower(followDto.getFollowId());
        }
    }

    @Override
    public void unfollow(FollowDto followDto) {
        int updatedCount = sqlSession.getMapper(MemberMapper.class).deleteFollow(followDto);
        if (updatedCount != 0) {
            sqlSession.getMapper(MemberMapper.class).decreaseFollowing(followDto.getMemberId());
            sqlSession.getMapper(MemberMapper.class).decreaseFollower(followDto.getFollowId());
        }
    }

    @Override
    public List<MemberDto> searchName(String name) {
        return sqlSession.getMapper(MemberMapper.class).findByNameLike(name);
    }
}
