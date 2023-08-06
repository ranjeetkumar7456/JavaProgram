package ArrayConcept;

public class MaxProductOfTwoValuesExample {
    public static int findMaxProduct(int[] array) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int product = array[i] * array[j];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        return maxProduct;
    }

    public static int findSecondMaxProduct(int[] array) {
            int maxProduct = Integer.MIN_VALUE;
            int secondMaxProduct = Integer.MIN_VALUE;

            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    int product = array[i] * array[j];
                    if (product > maxProduct) {
                        secondMaxProduct = maxProduct;
                        maxProduct = product;
                    } else if (product > secondMaxProduct && product < maxProduct) {
                        secondMaxProduct = product;
                    }
                }
            }

            return secondMaxProduct;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int maxProduct = findMaxProduct(array);
        System.out.println("Maximum product: " + maxProduct);
        /*int maxProduct1 = Integer.MIN_VALUE;
        System.out.println("----------"+maxProduct1);*/
        System.out.println("===========================");
        System.out.println(findSecondMaxProduct(array));
    }
}
