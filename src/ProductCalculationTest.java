import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class ProductCalculationsTest {

        // UNIT TEST 1
        @Test
        public void GetVat_WithValidData_ReturnsCorrectValue() {

            ProductCalculations product =
                    new ProductCalculations(3500);
            assertEquals(525.0, product.GetVat(), 0.01);
        }

        // UNIT TEST 2
        @Test
        public void GetTotal_WithValidData_ReturnsCorrectValue() {

            ProductCalculations product =
                    new ProductCalculations(3500);

            assertEquals(4200.0, product.GetTotal(), 0.01);
        }

    }
