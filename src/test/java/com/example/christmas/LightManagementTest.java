package com.example.christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LightManagementTest {

    LightManagement lightManagement;

    @BeforeEach
    void setUp() {
        lightManagement = new LightManagement();
    }

    @Test
    void shouldCreateLights() {
        Ligth ligth0 = new Ligth(0,0);
        Ligth ligth999 = new Ligth(999,999);

        List<Ligth> ligths = lightManagement.createLigth();

        assertEquals(1000*1000, ligths.size());
        assertEquals(ligth0, ligths.get(0));
        assertEquals(ligth999, ligths.get((1000*1000) - 1));
        assertTrue(ligths.stream().noneMatch(Ligth::isOn));
    }

    @Test
    void shouldLightOnEveryLight() {
        List<Ligth> ligths = lightManagement.createLigth();

        lightManagement.turnOnAll(ligths);

        assertTrue(ligths.stream().allMatch(Ligth::isOn));
    }

    @Test
    void shouldLightOnOneLightFromSelectedAreas() {
        Coordonnees coordonnees1 = new Coordonnees(0,0);
        Coordonnees coordonnees2 = new Coordonnees(0,0);

        List<Ligth> ligths = lightManagement.createLigth();

        lightManagement.turnOnSelectedLights(ligths, coordonnees1, coordonnees2);

        ligths.stream()
                .filter(ligth -> ligth.getLargeur() == 0 && ligth.getHauteur() == 0)
                .collect(Collectors.toList())
                .forEach(ligth -> assertTrue(ligth.isOn()));
        ligths.stream()
                .filter(ligth -> ligth.getLargeur() != 0 || ligth.getHauteur() != 0)
                .collect(Collectors.toList())
                .forEach(ligth -> assertFalse(ligth.isOn()));
    }

    @Test
    void shouldLightOnAllLightsWithSelectedAreas() {
        Coordonnees coordonnees1 = new Coordonnees(0,0);
        Coordonnees coordonnees2 = new Coordonnees(999,999);
        List<Ligth> ligths = lightManagement.createLigth();

        lightManagement.turnOnSelectedLights(ligths, coordonnees1, coordonnees2);

        assertTrue(ligths.stream().allMatch(Ligth::isOn));
    }

}
