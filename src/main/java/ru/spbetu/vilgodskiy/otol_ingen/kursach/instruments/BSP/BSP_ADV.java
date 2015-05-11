package ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.BSP;

/**
 * Created by Vred.L.Hom on 10.05.2015.
 */
public enum BSP_ADV {

    AVTOINCLUDE("Автоматически подключаемые библиотеки"), SPECFUNCTIONS("Специальные указания при сборке"), ANDROID("Сборка проектов под ОС Android");

    private String title;

    BSP_ADV(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
