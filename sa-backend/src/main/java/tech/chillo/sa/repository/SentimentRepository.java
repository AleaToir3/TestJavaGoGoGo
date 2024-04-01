package tech.chillo.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.sa.entites.Sentiment;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer > {
}
