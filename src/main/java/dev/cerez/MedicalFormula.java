package dev.cerez;

public record MedicalFormula(
        String name,
        Double size
) {
    public int codeFormula(){
        return hashCode();
    }
}
