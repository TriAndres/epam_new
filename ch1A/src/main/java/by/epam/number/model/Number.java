package by.epam.number.model;

public class Number {
    private Long id;
    private Integer num;

    public Number() {
    }

    public Number(Long id, Integer num) {
        this.id = id;
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%d/%d",id,num);
    }
}
