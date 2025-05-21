package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    public void testAjouterVoiture() {
        // Création d'une voiture de test
        Voiture voiture = new Voiture("Renault", 20000);

        // Test de la méthode ajouter
        statistiqueImpl.ajouter(voiture);

        // Vérification que la méthode a été appelée avec la bonne voiture
        verify(statistiqueImpl, times(1)).ajouter(voiture);
    }

    @Test
    public void testPrixMoyen() {
        // Création d'un échantillon attendu
        Echantillon echantillonAttendu = new Echantillon(2, 25000);

        // Configuration du mock
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillonAttendu);

        // Appel de la méthode
        Echantillon resultat = statistiqueImpl.prixMoyen();

        // Vérifications
        assertNotNull(resultat);
        assertEquals(2, resultat.getNombreDeVoitures());
        assertEquals(25000, resultat.getPrixMoyen());
        verify(statistiqueImpl, times(1)).prixMoyen();
    }

    @Test
    public void testPrixMoyenListeVide() {
        // Configuration du mock pour simuler une liste vide
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());

        // Vérification que l'exception est bien levée
        assertThrows(ArithmeticException.class, () -> {
            statistiqueImpl.prixMoyen();
        });
    }
}