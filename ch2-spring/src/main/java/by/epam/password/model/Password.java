package by.epam.password.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "password")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login")
    @NotNull
    @NotBlank
    @Size(min = 5, message = "login min = 5")
    private String login;
    @Column(name = "password")
    @NotNull
    @NotBlank
    @Size(min = 5, message = "password min = 5")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "email")
    private String email;
    @Column(name = "registration")
    private Boolean registration;
    @Column(name = "data_registration")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime dataRegistration;
}