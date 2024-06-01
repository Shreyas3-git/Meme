package com.crio.starter.MemeRepositoryService;

import java.util.List;

import com.crio.starter.data.Meme;
import com.crio.starter.repository.MemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MemeRepositoryServiceImpl implements MemeRepositoryService {

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
	MongoTemplate mongoTemplate;

    @Override
    public Meme getMemeById(int id) {


        Query query = new Query(Criteria.where("id").is(id));
        Meme meme= mongoTemplate.findOne(query, Meme.class, "memes");

        return meme;
    }

 
    @Override
    public int addMeme(Meme meme) {

 
        return memeRepository.save(meme).getId();
    }

    @Override
    public List<Meme> getLatestMemes() {

        List<Meme> memes = mongoTemplate.find(new Query().with( Sort.by(Sort.Direction.DESC, "id")).limit(100), Meme.class);
        return memes;
    }



@Override
public Boolean checkDuplicateMeme(Meme meme) {

    // Query query = new Query(Criteria.where("name").is(meme.getName().and("url").is(meme.getUrl().and("caption").is(meme.getCaption()));

    // Meme m =  mongoTemplate.findOne(query, Meme.class, "memes");
    List<Meme> m = memeRepository.findByNameAndUrlAndCaption(meme.getName(), meme.getUrl(), meme.getCaption());

    return !m.isEmpty();
}
    
}