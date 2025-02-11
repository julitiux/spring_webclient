package com.spring_webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GitHubService {

  private final WebClient webClient;

  public GitHubService(WebClient.Builder webClient) {
    this.webClient = webClient.baseUrl("https://api.github.com").build();
  }
}
