package ArrayConcept;

public class JavaMultidimensionalArrays {
    public static void main(String[] args) {
        int[][] a = new int[3][4];

        int[][] a1 = {{1, 2, 3}, {4, 5, 6, 9}, {7}};

        // calculate the length of each row
        System.out.println("Length of row 1: " + a1[0].length);
        System.out.println("Length of row 2: " + a1[1].length);
        System.out.println("Length of row 3: " + a1[2].length);
    }
}
