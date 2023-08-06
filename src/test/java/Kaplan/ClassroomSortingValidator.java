package Kaplan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassroomSortingValidator {
    public static void main(String[] args) {
        // Create a list of classrooms with their details
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(new Classroom("Class A", "Teacher A", 20, 51.5074, -0.1278));
        classrooms.add(new Classroom("Class B", "Teacher B", 15, 48.8566, 2.3522));
        classrooms.add(new Classroom("Class C", "Teacher C", 25, 52.3667, 4.8945));
        // Add more classrooms as needed

        // Validate if the classes are sorted by distance
        boolean isSorted = isClassroomListSortedByDistance(classrooms);

        // Print the result
        if (isSorted) {
            System.out.println("Classes are sorted by distance.");
        } else {
            System.out.println("Classes are not sorted by distance.");
        }
    }

   /* public static boolean isClassroomListSortedByDistance(List<Classroom> classrooms) {
        List<Classroom> sortedList = new ArrayList<>(classrooms);
        Collections.sort(sortedList, Comparator.comparingDouble((Classroom c) ->
                calculateDistance(c.getLatitude(), c.getLongitude(), 0, 0)));

        return sortedList.equals(classrooms);
    }*/

    public static boolean isClassroomListSortedByDistance(List<Classroom> classrooms) {
        List<Classroom> sortedList = new ArrayList<Classroom>(classrooms);
        Collections.sort(sortedList, new Comparator<Classroom>() {
            @Override
            public int compare(Classroom c1, Classroom c2) {
                double distance1 = calculateDistance(c1.getLatitude(), c1.getLongitude(), 0, 0);
                double distance2 = calculateDistance(c2.getLatitude(), c2.getLongitude(), 0, 0);
                return Double.compare(distance1, distance2);
            }
        });
        return sortedList.equals(classrooms);
    }


    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Radius of the Earth in kilometers
        double earthRadius = 6371;

        // Convert degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Haversine formula to calculate the distance
        double dlon = lon2Rad - lon1Rad;
        double dlat = lat2Rad - lat1Rad;
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}
