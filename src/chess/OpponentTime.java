/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author jitesh
 */
public class OpponentTime extends MainFrame implements Runnable {
    
    Thread th;
    
    public OpponentTime() {
        th=new Thread();
        th.start();
    }
    
    @Override
    public void run() {
        int totalsecond=1800;
        while(totalsecond!=0) {
            int minuts=1800/60;
            int seconds=1800%60;
            super.opponentTime.setText(minuts+":"+seconds);
            totalsecond--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
        javax.swing.JOptionPane.showMessageDialog(null, "Opponent lose the game.", "You won",
                javax.swing.JOptionPane.OK_OPTION);
        System.exit(0);
    }
    
}
