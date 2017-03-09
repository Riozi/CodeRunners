/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.CommuneDAO;
import DAO.DepartementDAO;
import DAO.DependreDAO;
import DAO.GiteDAO;
import DAO.RegionDAO;
import DAO.ServiceDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import metier.Commune;
import metier.Departement;
import metier.Dependre;
import metier.Gite;
import metier.Region;
import metier.Service;
import org.controlsfx.control.ListSelectionView;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.control.RangeSlider;

/**
 *
 * @author 59013-52-01
 */
public class accueilController implements Initializable {

    @FXML
    private ComboBox chambre;

    @FXML
    private ComboBox couchage;

    @FXML
    private ListSelectionView liste;

    @FXML
    private TextField adresse;

    @FXML
    private RangeSlider surfaceHabitable;

    @FXML
    private TextField surfaceHabitableTexteMax;

    @FXML
    private TextField surfaceHabitableTexteMin;

    @FXML
    private Button rechercher;

    @FXML
    private ComboBox region;

    @FXML
    private ComboBox departement;

    @FXML
    private ComboBox commune;

    @FXML
    private TableView<Gite> tableGite;

    @FXML
    private TableColumn<Gite, Integer> tableGiteNumeroGite;

    @FXML
    private TableColumn<Gite, String> tableGiteAdresse;

    @FXML
    private TableColumn<Gite, String> tableGiteCommune;

    @FXML
    private TableColumn<Gite, String> tableGiteDepartement;

    @FXML
    private TableColumn<Gite, String> tableGiteRegion;

    @FXML
    private TextField idGiteTexte;

    @FXML
    private TextField adresseTexte;

    @FXML
    private TextField complementAdresseTexte;

    @FXML
    private TextField surfaceHabitableTexte;

    @FXML
    private TextField nombreChambreTexte;

    @FXML
    private TextField nombreCouchageTexte;

    @FXML
    private TextField accueilAnimauxTexte;

    @FXML
    private TextField nomIndividuContact;

    @FXML
    private TextField prenomIndividuContact;

    @FXML
    private TextField nomIndividuProprietaire;

    @FXML
    private TextField prenomIndividuProprietaire;

    @FXML
    private TableView<Dependre> tableTarif;

    @FXML
    private TableColumn<Dependre, String> tableDateDebut;

    @FXML
    private TableColumn<Dependre, String> tableDateFin;

    @FXML
    private TableColumn<Dependre, String> tableSaison;

    @FXML
    private TableColumn<Dependre, Float> tablePrix;

    @FXML
    private ListView listeService;

    private Region regionSelectionne;

    private Departement departementSelectionne;

    private ArrayList<Integer> nbrChambre;

    private ArrayList<Integer> nbrCouchage;

    private ArrayList<Service> choixService;

    private ArrayList<Commune> choixCommune;

    private ArrayList<Departement> choixDepartement;

    private ArrayList<Region> choixRegion;

    private ArrayList<Gite> choixGite;

    private ArrayList<Dependre> choixDependre;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        afficherListeGite();

        affiinerRechercheChambreCouchage();

        RegionDAO listeRegion = new RegionDAO();
        DepartementDAO listeDepartement = new DepartementDAO();
        CommuneDAO listeCommune = new CommuneDAO();

        choixService = new ServiceDAO().getAll();
        choixCommune = new CommuneDAO().getAll();
        choixDepartement = new DepartementDAO().getAll();

        choixRegion = new RegionDAO().getAll();

        departement.setItems(FXCollections.observableArrayList(choixDepartement));

        liste.getSourceItems().addAll(choixService);

        liste.setTargetHeader(new Label("Sélectionné"));

        chambre.setItems(FXCollections.observableArrayList(nbrChambre));
        couchage.setItems(FXCollections.observableArrayList(nbrCouchage));

        region.setItems(FXCollections.observableArrayList(choixRegion));

        commune.setItems(FXCollections.observableArrayList(choixCommune));

