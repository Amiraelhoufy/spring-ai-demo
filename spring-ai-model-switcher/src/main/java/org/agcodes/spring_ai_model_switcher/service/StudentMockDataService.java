package org.agcodes.spring_ai_model_switcher.service;

import java.util.List;
import org.agcodes.spring_ai_model_switcher.model.Student;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class StudentMockDataService {

  private final ChatClient chatClient;

  public StudentMockDataService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  public List<Student> getStudents() {
    PromptTemplate pt = new PromptTemplate("""
                Return a current list of 10 students if exists or generate a new list with random values.
                Each object should contain:
                - an auto-incremented id field.
                - a birthDate field in the format yyyy-MM-dd (no time).
                - a valid email that ends with 'gmail.com', 'hotmail.com', or 'outlook.com' only.
                Do not include any explanations or additional text.
                """);

    List<Student> entity = this.chatClient.prompt(pt.create())
        .call()
        .entity(new ParameterizedTypeReference<>() {
        });
    System.out.println(entity);
    return entity;
  }
}
