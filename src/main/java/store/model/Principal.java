package store.model;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import store.model.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Principal
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String login;

  private String password;

  private String firstName;

  private String lastName;

  private String email;

  @Column(name = "BIRTH_DATE")
  @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
  private LocalDate birthDate;

  @Enumerated(EnumType.STRING)
  private Gender gender;

//  todo introduce TO for validation
//  private String confirmPassword;


  public Principal()
  {
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getLogin()
  {
    return login;
  }

  public void setLogin(String login)
  {
    this.login = login;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public LocalDate getBirthDate()
  {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate)
  {
    this.birthDate = birthDate;
  }

  public Gender getGender()
  {
    return gender;
  }

  public void setGender(Gender gender)
  {
    this.gender = gender;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Principal principal = (Principal) o;
    return Objects.equals(id, principal.id) &&
        Objects.equals(login, principal.login) &&
        Objects.equals(password, principal.password) &&
        Objects.equals(firstName, principal.firstName) &&
        Objects.equals(lastName, principal.lastName) &&
        Objects.equals(email, principal.email) &&
        Objects.equals(birthDate, principal.birthDate) &&
        gender == principal.gender;
  }

  @Override
  public String toString()
  {
    return "Principal{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", birthDate=" + birthDate +
        ", gender=" + gender +
        '}';
  }
}