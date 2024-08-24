package com.zguiz.musicplayer.controller;

import com.zguiz.musicplayer.Test.AopDemo1;
import com.zguiz.musicplayer.Test.IocDemo;
import com.zguiz.musicplayer.bean.Classify;
import com.zguiz.musicplayer.bean.Comment;
import com.zguiz.musicplayer.bean.Music;
import com.zguiz.musicplayer.mongodb.dao.CommentRepository;
import com.zguiz.musicplayer.service.ClassifyService;
import com.zguiz.musicplayer.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class OldSystemController extends BaseController{

    @Autowired
    private MusicService musicService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private AopDemo1 demo1;

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/findMusic")
    @ResponseBody
    public List<Music> searchMusicList(@RequestParam(value = "cond",required = false) String cond,@RequestParam("pageNo") int page){
        return musicService.searchMusic(cond,page);
    }

    @RequestMapping("/findAllMusicClassify")
    @ResponseBody
    public List<Classify> getClassify(){
        IocDemo demo =  new IocDemo();
        demo.setTest("test111");
        List<Comment> commentList = commentRepository.findAll();
        //demo1.test2(demo);
        return classifyService.getClassify();
    }

    @RequestMapping("/findMusicByList")
    @ResponseBody
    public List<Music> getMusicByList(@RequestParam(value = "listId") String id,@RequestParam(value = "pageNo",required = false) Integer page){
        return musicService.searchMusicByListId(id,page);
    }

    @RequestMapping("toIndex")
    public ModelAndView toIndex(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }
}
