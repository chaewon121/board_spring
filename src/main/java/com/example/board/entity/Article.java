package com.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity //디비가 얘를 인식할 수 있게
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }


    /*
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    /* //-> 롬복의 allconstructor 로 대체
     */
    /*
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }*/ //롬복의 tostring으로 대체

   // Article(){} -> 롬복의 noarsconstructor로
}