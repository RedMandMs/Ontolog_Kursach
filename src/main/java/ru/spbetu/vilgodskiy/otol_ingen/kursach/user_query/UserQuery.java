package ru.spbetu.vilgodskiy.otol_ingen.kursach.user_query;

import ru.spbetu.vilgodskiy.otol_ingen.kursach.Content;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.BOOLEAN_PARAM;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.BSP.BSP;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.BSP.BSP_ADV;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.GUILib.GUILib;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.GUILib.GUI_ADV;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.LogLib.COMPLEXITY;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.LogLib.LogLib;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.MSDB.MSDB;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.VCS.TEAM_SIZE;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.VCS.VCS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vred.L.Hom on 06.05.2015.
 */
public class UserQuery {

    Content content;

    public UserQuery(Content content) {
        this.content = content;
    }

    private COMPLEXITY complexity;
    private BOOLEAN_PARAM avalibDB;
    private TEAM_SIZE teamSize;
    private BSP_ADV bspAdv;
    private GUI_ADV guiAdv;
    private BOOLEAN_PARAM multyPlatform;
    private BOOLEAN_PARAM avalibAndroid;
    private BOOLEAN_PARAM needLogging;

    private JComboBox<BOOLEAN_PARAM> multyPlatfBox;
    private JComboBox<TEAM_SIZE> teamSizeBox;
    private JComboBox<GUI_ADV> guiAdvBox;
    private JComboBox<BOOLEAN_PARAM> avalibBDBox;
    private JComboBox<BOOLEAN_PARAM> avalibLogBox;
    private JComboBox<BOOLEAN_PARAM> avalibAndroidBox;
    private JComboBox<BSP_ADV> bspAdvBox;
    private JComboBox<COMPLEXITY> complexityBox;

    private JPanel queryPanel;

    private BSP suitableBSP;
    private GUILib suitableGUILib;
    private LogLib suitableLogLib;
    private MSDB suitableMSDB;
    private VCS suitableVCS;

    public static JButton suitableBtn = new JButton("����� ���������� �����������");

    public JPanel toDesignQueryPanal(){
        JPanel queryPanel = new JPanel(new GridLayout(15, 2));

        queryPanel.add(new JLabel("����� ��������� ������:"));
        complexityBox = new JComboBox(COMPLEXITY.values());
        queryPanel.add(complexityBox);
        queryPanel.add(new JLabel("������������ ������� ������:"));
        bspAdvBox = new JComboBox(BSP_ADV.values());
        queryPanel.add(bspAdvBox);
        queryPanel.add(new JLabel("��������� �������� ��� �� Android:"));
        avalibAndroidBox = new JComboBox(BOOLEAN_PARAM.values());
        queryPanel.add(avalibAndroidBox);
        queryPanel.add(new JLabel("������������� ������ � ����� ������:"));
        avalibBDBox = new JComboBox(BOOLEAN_PARAM.values());
        queryPanel.add(avalibBDBox);
        queryPanel.add(new JLabel("������������� �����������:"));
        avalibLogBox = new JComboBox(BOOLEAN_PARAM.values());
        queryPanel.add(avalibLogBox);
        queryPanel.add(new JLabel("������������ ����������� ����������:    "));
        guiAdvBox = new JComboBox(GUI_ADV.values());
        queryPanel.add(guiAdvBox);
        queryPanel.add(new JLabel("������������ ������� ������:"));
        teamSizeBox = new JComboBox(TEAM_SIZE.values());
        queryPanel.add(teamSizeBox);
        queryPanel.add(new JLabel("��������� ���������������������:"));
        multyPlatfBox = new JComboBox(BOOLEAN_PARAM.values());
        queryPanel.add(multyPlatfBox);
        queryPanel.add(suitableBtn);
        //TODO: �������
        queryPanel.add(new JLabel(""));
        /*queryPanel.add(new JLabel("���������� ������� ������ �������:"));
        queryPanel.add(new JLabel(suitableBSP.toString()));
        queryPanel.add(new JLabel("���������� ���������� ����������� ����������:"));
        queryPanel.add(new JLabel(suitableGUILib.toString()));
        queryPanel.add(new JLabel("���������� ���������� �����������:"));
        queryPanel.add(new JLabel(suitableLogLib.toString()));
        queryPanel.add(new JLabel("���������� ����:"));
        queryPanel.add(new JLabel(suitableMSDB.toString()));
        queryPanel.add(new JLabel("���������� ������� �������� ������:"));
        queryPanel.add(new JLabel(suitableVCS.toString()));*/

        this.queryPanel = queryPanel;
        return queryPanel;
    }

    private void readAllRequeres(){
        this.complexity = (COMPLEXITY) complexityBox.getSelectedItem();
        this.avalibDB = (BOOLEAN_PARAM) avalibBDBox.getSelectedItem();
        this.teamSize = (TEAM_SIZE) teamSizeBox.getSelectedItem();
        this.bspAdv = (BSP_ADV) bspAdvBox.getSelectedItem();
        this.guiAdv = (GUI_ADV) guiAdvBox.getSelectedItem();
        this.multyPlatform = (BOOLEAN_PARAM) multyPlatfBox.getSelectedItem();
        this.avalibAndroid = (BOOLEAN_PARAM) avalibAndroidBox.getSelectedItem();
        this.needLogging = (BOOLEAN_PARAM) avalibLogBox.getSelectedItem();
    }


    private void fillSuitableInstruments(UserQuery readyQuery) {
        queryPanel.add(new JLabel("���������� ������� ������ �������:"));
        queryPanel.add(new JLabel(readyQuery.getSuitableBSP().toString()));
        queryPanel.add(new JLabel("���������� ���������� ����������� ����������:"));
        queryPanel.add(new JLabel(readyQuery.getSuitableGUILib().toString()));
        queryPanel.add(new JLabel("���������� ���������� �����������:"));
        queryPanel.add(new JLabel(readyQuery.getSuitableLogLib().toString()));
        queryPanel.add(new JLabel("���������� ����:"));
        queryPanel.add(new JLabel(readyQuery.getSuitableMSDB().toString()));
        queryPanel.add(new JLabel("���������� ������� �������� ������:"));
        queryPanel.add(new JLabel(readyQuery.getSuitableVCS().toString()));
    }



    private class suitableInstrumentsBtnListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            readAllRequeres();
            content.runSWRL();
            UserQuery readyQuery = content.getQuery();
            fillSuitableInstruments(readyQuery);
        }
    }

    public static String getClassName(){
        return "UserQuery";
    }

    public BSP getSuitableBSP() {
        return suitableBSP;
    }

    public void setSuitableBSP(BSP suitableBSP) {
        this.suitableBSP = suitableBSP;
    }

    public GUILib getSuitableGUILib() {
        return suitableGUILib;
    }

    public void setSuitableGUILib(GUILib suitableGUILib) {
        this.suitableGUILib = suitableGUILib;
    }

    public LogLib getSuitableLogLib() {
        return suitableLogLib;
    }

    public void setSuitableLogLib(LogLib suitableLogLib) {
        this.suitableLogLib = suitableLogLib;
    }

    public MSDB getSuitableMSDB() {
        return suitableMSDB;
    }

    public void setSuitableMSDB(MSDB suitableMSDB) {
        this.suitableMSDB = suitableMSDB;
    }

    public VCS getSuitableVCS() {
        return suitableVCS;
    }

    public void setSuitableVCS(VCS suitableVCS) {
        this.suitableVCS = suitableVCS;
    }
}
