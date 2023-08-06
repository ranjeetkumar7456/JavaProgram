package ConstructorExample;



public class ConstructorCallingAnotherConstructorExample
{
    int sum;
    int product;
    ConstructorCallingAnotherConstructorExample(int a, int b)
    {
        this.sum=a+b;
    }

    ConstructorCallingAnotherConstructorExample()
    {
        this(5,4);
    }

    public void display()
    {
        System.out.println("Sum is : "+sum);
    }
    public static void main(String[] args)
    {
        ConstructorCallingAnotherConstructorExample main = new ConstructorCallingAnotherConstructorExample();
        main.display();
    }
}
