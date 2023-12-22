package Avanzado.J_JDCB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{

            //Crear conexion:
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejerciciosbdd","root","He260196");
            
            //Crear statment:
            Statement stmt = conexion.createStatement();
            
            //Ejecutar Sql:
            ResultSet rs = stmt.executeQuery("SELECT * FROM departamento;");

            //Rescorrer el resultado:
            while(rs.next()){
                System.out.println( rs.getInt("Numero_D")+" | "+rs.getString(2));
            }

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
