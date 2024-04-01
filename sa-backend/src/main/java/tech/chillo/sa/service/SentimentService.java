package tech.chillo.sa.service;

import org.springframework.stereotype.Service;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.entites.Sentiment;
import tech.chillo.sa.enums.TypeSentiment;
import tech.chillo.sa.repository.SentimentRepository;

import java.util.List;

@Service
public class SentimentService {
    private SentimentRepository sentimentRepository;
    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    public void cree(Sentiment sentiment){
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        //Analyse sentiment
        if (sentiment.getTexte().contains("nul")) {
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if(type == null){
            return this.sentimentRepository.findAll();
        }else{
            return this.sentimentRepository.findByType(type);
        }
    }


    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
