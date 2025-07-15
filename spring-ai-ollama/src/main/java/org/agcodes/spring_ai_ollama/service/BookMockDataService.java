package org.agcodes.spring_ai_ollama.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import org.agcodes.spring_ai_ollama.model.Book;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class BookMockDataService {

  private final ChatModel chatModel;
  private final ObjectMapper objectMapper;


  public BookMockDataService(OllamaChatModel chatModel, ObjectMapper objectMapper) {
    this.chatModel = chatModel;
    this.objectMapper = objectMapper;
  }

  public String buildPromptFromEntity() {
    return """
            Generate 5 fake 'Book' records with the following fields:
            - id  (integer) auto-incremented starting from 1
            - title (string)
            - author (string)
            - genre (string)
            - publishedDate (a string in exact ISO format: yyyy-MM-dd (e.g., "2020-06-15"))

          Do not use historical or ancient dates like "400 BCE".
          Only use valid ISO-formatted dates from year 1900 to 2025.
          Return ONLY the result as a valid JSON array. Do NOT include explanations and No quotes around the whole objects.
        """;
  }

  public List<Book> generateBooks() throws JsonProcessingException {
    Prompt prompt = new Prompt(buildPromptFromEntity());

    var response = chatModel.call(prompt).getResult().getOutput().getContent();

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule()); // For LocalDate
    objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

//    System.out.println(response);

    List<Book> books = objectMapper.readValue(response, new TypeReference<List<Book>>() {});

    return books;
  }

}

