/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Interfaz;

import Ayudas.Ayuda;
import Ayudas.Compra;
import Ayudas.Letras;
import Ayudas.Pista;
import Ayudas.SegundaDefinicion;
import Exceptions.EAyudaNoValidaException;
import Exceptions.EJugadorNoValidoException;
import Exceptions.EPalabraNoValidaException;
import Exceptions.EPartidaNoValidaException;
import Exceptions.ERoscoNoValidoException;
import Jugadores.Jugador;
import Partidas.Entrenamiento;
import Partidas.Rosco;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class PanelEntrenar extends javax.swing.JDialog {

    /**
     * Creates new form PanelEntrenamiento
     */
    private Entrenamiento entrenamiento;
    private int posicionLetraActual;
    private Jugador jugador;

    public PanelEntrenar(JDialog parent, boolean modal, Entrenamiento entrenamiento, Jugador jugador) throws EJugadorNoValidoException, EPartidaNoValidaException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        if (entrenamiento == null) {
            throw new EPartidaNoValidaException("No se puede entrenar sin un entrenamiento");
        }
        if (jugador == null) {
            throw new EJugadorNoValidoException("No se puede entrenar sin jugador");
        }
        this.entrenamiento = entrenamiento;
        this.posicionLetraActual = 0;
        this.jugador = jugador;
        //Iniciamos al valor correcto los contadores
        palabrasAcertadas.setText("0");
        palabrasFalladas.setText("0");
        vueltaActual.setText("1");
        vueltasMax.setText(String.valueOf(Rosco.NUM_VUELTAS_MAX));
        resultado.setText("Aun no se ha realizado ninguna jugada");
        //El panel para mostrar las letras se inicializa con todas las letras que tendra el rosco sin color
        //Excepto la primera letra, para asi indicar que estamos en esa letra
        JLabel nuevaEtiqueta = new JLabel(String.valueOf(Rosco.ABECEDARIO[0]));
        nuevaEtiqueta.setForeground(Color.BLUE);
        letras.add(nuevaEtiqueta);
        for (int i = 1; i < entrenamiento.getRosco().getNumLetras(); i++) {
            letras.add(new JLabel(String.valueOf(Rosco.ABECEDARIO[i])));
        }
        //Ponemos la definicion de la primera palabra
        definicion.setText("Empieza por A:\n" + entrenamiento.getRosco().getPalabras()[0].getDef1().toString());
    }

    private PanelEntrenar(JDialog jDialog, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vueltasMax = new javax.swing.JLabel();
        vueltaActual = new javax.swing.JLabel();
        letras = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelCopyrights = new javax.swing.JLabel();
        enviarPalabra = new javax.swing.JButton();
        respuesta = new javax.swing.JTextField();
        pasarPalabra = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        recibirAyuda = new javax.swing.JButton();
        resultado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        palabrasFalladas = new javax.swing.JLabel();
        palabrasAcertadas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        definicion = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        opciones = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenuItem();
        salirForzado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pasapalabra - Entrenamiento");
        setBackground(java.awt.Color.white);
        setResizable(false);
        setSize(new java.awt.Dimension(705, 755));

        jPanel1.setBackground(new java.awt.Color(244, 241, 234));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vueltasMax.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        vueltasMax.setForeground(new java.awt.Color(83, 119, 143));
        vueltasMax.setText("2");
        jPanel1.add(vueltasMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        vueltaActual.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        vueltaActual.setForeground(new java.awt.Color(83, 119, 143));
        vueltaActual.setText("1");
        jPanel1.add(vueltaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        letras.setBackground(java.awt.Color.white);
        letras.setForeground(new java.awt.Color(83, 119, 143));
        letras.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jPanel1.add(letras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 560, 40));

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(83, 119, 143));
        jLabel6.setText("Escriba su respuesta aqui:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(83, 119, 143));
        jLabel3.setText("Resultado de la ultima jugada:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(83, 119, 143));
        jLabel5.setText("Siguiente Palabra...");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        labelCopyrights.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        labelCopyrights.setForeground(new java.awt.Color(83, 119, 143));
        labelCopyrights.setText("©2022 The CSC Company");
        jPanel1.add(labelCopyrights, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 670, -1, -1));

        enviarPalabra.setBackground(new java.awt.Color(83, 119, 143));
        enviarPalabra.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        enviarPalabra.setForeground(java.awt.Color.white);
        enviarPalabra.setText("Responder");
        enviarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarPalabraActionPerformed(evt);
            }
        });
        jPanel1.add(enviarPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 120, -1));

        respuesta.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        respuesta.setForeground(new java.awt.Color(83, 119, 143));
        respuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestaActionPerformed(evt);
            }
        });
        jPanel1.add(respuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 250, -1));

        pasarPalabra.setBackground(new java.awt.Color(83, 119, 143));
        pasarPalabra.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        pasarPalabra.setForeground(java.awt.Color.white);
        pasarPalabra.setText("Pasa palabra");
        pasarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarPalabraActionPerformed(evt);
            }
        });
        jPanel1.add(pasarPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(83, 119, 143));
        jLabel8.setText("Vuelta actual:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(83, 119, 143));
        jLabel9.setText("Maximo vueltas:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        recibirAyuda.setBackground(new java.awt.Color(83, 119, 143));
        recibirAyuda.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        recibirAyuda.setForeground(java.awt.Color.white);
        recibirAyuda.setText("Recibir ayuda");
        recibirAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibirAyudaActionPerformed(evt);
            }
        });
        jPanel1.add(recibirAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 200, -1));

        resultado.setEditable(false);
        resultado.setBackground(java.awt.Color.white);
        resultado.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        resultado.setForeground(new java.awt.Color(83, 119, 143));
        resultado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadoActionPerformed(evt);
            }
        });
        jPanel1.add(resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 510, -1));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(83, 119, 143));
        jLabel1.setText("Palabras acertadas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(83, 119, 143));
        jLabel2.setText("Palabras falladas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        palabrasFalladas.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        palabrasFalladas.setForeground(new java.awt.Color(83, 119, 143));
        palabrasFalladas.setText("0");
        jPanel1.add(palabrasFalladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        palabrasAcertadas.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        palabrasAcertadas.setForeground(new java.awt.Color(83, 119, 143));
        palabrasAcertadas.setText("0");
        jPanel1.add(palabrasAcertadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        definicion.setEditable(false);
        definicion.setColumns(20);
        definicion.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        definicion.setForeground(new java.awt.Color(83, 119, 143));
        definicion.setRows(5);
        definicion.setBorder(null);
        jScrollPane1.setViewportView(definicion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 560, 150));

        jMenuBar1.setBackground(new java.awt.Color(244, 241, 234));
        jMenuBar1.setForeground(new java.awt.Color(83, 119, 143));
        jMenuBar1.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N

        opciones.setText("Opciones");

        ayuda.setText("Ayuda");
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });
        opciones.add(ayuda);

        salirForzado.setText("Forzar salida");
        salirForzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirForzadoActionPerformed(evt);
            }
        });
        opciones.add(salirForzado);

        jMenuBar1.add(opciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void respuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respuestaActionPerformed

    private void enviarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarPalabraActionPerformed
        // Al pulsar el boton de enviar respuesta, comprobamos la respuesta y actuamos en consecuencia
        try {
            if (respuesta.getText() == null || respuesta.getText().equals("")) {
                throw new EPalabraNoValidaException("La palabra respuesta no puede ser nula o vacia, vuelva a intentarlo");
            }
            //Si si hay una respuesta, comprobamos si es la correcta o no
            if (entrenamiento.getRosco().getPalabras()[posicionLetraActual].getPalabra().toString().equalsIgnoreCase(respuesta.getText())) {
                //Si acertamos la marcamos como correcta en la barra de letras y en el rosco
                entrenamiento.getRosco().getPalabras()[posicionLetraActual].setAcertada(true);
                letras.getComponent(posicionLetraActual).setForeground(Color.GREEN);
                //Sumamos un acierto
                if (entrenamiento.getRosco().setNumAciertos(entrenamiento.getRosco().getNumAciertos() + 1)) {
                    palabrasAcertadas.setText(String.valueOf(entrenamiento.getRosco().getNumAciertos()));
                } else {
                    throw new ERoscoNoValidoException("No puede haber un valor negativo en los aciertos");
                }
                //Emitimos mensaje de acertada en el resultado
                resultado.setText("La palabra ha sido acertada");
                resultado.setForeground(Color.GREEN);
            } else {
                //Si no acertamos la marcamos como fallada en la barra de letras y en el rosco
                entrenamiento.getRosco().getPalabras()[posicionLetraActual].setFallada(true);
                letras.getComponent(posicionLetraActual).setForeground(Color.RED);
                //Sumamos un fallo
                if (entrenamiento.getRosco().setNumFallos(entrenamiento.getRosco().getNumFallos() + 1)) {
                    palabrasFalladas.setText(String.valueOf(entrenamiento.getRosco().getNumFallos()));
                } else {
                    throw new ERoscoNoValidoException("No puede haber un valor negativo en los aciertos,lo sentimos, se debe abortar el entrenamiento");
                }
                //Emitimos mensaje de acertada en el resultado
                resultado.setText("La palabra ha sido fallada");
                resultado.setForeground(Color.RED);
            }
            //En caso de que estuviera aplazada cambiamos el aplazada por false
            entrenamiento.getRosco().getPalabras()[posicionLetraActual].setAplazada(false);
            //Una vez comprobado saltamos a la siguiente palabra no contestada si no hemos respondido todas
            if (entrenamiento.getRosco().getNumAciertos() + entrenamiento.getRosco().getNumFallos() == entrenamiento.getRosco().getNumLetras()) {
                posicionLetraActual = -1;
            } else {
                posicionLetraActual = calcularPosicionPalabraSiguiente();
            }
            //Si la posicion actual es -1 significa que ya hemos completados las maximas vueltas
            //o hemos contestado a todas las palabras y debemos acabar
            if (posicionLetraActual == -1) {
                finalizarEntrenamineto();
            }
            //Si no toca finalizar, actualizamos la definicion de la palabra actual
            definicion.setText("Empieza por " + entrenamiento.getRosco().getPalabras()[posicionLetraActual].getInicial() + ":\n" + entrenamiento.getRosco().getPalabras()[posicionLetraActual].getDef1().toString());
            //Tambien borramos la ultima respuesta del textfield de resouesta
            respuesta.setText("");
            //Tambien indicamos la letra actual
            letras.getComponent(posicionLetraActual).setForeground(Color.BLUE);
        } catch (EPalabraNoValidaException e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Error al responder", JOptionPane.ERROR_MESSAGE);
        } catch (ERoscoNoValidoException e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Error al responder", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (EJugadorNoValidoException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Jugador no válido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_enviarPalabraActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        // Al pulsar el boton de ayuda se emite un mensaje con las instrucciones del juego
        JOptionPane.showMessageDialog(this, Entrenamiento.INSTRUCIONES, "Instrucciones del entrenamiento", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ayudaActionPerformed

    private void salirForzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirForzadoActionPerformed
        // Emitimos un mensaje de que no se dara el beneficio y damos opcion de salir o continuar
        if (JOptionPane.showConfirmDialog(this, "La opcion de salir implica que no se guarde el beneficio, ¿desea usted salir?", "Forzar salida", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirForzadoActionPerformed

    private void resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultadoActionPerformed

    private void pasarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarPalabraActionPerformed
        // Si pasamos palabra antes de la vuelta 2 simplemente aplazamos la palabra y seguimos
        // Si pasamos palabra tras la vuelta 2 fallamos la palabra actual y seguimos
        if (entrenamiento.getRosco().getVuelta() >= 2) {
            try {
                //Si pasamos palabra ahora, acumulamos un fallo
                entrenamiento.getRosco().getPalabras()[posicionLetraActual].setFallada(true);
                letras.getComponent(posicionLetraActual).setForeground(Color.RED);
                //Si estaba aplazada, le quitamos el aplazado
                entrenamiento.getRosco().getPalabras()[posicionLetraActual].setAplazada(false);
                //Sumamos un fallo
                if (entrenamiento.getRosco().setNumFallos(entrenamiento.getRosco().getNumFallos() + 1)) {
                    palabrasFalladas.setText(String.valueOf(entrenamiento.getRosco().getNumFallos()));
                } else {
                    throw new ERoscoNoValidoException("No puede haber un valor negativo en los aciertos,lo sentimos, se debe abortar el entrenamiento");
                }
            } catch (ERoscoNoValidoException e) {
                JOptionPane.showMessageDialog(this, e.toString(), "Error al responder", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } else {
            //Sino, aplazamos la palabra
            entrenamiento.getRosco().getPalabras()[posicionLetraActual].setAplazada(true);
            letras.getComponent(posicionLetraActual).setForeground(Color.BLACK);
        }
        //En cualquier caso, indicamos que se ha pasado palabra y actualizamos la letra actual
        resultado.setText("Se ha pasado palabra");
        resultado.setForeground(Color.BLACK);
        //Calculamos la siguiemte posicion si es necesario
        if (entrenamiento.getRosco().getNumAciertos() + entrenamiento.getRosco().getNumFallos() == entrenamiento.getRosco().getNumLetras()) {
            posicionLetraActual = -1;
        } else {
            posicionLetraActual = calcularPosicionPalabraSiguiente();
        }
        //Si la posicion actual es -1 significa que ya hemos completados las maximas vueltas y debemos acabar
        if (posicionLetraActual == -1) {
            try {
                finalizarEntrenamineto();
            } catch (EJugadorNoValidoException ex) {
                JOptionPane.showMessageDialog(this, ex.toString(), "Error al finalizar el entrenamiento", JOptionPane.ERROR_MESSAGE);

            }
        }
        //Si no toca finalizar, actualizamos la definicion de la palabra actual
        definicion.setText("Empieza por " + entrenamiento.getRosco().getPalabras()[posicionLetraActual].getInicial() + ":\n" + entrenamiento.getRosco().getPalabras()[posicionLetraActual].getDef1().toString());
        //Tambien borramos la ultima respuesta del textfield de resouesta
        respuesta.setText("");
        //Tambien indicamos la letra actual
        letras.getComponent(posicionLetraActual).setForeground(Color.BLUE);
    }//GEN-LAST:event_pasarPalabraActionPerformed

    private void recibirAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibirAyudaActionPerformed
        // Cuando recibimos una ayuda tenemos varias opciones segun la ayuda recibida
        // Primero mostramos y damos a elegir el tipo de ayuda deseada
        Object retorno = JOptionPane.showInputDialog(this, "Por favor seleccione el tipo de ayuda deseado", "Sleccion de ayuda", JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Comprar (20 puntos)", "Pista (5 puntos)"}, "Pista (5 puntos)");
        //Comprobamos que ayuda se ha seleccionado y si tenemos puntos necesario para ello
        try {
            Ayuda ayudaRecibida;
            if (retorno.equals("Comprar (20 puntos)")) {
                //La compra implica la muestra de toda la informacion de la palabra
                if (jugador.getPuntos() < Compra.PRECIO_ESTANDAR) {
                    throw new EAyudaNoValidaException("No tiene suficientes puntos para comprar esta palabra");
                }
                ayudaRecibida = new Compra(Compra.PRECIO_ESTANDAR, entrenamiento.getRosco().getPalabras()[posicionLetraActual]);
                entrenamiento.getRosco().getPalabras()[posicionLetraActual].setAcertada(true);
                respuesta.setText(entrenamiento.getRosco().getPalabras()[posicionLetraActual].getPalabra().toString());
                this.enviarPalabraActionPerformed(evt);
            } else {
                if (jugador.getPuntos() < Pista.PRECIO_ESTANDAR) {
                    throw new EAyudaNoValidaException("No tiene suficientes puntos para comprar esta palabra");
                }
                //Si hay 2 definiciones mostramos la segunda, sino parte de las letras de la palabra
                if (entrenamiento.getRosco().getPalabras()[posicionLetraActual].getDef2() != null && !entrenamiento.getRosco().getPalabras()[posicionLetraActual].getDef2().toString().equals("")) {
                    ayudaRecibida = new SegundaDefinicion(Pista.PRECIO_ESTANDAR, entrenamiento.getRosco().getPalabras()[posicionLetraActual]);
                } else {
                    ayudaRecibida = new Letras(Pista.PRECIO_ESTANDAR, entrenamiento.getRosco().getPalabras()[posicionLetraActual]);
                }
            }
            //Mostramos la informacion de la ayuda
            JOptionPane.showMessageDialog(this, "La informacion de la palabra es:\n" + ayudaRecibida.mostrar_info(), "Compra", JOptionPane.INFORMATION_MESSAGE);
        } catch (EAyudaNoValidaException e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Aviso en la ayuda", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_recibirAyudaActionPerformed

    private int calcularPosicionPalabraSiguiente() {
        //Buscamos desde la posicion actual la prosima palabra no respondida o aplazada
        int posicion = posicionLetraActual + 1;
        if (posicion >= entrenamiento.getRosco().getNumLetras()) {
            //Si la proxima letra esta fuera del rango posible, volvemos a la primera sumando una vuelta
            entrenamiento.getRosco().setVuelta(entrenamiento.getRosco().getVuelta() + 1);
            vueltaActual.setText(String.valueOf(entrenamiento.getRosco().getVuelta()));
            posicion = 0;
        }
        boolean encontrada = false;
        while (!encontrada && entrenamiento.getRosco().getVuelta() <= Rosco.NUM_VUELTAS_MAX) {
            if (entrenamiento.getRosco().getPalabras()[posicion].getFallada() || entrenamiento.getRosco().getPalabras()[posicion].getAcertada()) {
                //Si no esta ni acertada ni fallada, la pasamos ya que no nos vale
                posicion++;
                if (posicion >= entrenamiento.getRosco().getNumLetras()) {
                    //Si la proxima letra esta fuera del rango posible, volvemos a la primera sumando una vuelta
                    entrenamiento.getRosco().setVuelta(entrenamiento.getRosco().getVuelta() + 1);
                    vueltaActual.setText(String.valueOf(entrenamiento.getRosco().getVuelta()));
                    posicion = 0;
                }
            } else {
                //Si esta aplazada o no esta ni aplazada ni fallada ni acertada, nos vale, paramos de buscar
                encontrada = true;
            }
        }
        //Si hemos parado porque el numero de vueltas supera el maximo, devolvemos -1
        if (entrenamiento.getRosco().getVuelta() > Rosco.NUM_VUELTAS_MAX) {
            return -1;
        } //Sino, devolvemos la posicion
        else {
            return posicion;
        }
    }

    public void finalizarEntrenamineto() throws EJugadorNoValidoException {
        //Emitimos el resultado, sumamos el beneficio al jugador en caso de que no tenga puntos y salimos
        StringBuilder mensaje = new StringBuilder("Enhorabuena, " + jugador.getNombre() + ", su entrenamiento ha finalizado con exito\n");
        mensaje.append("Resultados:\n"
                + "Aciertos:    " + entrenamiento.getRosco().getNumAciertos() + "\n"
                + "Fallos:      " + entrenamiento.getRosco().getNumFallos() + "\n");
        if (jugador.getPuntos() == 0) {
            jugador.setPuntos(entrenamiento.getBeneficio());
            mensaje.append("Como no tenia puntos se le ha beneficiado con " + String.valueOf(entrenamiento.getBeneficio()) + " puntos\n");
        }
        mensaje.append("Gracias por entrenar");
        resultado.setText("Fin del entrenamiento");
        resultado.setForeground(Color.BLACK);
        JOptionPane.showMessageDialog(this, mensaje.toString(), "Fin del entrenamineto", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelEntrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelEntrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelEntrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelEntrenar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PanelEntrenar dialog;
                dialog = new PanelEntrenar(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ayuda;
    private javax.swing.JTextArea definicion;
    private javax.swing.JButton enviarPalabra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCopyrights;
    private javax.swing.JPanel letras;
    private javax.swing.JMenu opciones;
    private javax.swing.JLabel palabrasAcertadas;
    private javax.swing.JLabel palabrasFalladas;
    private javax.swing.JButton pasarPalabra;
    private javax.swing.JButton recibirAyuda;
    private javax.swing.JTextField respuesta;
    private javax.swing.JTextField resultado;
    private javax.swing.JMenuItem salirForzado;
    private javax.swing.JLabel vueltaActual;
    private javax.swing.JLabel vueltasMax;
    // End of variables declaration//GEN-END:variables
}
