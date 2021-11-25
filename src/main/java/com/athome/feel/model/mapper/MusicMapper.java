package com.athome.feel.model.mapper;

import com.athome.feel.model.MusicDto;
import com.athome.feel.model.SonglikeDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicMapper {

    MusicDto findById(String youtubeId);

    void insertSong(MusicDto musicDto);
    
    void likeMusic(SonglikeDto songlikeDto);
    
    void dislikeMusic(SonglikeDto songlikeDto);
}
