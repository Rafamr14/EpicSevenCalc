import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.net.URL;
import data.Horoscopo;
import data.HoroscopoData;

public class MaterialCalculator extends JFrame {
    private HoroscopoData horoscopoData;
    private JLabel labelCosteMolagora;
    private JLabel labelCosteMaterialSkill;
    private JLabel labelCosteMaterialMax;
    private JLabel labelCosteOro;
    private JLabel imagenS1;
    private JLabel imagenS2;
    private JLabel imagenS3;
    private JLabel imgMolagora;
    private JLabel imgMatSkill;
    private JLabel imgMatMax;
    private JLabel imgOro;
    private JLabel imgPj;
    private JPanel mainPanel;

    private JComboBox<Personaje> characterComboBox;
    private JComboBox<Integer> s1LevelInitial;
    private JComboBox<Integer> s2LevelInitial;
    private JComboBox<Integer> s3LevelInitial;
    private JComboBox<Integer> s1LevelSelector, s2LevelSelector, s3LevelSelector;
    private JLabel resultLabel;
    private MaterialesPorHabilidad materialesPorHabilidad;

    public MaterialCalculator() {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setTitle("Epic Seven Farm Calc");
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializa materialesPorHabilidad antes de llamar initComponents
        materialesPorHabilidad = new MaterialesPorHabilidad();
        horoscopoData = new HoroscopoData();

        initComponents();
        setLocationRelativeTo(null);
    }


