package org.agcodes.spring_ai_ollama.config;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}
