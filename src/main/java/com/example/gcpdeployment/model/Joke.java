package com.example.gcpdeployment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Joke
{
    private static int idsCount;

    private int jokeId;
    private String joke;

    public Joke(String joke)
    {
        this.jokeId = idsCount++;
        this.joke = joke;
    }
}

