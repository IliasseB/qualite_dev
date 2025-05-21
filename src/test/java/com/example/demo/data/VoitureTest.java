package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture() {
        // Création d'une voiture avec le constructeur avec paramètres
        Voiture V = new Voiture("Renault", 20000);

        // Vérification des valeurs initiales
        assertEquals("Renault", V.getMarque());
        assertEquals(20000, V.getPrix());
        assertEquals(0, V.getId());
    }

}