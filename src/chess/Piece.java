/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author jitesh
 */
public abstract class Piece implements Cloneable{
    
    private String pieceColor,id,path;
    protected ArrayList<ChessBoardBlocks> possibleMoves = new ArrayList<ChessBoardBlocks>();
    
    public abstract ArrayList<ChessBoardBlocks> pieceMove(ChessBoardBlocks[][] boardBlock,int x, int y);
    
    public void setId(String id) {
        this.id=id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setPath(String path) {
        this.path=path;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public void setPieceColor(String pieceColor) {
        this.pieceColor=pieceColor;
    }
    
    public String getPieceColor() {
        return this.pieceColor;
    }
    
    public Piece getCopy() throws CloneNotSupportedException {
        return (Piece) this.clone();
    }
    
}
