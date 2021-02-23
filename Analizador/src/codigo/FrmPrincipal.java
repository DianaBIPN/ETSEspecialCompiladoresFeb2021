/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
/**
 *
 * @author Marisol
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer (new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true){
            Tokens token = lexer.yylex();
            if(token == null){
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token){
                case Salto: 
                    cont++;
                    resultado += "SALTO " + cont + "\n";
                    break;
                case ent:
                    resultado += "  <Reservada ent>\t" + lexer.lexem + "\n";
                    break;
                 case car:
                    resultado += "  <Reservada car>\t" + lexer.lexem + "\n";
                    break;
                case flot:
                    resultado += "  <Reservada flot>\t" + lexer.lexem + "\n";
                    break;
                case consta:
                    resultado += "  <Reservada consta>\t" + lexer.lexem + "\n";
                    break;
                case AND:
                    resultado += "  <Reservada AND>\t" + lexer.lexem + "\n";
                    break;
                case OR:
                    resultado += "  <Reservada OR>\t" + lexer.lexem + "\n";
                    break;
                case NOT:
                    resultado += "  <Reservada NOT>\t" + lexer.lexem + "\n";
                    break;
                case CONCA:
                    resultado += "  <Reservada CONCA>\t" + lexer.lexem + "\n";
                    break;
                case Para:
                    resultado += "  <Reservada Para>\t" + lexer.lexem + "\n";
                    break;
                case Si:
                    resultado += "  <Reservada Si>\t" + lexer.lexem + "\n";
                    break; 
                case Funcion:
                    resultado += "  <Reservada Funcion>\t" + lexer.lexem + "\n";
                    break;
                case Imprimir:
                    resultado += "  <Reservada Imprimir>\t" + lexer.lexem + "\n";
                    break;
                case Escribir:
                    resultado += "  <Reservada Escribir>\t" + lexer.lexem + "\n";
                    break;
                case Cambiar:
                    resultado += "  <Reservada Cambiar>\t" + lexer.lexem + "\n";
                    break;
                case Igual:
                    resultado += "  <Operacion Igual>\t" + lexer.lexem + "\n";
                    break;
                case Mas:
                    resultado += "  <Operacion Mas>\t" + lexer.lexem + "\n";
                    break;
                case Menos:
                    resultado += "  <Operacion Menos>\t" + lexer.lexem + "\n";
                    break;
                case MayorQ:
                    resultado += "  <Operacion Mayor que>\t" + lexer.lexem + "\n";
                    break;
                case MenorQ:
                    resultado += "  <Operacion Menor que>\t" + lexer.lexem + "\n";
                    break;
                case Parentesis_ap:
                    resultado += "  <Parentesis apertura>\t" + lexer.lexem + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis cierre>\t" + lexer.lexem + "\n";
                    break;
                case Llave_ap:
                    resultado += "  <Llave apertura>\t" + lexer.lexem + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave cierre>\t" + lexer.lexem + "\n";
                    break;
                case Main:
                    resultado += "  <Main>\t\t" + lexer.lexem + "\n";
                    break;
                case Punto_c:
                    resultado += "  <Punto coma>\t\t" + lexer.lexem + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t\t" + lexer.lexem + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexem + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexem + "\n";
                    break;
                case NumeroD:
                    resultado += "  <Numero Decimal>\t" + lexer.lexem + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\t\n";
                    break;
                    
            }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAbrir = new javax.swing.JButton();
        btnLimpiarL = new javax.swing.JButton();
        btnAnalizarL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarS = new javax.swing.JTextArea();
        btnAnalizarS = new javax.swing.JButton();
        btnLimpiarS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Léxico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanel1.setEnabled(false);

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnAbrir.setText("Abrir Archivo");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnLimpiarL.setText("Limpiar");
        btnLimpiarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLActionPerformed(evt);
            }
        });

        btnAnalizarL.setText("Analizar");
        btnAnalizarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrir)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnalizarL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarL)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnLimpiarL)
                    .addComponent(btnAnalizarL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(31, 31, 31))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Sintáctico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtAnalizarS.setColumns(20);
        txtAnalizarS.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarS);

        btnAnalizarS.setText("Analizar");
        btnAnalizarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSActionPerformed(evt);
            }
        });

        btnLimpiarS.setText("Limpiar");
        btnLimpiarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnalizarS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarS)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarS)
                    .addComponent(btnLimpiarS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnAnalizarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSActionPerformed
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalizarS.setText("Analisis realizado correctamente.");
            txtAnalizarS.setForeground(Color.green);
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarS.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarS.setForeground(Color.red);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnalizarSActionPerformed

    private void btnLimpiarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSActionPerformed
        txtAnalizarS.setText(null);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarSActionPerformed

    private void btnAnalizarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnalizarLActionPerformed

    private void btnLimpiarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLActionPerformed
        txtAnalizarLex.setText(null);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarLActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalizarL;
    private javax.swing.JButton btnAnalizarS;
    private javax.swing.JButton btnLimpiarL;
    private javax.swing.JButton btnLimpiarS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarS;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
