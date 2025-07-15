package org.agcodes.spring_ai_model_switcher.controller;

import java.util.List;
import org.agcodes.spring_ai_model_switcher.model.Student;
import org.agcodes.spring_ai_model_switcher.service.StudentMockDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai/")
public class AiController {

  private final StudentMockDataService studentMockDataService;

  public AiController(StudentMockDataService studentMockDataService) {
    this.studentMockDataService = studentMockDataService;
  }

  @GetMapping("/students/mock")
  public List<Student> getStudents() {
    return studentMockDataService.getStudents();
  }
}
