// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.edu.cqupt.cblog.domain;

import cn.edu.cqupt.cblog.domain.Album;
import cn.edu.cqupt.cblog.domain.Article;
import cn.edu.cqupt.cblog.domain.Clazz;
import cn.edu.cqupt.cblog.domain.ClazzHonor;
import cn.edu.cqupt.cblog.domain.HonorWall;
import cn.edu.cqupt.cblog.domain.PersonalHonor;
import cn.edu.cqupt.cblog.domain.Student;
import java.util.Set;

privileged aspect Clazz_Roo_JavaBean {
    
    public String Clazz.getClazzName() {
        return this.clazzName;
    }
    
    public void Clazz.setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
    
    public String Clazz.getSchool() {
        return this.school;
    }
    
    public void Clazz.setSchool(String school) {
        this.school = school;
    }
    
    public String Clazz.getMajor() {
        return this.major;
    }
    
    public void Clazz.setMajor(String major) {
        this.major = major;
    }
    
    public String Clazz.getFlagImg() {
        return this.flagImg;
    }
    
    public void Clazz.setFlagImg(String flagImg) {
        this.flagImg = flagImg;
    }
    
    public String Clazz.getSong() {
        return this.song;
    }
    
    public void Clazz.setSong(String song) {
        this.song = song;
    }
    
    public String Clazz.getSongTitle() {
        return this.songTitle;
    }
    
    public void Clazz.setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
    
    public String Clazz.getLyric() {
        return this.lyric;
    }
    
    public void Clazz.setLyric(String lyric) {
        this.lyric = lyric;
    }
    
    public String Clazz.getSongImg() {
        return this.songImg;
    }
    
    public void Clazz.setSongImg(String songImg) {
        this.songImg = songImg;
    }
    
    public String Clazz.getOverview() {
        return this.overview;
    }
    
    public void Clazz.setOverview(String overview) {
        this.overview = overview;
    }
    
    public String Clazz.getClazzImg() {
        return this.clazzImg;
    }
    
    public void Clazz.setClazzImg(String clazzImg) {
        this.clazzImg = clazzImg;
    }
    
    public String Clazz.getSlogan() {
        return this.slogan;
    }
    
    public void Clazz.setSlogan(String slogan) {
        this.slogan = slogan;
    }
    
    public Set<Student> Clazz.getStudents() {
        return this.students;
    }
    
    public void Clazz.setStudents(Set<Student> students) {
        this.students = students;
    }
    
    public Set<Article> Clazz.getArticles() {
        return this.articles;
    }
    
    public void Clazz.setArticles(Set<Article> articles) {
        this.articles = articles;
    }
    
    public Set<Album> Clazz.getAlbums() {
        return this.albums;
    }
    
    public void Clazz.setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
    
    public Set<PersonalHonor> Clazz.getPersonalHonors() {
        return this.personalHonors;
    }
    
    public void Clazz.setPersonalHonors(Set<PersonalHonor> personalHonors) {
        this.personalHonors = personalHonors;
    }
    
    public Set<HonorWall> Clazz.getHonorWalls() {
        return this.honorWalls;
    }
    
    public void Clazz.setHonorWalls(Set<HonorWall> honorWalls) {
        this.honorWalls = honorWalls;
    }
    
    public Set<ClazzHonor> Clazz.getClazzHonors() {
        return this.clazzHonors;
    }
    
    public void Clazz.setClazzHonors(Set<ClazzHonor> clazzHonors) {
        this.clazzHonors = clazzHonors;
    }
    
}
