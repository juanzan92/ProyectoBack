package tesis.entities.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Picture {
    private String index;
    private String src;

    @JsonProperty("img_desc")
    private String imgDescription;

    public String getIndex() {
        return index;
    }

    public String getSrc() {
        return src;
    }


    public void setIndex(String index) {
        this.index = index;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getImgDescription() {
        return imgDescription;
    }

    public void setImgDescription(String imgDescription) {
        this.imgDescription = imgDescription;
    }
}
