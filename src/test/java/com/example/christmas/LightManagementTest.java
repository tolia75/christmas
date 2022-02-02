package com.example.christmas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertTrue(ligths.stream().allMatch(ligth -> !ligth.isOn()));
    }

    @Test
    void shouldLightOnEveryLight() {
        List<Ligth> ligths = lightManagement.createLigth();

        lightManagement.turnOn(ligths);

        assertTrue(ligths.stream().allMatch(Ligth::isOn));
    }
}
