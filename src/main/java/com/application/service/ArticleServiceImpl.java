package com.application.service;

import com.application.model.Article;
import com.application.repositories.ArticleRepository;
import com.application.repositories.ArticleRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{

    ArticleRepository articleRepository = new ArticleRepositoryImpl();
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void remove(long id) {
        articleRepository.remove(id);

    }
    @Override
    public List<Article> checkStock(int stock){
        List<Article> filteredArticles = new ArrayList<>();
        for (Article article: articleRepository.findAll()) {
            if (article.getStock() <= stock) filteredArticles.add(article);

        }
        return filteredArticles;
    }
}
