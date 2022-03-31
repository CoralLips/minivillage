package com.yida.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "article")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int article_id;

    private String articleTitle;
    private String articleContent;
    private Date createdDate;

    private int articleViewed;
    private int likesNumber;
    private int dislikesNumber;

    // 发布文章所附带的回复评论(list)(@Transient：相当于可以每次从数据库取出暂存)
    @Transient
    List<Comment> comments;

    // 发表文章的用户
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
