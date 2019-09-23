package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dimensions {
    @JsonProperty("height")
    private int height;

    @JsonProperty("width")
    private int width;

    @JsonProperty("depth")
    private int depth;

    @JsonProperty("weight")
    private int weight;

    public int getHeight() {
        return height;
    }

    public Dimensions setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Dimensions setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getDepth() {
        return depth;
    }

    public Dimensions setDepth(int depth) {
        this.depth = depth;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Dimensions setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}
