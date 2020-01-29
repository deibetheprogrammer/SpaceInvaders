package Spaceinvaders;

/**
 *
 * @author Tyler C
 */
public class Space_Invaders_Level_1 extends javax.swing.JFrame {

    public Space_Invaders_Level_1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SpaceShip1Level1 = new javax.swing.JLabel();
        SpaceShip2Level1 = new javax.swing.JLabel();
        SpaceShip3Level1 = new javax.swing.JLabel();
        Scoreboard = new javax.swing.JLabel();
        Block1 = new javax.swing.JLabel();
        Block2 = new javax.swing.JLabel();
        Block3 = new javax.swing.JLabel();
        Block4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BlackbackGroundLevel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(SpaceShip1Level1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 60, 40));
        jPanel1.add(SpaceShip2Level1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 60, 40));
        jPanel1.add(SpaceShip3Level1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 60, 40));

        Scoreboard.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Scoreboard.setForeground(new java.awt.Color(255, 255, 255));
        Scoreboard.setText("Scoreboard:");
        jPanel1.add(Scoreboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(Block1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));
        jPanel1.add(Block2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));
        jPanel1.add(Block3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));
        jPanel1.add(Block4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 40, 40));
        jPanel1.add(BlackbackGroundLevel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Space_Invaders_Level_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Space_Invaders_Level_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Space_Invaders_Level_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Space_Invaders_Level_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Space_Invaders_Level_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BlackbackGroundLevel1;
    private javax.swing.JLabel Block1;
    private javax.swing.JLabel Block2;
    private javax.swing.JLabel Block3;
    private javax.swing.JLabel Block4;
    private javax.swing.JLabel Scoreboard;
    private javax.swing.JLabel SpaceShip1Level1;
    private javax.swing.JLabel SpaceShip2Level1;
    private javax.swing.JLabel SpaceShip3Level1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}