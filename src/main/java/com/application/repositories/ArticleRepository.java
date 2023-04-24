package com.application.repositories;

import com.application.model.Article;

import java.util.List;

public interface ArticleRepository {
    List<Article> findAll();
    Article findById(long id);
    Article save(Article article);
    void remove(long id);
}
