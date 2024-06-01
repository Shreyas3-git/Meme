package com.crio.starter.MemeRepositoryService;

import java.util.List;

import com.crio.starter.data.Meme;

public interface MemeRepositoryService {

    Meme getMemeById(int id);
    Boolean checkDuplicateMeme(Meme meme);
    int addMeme(Meme meme);
    List<Meme> getLatestMemes();



}