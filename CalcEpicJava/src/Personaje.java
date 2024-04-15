public class Personaje {
    private String horoscopoNombre;
    private String nombre;
    private String clase;
    private int rareza;
    private String elemento;
    private String horoscopo;
    private boolean tieneExclusiveEquipment;
    private boolean tieneStigma;
    private int nivelesS1;
    private int nivelesS2;
    private int nivelesS3;
    private String imgS1;
    private String imgS2;
    private String imgS3;

    // Constructor
    public Personaje(String nombre, String clase, int rareza, String elemento,
                     String horoscopo, boolean tieneExclusiveEquipment,
                     boolean tieneStigma, int nivelesS1, int nivelesS2, int nivelesS3,
                     String imgS1, String imgS2, String imgS3) {
        this.nombre = nombre;
        this.clase = clase;
        this.rareza = rareza;
        this.elemento = elemento;
        this.horoscopo = horoscopo;
        this.tieneExclusiveEquipment = tieneExclusiveEquipment;
        this.tieneStigma = tieneStigma;
        this.nivelesS1 = nivelesS1;
        this.nivelesS2 = nivelesS2;
        this.nivelesS3 = nivelesS3;
        this.imgS1 = imgS1;
        this.imgS2 = imgS2;
        this.imgS3 = imgS3;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClase() { return clase; }
    public void setClase(String clase) { this.clase = clase; }

    public int getRareza() { return rareza; }
    public void setRareza(int rareza) { this.rareza = rareza; }

    public String getElemento() { return elemento; }
    public void setElemento(String elemento) { this.elemento = elemento; }

    public String getHoroscopo() { return horoscopo; }
    public void setHoroscopo(String horoscopo) { this.horoscopo = horoscopo; }

    public boolean isTieneExclusiveEquipment() { return tieneExclusiveEquipment; }
    public void setTieneExclusiveEquipment(boolean tieneExclusiveEquipment) { this.tieneExclusiveEquipment = tieneExclusiveEquipment; }

    public boolean isTieneStigma() { return tieneStigma; }
    public void setTieneStigma(boolean tieneStigma) { this.tieneStigma = tieneStigma; }

    public int getNivelesS1() { return nivelesS1; }
    public void setNivelesS1(int nivelesS1) { this.nivelesS1 = nivelesS1; }

    public int getNivelesS2() { return nivelesS2; }
    public void setNivelesS2(int nivelesS2) { this.nivelesS2 = nivelesS2; }

    public int getNivelesS3() { return nivelesS3; }
    public void setNivelesS3(int nivelesS3) { this.nivelesS3 = nivelesS3; }

    public String getImgS1() { return imgS1; }
    public void setImgS1(String imgS1) { this.imgS1 = imgS1; }

    public String getImgS2() { return imgS2; }
    public void setImgS2(String imgS2) { this.imgS2 = imgS2; }

    public String getImgS3() { return imgS3; }
    public void setImgS3(String imgS3) { this.imgS3 = imgS3; }


    // Método para establecer el nombre del horóscopo (opcional si ya se establece en el constructor)
    public void setHoroscopoNombre(String horoscopoNombre) {
        this.horoscopoNombre = horoscopoNombre;
    }
    // Método toString para imprimir información del personaje
    @Override
    public String toString() {
        return nombre; // Esto asegura que solo el nombre se muestre en el JComboBox
    }
}
