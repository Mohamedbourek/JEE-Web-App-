package com.mycompany.essai;


public class Adresse {

       private int id;
    private String nom_rue;
    private int numero_rue;
    private String ville;
    private String personne_nom ;
    private int carnet_adresse_id;
   
    public int getId() {
        return id;
    }
     public void setId(int id) {
        this.id = id;
    }

    public String getNomRue() {
        return nom_rue;
    }

    public void setNomRue(String nom_rue) {
        this.nom_rue = nom_rue;
    }

    public int getNumeroRue() {
        return numero_rue;
    }

    public void setNumeroRue(int numero_rue) {
        this.numero_rue = numero_rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

   public String getNomPersonne() {
        return personne_nom;
    }

    public void setNomPersonne(String nomPersonne) {
        this.personne_nom = nomPersonne;
    }

    public int getCarnetAdresseId() {
        return carnet_adresse_id;
    }

    public void setCarnetAdresseId(int carnetAdresseId) {
        this.carnet_adresse_id = carnetAdresseId;
    }

}
