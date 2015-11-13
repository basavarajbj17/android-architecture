package co.techmagic.data.api.model;

public class CreateUserRequest extends Request {

    private int id;

    private String name;
    private String surName;


    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toUrl() {
        return null;
    }

}
