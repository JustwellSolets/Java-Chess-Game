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
public class Knight extends Piece {
    
    public Knight(String id,String path,String pieceColor) {
        setId(id);
        setPath(path);
        setPieceColor(pieceColor);
    }
    
    @Override
    public ArrayList<ChessBoardBlocks> pieceMove(ChessBoardBlocks[][] boardBlock, int x, int y) {
        
            possibleMoves.clear();
            
            int _x[]={x+1, x+1, x+2, x+2, x-1, x-1, x-2, x-2};
            int _y[]={y-2, y+2, y-1, y+1, y-2, y+2, y-1, y+1};
            
            for(int i=0; i<8; i++) {
                if(_x[i]>=0 && _x[i]<8 && _y[i]>=0 && _y[i]<8) {
                    if(boardBlock[_x[i]][_y[i]].getPiece()==null) {
                        possibleMoves.add(boardBlock[_x[i]][_y[i]]);
                    } else if(boardBlock[_x[i]][_y[i]].getPiece()!=null
                            && boardBlock[_x[i]][_y[i]].getPiece().getPieceColor().equals(opponentPieceColor)) {
                        possibleMoves.add(boardBlock[_x[i]][_y[i]]);
                    }
                }
            }
        
        return possibleMoves;
    }
    
}
