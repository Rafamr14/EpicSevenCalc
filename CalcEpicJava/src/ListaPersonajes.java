import java.util.ArrayList;
import java.util.List;

public class ListaPersonajes {

    public static List<Personaje> createPersonajes() {  // El método debe ser público y estático
        List<Personaje> personajes = new ArrayList<>();

        // Aquí añades todos tus personajes
        personajes.add(new Personaje(
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
                "/skills/sk_c1144_1.png",
                "/skills/sk_c1144_2.png",
                "/skills/sk_c1144_3.png"
        ));
        personajes.add(new Personaje(
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
                "/skills/sk_c2016_1.png",
                "/skills/sk_c2016_2.png",
                "/skills/sk_c2016_3.png"
        ));
        // Añadir más personajes con su constructor completo

        return personajes;
    }
}
