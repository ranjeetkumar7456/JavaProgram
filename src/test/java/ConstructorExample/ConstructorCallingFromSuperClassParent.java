package ConstructorExample;

public class ConstructorCallingFromSuperClassParent extends ConstructorCallingFromSuperClass
{

    ConstructorCallingFromSuperClassParent(int version1, int version2)
    {
        super(version1, version2);
    }

    public static void main(String[] args)
    {
        ConstructorCallingFromSuperClassParent test = new ConstructorCallingFromSuperClassParent(9,5);
    }
}
