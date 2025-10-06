package example.newspapercrud.dao.model;

import newspapercrud.domain.model.TypeDTO;

public class ArticleEntity {
    private int id;
    private String name;
    private TypeDTO type;
    private int npaperId;
    private double avgRanting;

    public double getAvgRanting() {
        return avgRanting;
    }

    public void setAvgRanting(double avgRanting) {
        this.avgRanting = avgRanting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public int getNpaperId() {
        return npaperId;
    }

    public void setNpaperId(int npaperId) {
        this.npaperId = npaperId;
    }
}
