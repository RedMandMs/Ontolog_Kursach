package ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.BSP;

/**
 * Created by Vred.L.Hom on 10.05.2015.
 */
public enum BSP_ADV {

    AVTOINCLUDE("������������� ������������ ����������"), SPECFUNCTIONS("����������� �������� ��� ������"), ANDROID("������ �������� ��� �� Android");

    private String title;

    BSP_ADV(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
