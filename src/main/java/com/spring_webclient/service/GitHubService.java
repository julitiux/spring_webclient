package com.spring_webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GitHubService {

  private final WebClient webClient;

  public GitHubService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://api.github.com").build();
  }

  public String getUser(String username) {
    return webClient.get()
      .uri("/users/{username}", username)
      .retrieve()
      .bodyToMono(String.class)
      .block();
  }
}
