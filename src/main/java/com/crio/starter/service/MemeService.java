package com.crio.starter.service;

import java.util.List;

import com.crio.starter.data.Meme;

public interface MemeService {
    
    int addMeme(Meme meme);
 Meme getMemeById(int id);


     List<Meme> findLatestMeme();

     public boolean alreadyExist(Meme meme);


}