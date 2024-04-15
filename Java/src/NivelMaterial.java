import javax.swing.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class NivelMaterial {

    int nivel;
    int molagora;
    int materialSkill;
    int materialMax;
    int oro;


    public NivelMaterial(int nivel, int molagora, int materialSkill, int materialMax, int oro) {
        this.nivel = nivel;
        this.molagora = molagora;
        this.materialSkill = materialSkill;
        this.materialMax = materialMax;
        this.oro = oro;
    }


    @Override
    public String toString() {
        return "Nivel " + nivel + ": " + molagora + " Molagora, " + materialSkill + " Skill Material, " +
                materialMax + " Max Material, " + oro + " Oro";
    }
}

class MaterialesPorHabilidad {
    private Map<Integer, List<NivelMaterial>> materialesSinStigma;
    private Map<Integer, List<NivelMaterial>> materialesConStigma;


    public MaterialesPorHabilidad() {
        materialesSinStigma = new HashMap<>();
        materialesConStigma = new HashMap<>();
        inicializarMaterialesSinStigma();
        inicializarMaterialesConStigma();
    }

    private void inicializarMaterialesSinStigma() {
        materialesSinStigma.put(1, List.of(
                new NivelMaterial(1, 3, 8, 0, 52000)
        ));
        materialesSinStigma.put(2, List.of(
                new NivelMaterial(1, 1, 3, 0, 19000),
                new NivelMaterial(2, 2, 0, 1, 38000)
        ));
        materialesSinStigma.put(3, List.of(
                new NivelMaterial(1, 1, 3, 0, 19000),
                new NivelMaterial(2, 2, 5, 0, 33000),
                new NivelMaterial(3, 4, 0, 3, 110000)
        ));
        materialesSinStigma.put(4, List.of(
                new NivelMaterial(1, 1, 0, 0, 4000),
                new NivelMaterial(2, 1, 3, 0, 19000),
                new NivelMaterial(3, 3, 5, 0, 37000),
                new NivelMaterial(4, 4, 0, 2, 80000)
        ));
        materialesSinStigma.put(5, List.of(
                new NivelMaterial(1, 1, 0, 0, 4000),
                new NivelMaterial(2, 1, 0, 0, 4000),
                new NivelMaterial(3, 1, 5, 0, 29000),
                new NivelMaterial(4, 3, 7, 0, 47000),
                new NivelMaterial(5, 5, 0, 2, 80000)
        ));
        materialesSinStigma.put(6, List.of(
                new NivelMaterial(1, 1, 0, 0, 4000),
                new NivelMaterial(2, 1, 0, 0, 4000),
                new NivelMaterial(3, 1, 2, 0, 14000),
                new NivelMaterial(4, 2, 4, 0, 28000),
                new NivelMaterial(5, 4, 5, 0, 45000),
                new NivelMaterial(6, 4, 0, 2, 80000)
        ));
        materialesSinStigma.put(7, List.of(
                new NivelMaterial(1, 1, 0, 0, 4000),
                new NivelMaterial(2, 1, 0, 0, 4000),
                new NivelMaterial(3, 1, 0, 0, 4000),
                new NivelMaterial(4, 1, 3, 0, 19000),
                new NivelMaterial(5, 3, 4, 0, 32000),
                new NivelMaterial(6, 3, 7, 0, 55000),
                new NivelMaterial(7, 4, 0, 3, 110000)
        ));
    }
    private void inicializarMaterialesConStigma() {
        materialesConStigma.put(1, List.of(
                new NivelMaterial(1, 300, 0, 0, 4000)
        ));
        materialesConStigma.put(2, List.of(
                new NivelMaterial(1, 250, 2, 0, 14000),
                new NivelMaterial(2, 650, 3, 0, 24000)
        ));
        // Continúa para los demás niveles ...
        materialesConStigma.put(3, List.of(
                new NivelMaterial(1, 200, 2, 0, 13000),
                new NivelMaterial(2, 450, 3, 0, 21000),
                new NivelMaterial(3, 850, 5, 3, 37000)
        ));
        materialesConStigma.put(4, List.of(
                new NivelMaterial(1, 150, 0, 0, 2000),
                new NivelMaterial(2, 300, 2, 0, 14000),
                new NivelMaterial(3, 550, 3, 0, 23000),
                new NivelMaterial(4, 1100, 4, 0, 35000)
        ));
        materialesConStigma.put(5, List.of(
                new NivelMaterial(1, 120, 0, 0, 2000),
                new NivelMaterial(2, 270, 0, 0, 4000),
                new NivelMaterial(3, 470, 3, 0, 22000),
                new NivelMaterial(4, 740, 4, 0, 30000),
                new NivelMaterial(5, 1100, 5, 0, 40000)
        ));
        materialesConStigma.put(6, List.of(
                new NivelMaterial(1, 80, 0, 0, 2000),
                new NivelMaterial(2, 180, 0, 0, 3000),
                new NivelMaterial(3, 320, 1, 0, 10000),
                new NivelMaterial(4, 530, 2, 0, 18000),
                new NivelMaterial(5, 850, 4, 2, 32000),
                new NivelMaterial(6, 1340, 6, 2, 48000)
        ));
        materialesConStigma.put(7, List.of(
                new NivelMaterial(1, 50, 0, 0, 1000),
                new NivelMaterial(2, 120, 0, 0, 2000),
                new NivelMaterial(3, 230, 0, 0, 4000),
                new NivelMaterial(4, 400, 3, 0, 21000),
                new NivelMaterial(5, 650, 4, 0, 29000),
                new NivelMaterial(6, 1000, 5, 0, 39000),
                new NivelMaterial(7, 1450, 6, 0, 50000)
        ));
    }

