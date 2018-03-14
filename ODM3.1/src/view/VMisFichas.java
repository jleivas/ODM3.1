/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import correo.FnEnviar;
import entities.Cliente;
import entities.Despacho;
import entities.Ficha;
import entities.HistorialPago;
import entities.TipoPago;
import fn.Boton;
import fn.FnCliente;
import fn.FnFicha;
import fn.FnNuevaFicha;
import fn.FnValidaRut;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author home
 */
public class VMisFichas extends javax.swing.JPanel {

    private static int cont = 0;
    /**
     * Creates new form VClientes
     */
    public VMisFichas() throws SQLException, ClassNotFoundException {
        initComponents();
        btnNotificar.setVisible(false);
        cargarDatos(0,1);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListar = new javax.swing.JTable();
        btnRestaurar = new javax.swing.JButton();
        txtDe = new com.toedter.calendar.JDateChooser();
        txtHasta = new com.toedter.calendar.JDateChooser();
        lblDe = new javax.swing.JLabel();
        lblHasta = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        btnNotificar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnActivos = new javax.swing.JButton();
        btnEliminados = new javax.swing.JButton();
        btnGarantias = new javax.swing.JButton();
        btnMorosos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReport = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mis Registros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 0, 18))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de registros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 0, 11))); // NOI18N

        tblListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Folio", "Fecha", "Cliente", "Estado", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblListar);

        btnRestaurar.setBackground(new java.awt.Color(153, 255, 153));
        btnRestaurar.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(0, 102, 0));
        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault1.jpg"))); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.setBorder(null);
        btnRestaurar.setBorderPainted(false);
        btnRestaurar.setContentAreaFilled(false);
        btnRestaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestaurar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRestaurar.setIconTextGap(-3);
        btnRestaurar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault3.jpg"))); // NOI18N
        btnRestaurar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault2.jpg"))); // NOI18N
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        lblDe.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblDe.setText("DE");

        lblHasta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblHasta.setText("HASTA");

        btnFiltrar.setBackground(new java.awt.Color(153, 255, 153));
        btnFiltrar.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(0, 102, 0));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault1.jpg"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setBorder(null);
        btnFiltrar.setBorderPainted(false);
        btnFiltrar.setContentAreaFilled(false);
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFiltrar.setIconTextGap(-3);
        btnFiltrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault3.jpg"))); // NOI18N
        btnFiltrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault2.jpg"))); // NOI18N
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnNotificar.setBackground(new java.awt.Color(153, 255, 153));
        btnNotificar.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnNotificar.setForeground(new java.awt.Color(0, 102, 0));
        btnNotificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail1.jpg"))); // NOI18N
        btnNotificar.setText("Notificar");
        btnNotificar.setBorder(null);
        btnNotificar.setBorderPainted(false);
        btnNotificar.setContentAreaFilled(false);
        btnNotificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNotificar.setIconTextGap(-3);
        btnNotificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail3.jpg"))); // NOI18N
        btnNotificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail2.jpg"))); // NOI18N
        btnNotificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(126, 126, 126)
                                    .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addComponent(lblDe, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblHasta)
                                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(26, 26, 26)
                            .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnNotificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNotificar)
                    .addComponent(btnRestaurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDe)
                    .addComponent(lblHasta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mostrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 0, 11))); // NOI18N

        btnActivos.setBackground(new java.awt.Color(153, 255, 153));
        btnActivos.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnActivos.setForeground(new java.awt.Color(0, 102, 0));
        btnActivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault1.jpg"))); // NOI18N
        btnActivos.setText("Activos");
        btnActivos.setBorder(null);
        btnActivos.setBorderPainted(false);
        btnActivos.setContentAreaFilled(false);
        btnActivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActivos.setIconTextGap(-3);
        btnActivos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault3.jpg"))); // NOI18N
        btnActivos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault2.jpg"))); // NOI18N
        btnActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivosActionPerformed(evt);
            }
        });

        btnEliminados.setBackground(new java.awt.Color(153, 255, 153));
        btnEliminados.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnEliminados.setForeground(new java.awt.Color(0, 102, 0));
        btnEliminados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault1.jpg"))); // NOI18N
        btnEliminados.setText("Eliminados");
        btnEliminados.setBorder(null);
        btnEliminados.setBorderPainted(false);
        btnEliminados.setContentAreaFilled(false);
        btnEliminados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminados.setIconTextGap(-3);
        btnEliminados.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault3.jpg"))); // NOI18N
        btnEliminados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnDefault2.jpg"))); // NOI18N
        btnEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminadosActionPerformed(evt);
            }
        });

        btnGarantias.setBackground(new java.awt.Color(153, 255, 153));
        btnGarantias.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnGarantias.setForeground(new java.awt.Color(0, 102, 0));
        btnGarantias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail1.jpg"))); // NOI18N
        btnGarantias.setText("Garantias");
        btnGarantias.setBorder(null);
        btnGarantias.setBorderPainted(false);
        btnGarantias.setContentAreaFilled(false);
        btnGarantias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGarantias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGarantias.setIconTextGap(-3);
        btnGarantias.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail3.jpg"))); // NOI18N
        btnGarantias.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail2.jpg"))); // NOI18N
        btnGarantias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGarantiasActionPerformed(evt);
            }
        });

        btnMorosos.setBackground(new java.awt.Color(153, 255, 153));
        btnMorosos.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnMorosos.setForeground(new java.awt.Color(0, 102, 0));
        btnMorosos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail1.jpg"))); // NOI18N
        btnMorosos.setText("Morosos");
        btnMorosos.setBorder(null);
        btnMorosos.setBorderPainted(false);
        btnMorosos.setContentAreaFilled(false);
        btnMorosos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMorosos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMorosos.setIconTextGap(-3);
        btnMorosos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail3.jpg"))); // NOI18N
        btnMorosos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botonGraph/btnMail2.jpg"))); // NOI18N
        btnMorosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMorososActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGarantias, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnMorosos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminados, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnActivos)
                .addComponent(btnEliminados)
                .addComponent(btnGarantias)
                .addComponent(btnMorosos))
        );

        txtReport.setEditable(false);
        txtReport.setColumns(20);
        txtReport.setRows(5);
        jScrollPane2.setViewportView(txtReport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivosActionPerformed
        try {
            cargarDatos(0,1);
            reiniciarPaneles();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado "+ex.getMessage(), "Cargar datos", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado "+ex.getMessage(), "Cargar datos", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActivosActionPerformed

    private void btnEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminadosActionPerformed
        FnFicha load = new FnFicha();
        if(load.validarAdmin()){
            try {
                cargarDatos(-1,0);
                btnNotificar.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error inesperado "+ex.getMessage(), "Cargar datos", JOptionPane.WARNING_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error inesperado "+ex.getMessage(), "Cargar datos", JOptionPane.WARNING_MESSAGE);
            }
        }
        
            
    }//GEN-LAST:event_btnEliminadosActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        reiniciarPaneles();
        try{
            int fila = tblListar.getSelectedRow();
            int idFicha = (int) tblListar.getValueAt(fila, 0);
            FnFicha load = new FnFicha();
            Ficha temp = load.cargar(idFicha,0);
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea restaurar la ficha numero "+temp.getId()+"?");
            if(respuesta == JOptionPane.YES_OPTION){
                if(load.restaurar(idFicha)){
                    JOptionPane.showMessageDialog(null, "El registro ha sido restaurado", "Restaurar", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo restaurar el registro", "Restaurar", JOptionPane.WARNING_MESSAGE);
                }
                cargarDatos(-1,0);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro en la tabla", "Seleccione", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        reiniciarPaneles();
        int idSesion1 = Integer.parseInt(ContentAdmin.idSesion.getText());
        Date fecha1 = txtDe.getDate();
        Date fecha2 = txtHasta.getDate();
        FnFicha load = new FnFicha();
        try {
            llenarTabla(load.listarPorFechaSesion(fecha1, fecha2,idSesion1), 1);
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erros desconocido: "+ex.getMessage(),"Cargar Datos",JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        btnRestaurar.setVisible(false);
//        btnEliminar.setVisible(true);

        lblDe.setVisible(true);
        lblHasta.setVisible(true);
        txtDe.setVisible(true);
        txtHasta.setVisible(true);
        btnFiltrar.setVisible(true);

        
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnNotificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificarActionPerformed
        
        Date fecha1 = txtDe.getDate();
        Date fecha2 = txtHasta.getDate();
        FnFicha load = new FnFicha();
        
        
        try {
            load.enviarNotificacion(load.morosos());
        } catch (SQLException | ClassNotFoundException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error desconocido:"+ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNotificarActionPerformed

    private void btnGarantiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGarantiasActionPerformed
        reiniciarPaneles();
        int idSesion = Integer.parseInt(ContentAdmin.idSesion.getText());
        btnNotificar.setVisible(false);
        btnFiltrar.setVisible(true);
//        btnEliminar.setVisible(true);
        btnRestaurar.setVisible(false);
        txtDe.setVisible(true);
        txtHasta.setVisible(true);
        FnFicha load = new FnFicha();
        try {
            llenarTabla(load.garantiasSesion(idSesion), 1);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado: "+ex.getMessage(),"Cargar morosos",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGarantiasActionPerformed

    private void btnMorososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMorososActionPerformed
        FnFicha load = new FnFicha();
        try {
            llenarTabla(load.morosos(), 0);
//            btnEliminar.setVisible(false);
            btnNotificar.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado: "+ex.getMessage(),"Cargar morosos",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnMorososActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivos;
    private javax.swing.JButton btnEliminados;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGarantias;
    private javax.swing.JButton btnMorosos;
    private javax.swing.JButton btnNotificar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDe;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JTable tblListar;
    private com.toedter.calendar.JDateChooser txtDe;
    private com.toedter.calendar.JDateChooser txtHasta;
    private javax.swing.JTextArea txtReport;
    // End of variables declaration//GEN-END:variables

   
    private void cargarDatos(int listar, int estado) throws SQLException, ClassNotFoundException {
        
        
        
        if(listar == -1){//eliminados
            btnRestaurar.setVisible(true);
//            btnEliminar.setVisible(false);
            
            lblDe.setVisible(false);
            lblHasta.setVisible(false);
            txtDe.setVisible(false);
            txtHasta.setVisible(false);
            btnFiltrar.setVisible(false);
            
            
            estado=0;
        }else{
            btnRestaurar.setVisible(false);
//            btnEliminar.setVisible(true);
            
            lblDe.setVisible(true);
            lblHasta.setVisible(true);
            txtDe.setVisible(true);
            txtHasta.setVisible(true);
            btnFiltrar.setVisible(true);
            
            
        }
            
        FnFicha datbd= new FnFicha();
        int idSesion = Integer.parseInt(ContentAdmin.idSesion.getText());
        llenarTabla(datbd.listarPorSesion(listar,idSesion,estado), estado);
        
    }

    

    private void buscarDatos(int buscar, int i) throws SQLException, ClassNotFoundException {
        int idSesion = Integer.parseInt(ContentAdmin.idSesion.getText());
        FnFicha load= new FnFicha();
        llenarTabla(load.listarPorSesion(buscar,idSesion, i), i);
        
    }
    
    private void llenarTabla(ArrayList<Ficha> lista, int i) throws SQLException, ClassNotFoundException{
        DecimalFormat formateador = new DecimalFormat("###,###,###"); 
        
        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
           @Override
           public boolean isCellEditable(int fila, int columna) {
               return false; //Con esto conseguimos que la tabla no se pueda editar
           }
        };
        FnEnviar load = new FnEnviar();
        String reporte = "";
        if(i==1){
           reporte = "REPORTE SEGÚN LISTA DESPLEGADA EN TABLA:\n\n"+load.obtenerReporte(lista);
         
        }
        txtReport.setText(reporte);
        modelo.addColumn("Folio");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cliente");
        modelo.addColumn("Estado");
        modelo.addColumn("Total");
        modelo.addColumn("Abono");
        modelo.addColumn("Saldo");
        tblListar.setModel(modelo);
        FnFicha datbd= new FnFicha();
        
        
        try{
            for (Ficha temp : lista) {
                int descuento =0;
                Object[] fila = new Object[7];
                fila[0] = temp.getId();
                fila[1] = temp.getFecha();
                fila[2] = temp.getCliente().getNombre();
                if(temp.getEstado() == 1)
                    fila[3] = "Pendiente";
                if(temp.getEstado() == 2)
                    fila[3] = "Pagada";
                if(temp.getEstado() == 3)
                    fila[3] = "Despachada";
                if(temp.getEstado() == 0)
                    fila[3] = "Anulada";
                if(temp.getEstado() == 4)
                    fila[3] = "Garantia";
                fila[4] = "$ "+formateador.format(temp.getValorTotal());
                fila[5] = "$ "+formateador.format((temp.getValorTotal()-temp.getSaldo()));
                fila[6] = "$ "+formateador.format(temp.getSaldo());
                modelo.addRow(fila);
            }
            tblListar.updateUI();
            if(tblListar.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "No se encontraron resultados, pruebe con otros valores de búsqueda.");
                 
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, ["+e.getMessage()+"]");
        }
    }

    
    

    



    
    private void reiniciarPaneles() {
            btnNotificar.setVisible(false);
    }
}
