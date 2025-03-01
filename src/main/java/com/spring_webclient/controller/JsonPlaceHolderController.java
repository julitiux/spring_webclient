package com.spring_webclient.controller;

import com.spring_webclient.dto.Post;
import com.spring_webclient.service.JsonPlaceHolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/json_place_holder")
public class JsonPlaceHolderController {

  private final JsonPlaceHolderService jsonPlaceHolderService;

  public JsonPlaceHolderController(JsonPlaceHolderService jsonPlaceHolderService) {
    this.jsonPlaceHolderService = jsonPlaceHolderService;
  }

  @PostMapping("/create_post")
  public Mono<ResponseEntity<String>> createPost(@RequestBody Post post) {
    return jsonPlaceHolderService.createPost(post)
      .map(response -> ResponseEntity.ok().body(response))
      .defaultIfEmpty(ResponseEntity.status(500).build());
  }
}