    public Costos calcularCostosAcumulados(Personaje personaje, int nivelInicial, int nivelFinal, String habilidad) {
        Map<Integer, List<NivelMaterial>> materiales = personaje.isTieneStigma()
                ? materialesConStigma
                : materialesSinStigma;
        Costos costosAcumulados = new Costos(0, 0, 0, 0);
        int maxNivelesHabilidad = 0;

        // Determinar el máximo de niveles según la habilidad
        switch (habilidad) {
            case "S1":
                maxNivelesHabilidad = personaje.getNivelesS1();
                break;
            case "S2":
                maxNivelesHabilidad = personaje.getNivelesS2();
                break;
            case "S3":
                maxNivelesHabilidad = personaje.getNivelesS3();
                break;
        }

        // Obtener la lista de costos para la habilidad y nivel correspondiente
        List<NivelMaterial> listaNiveles = materiales.get(maxNivelesHabilidad);

        if (listaNiveles != null && nivelInicial < nivelFinal) {
            for (int i = nivelInicial; i < nivelFinal; i++) {
                NivelMaterial nivel = listaNiveles.get(i);
                costosAcumulados.molagora += nivel.molagora;
                costosAcumulados.materialSkill += nivel.materialSkill;
                costosAcumulados.materialMax += nivel.materialMax;
                costosAcumulados.oro += nivel.oro;
            }
        }
        return costosAcumulados;
    }





    public void mostrarMateriales(JComboBox<Integer> selector, Personaje personaje) {
        Map<Integer, List<NivelMaterial>> materialesActuales = personaje.isTieneStigma()
                ? materialesConStigma
                : materialesSinStigma;

        int maxNiveles = (int) selector.getSelectedItem();
        List<NivelMaterial> niveles = materialesActuales .get(maxNiveles);
        if (niveles != null) {
            for (NivelMaterial nm : niveles) {
                if (nm.nivel == maxNiveles) {
                    JOptionPane.showMessageDialog(null, nm.toString());
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos de materiales para " + maxNiveles + " niveles.");
        }
    }

}
