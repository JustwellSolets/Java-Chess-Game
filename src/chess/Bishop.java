/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static chess.MainFrame.opponentPieceColor;
import java.util.ArrayList;

/**
 *
 * @author jitesh
 */
public class Bishop extends Piece {
    
    public Bishop(String id,String path,String pieceColor) {
        setId(id);
        setPath(path);
        setPieceColor(pieceColor);
    }
    
    @Override
    public ArrayList<ChessBoardBlocks> pieceMove(ChessBoardBlocks[][] boardBlock, int x, int y) {
            possibleMoves.clear();
            
            label1:for(int i=x+1,j=y+1; i<8 && j<8; i++,j++) {
                if(boardBlock[i][j].getPiece()==null) {
                    possibleMoves.add(boardBlock[i][j]);
                } else if(boardBlock[i][j].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[i][j]);
                    break label1;
                } else {
                    break;
                }
            }
            
            label2:for(int i=x-1,j=y-1; i>=0 && j>=0; j--,i--) {
                if(boardBlock[i][j].getPiece()==null) {
                    possibleMoves.add(boardBlock[i][j]);
                } else if(boardBlock[i][j].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[i][j]);
                    break label2;
                } else {
                    break;
                }
            }
            
            label3:for(int i=x+1,j=y-1; j>=0 && i<8; j--,i++) {
                if(boardBlock[i][j].getPiece()==null) {
                    possibleMoves.add(boardBlock[i][j]);
                } else if(boardBlock[i][j].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[i][j]);
                    break label3;
                } else {
                    break;
                }
            }
            
            label4:for(int i=x-1,j=y+1; j<8 && i>=0; j++,i--) {
                if(boardBlock[i][j].getPiece()==null) {
                    possibleMoves.add(boardBlock[i][j]);
                } else if(boardBlock[i][j].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[i][j]);
                    break label4;
                } else {
                    break;
                }
            }
            
        return possibleMoves;
    }
    
}
