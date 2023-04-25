package com.application.controller;

import com.application.model.Reservation;
import com.application.service.ReservationService;
import com.application.service.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    ReservationService articleService = new ReservationServiceImpl();

    // Endpoint
    // http://localhost:8080/api/article
    //    GET
    @GetMapping(value = "article", produces = "application/json")
    public List<Reservation> getAllArticles() {
        List<Reservation> articles = articleService.findAll();
        return articles;
    }

    // Endpoint
    // http://localhost:8080/api/article/stock/5
    //    GET
    @GetMapping(value = "article/stock/{stock}", produces = "application/json")
    public List<Reservation> getAllArticlesWithLowStock(@PathVariable int stock) {
        return articleService.checkStock(stock);
    }

    // Endpoint
    // http://localhost:8080/api/article/2
    //    GET
    @GetMapping(value = "article/{id}", produces = "application/json")
    public Reservation getArticlesById(@PathVariable long id) {
        Reservation article = articleService.findById(id);
        return article;
    }

    // Endpoint
    // http://localhost:8080/api/article
    //    PUT
    @PostMapping(value = "article", consumes = "application/json" , produces = "application/json")
    public Reservation createArticle(@RequestBody Reservation article) {
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
