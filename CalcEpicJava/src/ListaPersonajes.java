import java.util.ArrayList;
import java.util.List;

public class ListaPersonajes {

    public static List<Personaje> createPersonajes() {  // El método debe ser público y estático
        List<Personaje> personajes = new ArrayList<>();

        // Aquí añades todos tus personajes
        personajes.add(new Personaje(
                "c1144",
                "Abigail",
                "Luctor",
                5,
                "Fuego",
                "Aries",
                true,
                false,
                7,
                1,
                7,
                "/pj/c1144_s.png",
                "/skills/sk_c1144_1.png",
                "/skills/sk_c1144_2.png",
                "/skills/sk_c1144_3.png"
        ));
        personajes.add(new Personaje(
                "c2016",
                "Yufine Abismal",
                "Custodes",
                5,
                "Oscuridad",
                "Acuario",
                false,
                false,
                6,
                3,
                6,
                "/pj/c2016_s.png",
                "/skills/sk_c2016_1.png",
                "/skills/sk_c2016_2.png",
                "/skills/sk_c2016_3.png"
        ));
        // Añadir más personajes con su constructor completo

        return personajes;
    }
}
