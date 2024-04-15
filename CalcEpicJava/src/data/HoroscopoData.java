package data;

import data.Horoscopo;

import java.util.HashMap;
import java.util.Map;

public class HoroscopoData {
    private Map<String, Horoscopo> horoscoposMap;

    public HoroscopoData() {
        horoscoposMap = new HashMap<>();
        inicializarHoroscopos();
    }

    private void inicializarHoroscopos() {
        horoscoposMap.put("Acuario", new Horoscopo("Acuario", "horoscopo/cm_icon_zodiac_waterbearer.png", "level/ma_swordman_es.png", "level/ma_shield_es.png", "level/ma_insignia_es.png"));
        horoscoposMap.put("Aries", new Horoscopo("Aries","horoscopo/cm_icon_zodiac_ram.png", "level/ma_meca_es.png", "level/ma_nature_es.png", "level/ma_dreamerk_es.png"));
        horoscoposMap.put("Cancer", new Horoscopo("Cancer","horoscopo/cm_icon_zodiac_crab.png", "level/ma_rodent_es.png", "level/ma_siren_es.png", "level/ma_mecagolem_es.png"));
        horoscoposMap.put("Capricornio", new Horoscopo("Capricornio","horoscopo/cm_icon_zodiac_goat.png", "level/ma_slime_es.png", "level/ma_candle_es.png", "level/ma_wyvern_es.png"));
        horoscoposMap.put("Geminis", new Horoscopo("Geminis","horoscopo/cm_icon_zodiac_twins.png", "level/ma_taranor_es.png", "level/ma_magician_es.png", "level/ma_chimaera_es.png"));
        horoscoposMap.put("Leo", new Horoscopo("Leo","horoscopo/cm_icon_zodiac_lion.png", "level/ma_demon_es.png", "level/ma_wolf_es.png", "level/ma_queen_es.png"));
        horoscoposMap.put("Libra", new Horoscopo("Libra","horoscopo/cm_icon_zodiac_scales.png", "level/ma_gem_es.png", "level/ma_dreamer_es.png", "level/ma_raingar_es.png"));
        horoscoposMap.put("Piscis", new Horoscopo("Piscis","horoscopo/cm_icon_zodiac_fish.png", "level/ma_imp_es.png", "level/ma_bone_es.png", "level/ma_golem_es.png"));
        horoscoposMap.put("Sagitario", new Horoscopo("Sagitario","horoscopo/cm_icon_zodiac_archer.png", "level/ma_bowman_es.png", "level/ma_demonr_es.png", "level/ma_hired_es.png"));
        horoscoposMap.put("Escorpio", new Horoscopo("Escorpio","horoscopo/cm_icon_zodiac_scorpion.png", "level/ma_spearman_es.png", "level/ma_carapace_es.png", "level/ma_powder_es.png"));
        horoscoposMap.put("Tauro", new Horoscopo("Tauro","horoscopo/cm_icon_zodiac_bull.png", "level/ma_penguin_es.png", "level/ma_hatchling_es.png", "level/ma_demont_es.png"));
        horoscoposMap.put("Virgo", new Horoscopo("Virgo","horoscopo/cm_icon_zodiac_maiden.png", "level/ma_banshee_es.png", "level/ma_entree_es.png", "level/ma_angraf_es.png"));
    }

    public Horoscopo getHoroscopoPorNombre(String nombre) {
        return horoscoposMap.get(nombre);
    }
}
