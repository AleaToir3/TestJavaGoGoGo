package tech.chillo.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.chillo.sa.entites.Sentiment;
import tech.chillo.sa.repository.SentimentRepository;
import tech.chillo.sa.service.SentimentService;

import java.util.List;

@RestController
@RequestMapping(path = "sentiment",produces ="application/json")
public class SentimentController {
    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }
@ResponseStatus(HttpStatus.CREATED)
@PostMapping( consumes = "application/json")
public void creer(@RequestBody  Sentiment sentiment){
        this.sentimentService.cree(sentiment);
    }
    @GetMapping
    public @ResponseBody List<Sentiment>recherche(){
        return this.sentimentService.rechercher();
    }
    
}
