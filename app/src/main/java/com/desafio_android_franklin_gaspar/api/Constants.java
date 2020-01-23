package com.desafio_android_franklin_gaspar.api;

public enum Constants {
    LISTADEPERSONAGENS("characters"),
    LISTADEHQ("characters/{haracterId}/comics");

    private final String text;

    Constants(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}