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
public class Rook extends Piece {
    
    protected boolean firstMove=true;
    
    public Rook(String id,String path,String pieceColor) {
        setId(id);
        setPath(path);
        setPieceColor(pieceColor);
    }
    
    @Override
    public ArrayList<ChessBoardBlocks> pieceMove(ChessBoardBlocks[][] boardBlock, int x, int y) {
            possibleMoves.clear();
            
            for(int j=y+1; j<8; j++) {
                if(boardBlock[x][j].getPiece()==null) {
                    possibleMoves.add(boardBlock[x][j]);
                } else if(boardBlock[x][j].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x][j]);
                    break;
                } else {
                    break;
                }
            }

            for(int j=y-1; j>=0; j--) {
                if(boardBlock[x][j].getPiece()==null) {
                    possibleMoves.add(boardBlock[x][j]);
                } else if(boardBlock[x][j].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[x][j]);
                    break;
                } else {
                    break;
                }
            }

            for(int i=x-1; i>=0; i--) {
                if(boardBlock[i][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[i][y]);
                } else if(boardBlock[i][y].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[i][y]);
                    break;
                } else {
                    break;
                }
            }

            for(int i=x+1; i<8; i++) {
                if(boardBlock[i][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[i][y]);
                } else if(boardBlock[i][y].getPiece().getPieceColor().equals(opponentPieceColor)) {
                    possibleMoves.add(boardBlock[i][y]);
                    break;
                } else {
                    break;
                }
            }
        
        return possibleMoves;
    }
    
}
