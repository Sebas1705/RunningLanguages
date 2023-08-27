package com.sebss.Gui;

import javax.swing.*;
import javax.swing.event.*;

import com.sebss.Languages.Esp;
import com.sebss.Languages.Eng;

import java.awt.*;
import java.awt.event.*;

public class EditorFrame extends JFrame{

    public static void main(String[] args) {
        new EditorFrame();
    }

    //Variables:
    private int sizeX = 810;
    private int sizeY = 710;
    private int sizeChar = 20;
    private int numL,numE,numT;
    private int language = 0;
    private String[] texts = new String[4];
    //End Variables.

    //Components:
    //Dimensions:
    private Dimension screenSize;
    //MenuBar:
    private JMenuBar menuBar;
    private JMenu file, help, languages;
    private JMenuItem exit, info, esp, eng;
    //Panels:
    private JPanel absoluteBack, back, p1, p1a, p1b, p1c, p1d, p2, p3, p3a, p3aa, p3ab, p3b, p3c, p4;
    //Labels:
    private JLabel l1,l2,l3,lp;
    //TextArea:
    private JTextArea textArea;
    //TextField:
    private JTextField console;
    //ScrollPane:
    private JScrollPane scroll;
    //ButtonGroups:
    private ButtonGroup groupeTypeChar, groupeFormChar;
    //RadioButtons:
    private JRadioButton plain, bold, italic, times, arial, mvboli;
    //Slider:
    private JSlider slider;
    //Buttons:
    private JButton delete, set, title, colorChooserButton1, colorChooserButton2, save, load;
    //ProgressBar:
    private JProgressBar progressBar;
    //List:
    private JList<String> list;
    //End Components.
    
    //Constructor:
    public EditorFrame(){
        initComponents();
    }
    //End Constructor.

