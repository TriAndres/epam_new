package by.epam.password.modell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Password {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private Boolean registration;
    private LocalDateTime dataRegistration;

    public Password() {
    }

    public Password(Long id,
                    String login,
                    String password,
                    String firstName,
                    String secondName,
                    String email,
                    Boolean registration,
                    LocalDateTime dataRegistration) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.registration = registration;
        this.dataRegistration = dataRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRegistration() {
        return registration;
    }

    public void setRegistration(Boolean registration) {
        this.registration = registration;
    }

    public LocalDateTime getDataRegistration() {
        return dataRegistration;
    }

    public void setDataRegistration(LocalDateTime dataRegistration) {
        this.dataRegistration = dataRegistration;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
        return    id + "/"
                + login + "/"
                + password + "/"
                + firstName + "/"
                + secondName + "/"
                + email + "/"
                + registration + "/"
                + dataRegistration.format(formatter);
    }
}