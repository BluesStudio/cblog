// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.edu.cqupt.cblog.domain;

import cn.edu.cqupt.cblog.domain.Article;
import cn.edu.cqupt.cblog.domain.ArticleComment;
import cn.edu.cqupt.cblog.domain.Student;
import java.util.Date;

privileged aspect ArticleComment_Roo_JavaBean {
    
    public String ArticleComment.getContent() {
        return this.content;
    }
    
    public void ArticleComment.setContent(String content) {
        this.content = content;
    }
    
    public Date ArticleComment.getArticleCommentDate() {
        return this.articleCommentDate;
    }
    
    public void ArticleComment.setArticleCommentDate(Date articleCommentDate) {
        this.articleCommentDate = articleCommentDate;
    }
    
    public Student ArticleComment.getStudent() {
        return this.student;
    }
    
    public void ArticleComment.setStudent(Student student) {
        this.student = student;
    }
    
    public Article ArticleComment.getArticle() {
        return this.article;
    }
    
    public void ArticleComment.setArticle(Article article) {
        this.article = article;
    }
    
}
