package example.newspapercrud.domain.model;

import lombok.Getter;
import lombok.Setter;

public class ArticleDTO {
    @Setter
    private int id;
    @Setter
    private String name;
    @Setter
    private  TypeDTO type;
    @Setter
    private int npaperId;
    @Setter
    private double avgRanting;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TypeDTO getType() {
        return type;
    }

    public int getNpaperId() {
        return npaperId;
    }

    public double getAvgRanting() {
        return avgRanting;
    }

    public void setName(String name) {
    }
}
