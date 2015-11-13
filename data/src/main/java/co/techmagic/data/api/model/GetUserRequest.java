package co.techmagic.data.api.model;

public class GetUserRequest extends Request {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toUrl() {
        return ""+id;
    }
}
