package org.agcodes.spring_ai_ollama.service;


import java.util.Map;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  private final OllamaChatModel chatModel;

  @Autowired
  public ChatService(OllamaChatModel chatModel) {
    this.chatModel = chatModel;
  }

  public String generateResponse(String message) {
    return chatModel.call(message);
  }

  public Map<String, String> askOllama(String question) {
    return Map.of("generation", this.chatModel.call(question));

  }

  public Map<String, String> getQuoteOfTheDay() {
    String question = "Provide a short motivating Quote 10 words or less";
    return Map.of("generation", this.chatModel.call(question));
  }
}