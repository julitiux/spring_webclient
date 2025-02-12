package com.spring_webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GitHubService {

  private final WebClient webClient;

  public GitHubService(WebClient webClient) {
    this.webClient = webClient;
  }

//  public GitHubService(WebClient.Builder webClient) {
//    this.webClient = webClient.baseUrl("https://api.github.com").build();
//  }

  public Mono<String> getUser(String username){
    return webClient.get()
      .uri("/users/{username}", username)
      .retrieve()
      .bodyToMono(String.class);
  }

  public Mono<String> getUserInfo(String username){
    return webClient
      .get()
      .uri("/users/{username}", username)
      .retrieve()
      .bodyToMono(String.class);
  }
}
