import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.net.URL;
import data.Horoscopo;
import data.HoroscopoData;

public class MaterialCalculator extends JFrame {
    private HoroscopoData horoscopoData;
    private JLabel labelNombrePersonaje;

    private JLabel labelCosteMolagora;
    private JLabel labelCosteMaterialSkill;
    private JLabel labelCosteMaterialMax;
    private JLabel labelCosteOro;
    private JLabel imagenS1;
    private JLabel imagenS2;
    private JLabel imagenS3;
    private JLabel imglvS3;
    private JLabel PlusS3;
    private JLabel imglvS2;
    private JLabel PlusS2;
    private JLabel imglvS1;
    private JLabel PlusS1;
    private JLabel PlaceholderimglvS3;
    private JLabel PlaceholderimglvS2;
    private JLabel PlaceholderimglvS1;
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
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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
        s1LevelInitial.setBounds(10, 135, 80, 25);
        s2LevelInitial.setBounds(100, 135, 80, 25);
        s3LevelInitial.setBounds(190, 135, 80, 25);

        mainPanel.add(s1LevelInitial);
        mainPanel.add(s2LevelInitial);
        mainPanel.add(s3LevelInitial);

        characterComboBox = new JComboBox<>();
        characterComboBox.setBounds(10, 10, 180, 25);
        mainPanel.add(characterComboBox);
        loadPersonajes();
//se mueve todo 90 px
        imagenS1 = new JLabel();
        imagenS1.setBounds(10, 210, 80, 84);
        mainPanel.add(imagenS1);

        imagenS2 = new JLabel();
        imagenS2.setBounds(100, 210, 80, 84);
        mainPanel.add(imagenS2);

        imagenS3 = new JLabel();
        imagenS3.setBounds(190, 210, 80, 84);
        mainPanel.add(imagenS3);

        imgMolagora = new JLabel();
        imgMolagora.setBounds(10,300, 50, 50);
        mainPanel.add(imgMolagora);

        imgMatMax = new JLabel();
        imgMatMax.setBounds(190,300, 50, 50); // Asegúrate de que las coordenadas y el tamaño sean correctos
        mainPanel.add(imgMatMax);

        imgMatSkill = new JLabel();
        imgMatSkill.setBounds(100, 300, 50, 50);
        mainPanel.add(imgMatSkill);

        imgOro = new JLabel();
        imgOro.setBounds(280,300, 50, 50);
        mainPanel.add(imgOro);
        String oroImagePath = "/img/token_gold.png";
        setImageLabel(imgOro, oroImagePath, 50, 50);

        PlaceholderimglvS3 = new JLabel();
        PlaceholderimglvS3.setBounds(235,190, 50, 50);
        mainPanel.add(PlaceholderimglvS3);

        imglvS3 = new JLabel();
        imglvS3.setBounds(248,190, 50, 50);
        mainPanel.add(imglvS3);

        PlusS3 = new JLabel();
        PlusS3.setBounds(239,190, 50, 50);
        mainPanel.add(PlusS3);

        PlaceholderimglvS2 = new JLabel();
        PlaceholderimglvS2.setBounds(149,190, 50, 50);
        mainPanel.add(PlaceholderimglvS2);

        imglvS2 = new JLabel();
        imglvS2.setBounds(162,190, 50, 50);
        mainPanel.add(imglvS2);

        PlusS2 = new JLabel();
        PlusS2.setBounds(153,190, 50, 50);
        mainPanel.add(PlusS2);

        PlaceholderimglvS1 = new JLabel();
        PlaceholderimglvS1.setBounds(59,190, 50, 50);
        mainPanel.add(PlaceholderimglvS1);

        imglvS1 = new JLabel();
        imglvS1.setBounds(72,190, 50, 50);
        mainPanel.add(imglvS1);

        PlusS1 = new JLabel();
        PlusS1.setBounds(63,190, 50, 50);
        mainPanel.add(PlusS1);

        // Inicializa las etiquetas para mostrar los costes con valores iniciales
        labelNombrePersonaje = new JLabel();
        labelNombrePersonaje.setBounds(15, 35, 200, 30);
        mainPanel.add(labelNombrePersonaje);
        Font font = labelNombrePersonaje.getFont();
        labelNombrePersonaje.setFont(new Font(font.getName(), Font.BOLD, 16));

