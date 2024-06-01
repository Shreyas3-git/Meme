package com.crio.starter.repository;



import java.util.List;

import com.crio.starter.data.Meme;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeRepository extends MongoRepository<Meme, Integer> {
 
    // public List<Meme> findByContent(String name, String url, String caption);
        public List<Meme> findByNameAndUrlAndCaption(String name, String url, String caption);



}