package com.example.christmas;

import java.util.Objects;

public class Coordonnees {

    private int hauteur;
    private int largeur;

    public Coordonnees(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnees that = (Coordonnees) o;
        return hauteur == that.hauteur &&
                largeur == that.largeur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hauteur, largeur);
    }
}
