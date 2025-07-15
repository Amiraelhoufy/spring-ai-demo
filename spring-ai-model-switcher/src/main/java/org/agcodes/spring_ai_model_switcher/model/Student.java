package org.agcodes.spring_ai_model_switcher.model;
import java.time.LocalDate;

public class Student {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Gender gender;
  private LocalDate dateOfBirth;

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public Gender getGender() {
    return gender;
  }
}
