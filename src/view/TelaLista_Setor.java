/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import beans.Setor;
import controller.Setor_Controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import servicos.FuncoesSetor;
import servicos.Maiusculas;

/**
 *
 * @author linux
 * inicio do desenvolvimento 06/02/2015 
 */
public class TelaLista_Setor extends javax.swing.JInternalFrame {

    /**
     * Creates new form Lista_Setor
     */
    public TelaLista_Setor() {
        initComponents();
        selecionar();
        FuncoesSetor.pesquisar_setor("");
        jb_exlcuir.setEnabled(false);
        jb_alterar.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jt_pesq = new javax.swing.JTextField();
        jt_setor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jb_atender = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_setor = new javax.swing.JTable();
        jb_incluir = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();
        jb_relatorio = new javax.swing.JButton();
        jb_exlcuir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gerenciar Atendimento");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Selecione o setor na tabela ou digite para localizar");

        jt_pesq.setDocument(new Maiusculas());
        jt_pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_pesqKeyReleased(evt);
            }
        });

        jt_setor.setEditable(false);
        jt_setor.setEnabled(false);

        jLabel2.setText("Setor");

        jb_atender.setText("Atender");
        jb_atender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_atenderActionPerformed(evt);
            }
        });

        tabela_setor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_setor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_setorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_setor);
        if (tabela_setor.getColumnModel().getColumnCount() > 0) {
            tabela_setor.getColumnModel().getColumn(0).setMinWidth(50);
            tabela_setor.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela_setor.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jb_incluir.setText("Incluir Setor");
        jb_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_incluirActionPerformed(evt);
            }
        });

        jb_alterar.setText("Alterar Setor");
        jb_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_alterarActionPerformed(evt);
            }
        });

        jb_relatorio.setText("Relatório");
        jb_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_relatorioActionPerformed(evt);
            }
        });

        jb_exlcuir.setText("Excluir");
        jb_exlcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_exlcuirActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/atualizar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jb_incluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_relatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_exlcuir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jt_setor, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb_atender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 23, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_atender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_alterar)
                    .addComponent(jb_incluir)
                    .addComponent(jb_relatorio)
                    .addComponent(jb_exlcuir))
                .addGap(179, 179, 179))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_setorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_setorMouseClicked
       obterLinha();
       jb_exlcuir.setEnabled(true);
       jb_alterar.setEnabled(true);
    }//GEN-LAST:event_tabela_setorMouseClicked

    private void jb_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_incluirActionPerformed
        telaCadastrar();
    }//GEN-LAST:event_jb_incluirActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
       telaAlterar();
       
    }//GEN-LAST:event_jb_alterarActionPerformed

    private void jb_atenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_atenderActionPerformed
        if(codigoSetor == 0){
            JOptionPane.showMessageDialog(null, "Selecione um setor na tabela abaixo");
        }
        else{
            atender();
        }
        
    }//GEN-LAST:event_jb_atenderActionPerformed

    private void jt_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_pesqKeyReleased
        pesquisar();
        desativarBotoes();
    }//GEN-LAST:event_jt_pesqKeyReleased

    private void jb_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_relatorioActionPerformed
        telaRelatorio();
    }//GEN-LAST:event_jb_relatorioActionPerformed

    private void jb_exlcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_exlcuirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Você está certo disso?","Excluir",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(opcao == JOptionPane.YES_OPTION){
            excluir();
            
        }
        
        
    }//GEN-LAST:event_jb_exlcuirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       FuncoesSetor.pesquisar_setor("");
       jt_setor.setText("");
       codigoSetor=0;
       jb_alterar.setEnabled(false);
       jb_exlcuir.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed
private void excluir(){
    Setor_Controller sc = new Setor_Controller();
    Setor s = new Setor();
    s.setCodigo(codigoSetor);
    boolean teste = sc.excluir(s);
    if(teste){
        JOptionPane.showMessageDialog(null, "Certa resposta! Excluido com sucesso");
        FuncoesSetor.pesquisar_setor("");
        desativarBotoes();
    }else{
        JOptionPane.showMessageDialog(null, "Não foi possível excluir, paciente de alta!");
    }
}
    
    private void pesquisar(){
    FuncoesSetor.pesquisar_setor(jt_pesq.getText().trim());
}
    private void atender(){
    Date dateAtual = new Date();
    String data = formata_br.format(dateAtual);
    if(qtdeSetor == 0){
               Setor s = new Setor();
               s.setQtde(qtdeSetor+1);
               s.setCodigo(codigoSetor);
               s.setDataAtend(dateAtual);
               Setor_Controller sc = new Setor_Controller();
               boolean teste = sc.atender(s);
               if(teste){
                   JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
                 }   
    }else{
        Setor s = new Setor();
               s.setQtde(qtdeSetor+1);
               s.setCodigo(codigoSetor);
               s.setDataAtend(dateAtual);
               Setor_Controller sc = new Setor_Controller();
               boolean teste = sc.atenderSomar(s);
               if(teste){
                   JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
                 }   
    }
    
    jt_setor.setText("");
    qtdeSetor = 0;
    codigoSetor = 0;
    
}
    
    private void obterLinha(){
    int linha = tabela_setor.getSelectedRow();
    if(linha >=0 ){
        Object objCodigo = tabela_setor.getValueAt(linha, 0);
        Object objSetor = tabela_setor.getValueAt(linha, 1);
        codigoSetor = Integer.parseInt(objCodigo.toString());
        String setorStr = String.valueOf(objSetor);
        jt_setor.setText(setorStr);
        selecionar();
    }
}

private void selecionar(){
    Date dateAtual = new Date();
    String data = formata_br.format(dateAtual);
    System.out.println("Data: "+data);
    
    Setor_Controller sc = new Setor_Controller();
    try{
        qtdeSetor = sc.recuperarQtde(data, codigoSetor);
        System.out.println("Setor: "+jt_setor.getText()+" Qtde: "+qtdeSetor);
    }catch(Exception e){
        System.out.println("Setor: "+jt_setor.getText()+" Qtde: "+qtdeSetor);
    }
    
    
    
}

private void telaAlterar(){
    if(codigoSetor > 0){
        TelaAlterarSetor tASetor = new TelaAlterarSetor(codigoSetor);
        TelaPrincipal.desktop.add(tASetor);
        tASetor.show();
        desativarBotoes();
    }
}
private void desativarBotoes(){
    jb_alterar.setEnabled(false);
    jb_exlcuir.setEnabled(false);
    jt_setor.setText("");
    codigoSetor = 0;
    
}
private void ativarBotoes(){
    jb_alterar.setEnabled(true);
    jb_exlcuir.setEnabled(true);
    
    
}


private void telaRelatorio(){
    
        TelaRelatorioAtendimento tASetor = new TelaRelatorioAtendimento();
        TelaPrincipal.desktop.add(tASetor);
        tASetor.show();
    
}
private void telaCadastrar(){
    TelaCadSetor tCSetor = new TelaCadSetor();
    TelaPrincipal.desktop.add(tCSetor);
    tCSetor.show();
    
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_atender;
    private javax.swing.JButton jb_exlcuir;
    private javax.swing.JButton jb_incluir;
    private javax.swing.JButton jb_relatorio;
    private javax.swing.JTextField jt_pesq;
    private javax.swing.JTextField jt_setor;
    public static javax.swing.JTable tabela_setor;
    // End of variables declaration//GEN-END:variables
    int codigoSetor = 0;
    int qtdeSetor = 0;
    private final SimpleDateFormat formata_br = new SimpleDateFormat("dd/MM/yyyy");
}
