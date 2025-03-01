package com.spring_webclient.service;

import com.spring_webclient.dto.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class JsonPlaceHolderService {

  private final WebClient webClient;

  public JsonPlaceHolderService(WebClient.Builder webClient) {
    this.webClient = webClient.baseUrl("https://jsonplaceholder.typicode.com").build();
  }

  public Mono<String> createPost(Post newPost){
    return webClient
      .post()
      .uri("/posts")
      .bodyValue(newPost)
      .retrieve()
      .bodyToMono(String.class);
  }
}
