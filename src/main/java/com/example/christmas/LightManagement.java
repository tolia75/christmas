package com.example.christmas;

import java.util.ArrayList;
import java.util.List;

public class LightManagement {

    public List<Ligth> createLigth() {
        List<Ligth> ligths = new ArrayList<>();
        for (int hauteur = 0; hauteur < 1000; hauteur++) {
            for (int largeur = 0; largeur < 1000; largeur++) {
                Ligth ligth = new Ligth(hauteur, largeur);
                ligths.add(ligth);
            }
        }
        return ligths;
    }

    public void turnOn(List<Ligth> ligths) {
        ligths.forEach(Ligth::turnOn);
    }
}
