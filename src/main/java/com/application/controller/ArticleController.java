package com.application.controller;

import com.application.model.Article;
import com.application.service.ArticleService;
import com.application.service.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {
    ArticleService articleService = new ArticleServiceImpl();

    // Endpoint
    // http://localhost:8080/api/article
    //    GET
    @GetMapping(value = "article", produces = "application/json")
    public List<Article> getAllArticles() {
        List<Article> articles = articleService.findAll();
        return articles;
    }

    // Endpoint
    // http://localhost:8080/api/article/stock/5
    //    GET
    @GetMapping(value = "article/stock/{stock}", produces = "application/json")
    public List<Article> getAllArticlesWithLowStock(@PathVariable int stock) {
        return articleService.checkStock(stock);
    }

    // Endpoint
    // http://localhost:8080/api/article/2
    //    GET
    @GetMapping(value = "article/{id}", produces = "application/json")
    public Article getArticlesById(@PathVariable long id) {
        Article article = articleService.findById(id);
        return article;
    }

    // Endpoint
    // http://localhost:8080/api/article
    //    PUT
    @PostMapping(value = "article", consumes = "application/json" , produces = "application/json")
    public Article createArticle(@RequestBody Article article) {
        return articleService.save(article);
    }

    // Endpoint
    // http://localhost:8080/api/article/2
    //    DEL
    @DeleteMapping("article/{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.remove(id);
    }
}
