package com.athome.feel.model.service;

import com.athome.feel.model.MusicDto;
import com.athome.feel.model.SonglikeDto;

import java.util.List;

public interface MusicService {

    List<MusicDto> addMusicIfAbsent(List<MusicDto> musicDtos);
    void likeMusic(SonglikeDto songlikeDto);
    void dislikeMusic(SonglikeDto songlikeDto);
}
