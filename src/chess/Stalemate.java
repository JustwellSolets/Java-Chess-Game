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
public class Stalemate {
    
    public Stalemate() {
        java.awt.Window window=new java.awt.Window(new java.awt.Frame());
        window.setSize(400,160);
        window.setLocationRelativeTo(null);
        
        javax.swing.ImageIcon img=new javax.swing.ImageIcon(new javax.swing.ImageIcon(
                "images/others/matchdraw.png")
                .getImage().getScaledInstance(398, 153, java.awt.Image.SCALE_FAST));
        
        javax.swing.JPanel jp=new javax.swing.JPanel();
        jp.setBorder(new javax.swing.border.LineBorder(java.awt.Color.blue));
        javax.swing.JLabel jl=new javax.swing.JLabel(img);
        jl.setSize(400,160);
        window.add(jp);
        jp.setLocation(0, 0);
        jp.add(jl);
        jl.setLocation(0,0);
        window.setVisible(true);
        try
        {
            Thread.sleep(2000);
            window.dispose();
        }catch(InterruptedException ex){
            window.dispose();
        }
    }
    
}
