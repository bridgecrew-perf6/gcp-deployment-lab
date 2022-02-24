package com.example.gcpdeployment.service;

import com.example.gcpdeployment.model.Joke;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JokeService
{
    private List<Joke> jokes = new ArrayList(List.of(
        new Joke("Chuck Norris doesn’t read books. He stares them down until he gets the information he wants."),
        new Joke("Time waits for no man. Unless that man is Chuck Norris."),
        new Joke("If you spell Chuck Norris in Scrabble, you win. Forever."),
        new Joke("Chuck Norris breathes air … five times a day."),
        new Joke("In the Beginning there was nothing … then Chuck Norris roundhouse kicked nothing and told it to " +
            "get a job."),
        new Joke("When God said, “Let there be light!” Chuck said, “Say Please.”"),
        new Joke("Chuck Norris has a mug of nails instead of coffee in the morning."),
        new Joke("If Chuck Norris were to travel to an alternate dimension in which there was another Chuck " +
            "Norris and they both fought, they would both win."),
        new Joke("The dinosaurs looked at Chuck Norris the wrong way once. You know what happened to them."),
        new Joke("Chuck Norris’ tears cure cancer. Too bad he has never cried."),
        new Joke("Chuck Norris once roundhouse kicked someone so hard that his foot broke the speed of light"),
        new Joke("If you ask Chuck Norris what time it is, he always says, ‘Two seconds till.’ After you ask, " +
            "‘Two seconds to what?’ he roundhouse kicks you in the face.")
    ));

    //GET
    public Optional<Joke> jokeById(int id)
    {
        return jokes.stream()
            .filter(joke -> joke.getJokeId() == id)
            .findFirst();
    }

    //GET
    public List<Joke> getJokes()
    {
        return jokes;
    }

    //POST
    public Joke addJoke(Joke newJoke)
    {
        jokes.add(newJoke);
        return newJoke;
    }

    //PUT
    public Joke editJoke(int id, Joke editedJoke)
    {
        //get joke from DB, edit the data, save it
        Optional<Joke> query = jokeById(id);
        if (jokes.isEmpty())
        {
            Joke toEdit = query.get();
            toEdit.setJoke(editedJoke.getJoke());
            return toEdit;
        }
        else
        {
            throw new NoSuchElementException("Element not found!");
        }
    }

    //DELETE
    public void deleteJoke(int id)
    {
        Optional<Joke> query = jokeById(id);
        if (query.isPresent())
        {
            jokes = jokes.stream()
                .filter(joke -> joke.getJokeId() != id)
                .collect(Collectors.toList());
        }
        else
        {
            throw new NoSuchElementException("Element not found!");
        }
    }
}

