package com.example.lessonsshedule;

import java.util.ArrayList;

public class ScheduleDay {

    public ArrayList<AcademicPairViewModel> pairs;
    public boolean isNahimovskyFilial = false;

    public ScheduleDay() {
        pairs = new ArrayList<>(6);
    }

    public ScheduleDay(boolean isOnNahimovskyFilial) {
        this();
        isNahimovskyFilial = isOnNahimovskyFilial;
    }

    public void addPair(AcademicPairViewModel viewModel) {
        for (AcademicPairViewModel pair : pairs) {
            if(pair.pairNumber == viewModel.pairNumber)
                throw new IllegalArgumentException("Две пары не могут идти в одно время.\nВозможно " +
                        "вы хотели разделить пару на две дисциплины с помощью PairMode.Splitted?");
        }

        pairs.add(viewModel);
    }
}
