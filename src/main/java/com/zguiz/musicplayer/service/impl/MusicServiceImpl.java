package com.zguiz.musicplayer.service.impl;

import com.zguiz.musicplayer.bean.Music;
import com.zguiz.musicplayer.bean.SearchCondition;
import com.zguiz.musicplayer.mapper.MusicMapper;
import com.zguiz.musicplayer.service.MusicService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<Music> searchMusic(String condition,int page) {
        SearchCondition<Music> searchCondition = new SearchCondition<>();
        searchCondition.setSearchString(condition);
        searchCondition.setPage(page);
        return musicMapper.searchMusic(searchCondition);
    }
}
