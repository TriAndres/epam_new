package by.epam.password.model;

public class Password {
    private Long id;
    private String login;
    private String password;
    private Boolean registration;
    private String name;
    private String localDateTime;
    private Integer interval;

    /*
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
     */
    public Password(Long id,
                    String login,
                    String password,
                    Boolean registration,
                    String name,
                    String localDateTime,
                    Integer interval) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.registration = registration;
        this.name = name;
        this.localDateTime = localDateTime;
        this.interval = interval;
    }

    public Password() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return String.format("%d/%s/%s/%b/%s/%s/%d",
                id, login, password, registration, name, localDateTime, interval);
    }
}