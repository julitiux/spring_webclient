package com.spring_webclient.dto;

public record Post(
  String title,
  String body,
  Integer userId
) {
}