        labelCosteMolagora = new JLabel("0");
        labelCosteMolagora.setBounds(10, 340, 64, 30);
        mainPanel.add(labelCosteMolagora);
        Font fontMolagora = labelCosteMolagora.getFont();
        labelCosteMolagora.setFont(new Font(fontMolagora.getName(), Font.BOLD, 16));

        labelCosteMaterialSkill = new JLabel("0");
        labelCosteMaterialSkill.setBounds(100, 340, 64, 30);
        mainPanel.add(labelCosteMaterialSkill);
        Font fontMatSkill = labelCosteMaterialSkill.getFont();
        labelCosteMaterialSkill.setFont(new Font(fontMatSkill.getName(), Font.BOLD, 16));

        labelCosteMaterialMax = new JLabel("0");
        labelCosteMaterialMax.setBounds(190, 340, 64, 30);
        mainPanel.add(labelCosteMaterialMax);
        Font fontMatMax = labelCosteMaterialMax.getFont();
        labelCosteMaterialMax.setFont(new Font(fontMatMax.getName(), Font.BOLD, 16));

        labelCosteOro = new JLabel("0");
        labelCosteOro.setBounds(280, 340, 100, 30);
        mainPanel.add(labelCosteOro);
        Font fontOro = labelCosteOro.getFont();
        labelCosteOro.setFont(new Font(fontOro.getName(), Font.BOLD, 16));

        s1LevelSelector = new JComboBox<>();
        s1LevelSelector.setBounds(10, 160, 80, 25);
        mainPanel.add(s1LevelSelector);

        s2LevelSelector = new JComboBox<>();
        s2LevelSelector.setBounds(100, 160, 80, 25);
        mainPanel.add(s2LevelSelector);

        s3LevelSelector = new JComboBox<>();
        s3LevelSelector.setBounds(190, 160, 80, 25);
        mainPanel.add(s3LevelSelector);

        labelCosteOro.setVisible(false);
        labelCosteMaterialMax.setVisible(false);
        labelCosteMaterialSkill.setVisible(false);
        labelCosteMolagora.setVisible(false);
        imgOro.setVisible(false);
        s1LevelSelector.setVisible(false);
        s2LevelSelector.setVisible(false);
        s3LevelSelector.setVisible(false);
        s1LevelInitial.setVisible(false);
        s2LevelInitial.setVisible(false);
        s3LevelInitial.setVisible(false);
        PlaceholderimglvS1.setVisible(false);
        PlaceholderimglvS2.setVisible(false);
        PlaceholderimglvS3.setVisible(false);
        imglvS3.setVisible(false);
        imglvS2.setVisible(false);
        imglvS1.setVisible(false);

