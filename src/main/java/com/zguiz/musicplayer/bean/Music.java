package com.zguiz.musicplayer.bean;

import org.springframework.data.annotation.Id;

public class Music {
    @Id
    private String id;
    //音乐名
    private String musicName;
    //歌手
    private String artist;
    //比特率
    private Integer bps;
    //长度
    private Long length;
    //链接
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getBps() {
        return bps;
    }

    public void setBps(Integer bps) {
        this.bps = bps;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
