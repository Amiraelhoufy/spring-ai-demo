package org.agcodes.spring_ai_model_switcher.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("ollama")
public class OllamaConfig {
  @Value("${spring.ai.ollama.base-url}")
  private String baseUrl;

  @Value("${spring.ai.ollama.chat.model}")
  private String model;
  @Bean
  public OllamaApi ollamaApi() {
    return new OllamaApi(baseUrl);
  }

  @Bean
  public OllamaChatModel ollamaChatModel(OllamaApi ollamaApi) {
    return OllamaChatModel.builder()
        .ollamaApi(ollamaApi)
        .defaultOptions(
            OllamaOptions.builder()
                .model(model) // Model name (e.g., "llama3", "mistral")
                .build()
        )
        .build();
  }
  @Bean
  public ChatClient chatClient(OllamaChatModel model) {
    return ChatClient.builder(model).build();
  }

}
