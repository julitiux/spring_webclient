package com.spring_webclient.controller;

import com.spring_webclient.service.GitHubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/github")
public class GitHubController {

  private final GitHubService gitHubService;

  public GitHubController(GitHubService gitHubService) {
    this.gitHubService = gitHubService;
  }

  @GetMapping("/user/{username}")
  public Mono<String> getUser(@PathVariable String username) {
    return gitHubService.getUser(username);
  }

  @GetMapping("/userInfo/{username}")
  public Mono<String> getUserInfo(@PathVariable String username) {
    return gitHubService.getUserInfo(username);
  }
}
