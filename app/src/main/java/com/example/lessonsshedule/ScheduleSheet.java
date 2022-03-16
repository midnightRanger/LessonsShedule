package com.example.lessonsshedule;
import java.util.ArrayList;

public class ScheduleSheet {
    public static final int ElementCount = 7;
    public ArrayList<ScheduleDay> days;

    public ScheduleSheet() {
        days = new ArrayList<>();
    }

    public void initializeSchedule(String[] disciplineNamings, String[] teachers) {
        Discipline[] disciplines = initializePairs(disciplineNamings, teachers);

        ScheduleDay monday = new ScheduleDay(true);
        monday.addPair(new AcademicPairViewModel(2, disciplines[0]));
        monday.addPair(new AcademicPairViewModel(3, disciplines[1]));
        monday.addPair(new AcademicPairViewModel(4, disciplines[2]));
        monday.addPair(new AcademicPairViewModel(5, disciplines[3]));
        days.add(monday);

        ScheduleDay tuesday = new ScheduleDay();
        tuesday.addPair(new AcademicPairViewModel(1, disciplines[4]));
        tuesday.addPair(new AcademicPairViewModel(2, disciplines[5]));
        tuesday.addPair(new AcademicPairViewModel(3, disciplines[6]));
        tuesday.addPair(new AcademicPairViewModel(4, disciplines[7]));
        days.add(tuesday);

        ScheduleDay wednesday = new ScheduleDay(true);
        wednesday.addPair(new AcademicPairViewModel(1, disciplines[8]));
        wednesday.addPair(new AcademicPairViewModel(2, disciplines[1], disciplines[3]));
        wednesday.addPair(new AcademicPairViewModel(3, disciplines[9]));
        days.add(wednesday);

        ScheduleDay thursday = new ScheduleDay(true);
        thursday.addPair(new AcademicPairViewModel(2, disciplines[8], Pair.OnlyDenominator));
        thursday.addPair(new AcademicPairViewModel(3, disciplines[10]));
        thursday.addPair(new AcademicPairViewModel(4, disciplines[6]));
        thursday.addPair(new AcademicPairViewModel(5, disciplines[11]));
        days.add(thursday);

        ScheduleDay friday = new ScheduleDay(true);
        friday.addPair(new AcademicPairViewModel(1, disciplines[5]));
        friday.addPair(new AcademicPairViewModel(2, disciplines[12]));
        friday.addPair(new AcademicPairViewModel(3, disciplines[10], disciplines[7]));
        friday.addPair(new AcademicPairViewModel(4, disciplines[9], Pair.OnlyNumerator));
        days.add(friday);
    }

    private Discipline[] initializePairs(String[] disciplines, String[] teachers) {
        if (disciplines.length != teachers.length)
            throw new IllegalArgumentException("Массивы не совпадают по длине");

        int length = disciplines.length;
        Discipline[] array = new Discipline[length];

        for (int i = 0; i < length; i++)
            array[i] = (new Discipline(disciplines[i], teachers[i]));

        return array;
    }
}
