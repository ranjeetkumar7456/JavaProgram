package kaplan1;

import java.util.ArrayList;
import java.util.List;

public class ClassroomSortingValidatorNew {
    public static void main(String[] args) {
        List<ClassRoomNew> classRoomNew = new ArrayList<>();
        classRoomNew.add(new ClassRoomNew("Class A", "Teacher A", 20, 51.5074, -0.1278));
        classRoomNew.add(new ClassRoomNew("Class B", "Teacher B", 15, 48.8566, 2.3522));
        classRoomNew.add(new ClassRoomNew("Class C", "Teacher C", 25, 52.3667, 4.8945));
        classRoomNew.add(new ClassRoomNew("Class D", "Teacher D", 35, 54.5074, -0.2345));
        classRoomNew.add(new ClassRoomNew("Class E", "Teacher E", 31, 59.5074, -0.3345));
        classRoomNew.add(new ClassRoomNew("Class F", "Teacher F", 23, 56.5074, -0.2232));

    }
}
