package com.example.christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void turnOnAll(List<Ligth> ligths) {
        ligths.forEach(Ligth::turnOn);
    }

    public void turnOnSelectedLights(List<Ligth> ligths, Coordonnees coordonnees1, Coordonnees coordonnees2) {
        ligths.stream()
                .filter(ligth -> ligth.isInRange(coordonnees1, coordonnees2))
                .collect(Collectors.toList())
                .forEach(Ligth::turnOn);
    }
}
