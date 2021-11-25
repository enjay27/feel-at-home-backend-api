package com.athome.feel.model.service;

import com.athome.feel.model.MusicDto;
import com.athome.feel.model.SonglikeDto;
import com.athome.feel.model.mapper.MemberMapper;
import com.athome.feel.model.mapper.MusicMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<MusicDto> addMusicIfAbsent(List<MusicDto> musicDtos) {
    	List<MusicDto> result = new ArrayList<MusicDto>();
    	
        for (MusicDto musicDto : musicDtos) {
            MusicDto foundDto = sqlSession.getMapper(MusicMapper.class).findById(musicDto.getYoutube_id());
            if (foundDto == null) {
                sqlSession.getMapper(MusicMapper.class).insertSong(musicDto);
                foundDto = sqlSession.getMapper(MusicMapper.class).findById(musicDto.getYoutube_id());
            }
            result.add(foundDto);
        }
        
        return result;
    }

	@Override
	public void likeMusic(SonglikeDto songlikeDto) {
		sqlSession.getMapper(MusicMapper.class).likeMusic(songlikeDto);	
	}

	@Override
	public void dislikeMusic(SonglikeDto songlikeDto) {
		sqlSession.getMapper(MusicMapper.class).dislikeMusic(songlikeDto);
	}
}
