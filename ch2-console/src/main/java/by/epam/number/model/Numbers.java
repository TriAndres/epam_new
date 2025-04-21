package by.epam.number.model;

public class Numbers {
    private Long id;
    private Integer num;

    public Numbers() {
    }

    public Numbers(Long id, Integer num) {
        this.id = id;
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.format("%d/%d",id,num);
    }
}