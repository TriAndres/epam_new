package by.epam.password.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "password")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @NotBlank
    @Size(min = 5, message = "login min = 5")
    @Column(name = "login")
    private String login;
    @NotNull
    @NotBlank
    @Size(min = 5, message = "password min = 5")
    @Column(name = "password")
    private String password;
    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @NotBlank
    @Column(name = "second_name")
    private String secondName;
    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;
    @Column(name = "registration")
    private String registration;
    @Column(name = "data_registration")
    private String dataRegistration;
}