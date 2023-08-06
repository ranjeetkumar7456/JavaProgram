package MixCode;

enum Planet{
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8),
    PLUTO(9);
    int number;
    Planet(int number)
    {
        this.number=number;
    }


}


public class EnumWithTernary {
    public static void canILiveHere(Planet myPlanet)
    {
        switch (myPlanet)
        {
            case EARTH:
                System.out.println("You can Live here");
                System.out.println("This is planet number as well");
                break;
            default:
                System.out.println("You cant Live here .... yet");
                break;
        }
    }
}
