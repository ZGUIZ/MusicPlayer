package com.zguiz.musicplayer.controller;

import com.zguiz.musicplayer.bean.Music;
import com.zguiz.musicplayer.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OldSystemController {

    @Autowired
    private MusicService musicService;

    @RequestMapping("/findMusic")
    @ResponseBody
    public List<Music> searchMusicList(@RequestParam(value = "cond",required = false) String cond,@RequestParam("pageNo") int page){
        return musicService.searchMusic(cond,page);
    }
}