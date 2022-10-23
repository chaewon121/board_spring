package com.example.board.dto;

import com.example.board.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString //롬복의 tostring
@AllArgsConstructor //롬복의
@Setter
@NoArgsConstructor
public class ArticleForm {
    private Long id;
    private String title;
    private String content;
   /*
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
    */ //->롬복의 allconstructor로 대체

    /*
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    */ //->롬복의 tostring으로 대체
    public Article toEntity() {
        return new Article(id, title, content);    }
}
