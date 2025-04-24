package by.epam.number.model;

public class Numbers {
    private Long id;
    private Integer numbers;

    public Numbers() {
    }

    public Numbers(Long id, Integer num) {
        this.id = id;
        this.numbers = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return String.format("%d/%d",id, numbers);
    }
}