package com.crio.starter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.crio.starter.data.Meme;
import com.crio.starter.exchange.GetRequest;
import com.crio.starter.exchange.GetRequestResponse;
import com.crio.starter.exchange.PostRequestResponse;
import com.crio.starter.service.MemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Validated
@RestController
@RequestMapping(MemeController.Meme_API_ENDPOINT)
public class MemeController {
    public static final String Meme_API_ENDPOINT = "/memes/";
    public static final String Meme_BY_ID = "{id}";
    public static final String Meme_BY_Name = "Nikhil";

  @Autowired
  private  MemeService memeService;


    @GetMapping()
    public ResponseEntity<List<Meme>> getMemes()
    {
       List<Meme> memes= new ArrayList<>( );


          memes= memeService.findLatestMeme();

        return ResponseEntity.ok().body(memes) ;
        
    }
    
    // @GetMapping()
    // public ResponseEntity<String> getMemes()
    // {

    //     return ResponseEntity.ok().body("Hello world new") ;
        
    // }

    @GetMapping(Meme_BY_ID)
    public ResponseEntity<Object> getMemeById(@PathVariable(name = "id") int getRequest)
    {

    Meme meme=  memeService.getMemeById(getRequest);

    if(meme==null)
    {
      return   ResponseEntity.status(404).body("wrong id ");
    }
        return  ResponseEntity.ok().body(meme);
        
    }


    @PostMapping()
   public ResponseEntity<Object>addMeme( @Valid @RequestBody Meme meme)
   {
 

    // if(meme.getName()==null && meme.) {
    //   System.out.print("hello");
    //   return  ResponseEntity.status(404).body("body is empty");
    // }

    if (memeService.alreadyExist(meme))
     {
      return ResponseEntity.status(409).body("content already exists");
     }

            
          int id =memeService.addMeme(meme);   
          
          String ids=Integer.toString(id);
           
          PostRequestResponse postRequestResponse= new PostRequestResponse(ids);
    System.out.println(ids.getClass().getSimpleName());
       return ResponseEntity.ok().body(postRequestResponse);

   }
}