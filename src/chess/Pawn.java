/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static chess.MainFrame.myColor;
import static chess.MainFrame.opponentColor;
import java.util.ArrayList;

/**
 *
 * @author jitesh
 */
public class Pawn extends Piece{
    
    public Pawn(String id,String path,String pieceColor) {
        setId(id);
        setPath(path);
        setPieceColor(pieceColor);
    }
    
    @Override
    public ArrayList<ChessBoardBlocks> pieceMove(ChessBoardBlocks[][] boardBlock, int x, int y) {
        if(getPieceColor().equals(myColor)) {
            possibleMoves.clear();
            if(x==6) {
                if(boardBlock[x-1][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[x-1][y]);
                    if(boardBlock[x-2][y].getPiece()==null) {
                        possibleMoves.add(boardBlock[x-2][y]);
                    }
                }
            } else if(x<6 && x>1) {
                if(boardBlock[x-1][y].getPiece()==null)
                    possibleMoves.add(boardBlock[x-1][y]);
            } else if(x==1) {
                if(boardBlock[x-1][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[x-1][y]);
                    //write pawn promotion code here
                }
            }
            
            if(y==0) {
                if(boardBlock[x-1][y+1].getPiece()!=null && boardBlock[x-1][y+1].getPiece().getPieceColor().equals(opponentColor)) {
                    possibleMoves.add(boardBlock[x-1][y+1]);
                }
            } else if(y==7) {
                if(boardBlock[x-1][y-1].getPiece()!=null && boardBlock[x-1][y-1].getPiece().getPieceColor().equals(opponentColor)) {
                    possibleMoves.add(boardBlock[x-1][y-1]);
                }
            } else if(y<7 && y>0) {
                if(boardBlock[x-1][y+1].getPiece()!=null && boardBlock[x-1][y+1].getPiece().getPieceColor().equals(opponentColor)) {
                    possibleMoves.add(boardBlock[x-1][y+1]);
                }
                if(boardBlock[x-1][y-1].getPiece()!=null && boardBlock[x-1][y-1].getPiece().getPieceColor().equals(opponentColor)) {
                    possibleMoves.add(boardBlock[x-1][y-1]);
                }
            }
        } else { //opponent
            possibleMoves.clear();
            if(x==1) {
                if(boardBlock[x+1][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[x+1][y]);
                    if(boardBlock[x+2][y].getPiece()==null) {
                        possibleMoves.add(boardBlock[x+2][y]);
                    }
                }
            } else if(x<6 && x>1) {
                if(boardBlock[x+1][y].getPiece()==null)
                    possibleMoves.add(boardBlock[x+1][y]);
            } else if(x==6) {
                if(boardBlock[x+1][y].getPiece()==null) {
                    possibleMoves.add(boardBlock[x+1][y]);
                    //write pawn promotion code here
                }
            }
            
            if(y==0) {
                if(boardBlock[x+1][y+1].getPiece()!=null && boardBlock[x+1][y+1].getPiece().getPieceColor().equals(myColor)) {
                    possibleMoves.add(boardBlock[x+1][y+1]);
                }
            } else if(y==7) {
                if(boardBlock[x+1][y-1].getPiece()!=null && boardBlock[x+1][y-1].getPiece().getPieceColor().equals(myColor)) {
                    possibleMoves.add(boardBlock[x+1][y-1]);
                }
            } else if(y<7 && y>0) {
                if(boardBlock[x+1][y+1].getPiece()!=null && boardBlock[x+1][y+1].getPiece().getPieceColor().equals(myColor)) {
                    possibleMoves.add(boardBlock[x+1][y+1]);
                }
                if(boardBlock[x+1][y-1].getPiece()!=null && boardBlock[x+1][y-1].getPiece().getPieceColor().equals(myColor)) {
                    possibleMoves.add(boardBlock[x+1][y-1]);
                }
            }
        }
        return possibleMoves;
    }
    
}
