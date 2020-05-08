package br.edu.fjn.library.model;

public enum PhoneType {
    // celular //fixo
    CELLPHONE {
        @Override
        public String toString() {
            return "Celular";
        }
    },
    LANDLINE {
        @Override
        public String toString() {
            return "Fixo";
        }
    }
}