    //Private Methods:
    private void initComponents(){
        String[] comments = null;
        String[] marcs = null;
        if(language == 0){
            comments = Esp.COMMENTS_VIEW;
            marcs = Esp.PAGES;
        }else{
            comments = Eng.COMMENTS_VIEW;
            marcs = Eng.PAGES;
        }
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((screenSize.width/2)-(sizeX/2) , (screenSize.height/2)-(sizeY/2));
        this.setTitle("MINI-EDITOR");
        this.setResizable(false);
        
        //MenuBar:
        menuBar = new JMenuBar();
            //Menus:
            file = new JMenu(comments[0]);
            help = new JMenu(comments[1]);
            languages = new JMenu(comments[2]);
                //Items:
                exit = new JMenuItem(comments[3]);
                exit.addActionListener(e -> System.exit(0));
                info = new JMenuItem(comments[4]);
                info.addActionListener(e -> JOptionPane.showMessageDialog(null, "Little text editor.","Info:", JOptionPane.INFORMATION_MESSAGE));
                esp = new JMenuItem(comments[5]);
                esp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        setEspañol();
                    }
                });
                eng = new JMenuItem(comments[6]);
                eng.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        setEnglish();
                    }
                });
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
        absoluteBack.setPreferredSize(new Dimension(sizeX,sizeY));
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
                        lp = new JLabel(comments[7]);
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
                        colorChooserButton1 = new JButton(comments[8]);
                        colorChooserButton1.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                colorChooser1();
                            }
                        });
                        p1b.add(colorChooserButton1);
                        colorChooserButton2 = new JButton(comments[9]);
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
                        load = new JButton(comments[10]);
                        load.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                load();
                            }
                        });
                        p1c.add(load);
                        save = new JButton(comments[11]);
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
                        list = new JList<>(marcs);
                        list.setSelectedValue(marcs[0], true);
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
                            groupeTypeChar = new ButtonGroup();
                            plain = new JRadioButton(comments[12]);
                            plain.setSelected(true);
                            plain.setBackground(Color.BLACK);
                            plain.setForeground(Color.WHITE);
                            bold = new JRadioButton(comments[13]);
                            bold.setBackground(Color.BLACK);
                            bold.setForeground(Color.WHITE);
                            italic = new JRadioButton(comments[14]);
                            italic.setBackground(Color.BLACK);
                            italic.setForeground(Color.WHITE);
                            groupeTypeChar.add(plain);
                            groupeTypeChar.add(bold);
                            groupeTypeChar.add(italic);
                            p3aa.add(plain);
                            p3aa.add(bold);
                            p3aa.add(italic);
                            ////////////////////////////////////////////////////////////////////////
                            groupeFormChar = new ButtonGroup();
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
                            groupeFormChar.add(times);
                            groupeFormChar.add(arial);
                            groupeFormChar.add(mvboli);
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
                        delete = new JButton(comments[15]);
                        delete.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                delete();
                            }
                        });
                        p3b.add(delete);
                        set = new JButton(comments[16]);
                        set.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                set();
                            }
                        });                  
                        p3b.add(set);
                        title = new JButton(comments[17]);
                        title.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                setTitle();
                            }
                        });
                        p3b.add(title);
                        //End Buttons.
                    p3.add(p3b);
                    p3c = new JPanel();
                    p3c.setBackground(Color.BLACK);
                    p3c.setLayout(new GridLayout(3,1,5,5));
                        //Labels:
                        l1 = new JLabel(comments[18]);
                        l1.setOpaque(true);
                        l1.setFont(new Font("Arial", Font.BOLD, 20));
                        l1.setHorizontalAlignment(JLabel.CENTER);
                        l1.setBackground(Color.BLACK);
                        l1.setForeground(Color.WHITE);
                        p3c.add(l1);
                        l2 = new JLabel(comments[19] + numE);
                        l2.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
                        l2.setBackground(Color.BLACK);
                        l2.setForeground(Color.WHITE);
                        l2.setOpaque(true);
                        p3c.add(l2);
                        l3 = new JLabel(comments[20] + numL);
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
                    console = new JTextField();
                    console.setPreferredSize(new Dimension(800,50));
                    console.setHorizontalAlignment(JTextField.CENTER);
                    console.setFont(new Font("Times New Roman", Font.BOLD, 20));
                    console.setBackground(Color.WHITE);
                    console.setForeground(Color.BLACK);
                    console.setEditable(false);
                    p4.add(console);
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
    private void charSelector(){
        String[] comments = null;
        if (language == 0) comments = Esp.COMMENTS_CHAR;  
        else comments = Eng.COMMENTS_CHAR;
        if(plain.isSelected() && times.isSelected()) {
            textArea.setFont(new Font("Times New Roman", Font.PLAIN, sizeChar));
            console.setText(comments[0]+sizeChar+"...");
        }
        if(plain.isSelected() && arial.isSelected()){
            textArea.setFont(new Font("Arial", Font.PLAIN, sizeChar));
            console.setText(comments[1]+sizeChar+"...");
        }
        if(plain.isSelected() && mvboli.isSelected()){
            textArea.setFont(new Font("MV Boli", Font.PLAIN, sizeChar));
            console.setText(comments[2]+sizeChar+"...");
        }
        if(bold.isSelected() && times.isSelected()) {
            textArea.setFont(new Font("Times New Roman", Font.BOLD, sizeChar));
            console.setText(comments[3]+sizeChar+"...");
        }
        if(bold.isSelected() && arial.isSelected()){
            textArea.setFont(new Font("Arial", Font.BOLD, sizeChar));
            console.setText(comments[4]+sizeChar+"...");
        }
        if(bold.isSelected() && mvboli.isSelected()){
            textArea.setFont(new Font("MV Boli", Font.BOLD, sizeChar));
            console.setText(comments[5]+sizeChar+"...");
        }
        if(italic.isSelected() && times.isSelected()) {
            textArea.setFont(new Font("Times New Roman", Font.ITALIC, sizeChar));
            console.setText(comments[6]+sizeChar+"...");
        }
        if(italic.isSelected() && arial.isSelected()){
            textArea.setFont(new Font("Arial", Font.ITALIC, sizeChar));
            console.setText(comments[7]+sizeChar+"...");
        }
        if(italic.isSelected() && mvboli.isSelected()){
            textArea.setFont(new Font("MV Boli", Font.ITALIC, sizeChar));
            console.setText(comments[8]+sizeChar+"...");
        }
    }
    private void count(){
        String[] comments = null;
        if (language == 0) comments = Esp.COMMENTS_COUNT;  
        else comments = Eng.COMMENTS_COUNT;
        numL = countChars();
        numE  = countSpaces();
        numT = numL + numE;
        l3.setText(comments[0] + numL);
        l2.setText(comments[1] + numE);
    }
    private void setProgressBar(){
        String comment = null;
        if (language == 0) comment = Esp.COMMENT_PROGRESS_BAR;  
        else comment = Eng.COMMENT_PROGRESS_BAR;
        if(numT >= 2000){
            progressBar.setValue(2000);
            progressBar.setString(comment);
            textArea.setEnabled(false);
        }else{
            progressBar.setValue(numT);
            progressBar.setString(numT + "B / 2KB");
        }
    }
    private int countSpaces(){
        String cadena = textArea.getText();
        int numE_temp = 0;
        for(int i = 0; i < cadena.length(); i++) if(cadena.charAt(i) == ' ') numE_temp++;
        return numE_temp;
    }
    private int countChars(){
        String cadena = textArea.getText();
        int numP_temp = 0;
        for(int i = 0; i < cadena.length(); i++) if(cadena.charAt(i) != ' ') numP_temp++;
        return numP_temp;
    }
    private void colorChooser1(){
        String comment = null;
        if (language == 0) comment = Esp.COMMENT_COLOR_CHOOSER1;  
        else comment = Eng.COMMENT_COLOR_CHOOSER1;
        Color color = JColorChooser.showDialog(null, comment, Color.WHITE);
        textArea.setBackground(color);
        console.setBackground(color);
    }
    private void colorChooser2(){
        String comment = null;
        if (language == 0) comment = Esp.COMMENT_COLOR_CHOOSER2;  
        else comment = Eng.COMMENT_COLOR_CHOOSER2;
        Color color = JColorChooser.showDialog(null, comment, Color.BLACK);
        textArea.setForeground(color);
        console.setForeground(color);
    }
    private void load(){
        String[] comments = null;
        String[] listPages = null;
        if (language == 0) {
            comments = Esp.COMMENTS_LOAD;
            listPages = Esp.PAGES;  
        }else{
            comments = Eng.COMMENTS_LOAD;
            listPages = Eng.PAGES;
        }
        if(list.getSelectedValue() == listPages[0]){
            textArea.setText("");
            if(!(texts[0] == null || texts[0] == "")){
                console.setText(comments[0] + texts[0]);
                textArea.setText(texts[0]);
            }
        }else if(list.getSelectedValue() == listPages[1]){
            textArea.setText("");
            if(!(texts[1] == null || texts[1] == "")){
                console.setText(comments[1] + texts[1]);
                textArea.setText(texts[1]);
            }
        }else if(list.getSelectedValue() == listPages[2]){
            textArea.setText("");
            if(!(texts[2] == null || texts[2] == "")){
                console.setText(comments[2] + texts[2]);
                textArea.setText(texts[2]);
            }
        }else if(list.getSelectedValue() == listPages[3]){
            textArea.setText("");
            if(!(texts[3] == null || texts[3] == "")){
                console.setText(comments[3] + texts[3]);
                textArea.setText(texts[3]);
            }
        }else console.setText(comments[4]);

    }
    private void save(){
        String[] comments = null;
        String[] listPages = null;
        if (language == 0) {
            comments = Esp.COMMENTS_SAVE;
            listPages = Esp.PAGES;  
        }else{
            comments = Eng.COMMENTS_SAVE;
            listPages = Eng.PAGES;
        }
        if(list.getSelectedValue() == listPages[0]){
            texts[0] = textArea.getText();
            if(!(texts[0] == null || texts[0] == "")) console.setText(comments[0] + texts[0]);
        }else if(list.getSelectedValue() == listPages[1]){
            texts[1] = textArea.getText();
            if(!(texts[1] == null || texts[1] == "")) console.setText(comments[1] + texts[1]);
        }else if(list.getSelectedValue() == listPages[2]){
            texts[2] = textArea.getText();
            if(!(texts[2] == null || texts[2] == "")) console.setText(comments[2] + texts[2]);
        }else if(list.getSelectedValue() == listPages[3]){
            texts[3] = textArea.getText();
            if(!(texts[3] == null || texts[3] == "")) console.setText(comments[3] + texts[3]);
        }else console.setText(comments[4]);
    }
    private void delete() {
        String comment = null;
        if (language == 0) comment = Esp.COMMENT_DELETE; 
        else comment = Eng.COMMENT_DELETE;
        numE = 0;
        numL = 0;
        numT = 0;
        textArea.setText("");
        progressBar.setValue(0);
        textArea.setEnabled(true);
        progressBar.setString(numT + "B / 2KB");
        console.setText(comment);
    }
    private void slider(){
        String comment = null;
        if (language == 0) comment = Esp.COMMENT_SLIDER; 
        else comment = Eng.COMMENT_SLIDER;
        sizeChar = slider.getValue();
        console.setText(comment + sizeChar + "...");
    }
    private void setEspañol(){
        language = 0;
        setTexts();
    }
    private void setEnglish(){
        language = 1;
        setTexts();
    }
    private void setTexts(){
        String[] comments = null;
        String[] marcs = null;
        if(language == 0){
            comments = Esp.COMMENTS_VIEW;
            marcs = Esp.PAGES;
        }else{
            comments = Eng.COMMENTS_VIEW;
            marcs = Eng.PAGES;
        }
        file.setText(comments[0]);
        help.setText(comments[1]);
        languages.setText(comments[2]);
        exit.setText(comments[3]);
        info.setText(comments[4]);
        esp.setText(comments[5]);
        eng.setText(comments[6]);
        lp.setText(comments[7]);
        colorChooserButton1.setText(comments[8]);
        colorChooserButton2.setText(comments[9]);
        load.setText(comments[10]);
        save.setText(comments[11]);
        list.setListData(marcs);
        plain.setText(comments[12]);
        bold.setText(comments[13]);
        italic.setText(comments[14]);
        delete.setText(comments[15]);
        set.setText(comments[16]);
        title.setText(comments[17]);
        l1.setText(comments[18]);
        l2.setText(comments[19] + numE);
        l3.setText(comments[20] + numL);
    }
    private void setTitle(){
        setTitle(textArea.getText());
        String comment = null;
        if(language == 0) comment = Esp.COMMENT_TITLE;
        else comment = Eng.COMMENT_TITLE;
        console.setText(comment + textArea.getText());
    }
    private void set(){
        charSelector();
        count();
        setProgressBar();
    }
    //End Private Methods.
}
