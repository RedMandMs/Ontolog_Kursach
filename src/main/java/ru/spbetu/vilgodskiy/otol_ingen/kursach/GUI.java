package ru.spbetu.vilgodskiy.otol_ingen.kursach;

import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.Instrument;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.TYPES_INSTRUMENTS;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.BSP.BSP;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.GUILib.GUILib;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.LogLib.LogLib;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.MSDB.MSDB;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.VCS.VCS;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.user_query.UserQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vred.L.Hom on 06.05.2015.
 */
public class GUI {

    //������� ������
    JPanel mainPanel;
    //�������
    JTabbedPane tabbedPane;
    //������ ������ � ��������� ������������
    JPanel reviewPanel;
    //��������������� ����������� ����������� (������ � reviewPanel)
    JPanel currentReviwInstrPanel = new JPanel();
    //������ �������� ������ �����������
    JPanel createPanel = new JPanel();
    //������ ������ ������������ �����������
    JPanel currentCreateInstrPanel = new JPanel();

    Content content = new Content();

    public void toDesign(){

        /** ������� ���� */
        JFrame mainFrame = new JFrame("������ Java-������������");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** ������� ������ */
        mainPanel = new JPanel(new BorderLayout());
        mainFrame.add(mainPanel);


        /**
         *  ������ � ���������
         */
        tabbedPane = new JTabbedPane();
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        toCreateTabs();

        /**
         *  ������ ��� ������ ���������� ���������
         */
        JPanel buttonPanel = new JPanel(new FlowLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        //������� ����� ���� ���������
        JButton createButton = new JButton("������� ���������");
        //createButton.addActionListener(new CreatePopBtnListener());
        buttonPanel.add(createButton);

        //��������� ��������� �� �����
        JButton loadButton = new JButton("��������� ��������� �� �����");
        //loadButton.addActionListener(new OneStepBtnListener());
        buttonPanel.add(loadButton);

        //���������� ���������
        JButton saveButton = new JButton("���������...");
        //loadButton.addActionListener(new OneStepBtnListener());
        buttonPanel.add(saveButton);

        //���������� ��������� � ����� ����
        JButton saveAsButton = new JButton("��������� ���...");
        //loadButton.addActionListener(new OneStepBtnListener());
        buttonPanel.add(saveAsButton);

        /**
         * ������ � ��������� ����
         */
        mainFrame.setSize(1000, 700);
        mainFrame.setVisible(true);
    }

    private void toCreateTabs(){
        toDesignReviewTab();
        toDesignCreateTab();
        toDesignQueryTab();
    }

    /**
     * �������������� ������ ������ ���� ����������� � ���������� ����������
     * @return - ������ ������ �����������
     */
    private JPanel toDesignChooseReviewPanel(){
        JPanel choiseInstrumentPanel = new JPanel();
        choiseInstrumentPanel.add(new JLabel("�������� ����������:"));
        JComboBox<TYPES_INSTRUMENTS> typeInstrumentBox = new JComboBox<TYPES_INSTRUMENTS>(TYPES_INSTRUMENTS.values());
        JComboBox intrumentBox = new JComboBox();
        typeInstrumentBox.addActionListener(new ChangeTypeInstrumentListner(typeInstrumentBox, intrumentBox,choiseInstrumentPanel));
        intrumentBox.addActionListener(new ChangeChoiseInstrListner(intrumentBox));
        choiseInstrumentPanel.add(typeInstrumentBox);
        choiseInstrumentPanel.add(intrumentBox);

        return choiseInstrumentPanel;
    }

    private JPanel toDesignChooseCeatePanel(){
        JPanel choiseInstrumentPanel = new JPanel();
        choiseInstrumentPanel.add(new JLabel("�������� ����������:"));
        JComboBox<TYPES_INSTRUMENTS> typeInstrumentBox = new JComboBox<TYPES_INSTRUMENTS>(TYPES_INSTRUMENTS.values());
        typeInstrumentBox.addActionListener(new ChoiseCreateInstrument(typeInstrumentBox));
        choiseInstrumentPanel.add(typeInstrumentBox);

        return choiseInstrumentPanel;
    }

    /**
     * �������������� ������� ��������� ��������� ������������
     */
    private void toDesignReviewTab(){
        reviewPanel = new JPanel();
        reviewPanel.add(toDesignChooseReviewPanel(), BorderLayout.NORTH);
        tabbedPane.add("��������� �����������", reviewPanel);
    }

    /**
     * ������� ��������������� ����������
     * @param newPanel - ������ � ����� ������������
     */
    private void changeInstrReview(JPanel newPanel){
        reviewPanel.remove(currentReviwInstrPanel);
        currentReviwInstrPanel = newPanel;
        reviewPanel.add(currentReviwInstrPanel);
        reviewPanel.updateUI();
    }

    private void changeTypeInstrCreate(JPanel newPanel){
        createPanel.remove(currentCreateInstrPanel);
        currentReviwInstrPanel = newPanel;
        createPanel.add(currentReviwInstrPanel);
        createPanel.updateUI();
    }

    /**
     * �������������� ������� �������� ����� ������������
     */
    private void toDesignCreateTab(){
        JPanel choisePanel = toDesignChooseCeatePanel();
        createPanel.add(choisePanel, BorderLayout.NORTH);
        JButton createInstrumBtn = new JButton("������� ����������");
        createInstrumBtn.addActionListener(new CreateButtonListner
                ((JComboBox<TYPES_INSTRUMENTS>)(choisePanel.getComponent(1))));
        createPanel.add(createInstrumBtn, BorderLayout.SOUTH);
        tabbedPane.add("�������� �����������", createPanel);

    }


    /**
     * �������������� ������� ������� �������
     */
    private void toDesignQueryTab(){
        UserQuery query = new UserQuery(this.content);
        content.setQuery(query);
        JPanel queryPanel = new JPanel(new BorderLayout());
        queryPanel.add(query.toDesignQueryPanal(), BorderLayout.NORTH);
        tabbedPane.add("�������� �������", queryPanel);
    }

    private class ChangeTypeInstrumentListner implements ActionListener{

        //�����-���� � ������ ������������
        private JComboBox<TYPES_INSTRUMENTS> typeInstrCB;
        //�����-���� � ����������� �������������
        private JComboBox instrumentsCB;
        //������ ������ ������������
        private JPanel choisePanel;


        public ChangeTypeInstrumentListner(JComboBox<TYPES_INSTRUMENTS> typeInstrCB, JComboBox instrumentsCB, JPanel choisePanel) {
            this.typeInstrCB = typeInstrCB;
            this.instrumentsCB = instrumentsCB;
            this.choisePanel = choisePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            TYPES_INSTRUMENTS selectedType = (TYPES_INSTRUMENTS) typeInstrCB.getSelectedItem();
            choisePanel.remove(instrumentsCB);
            switch (selectedType){
                case BSP:
                    instrumentsCB = new JComboBox(content.getBspList().toArray());
                    break;
                case GUI_LIB:
                    instrumentsCB = new JComboBox(content.getGuiLibList().toArray());
                    break;
                case LOG_LIB:
                    instrumentsCB = new JComboBox(content.getLogLibList().toArray());
                    break;
                case MSDB:
                    instrumentsCB = new JComboBox(content.getMsdbList().toArray());
                    break;
                case VCS:
                    instrumentsCB = new JComboBox(content.getVcsList().toArray());
                    break;
            }
            choisePanel.add(instrumentsCB);
            instrumentsCB.addActionListener(new ChangeChoiseInstrListner(instrumentsCB));
            choisePanel.updateUI();
        }
    }

    private class ChangeChoiseInstrListner implements ActionListener{

        private JComboBox<Instrument> instrumentsCB;

        public ChangeChoiseInstrListner(JComboBox<Instrument> instrumentsCB) {
            this.instrumentsCB = instrumentsCB;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Instrument newReviewingInstrument = (Instrument) instrumentsCB.getSelectedItem();
            changeInstrReview(newReviewingInstrument.toDesignReviewPanel());
        }
    }

    private class ChoiseCreateInstrument implements ActionListener{

        private JComboBox<TYPES_INSTRUMENTS> typeInstrumentsCB;

        public ChoiseCreateInstrument(JComboBox<TYPES_INSTRUMENTS> typeInstrumentsCB) {
            this.typeInstrumentsCB = typeInstrumentsCB;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            TYPES_INSTRUMENTS selectedType = (TYPES_INSTRUMENTS)typeInstrumentsCB.getSelectedItem();
            createPanel.remove(currentCreateInstrPanel);
            switch (selectedType){
                case BSP:
                    currentCreateInstrPanel = BSP.toDesignCreatePanel();
                    break;
                case GUI_LIB:
                    currentCreateInstrPanel = GUILib.toDesignCreatePanel();
                    break;
                case LOG_LIB:
                    currentCreateInstrPanel = LogLib.toDesignCreatePanel();
                    break;
                case MSDB:
                    currentCreateInstrPanel = MSDB.toDesignCreatePanel();
                    break;
                case VCS:
                    currentCreateInstrPanel = VCS.toDesignCreatePanel();
                    break;
            }
            createPanel.add(currentCreateInstrPanel);
            createPanel.updateUI();
        }
    }

    private class CreateButtonListner implements ActionListener{

        private JComboBox<TYPES_INSTRUMENTS> typeInstrumentsCB;

        public CreateButtonListner(JComboBox<TYPES_INSTRUMENTS> typeInstrumentsCB) {
            this.typeInstrumentsCB = typeInstrumentsCB;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            TYPES_INSTRUMENTS selectedType = (TYPES_INSTRUMENTS)typeInstrumentsCB.getSelectedItem();
            switch (selectedType){
                case BSP:
                    BSP bsp = BSP.getNewBSP(createPanel);
                    content.getBspList().add(bsp);
                    break;
                case GUI_LIB:
                    GUILib gui = GUILib.getNewGUILib(createPanel);
                    content.getGuiLibList().add(gui);
                    break;
                case LOG_LIB:
                    LogLib logLib = LogLib.getNewLogLib(createPanel);
                    content.getLogLibList().add(logLib);
                    break;
                case MSDB:
                    MSDB msdb = MSDB.getNewMSDB(createPanel);
                    content.getMsdbList().add(msdb);
                    break;
                case VCS:
                    VCS vcs = VCS.getNewVCS(createPanel);
                    content.getVcsList().add(vcs);
                    break;
            }
        }
    }
}
