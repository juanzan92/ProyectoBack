package tesis.dtos.entities;

public class PocDTO {
    int value1;
    String description;

    public PocDTO(int value1, String description) {
        this.value1 = value1;
        this.description = description;
    }

    public PocDTO() {
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
