package metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Gite {

    private IntegerProperty id_gite;
    private IntegerProperty accueil_animal;
    private IntegerProperty surface_habitable;
    private IntegerProperty nbe_chambre;
    private IntegerProperty nbe_couchage;
    private StringProperty adresse;
    private StringProperty cpt_adresse;
    private IntegerProperty code_insee;
    private Commune commune;
    private Gerer gerer;

    public Gite(int id_gite, String adresse, String cpt_adresse, int surface_habitable, int nbe_chambre, int nbe_couchage, int accueil_animal, int code_insee) {
        this.id_gite = new SimpleIntegerProperty(id_gite);
        this.accueil_animal = new SimpleIntegerProperty(accueil_animal);
        this.surface_habitable = new SimpleIntegerProperty(surface_habitable);
        this.nbe_chambre = new SimpleIntegerProperty(nbe_chambre);
        this.nbe_couchage = new SimpleIntegerProperty(nbe_couchage);
        this.adresse = new SimpleStringProperty(adresse);
        this.cpt_adresse = new SimpleStringProperty(cpt_adresse);
        this.code_insee = new SimpleIntegerProperty(code_insee);
        commune = new Commune();
        gerer = new Gerer();
    }

    public Gite(int id_gite, String adresse) {
        this.id_gite = new SimpleIntegerProperty(id_gite);
        this.adresse = new SimpleStringProperty(adresse);
        commune = new Commune();
        gerer = new Gerer();
    }

    public Gite() {
        id_gite = new SimpleIntegerProperty();
        adresse = new SimpleStringProperty();
        commune = new Commune();
        gerer = new Gerer();
    }

    public IntegerProperty id_giteProperty() {
        return id_gite;
    }

    public Integer getId_gite() {
        return id_gite.get();
    }

    public void setId_gite(int id_gite) {
        this.id_gite.set(id_gite);
    }

    public Integer getAccueil_animal() {
        return accueil_animal.get();
    }

    public IntegerProperty accueil_animalProperty() {
        return accueil_animal;
    }

    public void setAccueil_animal(int accueil_animal) {
        this.accueil_animal.set(accueil_animal);
    }

    public IntegerProperty surface_habitableProperty() {
        return surface_habitable;
    }

    public Integer getSurface_habitable() {
        return surface_habitable.get();
    }

    public void setSurface_habitable(int surface_habitable) {
        this.surface_habitable.set(surface_habitable);
    }

    public Integer getNbe_chambre() {
        return nbe_chambre.get();
    }

    public IntegerProperty nbe_chambreProperty() {
        return nbe_chambre;
    }

    public void setNbe_chambre(int nbe_chambre) {
        this.nbe_chambre.set(nbe_chambre);
    }

    public Integer getNbe_couchage() {
        return nbe_couchage.get();
    }

    public IntegerProperty nbe_couchageProperty() {
        return nbe_couchage;
    }

    public void setNbe_couchage(int nbe_couchage) {
        this.nbe_couchage.set(nbe_couchage);
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public StringProperty cpt_adresseProperty() {
        return cpt_adresse;
    }

    public String getCpt_adresse() {
        return cpt_adresse.get();
    }

    public void setCpt_adresse(String cpt_adresse) {
        this.cpt_adresse.set(cpt_adresse);
    }

    public int getCode_insee() {
        return code_insee.get();
    }

    public IntegerProperty code_inseeProperty() {
        return code_insee;
    }

    public void setCode_insee(int code_insee) {
        this.code_insee.set(code_insee);
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Gerer getGerer() {
        return gerer;
    }

    public void setGerer(Gerer gerer) {
        this.gerer = gerer;
    }

    @Override
    public String toString() {
        return id_gite + " " + adresse;
    }

}
