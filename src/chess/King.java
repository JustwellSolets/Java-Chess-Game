/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static chess.MainFrame.myColor;
import static chess.MainFrame.opponentPieceColor;
import java.util.ArrayList;

/**
 *
 * @author jitesh
 */
public class King extends Piece {
    
    protected int x,y;
    protected boolean firstMove=true;
    
    public King(String id,String path,String pieceColor) {
        setId(id);
        setPath(path);
        setPieceColor(pieceColor);
        
        if(myColor.equals("White")) {
            if(pieceColor.equals("White")) {
                x=7;
                y=4;
            } else {
                x=0;
                y=4;
            }
        } else {
            if(pieceColor.equals("Black")) {
                x=7;
                y=3;
            } else {
                x=0;
                y=3;
            }
        }
        
    }
    
    @Override
    public ArrayList<ChessBoardBlocks> pieceMove(ChessBoardBlocks[][] boardBlock, int x, int y) {
            possibleMoves.clear();
            
            if(x!=7 && y!=7)
                if(boardBlock[x+1][y+1].getPiece()==null) {
                    possibleMoves.add(boardBlock[x+1][y+1]);
                } else if(boardBlock[x+1][y+1].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x+1][y+1]);
                }
            
            if(x!=0 && y!=0)
                if(boardBlock[x-1][y-1].getPiece()==null) {
                    possibleMoves.add(boardBlock[x-1][y-1]);
                } else if(boardBlock[x-1][y-1].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x-1][y-1]);
                }
            
            if(x!=0)
                if(boardBlock[x-1][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[x-1][y]);
                } else if(boardBlock[x-1][y].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x-1][y]);
                }
            
            if(y!=0)
                if(boardBlock[x][y-1].getPiece()==null) {
                    possibleMoves.add(boardBlock[x][y-1]);
                } else if(boardBlock[x][y-1].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x][y-1]);
                }
            
            if(x!=7)
                if(boardBlock[x+1][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[x+1][y]);
                } else if(boardBlock[x+1][y].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x+1][y]);
                }
            
            if(y!=7)
                if(boardBlock[x][y+1].getPiece()==null) {
                    possibleMoves.add(boardBlock[x][y+1]);
                } else if(boardBlock[x][y+1].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x][y+1]);
                }
            
            if(x!=7 && y!=0)
                if(boardBlock[x+1][y-1].getPiece()==null) {
                    possibleMoves.add(boardBlock[x+1][y-1]);
                } else if(boardBlock[x+1][y-1].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x+1][y-1]);
                }
            
            if(x!=0 && y!=7)
                if(boardBlock[x-1][y+1].getPiece()==null) {
                    possibleMoves.add(boardBlock[x-1][y+1]);
                } else if(boardBlock[x-1][y+1].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x-1][y+1]);
                }
        
        return possibleMoves;
    }
    
}
