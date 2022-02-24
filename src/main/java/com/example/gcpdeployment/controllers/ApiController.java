package com.example.gcpdeployment.controllers;

import com.example.gcpdeployment.model.Joke;
import com.example.gcpdeployment.service.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

public class ApiController
{
    private JokeService service;

    public ApiController(JokeService service)
    {
        this.service = service;
    }

    @GetMapping("")
    public List<Joke> allJokes()
    {
        return service.getJokes();
    }

    @GetMapping("{id}")
    public ResponseEntity<Joke> jokeById(@PathVariable int id)
    {
        return new ResponseEntity<>(service.jokeById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Joke> addJoke(@RequestBody Joke joke)
    {
        return new ResponseEntity<>(service.addJoke(joke), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Joke> editJoke(@PathVariable int id,
                                         @RequestBody Joke updateJoke)
    {
        return new ResponseEntity<>(service.editJoke(id, updateJoke),
                HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteJoke(@PathVariable int id)
    {
        service.deleteJoke(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> controllerExceptionHandler()
    {
        return new ResponseEntity<>("Element not found", HttpStatus.NOT_FOUND);
    }
}
