package com.example.christmas;

import java.util.Objects;

public class Ligth {

    private int hauteur;
    private int largeur;
    private boolean isOn;

    public Ligth(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligth ligth = (Ligth) o;
        return hauteur == ligth.hauteur &&
                largeur == ligth.largeur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hauteur, largeur);
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }
}
