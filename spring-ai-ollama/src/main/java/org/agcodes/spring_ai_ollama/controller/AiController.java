package org.agcodes.spring_ai_ollama.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Map;
import org.agcodes.spring_ai_ollama.model.Book;
import org.agcodes.spring_ai_ollama.service.BookMockDataService;
import org.agcodes.spring_ai_ollama.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {
  private final ChatService chatService;
  private final BookMockDataService bookMockDataService;

  @Autowired
  public AiController(ChatService chatService, BookMockDataService bookMockDataService) {
    this.chatService = chatService;
    this.bookMockDataService = bookMockDataService;
  }

  @GetMapping("/chat")
  public Map<String, String> ask(@RequestParam String question) {
    return chatService.askOllama(question);
  }

  @GetMapping("/quotes/daily")
  public Map<String, String> getQuoteOfTheDay() {
    return chatService.getQuoteOfTheDay();
  }

  @GetMapping("/books/mock")
  public List<Book> getMockBooks() throws JsonProcessingException {
    return bookMockDataService.generateBooks();
  }

}
