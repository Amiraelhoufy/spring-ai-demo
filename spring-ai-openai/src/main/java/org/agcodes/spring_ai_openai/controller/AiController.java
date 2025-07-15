package org.agcodes.spring_ai_openai.controller;

import org.agcodes.spring_ai_openai.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

  private final ChatService chatService;

  public AiController(ChatService chatService) {
    this.chatService = chatService;
  }

  @GetMapping("/chat")
  public String ask(@RequestParam String question) {
    return chatService.askOpenai(question);
  }

  @GetMapping("/quote/daily")
  public String getQuoteOfTheDay() {
    return chatService.getQuoteOfTheDay();
  }

}
