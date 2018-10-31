import javax.persistence.*;

/**
 * Created by sergii on 31.10.18.
 */

@Entity
@SuppressWarnings("all")
@Table(name = "product_tbl_temp")
@NamedQuery(name = "ProductJpa.getAll", query = "SELECT c from ProductJpa c")
public class ProductJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private float price;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}
