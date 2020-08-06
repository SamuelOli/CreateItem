package createItem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Menu extends javax.swing.JFrame {

    public static ArrayList<ItemEquipable> itemsEquipable = new ArrayList<ItemEquipable>();
    public static ArrayList<ItemConsumable> itemsConsumable = new ArrayList<ItemConsumable>();
    /**
     * Creates new form Menu2
     */
     DefaultTableModel modEquipable;
     DefaultTableModel modConsumable;
    
    public Menu() {
        initComponents();
        loadEquipable(); 
        loadConsumable();                    
    }

    public void addItemEquipable(ItemEquipable newItem){
        modEquipable = (DefaultTableModel)tblEquipavel.getModel();
        modEquipable.addRow(new String[]{newItem.getName(),
                String.valueOf(newItem.getInitialPower()),
                String.valueOf(newItem.getPower()),
                newItem.getRarityItem().getRarity(),
                newItem.getMaterialType().getMaterial()});
    }
    
    public void addItemConsumable(ItemConsumable newItem){
        modConsumable = (DefaultTableModel)tblConsumivel.getModel();
        modConsumable.addRow(new String[]{newItem.getName(),
                String.valueOf(newItem.getInitialPower()),
                String.valueOf(newItem.getStack())});
    }

    public void newEquipable(ItemEquipable newItem){
        itemsEquipable.add(newItem);
        addItemEquipable(newItem);
        saveEquipable(newItem);
    }
    public void newConsumable(ItemConsumable newItem){
        itemsConsumable.add(newItem);
        addItemConsumable(newItem);
        saveConsumable(newItem);
    }
    
    public void saveEquipable(ItemEquipable newItem){
        String arquivo = "ItemsEquipables.txt";
        String separador = ";";
        
         try {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(newItem.getName());
            bw.write(separador);
            bw.write(String.valueOf(newItem.getInitialPower()));
            bw.write(separador);
            bw.write(String.valueOf(newItem.getPower()));
            bw.write(separador);
            bw.write(newItem.getMaterialType().name()); 
            bw.write(separador);
            bw.write(newItem.getRarityItem().name());
            bw.newLine();

            bw.close();
            fw.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!\n Arquivo!");
        }
                    
    }
    
    public void loadEquipable(){
        
        String arquivo = "ItemsEquipables.txt";
        String separador = ";";
        
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr); 

            while (br.ready()) {
                String linha = br.readLine();
                String[] load = linha.split(";");
                ItemEquipable newItem = new ItemEquipable();
                newItem.setName(load[0]);
                newItem.setInitialPower(Float.parseFloat(load[1]));
                
                newItem.setMaterial(MaterialType.valueOf(load[3]));
                newItem.setRarity(RarityItem.valueOf(load[4]));
                
                newItem.setPower(Float.parseFloat(load[2]));
                
                itemsEquipable.add(newItem);
                addItemEquipable(newItem);               
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERRO Load Equipable");
        }
    }
    
    public void saveConsumable(ItemConsumable newItem){
        String arquivo = "ItemsConsumable.txt";
        String separador = ";";
        
         try {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(newItem.getName());
            bw.write(separador);
            bw.write(String.valueOf(newItem.getInitialPower()));
            bw.write(separador);
            bw.write(String.valueOf(newItem.getPower()));
            bw.write(separador);
            bw.write(String.valueOf(newItem.getStack()));
            bw.newLine();

            bw.close();
            fw.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro SAVE");
        }
                    
    }
    
    public void loadConsumable(){
        
        String arquivo = "ItemsConsumable.txt";
        String separador = ";";
               
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr); 
            
            while (br.ready()) {
                String linha = br.readLine();
                String[] load = linha.split(";");
                ItemConsumable newItem = new ItemConsumable();
                newItem.setName(load[0]);
                newItem.setInitialPower(Float.parseFloat(load[1]));
                
                newItem.setStack(Integer.parseInt(load[3]));
                
                
                newItem.setPower(Float.parseFloat(load[2]));
                
                itemsConsumable.add(newItem);
                addItemConsumable(newItem);
                
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERRO Consumable Load");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblConsumivel = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEquipavel = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setText("Novo Item Consumivel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Novo Item Equipavel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblConsumivel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Pooder", "Quantidae"
            }
        ));
        jScrollPane4.setViewportView(tblConsumivel);

        tblEquipavel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Poder inicial", "Poder", "Raridade", "Material"
            }
        ));
        jScrollPane5.setViewportView(tblEquipavel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(280, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(30, 30, 30))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(73, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CreateConsumable consumable = new CreateConsumable();
        consumable.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CreateEquipable equipable = new CreateEquipable();
        equipable.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblConsumivel;
    private javax.swing.JTable tblEquipavel;
    // End of variables declaration//GEN-END:variables
}
