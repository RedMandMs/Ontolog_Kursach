package ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.VCS;

/**
 * Created by Vred.L.Hom on 10.05.2015.
 */
public enum TEAM_SIZE {
    ALONE("����������� �����������"),
    SMALL_TEAM("����� ������� �������������"),
    NORMAL_TEAM("������� ������� �������������"),
    BIG_TEAM("������� ������� �������������");

    private String title;

    TEAM_SIZE(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
