package com.zguiz.musicplayer.controller;

import com.zguiz.musicplayer.bean.Classify;
import com.zguiz.musicplayer.bean.Music;
import com.zguiz.musicplayer.service.ClassifyService;
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
    @Autowired
    private ClassifyService classifyService;

    @RequestMapping("/findMusic")
    @ResponseBody
    public List<Music> searchMusicList(@RequestParam(value = "cond",required = false) String cond,@RequestParam("pageNo") int page){
        return musicService.searchMusic(cond,page);
    }

    @RequestMapping("/findAllMusicClassify")
    @ResponseBody
    public List<Classify> getClassify(){
        return classifyService.getClassify();
    }

    @RequestMapping("/findMusicByList")
    @ResponseBody
    public List<Music> getMusicByList(@RequestParam(value = "listId") String id,@RequestParam(value = "pageNo",required = false) Integer page){
        return musicService.searchMusicByListId(id,page);
    }
}
