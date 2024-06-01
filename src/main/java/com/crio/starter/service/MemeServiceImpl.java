package com.crio.starter.service;

import java.util.List;

import com.crio.starter.MemeRepositoryService.MemeRepositoryService;
import com.crio.starter.MemeRepositoryService.SequenceGeneratorService;
import com.crio.starter.data.Meme;
import com.crio.starter.repository.MemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService {

    @Autowired
    private MemeRepositoryService memeRepositoryService;
     
    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Override
    public List<Meme> findLatestMeme() {

        // System.out.println(memeRepositoryService.getLatestMemes());
        return memeRepositoryService.getLatestMemes();
    }

    @Override
    public boolean alreadyExist(Meme meme) {
        return   memeRepositoryService.checkDuplicateMeme(meme);

    }



    @Override
    public int addMeme(Meme meme) {
        // System.out.println(memeRepository.findAll());
        
    


        meme.setId(sequenceGenerator.generateSequence(Meme.SEQUENCE_NAME));
        
        
        
        int id=  memeRepositoryService.addMeme(meme);
        return id;
    }

    @Override
    public Meme getMemeById(int id) {


      Meme meme=  memeRepositoryService.getMemeById(id);
        return meme;
    }
    
}