package org.agcodes.spring_ai_openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
  private final ChatClient chatClient;

  // Spring will automatically provide the builder
  public ChatService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  public String askOpenai(String question) {
    return chatClient.prompt()
        .user(question)
        .call()
        .content();
  }

  public String getQuoteOfTheDay() {
    String prompt= "Provide a short, inspiring Quote of the Day that motivates people to stay positive and take action";
    PromptTemplate promptTemplate = new PromptTemplate(prompt);
    return chatClient.prompt(promptTemplate.getTemplate())  // pass the template string
        .call()
        .content();
  }
}
