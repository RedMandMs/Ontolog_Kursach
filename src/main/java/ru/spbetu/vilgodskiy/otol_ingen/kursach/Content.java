package ru.spbetu.vilgodskiy.otol_ingen.kursach;

import edu.stanford.smi.protege.exception.OntologyLoadException;
import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.jena.JenaOWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.BSP.BSP;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.GUILib.GUILib;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.Instrument;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.LogLib.LogLib;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.MSDB.MSDB;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.TYPES_INSTRUMENTS;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.instruments.VCS.VCS;
import ru.spbetu.vilgodskiy.otol_ingen.kursach.user_query.UserQuery;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vred.L.Hom on 06.05.2015.
 */
public class Content {

    // a variable of ontology
    JenaOWLModel owlModel = null;
    // a namespace of ontology
    String owlURI = "http://www.owl-ontologies.com/JavaInstruments.owl#";
    // a name of new file of ontology
    String owlNEWFileName = "Lab1_new.owl";
    // a variable of new file of ontology
    File owlNEWFile = new File(owlNEWFileName);

    String available_android_property_name = "available_android";
    String avalib_db_property_name = "avalib_db";
    String bsp_advanteges_property_name = "bsp_advanteges";
    String complexity_project_property_name = "complexity_project";
    String gui_advant_property_name = "gui_advant";
    String multy_platform_property_name = "multy_platform";
    String need_logging_property_name = "need_logging";
    String team_size_property_name = "team_size";


    OWLNamedClass Instrument_class = null;
    OWLNamedClass BuildSystemProject_class = null;
    OWLNamedClass DBMS_class = null;
    OWLNamedClass GUILib_class = null;
    OWLNamedClass LogLib_class = null;
    OWLNamedClass VersionControlSystem_class = null;
    OWLNamedClass NeedUser_class = null;

    /**
     * Компонент GUI
     */
    GUI gui;
    List<BSP> bspList = new ArrayList<BSP>();
    List<GUILib> guiLibList = new ArrayList<GUILib>();
    List<LogLib> logLibList = new ArrayList<LogLib>();
    List<MSDB> msdbList = new ArrayList<MSDB>();
    List<VCS> vcsList = new ArrayList<VCS>();
    UserQuery query;

    /**
     * Заполнить компоненты gui всеми имеющимися значениями инструментов
     */
    public void fillComponents(){

    }

    /**
     * Сохранение онтологии
     */
    public void saveOntology(){

    }

    /**
     * Подгрузка онтологии из файла
     */
    public void loadOntology(){

    }

    /**
     * Выполнить SWRL-правила
     */
    public void executeSWRL(){

    }


    public List<VCS> getVcsList() {
        return vcsList;
    }

    public List<MSDB> getMsdbList() {
        return msdbList;
    }

    public List<LogLib> getLogLibList() {
        return logLibList;
    }

    public List<GUILib> getGuiLibList() {
        return guiLibList;
    }

    public List<BSP> getBspList() {
        return bspList;
    }

    public UserQuery getQuery() {
        return query;
    }

    public void setQuery(UserQuery query) {
        this.query = query;
    }

    public void runSWRL() {
        readOntology();
        runRules();
        updateContent();
    }

    private void updateContent() {
        //TODO:
    }

    private void runRules() {
        //TODO:
    }

    private void readOntology() {

    }

    private void createOWL(JenaOWLModel owlModel) {
        try {
            owlModel = ProtegeOWL.createJenaOWLModel();
        } catch (OntologyLoadException e) {
            System.out.println("ERROR in creating ontology!");
            return;
        }
    }

    private void createClassesOWL(JenaOWLModel owlModel){
        owlModel.getNamespaceManager().setDefaultNamespace(owlURI);


        Instrument_class = owlModel.createOWLNamedClass(owlURI + Instrument.getSuperName());

        BuildSystemProject_class = owlModel.createOWLNamedClass(owlURI + TYPES_INSTRUMENTS.BSP.getClassName());
        BuildSystemProject_class.addSuperclass(Instrument_class);

        DBMS_class = owlModel.createOWLNamedClass(owlURI + TYPES_INSTRUMENTS.MSDB.getClassName());
        DBMS_class.addSuperclass(Instrument_class);

        GUILib_class = owlModel.createOWLNamedClass(owlURI + TYPES_INSTRUMENTS.GUI_LIB);
        GUILib_class.addSuperclass(Instrument_class);

        LogLib_class = owlModel.createOWLNamedClass(owlURI + TYPES_INSTRUMENTS.LOG_LIB);
        LogLib_class.addSuperclass(Instrument_class);

        VersionControlSystem_class = owlModel.createOWLNamedClass(owlURI + TYPES_INSTRUMENTS.VCS.getClassName());
        VersionControlSystem_class.addSuperclass(Instrument_class);

        NeedUser_class = owlModel.createOWLNamedClass(owlURI + UserQuery.getClassName());
    }

    private void createDataProperties(JenaOWLModel owlModel){

    }
}
