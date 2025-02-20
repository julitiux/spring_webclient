package com.spring_webclient.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

  public Mono<String> getUser(String username) {
    return webClient.get()
      .uri("/users/{username}", username)
      .retrieve()
      .bodyToMono(String.class);
  }

  public Mono<String> getUserInfo(String username) {
    return webClient
      .get()
      .uri("/users/{username}", username)
      .retrieve()
      .bodyToMono(String.class);
  }

  public ResponseEntity<String> getStringWithResponseEntity(String username) {
    return webClient
      .get()
      .uri("/users/{username}", username)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .onStatus(HttpStatusCode::is4xxClientError,
        response -> Mono.error(new RuntimeException("ERROR DEL CLIENTE"))
      )
      .toEntity(String.class)
      .block();

  }
}
