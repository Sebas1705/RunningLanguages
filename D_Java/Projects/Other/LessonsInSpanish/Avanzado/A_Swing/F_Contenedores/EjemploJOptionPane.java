package Avanzado.A_Swing.F_Contenedores;

import javax.swing.JOptionPane;

public class EjemploJOptionPane {
    
    public static void main(String[] args) {
        
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


