package com.crio.starter.exchange;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.crio.starter.data.Meme;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRequestResponse {
    
    private  List<Meme> memes;
}