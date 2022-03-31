package com.yida.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data

@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(unique=true)
    private String account;
    private String name;
    private String password;

    // 消息广场部分
    // 用户发布的文章(list)(@Transient：相当于可以每次从数据库取出暂存)
    @Transient
    List<Article> articles;



    // 部落绑定部分

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;

    @ManyToOne
    @JoinColumn(name = "Building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;



}
