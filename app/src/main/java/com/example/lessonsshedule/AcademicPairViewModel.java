package com.example.lessonsshedule;

public class AcademicPairViewModel {
    public int pairNumber;
    public Discipline numeratorDiscipline;
    public Pair pairMode;
    public Discipline denominatorDiscipline;

    public AcademicPairViewModel(int pairNumber, Discipline numeratorDiscipline, Discipline denominatorDiscipline) {
        if(pairNumber <= 0) throw new IllegalArgumentException("Пара должна начинаться с 1");

        this.pairNumber = pairNumber;
        this.numeratorDiscipline = numeratorDiscipline;
        this.denominatorDiscipline = denominatorDiscipline;
        pairMode = Pair.Splitted;
    }

    public AcademicPairViewModel(int pairNumber, Discipline pair, Pair mode) {
        this.pairNumber = pairNumber;
        pairMode = mode;

        switch (mode) {
            case OnlyDenominator:
                denominatorDiscipline = pair;
                break;
            case OnlyNumerator:
            case Both:
                numeratorDiscipline = pair;
                break;
            default:
                throw new IllegalArgumentException("Для разделенной на числитель и знаменатель" +
                        " пары, используйте конструктор с двумя дисциплинами");
        }
    }

    public AcademicPairViewModel(int pairNumber, Discipline pair) {
        this(pairNumber, pair, Pair.Both);
    }
}