package tech.chillo.sa.service;

import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.entites.Sentiment;
import tech.chillo.sa.enums.TypeSentiment;
import tech.chillo.sa.repository.SentimentRepository;

import javax.swing.text.html.parser.Entity;
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
        if (!this.sentimentRepository.existsById(id)) {
            throw new EntityNotFoundException("L'entité avec l'ID " + id + " n'existe pas et ne peut être supprimée.");
        }
        try {
            this.sentimentRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Une erreur est survenue lors de la suppression de l'entité.", e);
        }
    }
}
