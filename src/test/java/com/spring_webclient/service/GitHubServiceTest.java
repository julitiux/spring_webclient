package com.spring_webclient.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GitHubServiceTest {

  @Autowired
  GitHubService gitHubService;

  @Test
  void shouldGetGitHubUser() {

    String response = gitHubService.getUser("julitiux");
    assertNotNull(response);
    assertTrue(response.contains("julitiux"));
  }
}