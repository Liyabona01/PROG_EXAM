import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class ProductTest {

        @Test
        public void testTotalSales() {

            String[] products = {
                    "Cozy Nights Monarch",
                    "Restonic Barbados",
                    "Sealy Phuket"
            };

            int[][] sales = {
                    {25, 18, 20},
                    {15, 10, 12},
                    {18, 15, 20}
            };

            Product product = new Product(products, sales);

            assertEquals(153, product.GetTotalProductsSold());
        }

        @Test
        public void testAverageSales() {

            String[] products = {
                    "Cozy Nights Monarch",
                    "Restonic Barbados",
                    "Sealy Phuket"
            };

            int[][] sales = {
                    {25, 18, 20},
                    {15, 10, 12},
                    {18, 15, 20}
            };

            Product product = new Product(products, sales);

            assertEquals(17.0, product.GetAverageProductSold(), 0.01);
        }

}
