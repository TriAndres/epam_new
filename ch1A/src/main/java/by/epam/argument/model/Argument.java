package by.epam.argument.model;

public class Argument {
    private Long id;
    private Integer task;
    private String argument;

    public Argument() {
    }

    public Argument(Long id, Integer task, String argument) {
        this.id = id;
        this.task = task;
        this.argument = argument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTask() {
        return task;
    }

    public void setTask(Integer task) {
        this.task = task;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "Argument{" +
                "id=" + id +
                ", task=" + task +
                ", argument='" + argument + '\'' +
                '}';
    }
}
