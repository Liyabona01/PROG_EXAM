public class Product implements IProduct {

    String[] products;
    int[][] sales;

    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
        }
        @Override
        public int GetTotalProductsSold() {

            int total = 0;

            for (int i = 0; i < sales.length; i++) {
                for (int j = 0; j < sales[i].length; j++) {

                    total += sales[i][j];

                }
            }

            return total;
        }

        @Override
        public double GetAverageProductSold() {

            int total = GetTotalProductsSold();

            int count = 0;

            for (int i = 0; i < sales.length; i++) {
                count += sales[i].length;
            }

            return (double) total / count;
        }

        @Override
        public String GetMostPopularProduct() {

            int highest = 0;
            int index = 0;

            for (int i = 0; i < sales.length; i++) {

                int productTotal = 0;

                for (int j = 0; j < sales[i].length; j++) {
                    productTotal += sales[i][j];
                }

                if (productTotal > highest) {
                    highest = productTotal;
                    index = i;
                }
            }

            return products[index];
        }
    }


