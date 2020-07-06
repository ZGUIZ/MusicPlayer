package com.zguiz.musicplayer.service;

import com.zguiz.musicplayer.bean.Music;
import com.zguiz.musicplayer.bean.SearchCondition;

import java.util.List;

public interface MusicService {
    List<Music> searchMusic(String condition,int page);

}
