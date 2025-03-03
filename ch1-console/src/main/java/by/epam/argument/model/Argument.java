package by.epam.argument.model;

public class Argument {
    private Long id;
    private String argument;

    public Argument() {
    }

    public Argument(Long id, String argument) {
        this.id = id;
        this.argument = argument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return String.format("%d/%s", id, argument);
    }
}
