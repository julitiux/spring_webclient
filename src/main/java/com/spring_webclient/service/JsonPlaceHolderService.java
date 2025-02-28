package com.spring_webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class JsonPlaceHolderService {

  private final WebClient webClient;

  public JsonPlaceHolderService(WebClient.Builder webClient) {
    this.webClient = webClient.baseUrl("https://jsonplaceholder.typicode.com").build();
  }

}
