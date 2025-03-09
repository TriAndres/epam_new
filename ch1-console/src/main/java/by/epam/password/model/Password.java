package by.epam.password.model;

public class Password {
     private Long id;
     private String login;
     private String password;
     private Boolean registration;
     private String registrationLocalDateTime;
     private Long employeeId;

     public Password(Long id,
                     String login,
                     String password,
                     Boolean registration,
                     String registrationLocalDateTime,
                     Long employeeId) {
         this.id = id;
         this.login = login;
         this.password = password;
         this.registration = registration;
         this.registrationLocalDateTime = registrationLocalDateTime;
         this.employeeId = employeeId;
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

    public Boolean getRegistration() {
        return registration;
    }

    public void setRegistration(Boolean registration) {
        this.registration = registration;
    }

    public String getRegistrationLocalDateTime() {
        return registrationLocalDateTime;
    }

    public void setRegistrationLocalDateTime(String registrationLocalDateTime) {
        this.registrationLocalDateTime = registrationLocalDateTime;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return String.format("%d/%s/%s/%b/%s/%d",
                id, login, password, registration, registrationLocalDateTime, employeeId);
    }
}