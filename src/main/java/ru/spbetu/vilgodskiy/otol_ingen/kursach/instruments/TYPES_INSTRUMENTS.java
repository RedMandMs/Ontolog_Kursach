package ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments;

/**
 * Created by Vred.L.Hom on 10.05.2015.
 */
public enum TYPES_INSTRUMENTS {

    BSP("������� ������ ��������", "BSP"), GUI_LIB("���������� ������������ ����������", "GUILib"), LOG_LIB("���������� �����������", "LogLib"), MSDB("����", "MSDB"), VCS("������� �������� ������", "VCS");


    private String title;
    private String className;

    TYPES_INSTRUMENTS(String title, String className) {
        this.title = title;
        this.className = className;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getClassName(){
        return className;
    }

}
