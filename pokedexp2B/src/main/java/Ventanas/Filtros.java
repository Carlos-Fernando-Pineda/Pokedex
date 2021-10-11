/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author carlo
 */
public class Filtros extends javax.swing.JFrame {
    DefaultTableModel model;
    Statement estado;
    ResultSet resultadoConsulta, resultadoConsulta2;
    Connection conexion;
    
    void cargar(String valor){
        String [] titulos = {"id","name","forme_name","forme_base_pokemon_id",
            "generation_id","evolution_chain_id","evolution_parent_pokemon_id","evolution_method_id",
            "evolution_parameter","height","weight","species","color","pokemon_shape_id","habitat",
            "gender_rate","capture_rate","base_experience","base_happiness","gen1_internal_id",
            "is_baby","has_gen4_fem_sprite","has_gen4_fem_back_sprite"};
        String [] data = new String[23];
        
        String sql = "Select * from pokemon where CONCAT (name,' ',species,' ',color,' ',habitat,'',id,' ',height,' ',weight,' ',gender_rate,' ',capture_rate,' ',base_experience) LIKE '%"+valor+"%'";
        model = new DefaultTableModel(null,titulos);
        
        try {
            resultadoConsulta = estado.executeQuery(sql);
            while(resultadoConsulta.next()){
                data[0] = resultadoConsulta.getString("id");
                data[1] = resultadoConsulta.getString("name");
                data[2] = resultadoConsulta.getString("forme_name");
                data[3] = resultadoConsulta.getString("forme_base_pokemon_id");
                data[4] = resultadoConsulta.getString("generation_id");
                data[5] = resultadoConsulta.getString("evolution_chain_id");
                data[6] = resultadoConsulta.getString("evolution_parent_pokemon_id");
                data[7] = resultadoConsulta.getString("evolution_method_id");
                data[8] = resultadoConsulta.getString("evolution_parameter");
                data[9] = resultadoConsulta.getString("height");
                data[10] = resultadoConsulta.getString("weight");
                data[11] = resultadoConsulta.getString("species");
                data[12] = resultadoConsulta.getString("color");
                data[13] = resultadoConsulta.getString("pokemon_shape_id");
                data[14] = resultadoConsulta.getString("habitat");
                data[15] = resultadoConsulta.getString("gender_rate");
                data[16] = resultadoConsulta.getString("capture_rate");
                data[17] = resultadoConsulta.getString("base_experience");
                data[18] = resultadoConsulta.getString("base_happiness");
                data[19] = resultadoConsulta.getString("gen1_internal_id");
                data[20] = resultadoConsulta.getString("is_baby");
                data[21] = resultadoConsulta.getString("has_gen4_fem_sprite");
                data[22] = resultadoConsulta.getString("has_gen4_fem_back_sprite");
                model.addRow(data);
            }
            tbPoke.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
        }
    }
    
    

    /**
     * Creates new form Filtros
     */
    public Filtros() {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL";
            conexion = DriverManager.getConnection(JDBC_URL,"root","enanon");
            estado = conexion.createStatement();
            cargar("");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPoke = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        reporter = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbPoke.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tbPoke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbPoke);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BUSCAR");

        search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        reporter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reporter.setText("Reportar");
        reporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporterActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1464, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reporter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reporter)
                    .addComponent(regresar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        cargar(search.getText());
    }//GEN-LAST:event_searchKeyReleased

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        VentanaPokedex Pokedex = new VentanaPokedex();
        Pokedex.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void reporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporterActionPerformed
        // TODO add your handling code here:
        //try{
        //String reportPath = "C:\\Users\\carlo\\OneDrive\\Documentos\\NetBeansProjects\\pokedexp2B\\src\\main\\java\\Ventanas\\report1.jrxml";
        //JRBeanCollectionDataSource data Source = new JRBeanCollectionDataSource(list);
        //JasperReport jr = JasperCompileManager.compileReport(reportPath);
        //JasperPrint jp = JasperFillManager.fillReport(jr, null, conexion);
        //JasperExportManager.exportReportToPdf(jp,"C:\\tmp\\prograII\\Report\\pokemonReporte.pdf");
        //JasperViewer.viewReport(jp);
        //}catch (Exception ex){
            //ex.printStackTrace(System.out);
            //System.out.println("Problema");
        //}
        
        
        
    }//GEN-LAST:event_reporterActionPerformed

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
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filtros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    private javax.swing.JButton reporter;
    private javax.swing.JTextField search;
    private javax.swing.JTable tbPoke;
    // End of variables declaration//GEN-END:variables
}
