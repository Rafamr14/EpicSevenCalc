package data;

public class Horoscopo {
    private String nombre;
    private String imgHoroscopo;
    private String imgMatSkill;
    private String imgMatAwakening;
    private String imgMatMax;

    public Horoscopo(String nombre, String imgHoroscopo, String imgMatSkill, String imgMatAwakening, String imgMatMax) {
        this.nombre = nombre;
        this.imgHoroscopo = imgHoroscopo;
        this.imgMatSkill = imgMatSkill;
        this.imgMatAwakening = imgMatAwakening;
        this.imgMatMax = imgMatMax;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getImgHoroscopo() { return imgHoroscopo; }
    public String getImgMatSkill() { return imgMatSkill; }
    public String getImgMatAwakening() { return imgMatAwakening; }
    public String getImgMatMax() { return imgMatMax; }
}
