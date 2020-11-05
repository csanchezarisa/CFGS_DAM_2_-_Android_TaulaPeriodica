package com.example.taulaperidica.elements;

public class Element {
    private String simbol;
    private String tipus;
    private int numeroAtomic;
    private String nom;
    private String massaAtomica;
    private String configuracioElectronica;
    private String estatPredeterminat;

    public Element(String simbol, int numeroAtomic, String tipus, String nom, String massaAtomica, String configuracioElectronica, String estatPredeterminat) {

        this.simbol = simbol;
        this.tipus = tipus;
        this.numeroAtomic = numeroAtomic;
        this.nom = nom;
        this.massaAtomica = massaAtomica;
        this.configuracioElectronica = configuracioElectronica;
        this.estatPredeterminat = estatPredeterminat;

    }

}