        surfaceHabitableTexteMin.setText(surfaceHabitable.getLowValue() + "");
        surfaceHabitable.lowValueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                if (newValue == null) {
                    surfaceHabitableTexteMin.setText("");
                    return;
                }
                surfaceHabitableTexteMin.setText(Math.round(newValue.intValue()) + "");
            }
        });

        surfaceHabitableTexteMax.setText(surfaceHabitable.getHighValue() + "");
        surfaceHabitable.highValueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                if (newValue == null) {
                    surfaceHabitableTexteMax.setText("");
                    return;
                }
                surfaceHabitableTexteMax.setText(Math.round(newValue.intValue()) + "");
            }
        });

        surfaceHabitable.setHighValue(75);
        surfaceHabitable.setHighValueChanging(true);
        surfaceHabitable.setLowValue(25);
        surfaceHabitable.setLowValueChanging(true);

        tableGite.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showGiteDetail(newValue));
        tableGite.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPeriodeTarif(newValue));
        tableGite.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showServiceEquipement(newValue));

    }

    public void showServiceEquipement(Gite gite) {
        if (gite != null) {
            listeService.getItems().clear();
            ArrayList<Service> servicesGite = new ServiceDAO().getServiceGite(gite.getId_gite());
            listeService.getItems().addAll(servicesGite);
        }
    }

    public void showGiteDetail(Gite gite) {
        if (gite != null) {
            Gite giteChoisis = new GiteDAO().getLike(gite.getId_gite());
            idGiteTexte.setText(giteChoisis.getId_gite().toString());
            adresseTexte.setText(giteChoisis.getAdresse().toString());
            surfaceHabitableTexte.setText(giteChoisis.getSurface_habitable().toString());
            nombreChambreTexte.setText(giteChoisis.getNbe_chambre().toString());
            nombreCouchageTexte.setText(giteChoisis.getNbe_couchage().toString());
            if (giteChoisis.getAccueil_animal().toString().equals("-1")) {
                accueilAnimauxTexte.setText("Non");
            } else if (giteChoisis.getAccueil_animal().toString().equals("0")) {
                accueilAnimauxTexte.setText("Gratuit");
            }
            else
            {
                accueilAnimauxTexte.setText(giteChoisis.getAccueil_animal().toString() + " €");
            }
            if (giteChoisis.getGerer().getIndividu().getCategoriser().getType_individu().getType_individu().equals("contact")) {
                nomIndividuContact.setText(giteChoisis.getGerer().getIndividu().getNom_individu());
                prenomIndividuContact.setText(giteChoisis.getGerer().getIndividu().getPrenom_individu());
            } else {
                nomIndividuProprietaire.setText(giteChoisis.getGerer().getIndividu().getNom_individu());
                prenomIndividuProprietaire.setText(giteChoisis.getGerer().getIndividu().getPrenom_individu());
            }

        } else {
            idGiteTexte.setText("");
            adresseTexte.setText("");
            surfaceHabitableTexte.setText("");
            nombreChambreTexte.setText("");
            nombreCouchageTexte.setText("");
            accueilAnimauxTexte.setText("");
            nomIndividuContact.setText("");
            prenomIndividuContact.setText("");
            nomIndividuProprietaire.setText("");
            prenomIndividuProprietaire.setText("");

        }
    }

    private void affiinerRechercheChambreCouchage() {
        nbrChambre = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            nbrChambre.add(i);
        }

        nbrCouchage = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            nbrCouchage.add(i);
        }
    }

    private void afficherListeGite() {

        choixGite = new GiteDAO().getLike();

        tableGite.setItems(FXCollections.observableArrayList(choixGite));

        tableGiteNumeroGite.setCellValueFactory(cellData -> cellData.getValue().id_giteProperty().asObject());

        tableGiteAdresse.setCellValueFactory(cellData -> cellData.getValue().adresseProperty());

        tableGiteCommune.setCellValueFactory(cellData -> cellData.getValue().getCommune().nom_communeProperty());

        tableGiteDepartement.setCellValueFactory(cellData -> cellData.getValue().getCommune().getDepartement().Nom_departementProperty());

        tableGiteRegion.setCellValueFactory(cellData -> cellData.getValue().getCommune().getDepartement().getRegion().nom_regionProperty());
    }

    private void showPeriodeTarif(Gite gite) {

        choixDependre = new DependreDAO().getAll(gite.getId_gite());

        tableTarif.setItems(FXCollections.observableArrayList(choixDependre));

        tableDateDebut.setCellValueFactory(cellData -> cellData.getValue().getPeriode_tarif().date_debutProperty());

        tableDateFin.setCellValueFactory(cellData -> cellData.getValue().getPeriode_tarif().date_finProperty());

        tableSaison.setCellValueFactory(cellData -> cellData.getValue().getTarif().getSaison().saisonProperty());

        tablePrix.setCellValueFactory(cellData -> cellData.getValue().getTarif().montantProperty().asObject());

    }

    @FXML
    private void regionSelectionneComboBox(ActionEvent event) throws IOException {
        if (region.getSelectionModel().getSelectedItem() != null) {
            regionSelectionne = choixRegion.get(region.getSelectionModel().getSelectedIndex());
            choixDepartement = new DepartementDAO().getAllRegion(regionSelectionne.getId_region());
            departement.getItems().clear();
            departement.setItems(FXCollections.observableArrayList(choixDepartement));

        } else {
            departement.setItems(FXCollections.observableArrayList(choixDepartement));

        }

        if (region.getSelectionModel().getSelectedItem() != null) {
            regionSelectionne = choixRegion.get(region.getSelectionModel().getSelectedIndex());
            choixCommune = new CommuneDAO().getAllCommuneRegion(regionSelectionne.getId_region());
            commune.setItems(FXCollections.observableArrayList(choixCommune));

        } else {
            commune.setItems(FXCollections.observableArrayList(choixCommune));

        }

    }

    @FXML
    private void departementSelectionneComboBox(ActionEvent event) throws IOException {

        if (departement.getSelectionModel().getSelectedItem() != null) {
            departementSelectionne = choixDepartement.get(departement.getSelectionModel().getSelectedIndex());
            choixCommune = new CommuneDAO().getAllCommuneDepartement(departementSelectionne.getId_departement());
            commune.getItems().clear();
            commune.setItems(FXCollections.observableArrayList(choixCommune));

        } else {
            commune.setItems(FXCollections.observableArrayList(choixCommune));

        }

    }

    @FXML
    private void radioBoutonRegion(ActionEvent event) throws IOException {
        AutoCompletionBinding<Region> autoCompletionBinding = TextFields.bindAutoCompletion(adresse, choixRegion);
    }

    @FXML
    private void radioBoutonDepartement(ActionEvent event) throws IOException {
        AutoCompletionBinding<Departement> autoCompletionBinding = TextFields.bindAutoCompletion(adresse, choixDepartement);
    }

    @FXML
    private void radioBoutonCommune(ActionEvent event) throws IOException {
        AutoCompletionBinding<Commune> autoCompletionBinding = TextFields.bindAutoCompletion(adresse, choixCommune);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

}
