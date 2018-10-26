package de.holisticon.zeitzuhelfen.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Requirements {
    CAR("Auto vorhanden"),
    ANIMALS("Kontakt mit Tieren"),
    HAVY_LOAD("Schwere Hebearbeit"),
    LIGHT_LOAD("Leichte_Hebearbeit"),
    PC("Computerkenntnisse"),
    LANGUAGES("Fremdsprachen");

    private String description;
}
