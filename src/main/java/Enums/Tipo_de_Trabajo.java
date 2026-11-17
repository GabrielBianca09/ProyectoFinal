package Enums;

public enum Tipo_de_Trabajo {
    cadete(30),cocinero(20),conserje(50),mozo(16);
    private final double factor;

    Tipo_de_Trabajo(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
