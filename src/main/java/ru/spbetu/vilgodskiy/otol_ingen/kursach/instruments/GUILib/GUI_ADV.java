package ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.GUILib;

/**
 * Created by Vred.L.Hom on 10.05.2015.
 */
public enum GUI_ADV {
    DOCUMENTATION("������ �������������� ������������"),
    VERIETY_ELEMENTS("������������� ����������� ����������"),
    FORM_EDITOR("�������� ����");

    private String title;

    GUI_ADV(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
