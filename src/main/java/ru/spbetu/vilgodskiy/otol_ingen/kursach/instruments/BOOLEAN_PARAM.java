package ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments;

/**
 * Created by Vred.L.Hom on 10.05.2015.
 */
public enum BOOLEAN_PARAM {

    TRUE("True"), FALSE("False");

    private String title;

    BOOLEAN_PARAM(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}
