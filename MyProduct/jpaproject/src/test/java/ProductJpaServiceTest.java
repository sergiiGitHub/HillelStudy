import org.junit.Test;


/**
 * Created by sergii on 30.10.18.
 */
public class ProductJpaServiceTest {

    ProductService service = new ProductService();

    @Test
    public void testSaveRecord() throws Exception {
        ProductJpa productJpa = new ProductJpa();
        productJpa.setName("SEAT");
        productJpa.setPrice(100);

        ProductJpa productJpaFromDb = service.add(productJpa);
        System.out.println(productJpaFromDb);
    }
}
