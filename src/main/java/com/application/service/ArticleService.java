package com.application.service;

import com.application.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();
    Article findById(long id);
    Article save(Article article);
    void remove(long id);
    List<Article> checkStock(int stock);
}
