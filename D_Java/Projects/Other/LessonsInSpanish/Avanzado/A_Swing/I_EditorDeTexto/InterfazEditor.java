package Avanzado.A_Swing.I_EditorDeTexto;

import javax.swing.*;
import javax.swing.event.*;

import Avanzado.A_Swing.I_EditorDeTexto.Idiomas.Eng;
import Avanzado.A_Swing.I_EditorDeTexto.Idiomas.Esp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class InterfazEditor extends JFrame{
    
    //Main:
    public static void main(String[] args){
        try{
            new InterfazEditor();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //End Main

    //Variables:
    private int tamX = 810;
    private int tamY = 710;
    private int tamLetra = 20;
    private int numL,numE,numT;
    private int idioma = 0;
    private String[] textos = new String[4];
    private String mensajeInfo;
    //End Variables.

    //Components:
    //Dimensions:
    private Dimension screenSize;
    //MenuBar:
    private JMenuBar menuBar;
    private JMenu file, help, languages;
    private JMenuItem exit, guardar, info, esp, eng;
    //Panels:
    private JPanel absoluteBack, back, p1, p1a, p1b, p1c, p1d, p2, p3, p3a, p3aa, p3ab, p3b, p3c, p4;
    //Labels:
    private JLabel l1,l2,l3,lp;
    //TextArea:
    private JTextArea textArea;
    //TextField:
    private JTextField consola;
    //ScrollPane:
    private JScrollPane scroll;
    //ButtonGroups:
    private ButtonGroup grupoTipoLetra, grupoFormaLetra;
    //RadioButtons:
    private JRadioButton plain, bold, italic, times, arial, mvboli;
    //Slider:
    private JSlider slider;
    //Buttons:
    private JButton borrar, aplicar, titulo, colorChooserButton1, colorChooserButton2, save, load;
    //ProgressBar:
    private JProgressBar progressBar;
    //List:
    private JList<String> list;
    //End Components.
    
    //Constructor:
    public InterfazEditor(){
        initComponets();
    }
    //End Constructor.

    //Metodos Privados:
    private void initComponets(){
        String[] comentarios = null;
        String[] marcas = null;
        if(idioma == 0){
            comentarios = Esp.COMENTARIOS_VISTA;
            marcas = Esp.MARCAS;
        }else{
            comentarios = Eng.COMENTARIOS_VISTA;
            marcas = Eng.MARCAS;
        }
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((screenSize.width/2)-(tamX/2) , (screenSize.height/2)-(tamY/2));
        this.setTitle("Gui Ejercicio");
        this.setResizable(false);
        
        //MenuBar:
        menuBar = new JMenuBar();
            //Menus:
            file = new JMenu(comentarios[0]);
            help = new JMenu(comentarios[1]);
            languages = new JMenu(comentarios[2]);
                //Items:
                exit = new JMenuItem(comentarios[3]);
                exit.addActionListener(e -> System.exit(0));
                guardar = new JMenuItem(comentarios[21]);
                guardar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        try {
                            fileChooser1();
                        } catch (IOException e1) {
                            System.out.println(e1.getMessage());
                        }
                    }
                });
                info = new JMenuItem(comentarios[4]);
                mensajeInfo = comentarios[22];
                info.addActionListener(e -> JOptionPane.showMessageDialog(null, mensajeInfo,"Info:", JOptionPane.INFORMATION_MESSAGE));
                esp = new JMenuItem(comentarios[5]);
                esp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        setEspañol();
                    }
                });
                eng = new JMenuItem(comentarios[6]);
                eng.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        setEnglish();
                    }
                });
                file.add(guardar);
                file.add(exit);
                help.add(info);
                languages.add(esp);
                languages.add(eng);
                //End Items.
            menuBar.add(file);
            menuBar.add(help);
            menuBar.add(languages);
            //End Menus.
        this.setJMenuBar(menuBar);
        //End MenuBar.
        
        
        //AbsoluteBack:
        absoluteBack = new JPanel();
        absoluteBack.setBackground(Color.BLACK);
        absoluteBack.setPreferredSize(new Dimension(tamX,tamY));
            //Back:
            back = new JPanel();
            back.setPreferredSize(new Dimension(800,700));
            back.setLayout(new BorderLayout(10,0));
            back.setBackground(Color.BLACK);
                //Panels:
                p1 = new JPanel();
                p1.setPreferredSize(new Dimension(200,500));
                p1.setLayout(new GridLayout(4,1,10,10));
                p1.setBackground(Color.BLACK);
                    //Panels Interior:
                    p1a = new JPanel();
                    p1a.setLayout(new GridLayout(2,1,5,5));
                    p1a.setBackground(Color.BLACK);
                        //Label:
                        lp = new JLabel(comentarios[7]);
                        lp.setFont(new Font("MV Boli", Font.BOLD, 15));
                        lp.setHorizontalAlignment(JLabel.CENTER);
                        lp.setBackground(Color.BLACK);
                        lp.setForeground(Color.WHITE);
                        p1a.add(lp);
                        //End Label.
                        //ProgressBar:
                        progressBar = new JProgressBar(0,2000);
                        progressBar.setValue(0);
                        progressBar.setStringPainted(true);
                        progressBar.setFont(new Font("MV Boli", Font.BOLD, 25));
                        progressBar.setForeground(new Color(180,180,255));
                        progressBar.setBackground(Color.BLACK);
                        progressBar.setString("0B / 2KB");
                        p1a.add(progressBar);
                        //End ProgressBar.
                    p1.add(p1a);
                    p1b = new JPanel();
                    p1b.setLayout(new GridLayout(2,1,10,10));
                    p1b.setBackground(Color.BLACK);
                        //ColorChoosers:
                        colorChooserButton1 = new JButton(comentarios[8]);
                        colorChooserButton1.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                colorChooser1();
                            }
                        });
                        p1b.add(colorChooserButton1);
                        colorChooserButton2 = new JButton(comentarios[9]);
                        colorChooserButton2.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                colorChooser2();
                            }
                        });
                        p1b.add(colorChooserButton2);
                        //End ColorChoosers.
                    p1.add(p1b);
                    p1c = new JPanel();
                    p1c.setLayout(new GridLayout(2,1,10,10));
                    p1c.setBackground(Color.BLACK);
                        //Buttons:
                        load = new JButton(comentarios[10]);
                        load.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                load();
                            }
                        });
                        p1c.add(load);
                        save = new JButton(comentarios[11]);
                        save.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                save();
                            }
                        });
                        p1c.add(save);
                        //End Buttons.
                    p1.add(p1c);
                    p1d = new JPanel();
                    p1d.setBackground(Color.BLACK);
                        //List:
                        list = new JList<>(marcas);
                        list.setSelectedValue(marcas[0], true);
                        list.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        list.setForeground(Color.WHITE);
                        list.setBackground(Color.BLACK);
                        p1d.add(list);
                        //End List.
                    p1.add(p1d);
                    //End Panels Interior.
                p2 = new JPanel();
                p2.setPreferredSize(new Dimension(380,700));
                p2.setBackground(Color.BLACK);
                    //TextArea:
                    textArea = new JTextArea();
                    textArea.setText("");
                    textArea.setFont(new Font("Arial", Font.PLAIN, 20));
                    textArea.setForeground(Color.BLACK);
                        //ScrollPanes:
                        scroll = new JScrollPane(textArea);
                        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                        scroll.setPreferredSize(new Dimension(380,635));
                        p2.add(scroll);
                        //End ScrollPanes.
                    //End TextArea.
                p3 = new JPanel();
                p3.setPreferredSize(new Dimension(200,500));
                p3.setLayout(new GridLayout(3,1,10,10));
                p3.setBackground(Color.BLACK);
                    //Panels interiores:
                    p3a = new JPanel();
                    p3a.setBackground(Color.BLACK);
                    p3a.setLayout(new GridLayout(2,1,5,5));
                        //Panels subInteriores:
                        p3aa = new JPanel();
                        p3aa.setBackground(Color.BLACK);
                        p3aa.setLayout(new FlowLayout(5));    
                            //RadioButtons:
                            grupoTipoLetra = new ButtonGroup();
                            plain = new JRadioButton(comentarios[12]);
                            plain.setSelected(true);
                            plain.setBackground(Color.BLACK);
                            plain.setForeground(Color.WHITE);
                            bold = new JRadioButton(comentarios[13]);
                            bold.setBackground(Color.BLACK);
                            bold.setForeground(Color.WHITE);
                            italic = new JRadioButton(comentarios[14]);
                            italic.setBackground(Color.BLACK);
                            italic.setForeground(Color.WHITE);
                            grupoTipoLetra.add(plain);
                            grupoTipoLetra.add(bold);
                            grupoTipoLetra.add(italic);
                            p3aa.add(plain);
                            p3aa.add(bold);
                            p3aa.add(italic);
                            ////////////////////////////////////////////////////////////////////////
                            grupoFormaLetra = new ButtonGroup();
                            times = new JRadioButton("T.N.R.");
                            times.setBackground(Color.BLACK);
                            times.setForeground(Color.WHITE);
                            arial = new JRadioButton("Arial");
                            arial.setSelected(true);
                            arial.setBackground(Color.BLACK);
                            arial.setForeground(Color.WHITE);
                            mvboli = new JRadioButton("MV Boli");
                            mvboli.setBackground(Color.BLACK);
                            mvboli.setForeground(Color.WHITE);
                            grupoFormaLetra.add(times);
                            grupoFormaLetra.add(arial);
                            grupoFormaLetra.add(mvboli);
                            p3aa.add(times);
                            p3aa.add(arial);
                            p3aa.add(mvboli);
                            //End RadioButtons.
                        p3a.add(p3aa);

                        p3ab = new JPanel();
                        p3ab.setBackground(Color.BLACK);
                        p3ab.setLayout(new FlowLayout());
                            //Slider:
                            slider = new JSlider(5, 55, 20);
                            slider.setBackground(Color.BLACK);
                            slider.setForeground(Color.WHITE);
                            slider.setPaintTicks(true);
                            slider.setMinorTickSpacing(10);
                            slider.setPaintTrack(true);
                            slider.setMajorTickSpacing(25);
                            slider.setPaintLabels(true);
                            slider.addChangeListener(new ChangeListener() {
                                public void stateChanged(ChangeEvent e) {
                                    slider();
                                }
                            });
                            p3ab.add(slider);
                            //End Slider.
                        p3a.add(p3ab);
                        //End Paneles subInteriores.
                    p3.add(p3a);
                    p3b = new JPanel();
                    p3b.setBackground(Color.BLACK);
                    p3b.setLayout(new GridLayout(3,1,5,5));
                        //Buttons:
                        borrar = new JButton(comentarios[15]);
                        borrar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                borrar();
                            }
                        });
                        p3b.add(borrar);
                        aplicar = new JButton(comentarios[16]);
                        aplicar.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                aplicar();
                            }
                        });                  
                        p3b.add(aplicar);
                        titulo = new JButton(comentarios[17]);
                        titulo.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                setTitle();
                            }
                        });
                        p3b.add(titulo);
                        //End Buttons.
                    p3.add(p3b);
                    p3c = new JPanel();
                    p3c.setBackground(Color.BLACK);
                    p3c.setLayout(new GridLayout(3,1,5,5));
                        //Labels:
                        l1 = new JLabel(comentarios[18]);
                        l1.setOpaque(true);
                        l1.setFont(new Font("Arial", Font.BOLD, 20));
                        l1.setHorizontalAlignment(JLabel.CENTER);
                        l1.setBackground(Color.BLACK);
                        l1.setForeground(Color.WHITE);
                        p3c.add(l1);
                        l2 = new JLabel(comentarios[19] + numE);
                        l2.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
                        l2.setBackground(Color.BLACK);
                        l2.setForeground(Color.WHITE);
                        l2.setOpaque(true);
                        p3c.add(l2);
                        l3 = new JLabel(comentarios[20] + numL);
                        l3.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
                        l3.setBackground(Color.BLACK);
                        l3.setForeground(Color.WHITE);
                        l3.setOpaque(true);
                        p3c.add(l3);
                        //End Labels.
                    p3.add(p3c);
                    //End Panels interiores.
                p4 = new JPanel();
                p4.setBackground(Color.BLACK);
                p4.setLayout(new FlowLayout(10));
                    //Label:
                    consola = new JTextField();
                    consola.setPreferredSize(new Dimension(800,50));
                    consola.setHorizontalAlignment(JTextField.CENTER);
                    consola.setFont(new Font("Times New Roman", Font.BOLD, 20));
                    consola.setBackground(Color.WHITE);
                    consola.setForeground(Color.BLACK);
                    consola.setEditable(false);
                    p4.add(consola);
                    //End Label.
                back.add(p1, BorderLayout.WEST);
                back.add(p2, BorderLayout.CENTER);
                back.add(p3, BorderLayout.EAST);
                back.add(p4, BorderLayout.SOUTH);
                //End Panels.
            absoluteBack.add(back, BorderLayout.CENTER);        
            //End Back.       
        this.add(absoluteBack);
        //End AbsoluteBack.
        
        this.pack();
        this.setVisible(true);
    }
    private void selectorDeLetra(){
        String[] comentarios = null;
        if (idioma == 0) comentarios = Esp.COMENTARIOS_LETRA;  
        else comentarios = Eng.COMENTARIOS_LETRA;
        if(plain.isSelected() && times.isSelected()) {
            textArea.setFont(new Font("Times New Roman", Font.PLAIN, tamLetra));
            consola.setText(comentarios[0]+tamLetra+"...");
        }
        if(plain.isSelected() && arial.isSelected()){
            textArea.setFont(new Font("Arial", Font.PLAIN, tamLetra));
            consola.setText(comentarios[1]+tamLetra+"...");
        }
        if(plain.isSelected() && mvboli.isSelected()){
            textArea.setFont(new Font("MV Boli", Font.PLAIN, tamLetra));
            consola.setText(comentarios[2]+tamLetra+"...");
        }
        if(bold.isSelected() && times.isSelected()) {
            textArea.setFont(new Font("Times New Roman", Font.BOLD, tamLetra));
            consola.setText(comentarios[3]+tamLetra+"...");
        }
        if(bold.isSelected() && arial.isSelected()){
            textArea.setFont(new Font("Arial", Font.BOLD, tamLetra));
            consola.setText(comentarios[4]+tamLetra+"...");
        }
        if(bold.isSelected() && mvboli.isSelected()){
            textArea.setFont(new Font("MV Boli", Font.BOLD, tamLetra));
            consola.setText(comentarios[5]+tamLetra+"...");
        }
        if(italic.isSelected() && times.isSelected()) {
            textArea.setFont(new Font("Times New Roman", Font.ITALIC, tamLetra));
            consola.setText(comentarios[6]+tamLetra+"...");
        }
        if(italic.isSelected() && arial.isSelected()){
            textArea.setFont(new Font("Arial", Font.ITALIC, tamLetra));
            consola.setText(comentarios[7]+tamLetra+"...");
        }
        if(italic.isSelected() && mvboli.isSelected()){
            textArea.setFont(new Font("MV Boli", Font.ITALIC, tamLetra));
            consola.setText(comentarios[8]+tamLetra+"...");
        }
    }
    private void recuento(){
        String[] comentarios = null;
        if (idioma == 0) comentarios = Esp.COMENTARIOS_RECUENTO;  
        else comentarios = Eng.COMENTARIOS_RECUENTO;
        numL = contadorLetras();
        numE  = contadorEspacios();
        numT = numL + numE;
        l3.setText(comentarios[0] + numL);
        l2.setText(comentarios[1] + numE);
    }
    private void actualizarProgressBar(){
        String comentario = null;
        if (idioma == 0) comentario = Esp.COMENTARIO_PROGRESSBAR;  
        else comentario = Eng.COMENTARIO_PROGRESSBAR;
        if(numT >= 2000){
            progressBar.setValue(2000);
            progressBar.setString(comentario);
            textArea.setEnabled(false);
        }else{
            progressBar.setValue(numT);
            progressBar.setString(numT + "B / 2KB");
        }
    }
    private int contadorEspacios(){
        String cadena = textArea.getText();
        int numE_temp = 0;
        for(int i = 0; i < cadena.length(); i++) if(cadena.charAt(i) == ' ') numE_temp++;
        return numE_temp;
    }
    private int contadorLetras(){
        String cadena = textArea.getText();
        int numP_temp = 0;
        for(int i = 0; i < cadena.length(); i++) if(cadena.charAt(i) != ' ') numP_temp++;
        return numP_temp;
    }
    private void colorChooser1(){
        String comentario = null;
        if (idioma == 0) comentario = Esp.COMENTARIO_COLORCHOOSER1;  
        else comentario = Eng.COMENTARIO_COLORCHOOSER1;
        Color color = JColorChooser.showDialog(null, comentario, Color.WHITE);
        textArea.setBackground(color);
        consola.setBackground(color);
    }
    private void colorChooser2(){
        String comentario = null;
        if (idioma == 0) comentario = Esp.COMENTARIO_COLORCHOOSER2;  
        else comentario = Eng.COMENTARIO_COLORCHOOSER2;
        Color color = JColorChooser.showDialog(null, comentario, Color.BLACK);
        textArea.setForeground(color);
        consola.setForeground(color);
    }
    private void fileChooser1() throws IOException{
        String comentario1 = null, comentario2 = null, comentario3 = null;
        if (idioma == 0){
            comentario1 = Esp.COMENTARIO_FILECHOOSER1;
            comentario2 = Esp.COMENTARIO_FILECHOOSER2;
            comentario3 = Esp.COMENTARIO_FILECHOOSER3;
        }
        else {
            comentario1 = Eng.COMENTARIO_FILECHOOSER1;
            comentario2 = Eng.COMENTARIO_FILECHOOSER2;  
            comentario3 = Eng.COMENTARIO_FILECHOOSER3;
        }
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            String path = chooser.getSelectedFile().getAbsolutePath();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(comentario3);
            int i = 1;
            for(String s : textos) bw.append(hojaAString(s, (i++)));
            bw.close();
            consola.setText(comentario1+path);
        }else{
            JOptionPane.showMessageDialog(null, "ERROR", comentario2, JOptionPane.WARNING_MESSAGE); 
        }
    }
    private String hojaAString(String s, int i){
        StringBuilder sb = new StringBuilder("--->>>Hoja "+i+":\n\n");
        sb.append("#################################################\n");
        sb.append(s).append("\n");
        sb.append("#################################################\n");
        sb.append("\n--->>>Fin Hoja "+i+".\n\n\n");
        return sb.toString();
    }
    private void load(){
        String[] comentarios = null;
        String[] lista = null;
        if (idioma == 0) {
            comentarios = Esp.COMENTARIOS_LOAD;
            lista = Esp.MARCAS;  
        }else{
            comentarios = Eng.COMENTARIOS_LOAD;
            lista = Eng.MARCAS;
        }
        if(list.getSelectedValue() == lista[0]){
            textArea.setText("");
            if(!(textos[0] == null || textos[0] == "")){
                consola.setText(comentarios[0] + textos[0]);
                textArea.setText(textos[0]);
            }
        }else if(list.getSelectedValue() == lista[1]){
            textArea.setText("");
            if(!(textos[1] == null || textos[1] == "")){
                consola.setText(comentarios[1] + textos[1]);
                textArea.setText(textos[1]);
            }
        }else if(list.getSelectedValue() == lista[2]){
            textArea.setText("");
            if(!(textos[2] == null || textos[2] == "")){
                consola.setText(comentarios[2] + textos[2]);
                textArea.setText(textos[2]);
            }
        }else if(list.getSelectedValue() == lista[3]){
            textArea.setText("");
            if(!(textos[3] == null || textos[3] == "")){
                consola.setText(comentarios[3] + textos[3]);
                textArea.setText(textos[3]);
            }
        }else consola.setText(comentarios[4]);

    }
    private void save(){
        String[] comentarios = null;
        String[] lista = null;
        if (idioma == 0) {
            comentarios = Esp.COMENTARIOS_SAVE;
            lista = Esp.MARCAS;  
        }else{
            comentarios = Eng.COMENTARIOS_SAVE;
            lista = Eng.MARCAS;
        }
        if(list.getSelectedValue() == lista[0]){
            textos[0] = textArea.getText();
            if(!(textos[0] == null || textos[0] == "")) consola.setText(comentarios[0] + textos[0]);
        }else if(list.getSelectedValue() == lista[1]){
            textos[1] = textArea.getText();
            if(!(textos[1] == null || textos[1] == "")) consola.setText(comentarios[1] + textos[1]);
        }else if(list.getSelectedValue() == lista[2]){
            textos[2] = textArea.getText();
            if(!(textos[2] == null || textos[2] == "")) consola.setText(comentarios[2] + textos[2]);
        }else if(list.getSelectedValue() == lista[3]){
            textos[3] = textArea.getText();
            if(!(textos[3] == null || textos[3] == "")) consola.setText(comentarios[3] + textos[3]);
        }else consola.setText(comentarios[4]);
    }
    private void borrar() {
        String comentario = null;
        if (idioma == 0) comentario = Esp.COMENTARIO_BORRAR; 
        else comentario = Eng.COMENTARIO_BORRAR;
        numE = 0;
        numL = 0;
        numT = 0;
        textArea.setText("");
        progressBar.setValue(0);
        textArea.setEnabled(true);
        progressBar.setString(numT + "B / 2KB");
        consola.setText(comentario);
    }
    private void slider(){
        String comentario = null;
        if (idioma == 0) comentario = Esp.COMENTARIO_SLIDER; 
        else comentario = Eng.COMENTARIO_SLIDER;
        tamLetra = slider.getValue();
        consola.setText(comentario + tamLetra + "...");
    }
    private void setEspañol(){
        idioma = 0;
        setTexts();
    }
    private void setEnglish(){
        idioma = 1;
        setTexts();
    }
    private void setTexts(){
        String[] comentarios = null;
        String[] marcas = null;
        if(idioma == 0){
            comentarios = Esp.COMENTARIOS_VISTA;
            marcas = Esp.MARCAS;
        }else{
            comentarios = Eng.COMENTARIOS_VISTA;
            marcas = Eng.MARCAS;
        }
        mensajeInfo = comentarios[22];
        file.setText(comentarios[0]);
        help.setText(comentarios[1]);
        languages.setText(comentarios[2]);
        exit.setText(comentarios[3]);
        guardar.setText(comentarios[21]);
        info.setText(comentarios[4]);
        esp.setText(comentarios[5]);
        eng.setText(comentarios[6]);
        lp.setText(comentarios[7]);
        colorChooserButton1.setText(comentarios[8]);
        colorChooserButton2.setText(comentarios[9]);
        load.setText(comentarios[10]);
        save.setText(comentarios[11]);
        list.setListData(marcas);
        plain.setText(comentarios[12]);
        bold.setText(comentarios[13]);
        italic.setText(comentarios[14]);
        borrar.setText(comentarios[15]);
        aplicar.setText(comentarios[16]);
        titulo.setText(comentarios[17]);
        l1.setText(comentarios[18]);
        l2.setText(comentarios[19] + numE);
        l3.setText(comentarios[20] + numL);
    }
    private void setTitle(){
        setTitle(textArea.getText());
        String comentario = null;
        if(idioma == 0) comentario = Esp.COMENTARIO_TITULO;
        else comentario = Eng.COMENTARIO_TITULO;
        consola.setText(comentario + textArea.getText());
    }
    private void aplicar(){
        selectorDeLetra();
        recuento();
        actualizarProgressBar();
    }
    //End Metodos Privados.
}
