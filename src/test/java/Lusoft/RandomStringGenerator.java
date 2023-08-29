package Lusoft;

import java.util.Random;

public class RandomStringGenerator
{
    public static void randomGenerator()
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int minNumber=10;
        int maxNumber = 99;
        char firstCombination = (char) ('A' + random.nextInt(26)); // Random uppercase letter
        int secondCombination = minNumber + random.nextInt(maxNumber - minNumber + 1); // Random number
        char thirdCombination= (char) ('A' + random.nextInt(26)); // Random uppercase letter
        char fourthCombination = (char) ('A' + random.nextInt(26)); // Random uppercase letter
        sb.append(firstCombination).append(secondCombination).append(thirdCombination).append(fourthCombination);
        System.out.println(sb);
    }
    public static void main(String[] args)
    {
        randomGenerator();
    }
}
