package org.agcodes.spring_ai_model_switcher.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("openai")
public class OpenAiConfig {
  @Value("${spring.ai.openai.api-key}")
  private String apiKey;

  @Value("${spring.ai.openai.model}")
  private String model;

  @Bean
  public OpenAiChatModel openAiChatModel() {
    OpenAiApi api = new OpenAiApi(apiKey);
    OpenAiChatOptions options = OpenAiChatOptions.builder()
        .model(model)
        .build();
    return new OpenAiChatModel(api, options);
  }

  @Bean
  public ChatClient chatClient(OpenAiChatModel model) {
    return ChatClient.builder(model).build();
  }

}
