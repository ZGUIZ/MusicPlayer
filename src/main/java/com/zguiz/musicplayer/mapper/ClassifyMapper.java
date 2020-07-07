package com.zguiz.musicplayer.mapper;

import com.zguiz.musicplayer.bean.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassifyMapper {
    List<Classify> getAllClassify();
}
