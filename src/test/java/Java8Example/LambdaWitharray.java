package Java8Example;

public class LambdaWitharray {
    public static void main(String[] args) {
        initialize_an_array_usingLambda[] alg = new initialize_an_array_usingLambda[] {
                (a, b) -> a+b,
                (a, b) -> a-b,
                (a, b) -> a*b,
                (a, b) -> a/b
        };

        initialize_an_array_usingLambda[] alg1 = new initialize_an_array_usingLambda[] {
                (a, b) -> a*100+b*100,
                (a, b) -> a*100-b*10,
                (a, b) -> a*100*b*10,
                (a, b) -> a*100/b*10
        };

        initialize_an_array_usingLambda[] alg2 = new initialize_an_array_usingLambda[] {
                (a, b) -> a*100+b*100,
                (a, b) -> a*100-b*10,
                (a, b) -> a*100*b*10,
                (a, b) -> a*100/b*10
        };


        /*System.out.println("The addition of a and b is: " + alg[0].operate(30, 20));
        System.out.println("The subtraction of a and b is: " + alg[1].operate(30, 20));
        System.out.println("The multiplication of a and b is: " + alg[2].operate(30, 20));
        System.out.println("The division of a and b is: " + alg[3].operate(30, 20));
        System.out.println("The division of a and b is: " + alg[3].operate(15,6));*/

        System.out.println("The division of a and b is: " + alg1[3].operate(5,5));
    }

}
