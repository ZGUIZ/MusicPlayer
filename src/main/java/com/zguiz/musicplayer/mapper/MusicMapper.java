package com.zguiz.musicplayer.mapper;

import com.zguiz.musicplayer.bean.Music;
import com.zguiz.musicplayer.bean.SearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {
    /**
     * 根据searchString字符串搜索音乐
     * @param conditionObject
     * @return
     */
    List<Music> searchMusic(SearchCondition<Music> conditionObject);
}
