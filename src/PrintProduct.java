public class PrintProduct {
    Product product;

        public PrintProduct(Product product) {
            this.product = product;
        }

        public void PrintTotalProductSales() {

            System.out.println("TOTAL PRODUCT SALES: "
                    + product.GetTotalProductsSold());
        }

        public void PrintAverageProductSales() {

            System.out.println("AVERAGE PRODUCT SALES: "
                    + product.GetAverageProductSold());
        }

        public void PrintMostPopularProduct() {

            System.out.println("MOST POPULAR PRODUCT: "
                    + product.GetMostPopularProduct());
        }
        
}
