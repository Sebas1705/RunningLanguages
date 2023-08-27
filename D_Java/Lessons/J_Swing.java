import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

import java.awt.*;
import java.awt.geom.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.*;

public class J_Swing {
    
    public static void main(String[] args) {
        new SpringExample();
    }

    //JFrame:
    static class MyFrame extends JFrame{

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dm = tk.getScreenSize();

        public MyFrame() {
            // setSize(500,500);
            // setLocation(400,400);
            int x = dm.width, y = dm.height;
            setBounds(x/4, y/4, x/2, y/2);

            //Add components:
            add(new MyPanel(0,0,x/2,y/2));

            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//EXIT_ON_CLOSE|DO_NOTHING_ON_CLOSE|HIDE_ON_CLOSE|DISPOSE_ON_CLOSE
            //setIconImage(new ImageIcon("iconPath").getImage());
            setTitle("MyFrame");         
            setResizable(false);
            setExtendedState(Frame.NORMAL);//NORMAL|MAXIMIZED_BOTH|MAXIMIZED_VERT|MAXIMIZED_HORIZ|ICONIFIED

            //Frame events:

            addWindowListener(new WindowListener(){
                public void windowOpened(WindowEvent e) {System.out.println("Windows open");}
                public void windowClosing(WindowEvent e) {System.out.println("Windows closing");}
                public void windowClosed(WindowEvent e) {System.out.println("Windows close");}
                public void windowIconified(WindowEvent e) {System.out.println("Windows minimized");}
                public void windowDeiconified(WindowEvent e) {System.out.println("Windows de-minimized");}
                public void windowActivated(WindowEvent e) {System.out.println("Windows activated");}
                public void windowDeactivated(WindowEvent e) {System.out.println("Windows deactivated");}
            });

            addWindowStateListener(new WindowStateListener() {
                public void windowStateChanged(WindowEvent e) {
                    System.out.println("Windows change state to: "+e.getNewState());
                }
            });

            addKeyListener(new KeyListener() {
                public void keyPressed(KeyEvent e) {System.out.println("Pressed: "+e.getKeyCode()+": "+e.getKeyChar());}
                public void keyReleased(KeyEvent e) {System.out.println("Unpressed: "+e.getKeyCode()+": "+e.getKeyChar());}
                public void keyTyped(KeyEvent e) {System.out.println("Typed: "+e.getKeyCode()+": "+e.getKeyChar());}
            });

            addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {System.out.println("Mouse Clicked");}
                public void mousePressed(MouseEvent e) {System.out.println("Mouse Pressed");}
                public void mouseReleased(MouseEvent e) {System.out.println("Mouse Released");}
                public void mouseEntered(MouseEvent e) {System.out.println("Mouse Entered");}
                public void mouseExited(MouseEvent e) {System.out.println("Mouse Exited");}
            });
        }
    }

    //JPanel print example:
    static class MyPanel extends JPanel{

        private int width, height;
        private final String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        private Toolkit tk = Toolkit.getDefaultToolkit();
        private String imageSrc="E:\\Escritorio\\Programacion\\RunningLanguages\\D_Java\\Lessons\\src\\img\\image.jpeg";
        
        public MyPanel(int x, int y, int width, int height){
            this.width=width;this.height=height;
            setBounds(x, y, width, height);
            setVisible(true);
            setBackground(Color.CYAN); //SystemColor.window : OS color
        }
        //Paint function
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            //Commands graphics:
                g.drawString("Swing learning", width/2, height/2);
                g.drawRect(0, 0, 100, 100);
                g.drawLine(0,0,width,height);
                g.drawArc(0,0,width/2,height/2,100,350);
            //End commands graphics.

            //Commands graphics2d:
                Graphics2D g2 = (Graphics2D) g;

                //Rect
                Rectangle2D rect = new Rectangle2D.Double(100, 200, 300, 100);
                g2.setPaint(new Color(255,0,123));
                g2.draw(rect);

                //Ellipse:
                Ellipse2D ellipse = new Ellipse2D.Double();
                ellipse.setFrame(rect);
                g2.setPaint(new Color(0,0,255));
                g2.fill(ellipse);

                //Circle
                Ellipse2D circle = new Ellipse2D.Double();
                circle.setFrameFromCenter(rect.getCenterX(), rect.getCenterY(), rect.getCenterX()+rect.getWidth()/2, rect.getCenterY()+rect.getWidth()/2);
                g2.setPaint(Color.GREEN);
                g2.draw(circle);

                //Line:
                g2.setPaint(Color.MAGENTA);
                g2.draw(new Line2D.Double(100,100, 200,400));

                //String:
                g2.setColor(Color.yellow);
                g2.setFont(new Font(fonts[6], Font.BOLD, 26));
                g2.drawString("String g2", 600, 300);

                //Image:
                g2.drawImage(tk.getImage(imageSrc), 600, 0, null);

                //Copy sector:
                g2.copyArea(0, 0, 300, 300, 400, 400);
            //End Commands graphics2d.
        }
    }

    //Button events:
    static class PanelButtons extends JPanel implements ActionListener, FocusListener{
        JButton button1, button2, button3, button4, button5, button6;
        public PanelButtons(int x,int y,int width,int height){
            setBounds(x, y, width, height);
            setVisible(true);
            setBackground(SystemColor.window);

            button1 = new JButton("Blue");
            button1.addFocusListener(this);
            button1.addActionListener(this);
            button1.setFocusable(true);
            add(button1);

            button2 = new JButton("Red");
            button2.addActionListener(this);
            button2.setFocusable(true);
            add(button2);

            button3 = new JButton("Yellow");
            button3.addActionListener(this);
            button3.setFocusable(false); 
            add(button3);
            
            button4 = new JButton("Cyan");
            button4.addActionListener(this); //As the same class with an implemented interface
            button4.setFocusable(false);
            add(button4);

            button5 = new JButton("Magenta");
            button5.addActionListener(new ActionListener() {//As a anonymous function
                @Override
                public void actionPerformed(ActionEvent e){
                    setBackground(Color.MAGENTA);
                }
            });
            button5.setFocusable(false);
            add(button5);

            button6 = new JButton("Pink");
            button6.addActionListener(e->setBackground(Color.PINK));//With lambda as an anonymous function
            button6.setFocusable(false);
            add(button6);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if(o == button1) setBackground(Color.BLUE);
            else if(o == button2) setBackground(Color.RED);
            else if(o == button3) setBackground(Color.YELLOW);
            else setBackground(Color.CYAN); 
        }

        @Override
        public void focusGained(FocusEvent e) {   
            System.out.println("Focus gained button1");
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("Focus lost button1"); 
        }
    }

    //Components:
    static class JButtonExample extends JFrame{
        public JButtonExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JButton");
            
            JButton btn = new JButton("Button1");
            btn.setPreferredSize(new Dimension(300,100));
            this.add(btn);
            
            this.pack();
            this.setVisible(true);
        }
    }
    static class JCheckBoxExample extends JFrame{
        public JCheckBoxExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JCheckBox");
            
            JCheckBox btn = new JCheckBox("CheckBox");
            btn.setHorizontalAlignment(JCheckBox.CENTER);
            btn.setPreferredSize(new Dimension(300,100));
            this.add(btn);
            
            this.pack();
            this.setVisible(true);
        }
    }
    static class JColorChooserExample extends JFrame{
        public JColorChooserExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setTitle("JColorChooser");
            JButton b = new JButton("JColorChooser");
            b.setPreferredSize(new Dimension(300,100));
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Color c=JColorChooser.showDialog(b, "JColorChooser", Color.BLACK);
                    System.out.println("Color: "+c.toString());
                }
            });
            this.add(b);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JComboBoxExample extends JFrame{
        public JComboBoxExample() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("JComboBox");
            String[] list = {"object1", "object2", "object3", "object4", "object5"};
            JComboBox<String> comboBox = new JComboBox<String>(list);
            comboBox.setPreferredSize(new Dimension(300,100));
            this.add(comboBox);
            this.pack();
            this.setVisible(true);
        }    
    }
    static class JFileChooserExample extends JFrame{
        public JFileChooserExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setTitle("JFileChooser");
            JButton b = new JButton("JFileChooser");
            b.setPreferredSize(new Dimension(300,100));
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JFileChooser f = new JFileChooser();
                    f.showOpenDialog(null);
                    File file=f.getSelectedFile();
                    System.out.println("File selected: " + file.getName());
                }
            });
            this.add(b);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JLabelExample extends JFrame{
        public JLabelExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JLabel");
            JLabel label = new JLabel("Hello, world!");
            label.setPreferredSize(new Dimension(300,100));
            label.setHorizontalAlignment(JLabel.CENTER);
            this.add(label);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JListExample extends JFrame{
        public JListExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setTitle("JListExample");
            this.setLocationRelativeTo(null);
            String[] things = {
                "Box", "PC", "Motherboard", "GPU", "CPU", "RAM", "Memory"
            };
            JList<String> list = new JList<String>(things);
            list.setPreferredSize(new Dimension(300,150));
            this.add(list);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JMenuBarExample extends JFrame{
        public JMenuBarExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setTitle("JMenuBarExample");
            this.setSize(300,100);
            JMenuBar menubar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            //File menu:
            JMenuItem loadItem = new JMenuItem("Button");
            JCheckBoxMenuItem saveItem = new JCheckBoxMenuItem("CheckBox");
            JRadioButtonMenuItem exitItem = new JRadioButtonMenuItem("RadioButton");
            fileMenu.add(loadItem);
            fileMenu.add(saveItem);
            fileMenu.add(exitItem);
            //--------------------
            menubar.add(fileMenu);
            this.setJMenuBar(menubar);
            this.setVisible(true);
        }
    }
    static class JPasswordFieldExample extends JFrame{
        public JPasswordFieldExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JPasswordFieldExample");
            JPanel back = new JPanel();
            back.setPreferredSize(new Dimension(400,120));
            JPasswordField txf = new JPasswordField();
            txf.setPreferredSize(new Dimension(300,100));
            back.add(txf);
            this.add(back);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JPopupMenuExample extends JFrame implements MouseListener{
        JPopupMenu popup;
        public JPopupMenuExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setTitle("JPopupMenuExample");
            this.setSize(300,300);
            popup = new JPopupMenu();
            JMenuItem loadItem = new JMenuItem("Button");
            JCheckBoxMenuItem saveItem = new JCheckBoxMenuItem("CheckBox");
            JRadioButtonMenuItem exitItem = new JRadioButtonMenuItem("RadioButton");
            popup.add(loadItem);
            popup.add(saveItem);
            popup.add(exitItem);
            addMouseListener(this);
            add(popup);
            this.setVisible(true);
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.isPopupTrigger()){
                popup.show(this, e.getX(), e.getY());
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.isPopupTrigger()){
                popup.show(this, e.getX(), e.getY());
            }
        }
        @Override
        public void mouseEntered(MouseEvent e) {}
    
        @Override
        public void mouseExited(MouseEvent e) {} 
    }
    static class JProgressBarExample extends JFrame {
        public JProgressBarExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("JProgressBarExample");
            this.setLayout(null);
            this.setSize(460,120);
            this.setVisible(true);
            JProgressBar pb1 = new JProgressBar(0, 500);
            pb1.setValue(50);
            pb1.setBounds(10, 10, 420, 50);
            pb1.setStringPainted(true);
            pb1.setFont(new Font("MV Boli", Font.BOLD, 25));
            pb1.setForeground(Color.RED);
            pb1.setBackground(Color.BLACK);
            this.add(pb1);
        }  
    }
    static class JRadioButtonExample extends JFrame{
        public JRadioButtonExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JRadioButtonExample");
            JRadioButton button = new JRadioButton("RadioButton");
            button.setHorizontalAlignment(JRadioButton.CENTER);
            button.setPreferredSize(new Dimension(300,100));
            this.add(button);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JScrollBarExample extends JFrame{
        public JScrollBarExample() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setTitle("JScrollBarExample");
            this.setResizable(false);
            JScrollBar scroll = new JScrollBar(JScrollBar.HORIZONTAL, 100,0,0,255);
            scroll.setPreferredSize(new Dimension(300,20));
            this.add(scroll);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JSliderExample extends JFrame{
        public JSliderExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.setTitle("JSliderExample");
            JSlider mySlider = new JSlider(0, 100, 50);
            mySlider.setPreferredSize(new Dimension(350,200));
            mySlider.setPaintTicks(true);
            mySlider.setMinorTickSpacing(10);
            mySlider.setPaintTrack(true);
            mySlider.setMajorTickSpacing(25);
            mySlider.setPaintLabels(true);
            this.add(mySlider);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JTableExample extends JFrame{
        public JTableExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JTableExample");
            String data[][]={ {"101","Amit","670000"},{"102","Jai","780000"},{"102","Jai","780000"},
                              {"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},
                              {"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},
                              {"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},
                              {"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},
                              {"102","Jai","780000"},{"102","Jai","780000"},{"102","Jai","780000"},
                              {"102","Jai","780000"},{"101","Sachin","700000"}};    
            String column[]={"ID","NAME","SALARY"};         
            JTable jt=new JTable(data,column);    
            jt.setPreferredSize(new Dimension(400,600));          
            JScrollPane sp=new JScrollPane(jt);    
            add(sp);         
            this.pack();
            this.setVisible(true);
        }
    }
    static class JTextAreaExample extends JFrame{
        public JTextAreaExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("EjemploJTextArea");
            JPanel back = new JPanel();
            back.setPreferredSize(new Dimension(400,220));
            JTextArea txf = new JTextArea();
            txf.setPreferredSize(new Dimension(300,200));
            back.add(txf);
            this.add(back);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JTextFieldExample extends JFrame{
        public JTextFieldExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JTextFieldExample");
            JPanel back = new JPanel();
            back.setPreferredSize(new Dimension(400,120));
            JTextField txf = new JTextField();
            txf.setPreferredSize(new Dimension(300,100));
            back.add(txf);
            this.add(back);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JToolBarExample extends JFrame{
        public JToolBarExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setLayout(new BorderLayout());
            this.setTitle("JToolBarExample");
            this.setSize(800,800);
            JTextArea ta = new JTextArea(); 
            JToolBar toolBar = new JToolBar("ToolBar");
            toolBar.setBackground(Color.BLACK);
            JButton b1 = new JButton("Rojo");
            b1.addActionListener(e -> ta.setBackground(Color.RED));
            JButton b2 = new JButton("Verde");
            b2.addActionListener(e -> ta.setBackground(Color.GREEN));
            JButton b3 = new JButton("Azul");
            b3.addActionListener(e -> ta.setBackground(Color.BLUE));
            toolBar.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
            toolBar.add(b1);
            toolBar.add(b2);
            toolBar.add(b3);
            add(toolBar, BorderLayout.NORTH);
            add(ta, BorderLayout.CENTER);
            this.setVisible(true);
        }
    }
    static class BoxExample extends JFrame{
        public BoxExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("BoxExample");
            this.setSize(350,150);
            this.setLayout(new BorderLayout(10,10));
    
            Box a1 = Box.createHorizontalBox();
            a1.add(new JLabel("Name:"));
            a1.add(Box.createHorizontalStrut(20));
            JTextField t1 = new JTextField(10);
            t1.setMaximumSize(t1.getPreferredSize());
            a1.add(t1);
            Box a2 = Box.createHorizontalBox();
            a2.add(new JLabel("Password:"));
            a2.add(Box.createHorizontalStrut(20));
            JPasswordField t2 = new JPasswordField(10);
            t2.setMaximumSize(t2.getPreferredSize());
            a2.add(t2);
            Box a3 = Box.createHorizontalBox();
            JButton b1 = new JButton("Send");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Data: Name->"+t1.getText()+" y Password->"+String.valueOf(t2.getPassword()));
                }
            });
            a3.add(b1);
            a3.add(Box.createGlue());
            JButton b2 = new JButton("Remove");
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    try {
                        Thread.sleep(2000); 
                        t1.setText("");
                        t2.setText("");
                    } catch (InterruptedException e1) {e1.printStackTrace();}
                }
            });
            a3.add(b2);
            Box a4 = Box.createVerticalBox();
            a4.add(a1); a4.add(a2); a4.add(a3);
            add(a4, BorderLayout.CENTER);
            this.setVisible(true);
        }
    }
    static class SpringExample extends JFrame{    
        public SpringExample(){
            JPanel p;
            JButton b1, b2, b3;
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("SpringExample");
            this.setSize(600,600);
            p = new JPanel();
            p.setBackground(Color.GRAY);
            SpringLayout layout = new SpringLayout();
            p.setLayout(layout);
            b1 = new JButton("b1");
            b2 = new JButton("b2");
            b3 = new JButton("b3");
            p.add(b1);
            p.add(b2);
            p.add(b3);
            //lateral(flexible):
            layout.putConstraint(SpringLayout.WEST, b1, Spring.constant(10, 100, 300), SpringLayout.WEST, p);
            layout.putConstraint(SpringLayout.WEST, b2, Spring.constant(10, 100, 300), SpringLayout.EAST, b1);
            layout.putConstraint(SpringLayout.WEST, b3, Spring.constant(10, 100, 300), SpringLayout.EAST, b2);
            layout.putConstraint(SpringLayout.EAST, p, Spring.constant(10, 100, 300), SpringLayout.EAST, b3);
            //superior(freeze):
            layout.putConstraint(SpringLayout.NORTH, b1, Spring.constant(10), SpringLayout.NORTH, p);
            layout.putConstraint(SpringLayout.NORTH, b2, Spring.constant(10), SpringLayout.NORTH, p);
            layout.putConstraint(SpringLayout.NORTH, b3, Spring.constant(10), SpringLayout.NORTH, p);
            add(p);
            this.setVisible(true);
            this.setResizable(true);
        }
    }

    //Containers:
    static class JDialogExample extends JFrame{
        public JDialogExample(){
            this.setTitle("JDialogExample");
            this.setLocationRelativeTo(null);
            JButton button = new JButton("Open secondary");
            button.setPreferredSize(new Dimension(300,100));
            this.add(button);
            this.pack();
            JDialog vS = new JDialog(this,"Secondary window");
            vS.setPreferredSize(new Dimension(300,100));
            vS.setLocationRelativeTo(null);
            JLabel label = new JLabel("Hi");
            vS.getContentPane().add(label);
            vS.pack();
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){vS.setVisible(true);}});
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }
    static class JEditorPaneExample extends JFrame{
        public JEditorPaneExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JEditorPaneExample");
            this.setResizable(false);
            this.setLayout(new BorderLayout());
            JEditorPane editor = new JEditorPane();
            editor.setContentType("text/html");
            editor.setEditable(false);
            try(BufferedReader br = new BufferedReader(new FileReader(new File("E:\\Escritorio\\Programacion\\Web\\WebCSS\\index.html")));){
                StringBuilder sb = new StringBuilder();
                String buf = null;
                while((buf  = br.readLine()) != null) sb.append(buf);
                editor.setText(sb.toString());
            }catch(IOException e) {System.out.println(e.getMessage());}
            JScrollPane js = new JScrollPane(editor);
            js.setPreferredSize(new Dimension(700,400));
            this.add(js, BorderLayout.CENTER);
            this.setVisible(true);
            this.pack();
        }
    }
    static class JInternalFrameExample extends JFrame {
        public JInternalFrameExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("JInternalFrameExample");
            this.setSize(350,200);
            JDesktopPane dp = new JDesktopPane();
            JPanel p = new JPanel();
            p.setLayout(new FlowLayout());
            p.add (new JLabel("Label"));
            p.add (new JTextField(10));
            JInternalFrame internal = new JInternalFrame("Internal Frame");
            internal.add(p);
            internal.pack();
            internal.setVisible(true);
            dp.add(internal);
            this.add(dp);
            this.setVisible(true);
        }
    }
    static class JLayeredPaneExample extends JFrame{
        public JLayeredPaneExample(){
            this.setTitle("JLayeredPaneExample");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(new Dimension(400,400));
            this.setLayout(null);
            this.setVisible(true);
            JLabel l1 = new JLabel();
            l1.setOpaque(true);
            l1.setBackground(Color.RED);
            l1.setBounds(50, 50, 200, 200);
            JLabel l2 = new JLabel();
            l2.setOpaque(true);
            l2.setBackground(Color.GREEN);
            l2.setBounds(100, 100, 200, 200);
            JLabel l3 = new JLabel();
            l3.setOpaque(true);
            l3.setBackground(Color.BLUE);
            l3.setBounds(150, 150, 200, 200);
            JLayeredPane pane = new JLayeredPane();
            //DEFAULT_LAYER<<PALETTE_LAYER<<MODAL_LAYER<<POPUP_LAYER<<DRAG_LAYER//
            pane.setBounds(0, 0, 500, 500);
            pane.add(l1, JLayeredPane.DEFAULT_LAYER);
            pane.add(l2, JLayeredPane.MODAL_LAYER);
            pane.add(l3, JLayeredPane.DRAG_LAYER);
            this.add(pane);
        }
    }
    static class JOptionPaneExample {
        public JOptionPaneExample(){
            //ShowMessageDialog:
            JOptionPane.showMessageDialog(null, "Information", "Information_Message", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Question", "Question_Message", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Warning", "Warning_Message", JOptionPane.WARNING_MESSAGE);    
            JOptionPane.showMessageDialog(null, "Error", "Error_Message", JOptionPane.ERROR_MESSAGE);
            //ShowConfirmDialog:
            JOptionPane.showConfirmDialog(null, "Seleccione:", "Yes_Option", JOptionPane.YES_OPTION);
            JOptionPane.showConfirmDialog(null, "Seleccione:", "Yes_No_Cancel_Option", JOptionPane.YES_NO_CANCEL_OPTION);
            JOptionPane.showConfirmDialog(null, "Seleccione:", "No_Option", JOptionPane.NO_OPTION);
            JOptionPane.showConfirmDialog(null, "Seleccione:", "OK_Option", JOptionPane.OK_OPTION);
            JOptionPane.showConfirmDialog(null, "Seleccione:", "Cancel_Option", JOptionPane.CANCEL_OPTION);
            JOptionPane.showConfirmDialog(null, "Seleccione:", "Closed_Option", JOptionPane.CLOSED_OPTION);
            //ShowInputDialog:
            JOptionPane.showInputDialog(null, "Introduzca");
            JOptionPane.showInputDialog(null,"Seleccione:","Opciones", JOptionPane.INFORMATION_MESSAGE, null,
                new Object[] { "Seleccione","Opcion1", "Opcion2", "Opcion3" },"Seleccione");
            //ShowOptionDialog:
            JOptionPane.showOptionDialog(null, "Seleccione:", "Option_Dialog", JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Opcion1", "Opcion2", "Opcion3"}, 0);
        }
    }
    static class JPanelExample extends JFrame{
        public JPanelExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("EjemploJPanel");
            this.setLayout(null);
            this.setSize(500,500);
            this.setVisible(true);
            JPanel panel = new JPanel();
            panel.setBackground(Color.BLUE);
            panel.setBounds(100,100,300,300);
            this.add(panel);
        }
    }
    static class JScrollPaneExample extends JFrame{
        public JScrollPaneExample() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setTitle("JScrollPaneExample");
            this.setLayout(new FlowLayout());
            JScrollPane pane = new JScrollPane();
            pane.setPreferredSize(new Dimension(300, 100));
            pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            this.add(pane);
            this.pack();
            this.setVisible(true);
        }
    }
    static class JTextPaneExample extends JFrame{
        public JTextPaneExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("JTextPaneExample");
            this.setResizable(false);
            this.setLayout(new BorderLayout());
            JTextPane pane = new JTextPane();  
            pane.setFont(new Font("Arial", Font.BOLD, 100));
            SimpleAttributeSet attributeSet = new SimpleAttributeSet();  
            StyleConstants.setBold(attributeSet, false); 
            pane.setCharacterAttributes(attributeSet, true);  
            pane.setText("Welcome");  
            attributeSet = new SimpleAttributeSet();  
            StyleConstants.setItalic(attributeSet, true);  
            StyleConstants.setForeground(attributeSet, Color.red);  
            StyleConstants.setBackground(attributeSet, Color.blue);  
            Document doc = pane.getStyledDocument();  
            try{doc.insertString(doc.getLength(), "To Java ", attributeSet);}catch(Exception e){e.printStackTrace();}  
            attributeSet = new SimpleAttributeSet();  
            try{doc.insertString(doc.getLength(), "World", attributeSet);}catch(Exception e){e.printStackTrace();}
            JScrollPane scrollPane = new JScrollPane(pane);  
            add(scrollPane, BorderLayout.CENTER);  
            this.setVisible(true);
            this.pack();
        }
    }
    
    //Layouts:
    static class LayoutExample extends JFrame{
        public LayoutExample(int option) {
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension dm = tk.getScreenSize();
            int x = dm.width, y = dm.height;
            setBounds(x/4, y/4, x/2, y/2);
            setMinimumSize(new Dimension(200,200));
            setBackground(SystemColor.window);
            JButton b1 = new JButton("b1");
            b1.setPreferredSize(new Dimension(200,50));
            JButton b2 = new JButton("b2");
            b2.setPreferredSize(new Dimension(200,50));
            JButton b3 = new JButton("b3");
            b3.setPreferredSize(new Dimension(200,50));
            JButton b4 = new JButton("b4");
            b4.setPreferredSize(new Dimension(200,50));
            JButton b5 = new JButton("b5");
            b5.setPreferredSize(new Dimension(200,50));
            JButton b6 = new JButton("b6");
            b6.setPreferredSize(new Dimension(200,50));
            switch (option) {
                case 1:
                    setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
                    add(b1);
                    add(b2);
                    add(b3);
                    add(b4);
                    add(b5);
                    add(b6);
                    break;
                case 2:
                    setLayout(new BorderLayout(50, 50));
                    add(b1, BorderLayout.NORTH);
                    add(b2, BorderLayout.EAST);
                    add(b3, BorderLayout.WEST);
                    add(b4, BorderLayout.SOUTH);
                    add(b5, BorderLayout.CENTER);
                    add(b6, BorderLayout.NORTH);
                    break;
                case 3:
                    setLayout(new GridLayout(2,3,50,50));
                    add(b1);
                    add(b2);
                    add(b3);
                    add(b4);
                    add(b5);
                    add(b6);
                    break;
                default:
                    break;
            }
            setTitle("Ventana");
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            pack();
        }
    }

    //Document events:
    static class DocumentEventsExample extends JFrame{
        public DocumentEventsExample() {
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension dm = tk.getScreenSize();
            int x = dm.width, y = dm.height;
            setBounds(x/4, y/4, x/2, y/2);
            setMinimumSize(new Dimension(200,200));//Tamaño Minimo
            setBackground(SystemColor.window);
            setLayout(new FlowLayout());
            JTextField tf = new JTextField();
            tf.setPreferredSize(new Dimension(300, 50));
            tf.getDocument().addDocumentListener(new DocumentListener(){
                @Override public void insertUpdate(DocumentEvent e) {System.out.println("Insert update");}
                @Override public void removeUpdate(DocumentEvent e) {System.out.println("Remove update");}
                @Override public void changedUpdate(DocumentEvent e) {System.out.println("Change update");}
            });
            add(tf);
            setTitle("DocumentEventsExample");
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    //Free layout:
    static class FreeLayoutExample extends JFrame{
        JPanel p;
        JButton b1, b2, b3;
        public FreeLayoutExample(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setTitle("FreeLayoutExample");
            this.setSize(600,600);
            JPanel p = new JPanel();
            p.setLayout(null);
            p.setBackground(Color.RED);
            JButton b = new JButton("Button");
            b.setBounds(250,250,100,100);
            p.add(b);
            add(p);
            this.setVisible(true);
            this.setResizable(false);
        }
    }

}
