public class Costos {
    int molagora;
    int materialSkill;
    int materialMax;
    int oro;

    public Costos(int molagora, int materialSkill, int materialMax, int oro) {
        this.molagora = molagora;
        this.materialSkill = materialSkill;
        this.materialMax = materialMax;
        this.oro = oro;
    }

    // Suma los costos de otro objeto Costos a este objeto
    public void sumar(Costos otrosCostos) {
        this.molagora += otrosCostos.molagora;
        this.materialSkill += otrosCostos.materialSkill;
        this.materialMax += otrosCostos.materialMax;
        this.oro += otrosCostos.oro;
    }
}
