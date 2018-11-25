/**
 * Created by sergii on 25.11.18.
 */
public class Model {

    private int id;
    private String packageName;

    public Model(int id, String packageName) {
        setId(id);
        setPackageName(packageName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packegeName) {
        this.packageName = packegeName;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Model)obj).id == id;
    }

    @Override
    public String toString() {
        return "" +id;
    }
}