    private void initComponents() {
        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(null);

        s1LevelInitial = new JComboBox<>();
        s2LevelInitial = new JComboBox<>();
        s3LevelInitial = new JComboBox<>();

        // Establece ubicaciones y tamaños, ajusta según tus necesidades
        s1LevelInitial.setBounds(10, 50, 50, 20);
        s2LevelInitial.setBounds(100, 50, 50, 20);
        s3LevelInitial.setBounds(190, 50, 50, 20);

        mainPanel.add(s1LevelInitial);
        mainPanel.add(s2LevelInitial);
        mainPanel.add(s3LevelInitial);

        characterComboBox = new JComboBox<>();
        characterComboBox.setBounds(10, 10, 180, 25);
        mainPanel.add(characterComboBox);
        loadPersonajes();

        imagenS1 = new JLabel();
        imagenS1.setBounds(10, 100, 80, 84);
        mainPanel.add(imagenS1);

        imagenS2 = new JLabel();
        imagenS2.setBounds(100, 100, 80, 84);
        mainPanel.add(imagenS2);

        imagenS3 = new JLabel();
        imagenS3.setBounds(190, 100, 80, 84);
        mainPanel.add(imagenS3);

        imgMolagora = new JLabel();
        imgMolagora.setBounds(10,190, 50, 50);
        mainPanel.add(imgMolagora);

        imgMatMax = new JLabel();
        imgMatMax.setBounds(190,190, 50, 50); // Asegúrate de que las coordenadas y el tamaño sean correctos
        mainPanel.add(imgMatMax);

        imgMatSkill = new JLabel();
        imgMatSkill.setBounds(100, 190, 50, 50);
        mainPanel.add(imgMatSkill);

        imgOro = new JLabel();
        imgOro.setBounds(280,190, 50, 50);
        mainPanel.add(imgOro);
        String oroImagePath = "/img/token_gold.png";
        setImageLabel(imgOro, oroImagePath, 50, 50);

        imgPj = new JLabel();
        imgPj.setBounds(420,-100, 900, 1100);
        mainPanel.add(imgPj);
        String imgPjPath = "/Splash/c2016_idle_normal.png";
        setImageLabel(imgPj, imgPjPath, 900, 1000);

        // Inicializa las etiquetas para mostrar los costes con valores iniciales
        labelCosteMolagora = new JLabel("0");
        labelCosteMolagora.setBounds(10, 230, 64, 30);
        mainPanel.add(labelCosteMolagora);

        labelCosteMaterialSkill = new JLabel("0");
        labelCosteMaterialSkill.setBounds(100, 230, 64, 30);
        mainPanel.add(labelCosteMaterialSkill);

        labelCosteMaterialMax = new JLabel("0");
        labelCosteMaterialMax.setBounds(190, 230, 64, 30);
        mainPanel.add(labelCosteMaterialMax);

        labelCosteOro = new JLabel("0");
        labelCosteOro.setBounds(280, 230, 100, 30);
        mainPanel.add(labelCosteOro);

        s1LevelSelector = new JComboBox<>();
        s1LevelSelector.setBounds(10, 70, 80, 25);
        mainPanel.add(s1LevelSelector);

        s2LevelSelector = new JComboBox<>();
        s2LevelSelector.setBounds(100, 70, 80, 25);
        mainPanel.add(s2LevelSelector);

        s3LevelSelector = new JComboBox<>();
        s3LevelSelector.setBounds(190, 70, 80, 25);
        mainPanel.add(s3LevelSelector);

        // Agregar el ActionListener al characterComboBox
        characterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Personaje selectedPersonaje = (Personaje) characterComboBox.getSelectedItem();
                if (selectedPersonaje != null) {
                    updateHoroscopeImages(selectedPersonaje);
                    updateLevelSelectors(selectedPersonaje);
                    updateSkillImages(selectedPersonaje);
                    imgMolagoraStigma(selectedPersonaje);
                }

            }
        });
        horoscopoData = new HoroscopoData();
        addSelectorListeners();
    }
    private void loadPersonajes() {
        List<Personaje> personajes = ListaPersonajes.createPersonajes(); // Asegúrate de que ListaPersonajes esté importado correctamente
        for (Personaje p : personajes) {
            characterComboBox.addItem(p);
        }
    }

    // Esta función se llamará cada vez que se seleccione un personaje en el JComboBox
    private void updateHoroscopeImages(Personaje selectedPersonaje) {
        if (selectedPersonaje != null) {
            Horoscopo horoscopoSeleccionado = horoscopoData.getHoroscopoPorNombre(selectedPersonaje.getHoroscopo());
            if (horoscopoSeleccionado != null) {
                String matSkillPath = "/" + horoscopoSeleccionado.getImgMatSkill();
                String matMaxPath = "/" + horoscopoSeleccionado.getImgMatMax();

                setImageLabel(imgMatSkill, matSkillPath, 50, 50); // Asumiendo que quieres que imgMatSkill sea de 50x50 píxeles
                setImageLabel(imgMatMax, matMaxPath, 50, 50); // Igual para imgMatMax
            } else {
                imgMatSkill.setIcon(null); // Si no se encuentra el horóscopo, puedes dejar la imagen en blanco
                imgMatMax.setIcon(null);
            }
        }
    }

    private void updateSkillImages(Personaje personaje) {
        if (personaje != null) {
            imagenS1.setIcon(new ImageIcon(getClass().getResource(personaje.getImgS1())));
            imagenS2.setIcon(new ImageIcon(getClass().getResource(personaje.getImgS2())));
            imagenS3.setIcon(new ImageIcon(getClass().getResource(personaje.getImgS3())));
        }
    }

    private void imgMolagoraStigma(Personaje personaje) {
        String imagePath;
        if (!personaje.isTieneStigma()) {
            imagePath = "/level/ma_moragora1.png";
        } else {
            imagePath = "/img/token_stigma.png";
        }

        URL imgURL = getClass().getResource(imagePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            imgMolagora.setIcon(icon);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + imagePath);
            imgMolagora.setIcon(null);
        }
        setImageLabel(imgMolagora, imagePath, 50, 50);
    }
    private void setImageLabel(JLabel label, String imagePath, int width, int height) {
        // Asegúrate de que la ruta de imagen comienza con "/"
        URL imgURL = getClass().getResource(imagePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image image = icon.getImage(); // Transforma el icono en una imagen para poder escalarla
            Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // Escala la imagen de manera suave a width x height
            icon = new ImageIcon(newimg);  // Transforma de vuelta la imagen escalada en un icono
            label.setIcon(icon);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + imagePath);
        }
    }


    private void updateLevelSelectors(Personaje personaje) {
        updateSelector(s1LevelSelector, personaje.getNivelesS1());
        updateSelector(s2LevelSelector, personaje.getNivelesS2());
        updateSelector(s3LevelSelector, personaje.getNivelesS3());

        // También actualiza los selectores iniciales
        updateSelector(s1LevelInitial, personaje.getNivelesS1());
        updateSelector(s2LevelInitial, personaje.getNivelesS2());
        updateSelector(s3LevelInitial, personaje.getNivelesS3());
    }

    private void updateSelector(JComboBox<Integer> selector, int maxLevel) {
        selector.removeAllItems();
        selector.addItem(0); // Añade el estado "en blanco" como el valor cero.
        for (int i = 1; i <= maxLevel; i++) {
            selector.addItem(i);
        }
        // No selecciona ningún nivel por defecto para dejarlo en blanco o en cero
        selector.setSelectedIndex(0); // Establece el estado "en blanco" como seleccionado por defecto
    }


    private void calcularYMostrarCostoTotal() {
        Personaje selectedPersonaje = (Personaje) characterComboBox.getSelectedItem();
        if (selectedPersonaje == null) {
            return; // No hay personaje seleccionado.
        }

        // Obtiene los niveles iniciales y finales de S1, S2 y S3.
        int nivelS1Inicial = s1LevelInitial.getSelectedItem() == null ? 0 : (int) s1LevelInitial.getSelectedItem();
        int nivelS1Final = s1LevelSelector.getSelectedItem() == null ? 0 : (int) s1LevelSelector.getSelectedItem();

        // Debes usar los selectores de S2 aquí, no los de S1.
        int nivelS2Inicial = s2LevelInitial.getSelectedItem() == null ? 0 : (int) s2LevelInitial.getSelectedItem();
        int nivelS2Final = s2LevelSelector.getSelectedItem() == null ? 0 : (int) s2LevelSelector.getSelectedItem();

        // Debes usar los selectores de S3 aquí, no los de S1.
        int nivelS3Inicial = s3LevelInitial.getSelectedItem() == null ? 0 : (int) s3LevelInitial.getSelectedItem();
        int nivelS3Final = s3LevelSelector.getSelectedItem() == null ? 0 : (int) s3LevelSelector.getSelectedItem();

        Costos costosTotales = new Costos(0, 0, 0, 0);

        // Realiza los cálculos de costos de S1.
        if (nivelS1Final > nivelS1Inicial) {
            Costos costosS1 = materialesPorHabilidad.calcularCostosAcumulados(selectedPersonaje, nivelS1Inicial, nivelS1Final, "S1");
            costosTotales.sumar(costosS1);
        }

        // Realiza los cálculos de costos de S2.
        if (nivelS2Final > nivelS2Inicial) {
            Costos costosS2 = materialesPorHabilidad.calcularCostosAcumulados(selectedPersonaje, nivelS2Inicial, nivelS2Final, "S2");
            costosTotales.sumar(costosS2);
        }

        // Realiza los cálculos de costos de S3.
        if (nivelS3Final > nivelS3Inicial) {
            Costos costosS3 = materialesPorHabilidad.calcularCostosAcumulados(selectedPersonaje, nivelS3Inicial, nivelS3Final, "S3");
            costosTotales.sumar(costosS3);
        }

        // Actualiza los componentes de la interfaz gráfica con los costos totales.
        labelCosteMolagora.setText(String.valueOf(costosTotales.molagora));
        labelCosteMaterialSkill.setText(String.valueOf(costosTotales.materialSkill));
        labelCosteMaterialMax.setText(String.valueOf(costosTotales.materialMax));
        labelCosteOro.setText(String.valueOf(costosTotales.oro));
    }


    private void addSelectorListeners() {
        ActionListener materialsListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularYMostrarCostoTotal();
            }
        };

        s1LevelSelector.addActionListener(materialsListener);
        s2LevelSelector.addActionListener(materialsListener);
        s3LevelSelector.addActionListener(materialsListener);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MaterialCalculator().setVisible(true);
            }
        });
    }
}