        // Agregar el ActionListener al characterComboBox
        characterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Personaje selectedPersonaje = (Personaje) characterComboBox.getSelectedItem();
                if (selectedPersonaje != null) {
                    updateHoroscopeImages(selectedPersonaje);
                    updateLevelSelectors(selectedPersonaje);
                    updateSkillImages(selectedPersonaje);
                    imgMolagoraStigma(selectedPersonaje);

                    labelNombrePersonaje.setText(selectedPersonaje.getNombre());
                }

            }
        });

        mainPanel.setComponentZOrder(imglvS3, 0);
        mainPanel.setComponentZOrder(PlusS3, 1);
        mainPanel.setComponentZOrder(PlaceholderimglvS3, 2);
        mainPanel.setComponentZOrder(imglvS2, 3);
        mainPanel.setComponentZOrder(PlusS2, 4);
        mainPanel.setComponentZOrder(PlaceholderimglvS2, 5);
        mainPanel.setComponentZOrder(imglvS1, 6);
        mainPanel.setComponentZOrder(PlusS1, 7);
        mainPanel.setComponentZOrder(PlaceholderimglvS1, 8);



        s3LevelSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Personaje selectedPersonaje = (Personaje) characterComboBox.getSelectedItem();
                if (s3LevelSelector.getSelectedIndex() != -1 && s3LevelSelector.getSelectedItem() != null) {
                    if (selectedPersonaje != null) {
                        updateSkillImages(selectedPersonaje);
                        imglvS3.setVisible(true);
                        labelCosteOro.setVisible(true);
                        imgOro.setVisible(true);
                        labelCosteMaterialMax.setVisible(true);
                        labelCosteMaterialSkill.setVisible(true);
                        labelCosteMolagora.setVisible(true);
                        s1LevelSelector.setVisible(true);
                        s2LevelSelector.setVisible(true);
                        s3LevelSelector.setVisible(true);
                        s1LevelInitial.setVisible(true);
                        s2LevelInitial.setVisible(true);
                        s3LevelInitial.setVisible(true);
                    }
                } else {
                    imglvS3.setVisible(false);
                    labelCosteOro.setVisible(false);
                }
            }
        });
        s2LevelSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Personaje selectedPersonaje = (Personaje) characterComboBox.getSelectedItem();
                if (s2LevelSelector.getSelectedIndex() != -1 && s2LevelSelector.getSelectedItem() != null) {
                    if (selectedPersonaje != null) {
                        updateSkillImages(selectedPersonaje);
                        imglvS2.setVisible(true);
                    }
                } else {
                    imglvS2.setVisible(false);
                }
            }
        });
        s1LevelSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Personaje selectedPersonaje = (Personaje) characterComboBox.getSelectedItem();
                if (s1LevelSelector.getSelectedIndex() != -1 && s1LevelSelector.getSelectedItem() != null) {
                    if (selectedPersonaje != null) {
                        updateSkillImages(selectedPersonaje);
                        imglvS1.setVisible(true);
                    }
                } else {
                    imglvS1.setVisible(false);
                }
            }
        });

        horoscopoData = new HoroscopoData();
        addSelectorListeners();
    }
    private void loadPersonajes() {
        List<Personaje> personajes = ListaPersonajes.createPersonajes();
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

            // Obtén el nivel seleccionado de s3LevelSelector, asumiendo que los niveles están bien definidos
            Integer selectedLevel = (Integer) s3LevelSelector.getSelectedItem();
            if (selectedLevel != null && selectedLevel > 0) {
                String imglvS3path = "/ui/itxt_num" + selectedLevel + "_b.png";
                String PlusS3path = "/ui/itxt_numplus_b.png";
                setImageLabel(imglvS3, imglvS3path, 13, 15);
                setImageLabel(PlusS3, PlusS3path, 13, 15);
                String PlaceholderimglvS3path = "/ui/_upgrade_num_orange2.png";
                setImageLabel(PlaceholderimglvS3, PlaceholderimglvS3path, 30, 20);
                PlaceholderimglvS3.setVisible(true);
                imglvS3.setVisible(true);
            } else {
                PlaceholderimglvS3.setVisible(false);
                imglvS3.setVisible(false);
            }
            Integer selectedLevelS2 = (Integer) s2LevelSelector.getSelectedItem();
            if (selectedLevelS2 != null && selectedLevelS2 > 0) {
                String imglvS2path = "/ui/itxt_num" + selectedLevelS2 + "_b.png";
                String PlusS2path = "/ui/itxt_numplus_b.png";
                setImageLabel(imglvS2, imglvS2path, 13, 15);
                setImageLabel(PlusS2, PlusS2path, 13, 15);
                String PlaceholderimglvS2path = "/ui/_upgrade_num_orange2.png";
                setImageLabel(PlaceholderimglvS2, PlaceholderimglvS2path, 30, 20);
                PlaceholderimglvS2.setVisible(true);
                imglvS2.setVisible(true);
            } else {
                PlaceholderimglvS2.setVisible(false);
                imglvS2.setVisible(false);
            }
            Integer selectedLevelS1 = (Integer) s1LevelSelector.getSelectedItem();
            if (selectedLevelS1 != null && selectedLevelS1 > 0) {
                String imglvS1path = "/ui/itxt_num" + selectedLevelS1 + "_b.png";
                String PlusS1path = "/ui/itxt_numplus_b.png";
                setImageLabel(imglvS1, imglvS1path, 13, 15);
                setImageLabel(PlusS1, PlusS1path, 13, 15);
                String PlaceholderimglvS1path = "/ui/_upgrade_num_orange2.png";
                setImageLabel(PlaceholderimglvS1, PlaceholderimglvS1path, 30, 20);
                PlaceholderimglvS1.setVisible(true);
                imglvS1.setVisible(true);
            } else {
                PlaceholderimglvS1.setVisible(false);
                imglvS1.setVisible(false);
            }
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
        s1LevelInitial.addActionListener(materialsListener);
        s2LevelInitial.addActionListener(materialsListener);
        s3LevelInitial.addActionListener(materialsListener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MaterialCalculator().setVisible(true);
            }
        });
    }
}
