package Roopal;

import java.util.Random;

public class JavaEnumGetRandomElement {
    enum ColorEnum {
        GREEN,
        BLUE,
        RED,
        YELLOW;

        public static ColorEnum generateRandomColor() {
            ColorEnum[] values = ColorEnum.values();
            int length = values.length;
            int randIndex = new Random().nextInt(length);
            return values[randIndex];
        }
    }

    public static void main(String[] args) {
        System.out.println(ColorEnum.generateRandomColor()); // RED
        System.out.println(ColorEnum.generateRandomColor()); // YELLOW
        System.out.println(ColorEnum.generateRandomColor()); // GREEN
    }
}
