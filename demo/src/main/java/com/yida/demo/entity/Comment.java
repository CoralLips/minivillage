package com.yida.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "comment")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int comment_id;

    private String commentContent;
    private Date createdDate;

    // 发布文章所附带的回复评论(list)(@Transient：相当于可以每次从数据库取出暂存)
    @Transient
    List<Comment> comments;

    // 发表评论的用户
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 改评论回复的帖子
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    // 改评论回复的评论
    @ManyToOne
    @JoinColumn(name = "commentReplied_id")
    private Comment commentReplied;
}
