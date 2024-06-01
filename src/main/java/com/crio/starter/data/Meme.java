package com.crio.starter.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "memes")
@NoArgsConstructor
@AllArgsConstructor
public class Meme {

    @Transient
    public static final String SEQUENCE_NAME = "posts_sequence";
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    @NotNull
    private String caption;
   

}