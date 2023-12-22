package Avanzado.A_Swing.E_Componentes;

import java.awt.Dimension;

import javax.swing.*;

public class EjemploJTable extends JFrame{
    
    public EjemploJTable(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("EjemploJTable");

        String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
        String column[]={"ID","NAME","SALARY"};         
        JTable jt=new JTable(data,column);    
        jt.setPreferredSize(new Dimension(400,600));          
        JScrollPane sp=new JScrollPane(jt);    
        add(sp);         

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJTable();
    }
}