package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data //Using lombok to handle the getter setters
@NoArgsConstructor //Creates a zero argument constructor
@AllArgsConstructor //Creates an all argument constructor
@Builder
@Document(collection = "track")
public class Track {


    //@GeneratedValue(strategy= GenerationType.AUTO)
    @Id
   private int id;
  private  String name;
   private String comment;

  public Track(String comment, String name) {
  }




}
