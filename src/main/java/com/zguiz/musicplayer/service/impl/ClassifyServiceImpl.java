package com.zguiz.musicplayer.service.impl;

import com.zguiz.musicplayer.bean.Classify;
import com.zguiz.musicplayer.mapper.ClassifyMapper;
import com.zguiz.musicplayer.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public List<Classify> getClassify() {
        return classifyMapper.getAllClassify();
    }
}
