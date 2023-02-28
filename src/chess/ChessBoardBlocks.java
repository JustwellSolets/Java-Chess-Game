package chess;

import static chess.MainFrame.selectColor;
import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jitesh
 */
public class ChessBoardBlocks extends JPanel{
    
    public int x,y;
    private Piece P;
    private JLabel iconBlock;
    private boolean isSelected=false, highlighted=false;
    
    public ChessBoardBlocks(int x, int y, Piece p) {
        this.setOpaque(true);
        this.x=x;
        this.y=y;
        
        this.setLayout(new BorderLayout());
        
        if(p!=null) {
            setPiece(p);
        }
        
    }
    
    protected void setPiece(Piece p) {
        this.P=p;
        URL imgpath=this.getClass().getResource(p.getPath());
        iconBlock=new JLabel(new javax.swing.ImageIcon(imgpath));
        this.add(iconBlock);
    }
    
    protected void removePiece() {
        this.P=null;
        this.remove(iconBlock);
    }
    
    protected Piece getPiece() {
        return this.P;
    }
    
    protected void select() {
//        tempSelectColor=this.getBackground();
//        this.setBackground(selectColor);
        this.setBorder(BorderFactory.createLineBorder(selectColor, 5));
        setSelected();
    }
    
    protected void deSelect() {
//        this.setBackground(tempSelectColor);
        this.setBorder(null);
        setDeselected();
    }
    
    protected void setSelected() {
        this.isSelected=true;
    }
    
    protected boolean getIsSelected() {
        return this.isSelected;
    }
    
    protected void setDeselected() {
        this.isSelected=false;
    }
    
    protected void setHightlighted() {
        this.highlighted=true;
    }
    
    protected void setUnhightlighted() {
        this.highlighted=false;
    }
    
    protected boolean getHightlighted() {
        return this.highlighted;
    }
    
}
