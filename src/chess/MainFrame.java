/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

//<editor-fold defaultstate="collapsed" desc="Imports..">
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
//</editor-fold>

/**
 *
 * @author jitesh
 */
public class MainFrame extends JFrame implements MouseListener{

    //<editor-fold defaultstate="collapsed" desc="Variable Declaration">
    protected static boolean gameStarted=false,gameOver=true;
    protected static String promotedTo;
    protected static String myPieceColor, opponentPieceColor, gameType, chance="White",
                            chessBoardType="Default", chessPiecesType="Default",
                            oldPieceType, oldBoardType, myColor, opponentColor;
    protected static Color selectColor;
    protected JLabel myTime, opponentTime;
    
    private int whiteMovesWithoutPieceCaptureAndPawnMove, 
                        blackMovesWithoutPieceCaptureAndPawnMove;
    private boolean pieceCaptured=false, isEnpassantPossible=false;
    private Color blackKingBkColor, whiteKingBkColor, checkColor, moveColor,
                    moveToBkgdColor, focusColor, highlightColor;
    private JPanel mainPanel, chessBoard, me, opponent, myPiecesDead, opponentPiecesDead;
    private JLabel youLabel, opponentLabel;
    private JMenuBar menuBar=new JMenuBar();
    private JMenu newGameMenu=new JMenu("New Game");
    private JMenu optionMenu=new JMenu("Options");
    private JMenu helpMenu=new JMenu("Help");
    private JMenuItem localNewGame=new JMenuItem("Local New Game");
    private JMenuItem serverNewGame=new JMenuItem("Server New Game");
    private JMenuItem changeBoard=new JMenuItem("Change Chess Board");
    private JMenuItem changePieces=new JMenuItem("Change Chess Pieces");
    private JMenuItem rules=new JMenuItem("Rules");
    private ChessBoardBlocks[][] chessBoardBlocks=new ChessBoardBlocks[8][8];
    private ChessBoardBlocks newClick, previousClick, tempNewClick, tempPreviousClick, 
                            kingOldPosition;//blackKingOldPosition, whiteKingOldPosition;
    private ArrayList<ChessBoardBlocks> destinationList=new ArrayList<ChessBoardBlocks>();
    private ArrayList<ChessBoardBlocks> canMove=new ArrayList<ChessBoardBlocks>();
    private ArrayList<ChessBoardBlocks> checkFrom=new ArrayList<ChessBoardBlocks>();
    private ArrayList<JLabel> deadPiece=new ArrayList<JLabel>();
    
    private Bishop wb1,wb2,bb1,bb2;
    private King wk,bk;
    private Knight wk1,wk2,bk1,bk2;
    private Pawn wp[]=new Pawn[8],bp[]=new Pawn[8];
    private Queen wq,bq;
    private Rook wr1,wr2,br1,br2;
    //</editor-fold>
    
    public MainFrame() {
        //<editor-fold defaultstate="collapsed">
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setSize(1200, 740);
        this.setMinimumSize(new Dimension(1200, 740));
        this.setTitle("Chess");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(this.getClass().getResource("images/logo.jpg")).getImage());
        
        menuBar.add(newGameMenu);
        menuBar.add(optionMenu);
        menuBar.add(helpMenu);
        
        newGameMenu.add(localNewGame);
        newGameMenu.add(serverNewGame);
        
        optionMenu.add(changeBoard);
        optionMenu.add(changePieces);
        
        helpMenu.add(rules);
        
        localNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                deadPiece.clear();
                chessBoard.removeAll();
                myPiecesDead.removeAll();
                opponentPiecesDead.removeAll();
                repaint();
                
                myPieceColor="White";
                opponentPieceColor="Black";
                myColor="White";
                opponentColor="Black";
                
                opponentTime.setText("");
                chance="White";
                
                gameType="Local";
                gameStarted=true;
                gameOver=false;
                initPieces();
                drawChessBoard();
//                new myTime();
//                new opponentTime();
                myTime.setText("Your's Move");
                //new ShowFirstMove();
                if(myColor.equals("White")) {
                    JOptionPane.showMessageDialog(null, "First move is your's.");
                } else {
                    JOptionPane.showMessageDialog(null, "First move is opponent's.");
                }
                //local new game code
            }

        });
        
        serverNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deadPiece.clear();
                chessBoard.removeAll();
                myPiecesDead.removeAll();
                opponentPiecesDead.removeAll();
                repaint();
                
                autoChoosePieceColor();
                gameType="Server";
                gameStarted=true;
                gameOver=false;
                initPieces();
                drawChessBoard();
                chance="White";
                //server new game code
            }

        });
        serverNewGame.setEnabled(false);

        changeBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change board code
                new ChangeBoard();
                if(gameStarted)
                    setBoardBlocksColor();
            }

        });
        
        changePieces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change pieces code
                oldPieceType=chessPiecesType;
                new ChangePieces();
                if(gameStarted && !oldPieceType.equals(chessPiecesType))
                    updateChessPieces();
            }

        });
        
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Rules();
            }

        });

        this.setJMenuBar(menuBar);
        
        mainPanel=new JPanel();
        mainPanel.setBackground(new Color(230, 230, 230));
        this.add(mainPanel);
        
        me=new JPanel();
        me.setPreferredSize(new Dimension(252, 84*8));
        me.setMaximumSize(new Dimension(252, 84*8));
        me.setMinimumSize(new Dimension(252, 84*8));
        me.setBorder(LineBorder.createBlackLineBorder());
        youLabel=new JLabel("You");
        youLabel.setFont(new java.awt.Font("FreeSerif", 0, 18));
        me.add(youLabel,BorderLayout.EAST);
        myTime=new JLabel();
        myTime.setPreferredSize(new Dimension(240,30));
        myTime.setMaximumSize(new Dimension(240,30));
        myTime.setMinimumSize(new Dimension(240,30));
        myTime.setFont(new java.awt.Font("FreeSerif", 0, 18));
//        myTime.setBorder(LineBorder.createBlackLineBorder());
        myTime.setForeground(Color.RED);
        myTime.setHorizontalAlignment(SwingConstants.CENTER);
        me.add(myTime);
        opponentPiecesDead=new JPanel(new GridLayout(5, 3));
        opponentPiecesDead.setPreferredSize(new Dimension(240,600));
        opponentPiecesDead.setMaximumSize(new Dimension(240,600));
        opponentPiecesDead.setMinimumSize(new Dimension(240,600));
//        opponentPiecesDead.setBorder(LineBorder.createBlackLineBorder());
        me.add(opponentPiecesDead, BorderLayout.CENTER);
        mainPanel.add(me);
        
        chessBoard=new JPanel();
        chessBoard.setBorder(LineBorder.createGrayLineBorder());
        chessBoard.setPreferredSize(new Dimension(84*8, 84*8));
        chessBoard.setMaximumSize(new Dimension(84*8, 84*8));
        chessBoard.setMinimumSize(new Dimension(84*8, 84*8));
        chessBoard.setBackground(new Color(180, 180, 180));
        mainPanel.add(chessBoard);
        
        opponent=new JPanel();
        opponent.setBorder(LineBorder.createBlackLineBorder());
        opponent.setPreferredSize(new Dimension(252, 84*8));
        opponent.setMaximumSize(new Dimension(252, 84*8));
        opponent.setMinimumSize(new Dimension(252, 84*8));
        opponentLabel=new JLabel("Opponent");
        opponentLabel.setFont(new java.awt.Font("FreeSerif", 0, 18));
        opponent.add(opponentLabel, BorderLayout.EAST);
        opponentTime=new JLabel();
        opponentTime.setPreferredSize(new Dimension(240,30));
        opponentTime.setMaximumSize(new Dimension(240,30));
        opponentTime.setMinimumSize(new Dimension(240,30));
        opponentTime.setFont(new java.awt.Font("FreeSerif", 0, 18));
//        opponentTime.setBorder(LineBorder.createBlackLineBorder());
        opponentTime.setForeground(Color.RED);
        opponentTime.setHorizontalAlignment(SwingConstants.CENTER);
        opponent.add(opponentTime);
        myPiecesDead=new JPanel(new GridLayout(5, 3));
        myPiecesDead.setPreferredSize(new Dimension(240,600));
        myPiecesDead.setMaximumSize(new Dimension(240,600));
        myPiecesDead.setMinimumSize(new Dimension(240,600));
//        myPiecesDead.setBorder(LineBorder.createBlackLineBorder());
        opponent.add(myPiecesDead, BorderLayout.CENTER);
        mainPanel.add(opponent);
        //</editor-fold>
    }
    
    public void updateChessPieces() {
        //<editor-fold defaultstate="collapsed">
        
        for(int i=0; i<7; i++) {
            wp[i].setPath(wp[i].getPath().replace(oldPieceType, chessPiecesType));
            bp[i].setPath(bp[i].getPath().replace(oldPieceType, chessPiecesType));
        }
        
        wr1.setPath(wr1.getPath().replace(oldPieceType, chessPiecesType));
        br1.setPath(br1.getPath().replace(oldPieceType, chessPiecesType));
        wr2.setPath(wr2.getPath().replace(oldPieceType, chessPiecesType));
        br2.setPath(br2.getPath().replace(oldPieceType, chessPiecesType));
        
        wb1.setPath(wb1.getPath().replace(oldPieceType, chessPiecesType));
        bb1.setPath(bb1.getPath().replace(oldPieceType, chessPiecesType));
        wb2.setPath(wb2.getPath().replace(oldPieceType, chessPiecesType));
        bb2.setPath(bb2.getPath().replace(oldPieceType, chessPiecesType));
        
        wk1.setPath(wk1.getPath().replace(oldPieceType, chessPiecesType));
        bk1.setPath(bk1.getPath().replace(oldPieceType, chessPiecesType));
        wk2.setPath(wk2.getPath().replace(oldPieceType, chessPiecesType));
        bk2.setPath(bk2.getPath().replace(oldPieceType, chessPiecesType));
        
        wq.setPath(wq.getPath().replace(oldPieceType, chessPiecesType));
        bq.setPath(bq.getPath().replace(oldPieceType, chessPiecesType));
        
        wk.setPath(wk.getPath().replace(oldPieceType, chessPiecesType));
        bk.setPath(bk.getPath().replace(oldPieceType, chessPiecesType));
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessBoardBlocks[i][j].getPiece()!=null){
                    Piece tempPiece=chessBoardBlocks[i][j].getPiece();
                    String str=tempPiece.getPath().replace(oldPieceType, chessPiecesType);
                    tempPiece.setPath(str);
                    chessBoardBlocks[i][j].removePiece();
                    chessBoardBlocks[i][j].setPiece(tempPiece);
                }
            }
        }
        
        if(!deadPiece.isEmpty()) {
            myPiecesDead.removeAll();
            opponentPiecesDead.removeAll();
            Piece p=null;
            String str;
            JLabel jlabel;
            for(JLabel jl: deadPiece) {
                str=jl.getIcon().toString().replace(oldPieceType, chessPiecesType);
                if(str.contains("white")) {
                    if(str.endsWith("pawn.png")) {
                        try {
                            p=wp[0].getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("rook.png")) {
                        try {
                            p=wr1.getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("bishop.png")) {
                        try {
                            p=wb1.getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("knight.png")) {
                        try {
                            p=wk1.getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("queen.png")) {
                        try {
                            p=wq.getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    }
                } else {
                    if(str.endsWith("pawn.png")) {
                        try {
                            p=bp[0].getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("rook.png")) {
                        try {
                            p=br1.getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("bishop.png")) {
                        try {
                            p=bb1.getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("knight.png")) {
                        try {
                            p=bk1.getCopy();
                        } catch (CloneNotSupportedException ex) {}
                    } else if(str.endsWith("queen.png")) {
                        try {
                            p=bq.getCopy();
                        } catch (CloneNotSupportedException ex) {
                        ex.printStackTrace();}
                    }
                }
                
                str=p.getPath().replace(oldPieceType, chessPiecesType);
                URL imgpath=this.getClass().getResource(str);
                jlabel=new JLabel(new javax.swing.ImageIcon(imgpath));
                if(str.contains(myColor.toLowerCase())) {
                    myPiecesDead.add(jlabel);
                } else {
                    opponentPiecesDead.add(jlabel);
                }
            }
        }
        repaint();
        //</editor-fold>
    }
    
    private void initPieces() {
        //<editor-fold defaultstate="collapsed">
        for(int i=0;i<8;i++) {
            wp[i]=new Pawn("wp"+i,"images/pieces/"+chessPiecesType+"/white/pawn.png","White");
            bp[i]=new Pawn("bp"+i,"images/pieces/"+chessPiecesType+"/black/pawn.png","Black");
        }
        
        wr1=new Rook("wr1","images/pieces/"+chessPiecesType+"/white/rook.png","White");
        wr2=new Rook("wr2","images/pieces/"+chessPiecesType+"/white/rook.png","White");
        br1=new Rook("br1","images/pieces/"+chessPiecesType+"/black/rook.png","Black");
        br2=new Rook("br2","images/pieces/"+chessPiecesType+"/black/rook.png","Black");

        wk1=new Knight("wk1","images/pieces/"+chessPiecesType+"/white/knight.png","White");
        wk2=new Knight("wk2","images/pieces/"+chessPiecesType+"/white/knight.png","White");
        bk1=new Knight("bk1","images/pieces/"+chessPiecesType+"/black/knight.png","Black");
        bk2=new Knight("bk2","images/pieces/"+chessPiecesType+"/black/knight.png","Black");
        
        wb1=new Bishop("wb1","images/pieces/"+chessPiecesType+"/white/bishop.png","White");
        wb2=new Bishop("wb2","images/pieces/"+chessPiecesType+"/white/bishop.png","White");
        bb1=new Bishop("bb1","images/pieces/"+chessPiecesType+"/black/bishop.png","Black");
        bb2=new Bishop("bb2","images/pieces/"+chessPiecesType+"/black/bishop.png","Black");

        wk=new King("wk","images/pieces/"+chessPiecesType+"/white/king.png","White");
        bk=new King("bk","images/pieces/"+chessPiecesType+"/black/king.png","Black");

        wq=new Queen("wq","images/pieces/"+chessPiecesType+"/white/queen.png","White");
        bq=new Queen("bq","images/pieces/"+chessPiecesType+"/black/queen.png","Black");
        //</editor-fold>
    }
    
    private void autoChoosePieceColor() {
        //<editor-fold defaultstate="collapsed">
        java.util.Random random=new java.util.Random();
        if(random.nextInt(1000)%2==0) {
            myPieceColor="White";
            opponentPieceColor="Black";
            myColor="White";
            opponentColor="Black";
        } else {
            myPieceColor="Black";
            opponentPieceColor="White";
            myColor="Black";
            opponentColor="White";
        }
        //</editor-fold>
    }
    
    private void drawChessBoard() {
        //<editor-fold defaultstate="collapsed">
        Piece p;
        if(myColor.equals("White")) {
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    p=null;
                    switch (i) {
                        case 0:
                            switch (j) {
                                case 0:
                                    p=br1;
                                    break;
                                case 1:
                                    p=bk1;
                                    break;
                                case 2:
                                    p=bb1;
                                    break;
                                case 3:
                                    p=bq;
                                    break;
                                case 4:
                                    p=bk;
                                    break;
                                case 5:
                                    p=bb2;
                                    break;
                                case 6:
                                    p=bk2;
                                    break;
                                case 7:
                                    p=br2;
                                    break;
                                default:
                                    break;
                            }   break;
                        case 1:
                            p=bp[j];
                            break;
                        case 6:
                            p=wp[j];
                            break;
                        case 7:
                            switch (j) {
                                case 0:
                                    p=wr1;
                                    break;
                                case 1:
                                    p=wk1;
                                    break;
                                case 2:
                                    p=wb1;
                                    break;
                                case 3:
                                    p=wq;
                                    break;
                                case 4:
                                    p=wk;
                                    break;
                                case 5:
                                    p=wb2;
                                    break;
                                case 6:
                                    p=wk2;
                                    break;
                                case 7:
                                    p=wr2;
                                    break;
                                default:
                                    break;
                            }   break;
                        default:
                            break;
                    }
                    chessBoardBlocks[i][j]=new ChessBoardBlocks(i,j,p);
                    chessBoardBlocks[i][j].addMouseListener(this);
                    chessBoard.add(chessBoardBlocks[i][j]);
                }
            }
            chessBoard.setLayout(new GridLayout(8,8));
        } else {
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    p=null;
                    switch (i) {
                        case 0:
                            switch (j) {
                                case 0:
                                    p=wr1;
                                    break;
                                case 1:
                                    p=wk1;
                                    break;
                                case 2:
                                    p=wb1;
                                    break;
                                case 3:
                                    p=wk;
                                    break;
                                case 4:
                                    p=wq;
                                    break;
                                case 5:
                                    p=wb2;
                                    break;
                                case 6:
                                    p=wk2;
                                    break;
                                case 7:
                                    p=wr2;
                                    break;
                                default:
                                    break;
                            }   break;
                        case 1:
                            p=wp[j];
                            break;
                        case 6:
                            p=bp[j];
                            break;
                        case 7:
                            switch (j) {
                                case 0:
                                    p=br1;
                                    break;
                                case 1:
                                    p=bk1;
                                    break;
                                case 2:
                                    p=bb1;
                                    break;
                                case 3:
                                    p=bk;
                                    break;
                                case 4:
                                    p=bq;
                                    break;
                                case 5:
                                    p=bb2;
                                    break;
                                case 6:
                                    p=bk2;
                                    break;
                                case 7:
                                    p=br2;
                                    break;
                                default:
                                    break;
                            }   break;
                        default:
                            break;
                    }
                    chessBoardBlocks[i][j]=new ChessBoardBlocks(i,j,p);
                    chessBoardBlocks[i][j].addMouseListener(this);
                    chessBoard.add(chessBoardBlocks[i][j]);
                }
            }
            chessBoard.setLayout(new GridLayout(8,8));
            pack();
        }
        setBoardBlocksColor();
        //</editor-fold>
    }
    
    public void setBoardBlocksColor() {
        //<editor-fold defaultstate="collapsed">
        switch(chessBoardType) {
            case "Default":
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            chessBoardBlocks[i][j].setBackground(new Color(255,206,158));
                        }else{
                            chessBoardBlocks[i][j].setBackground(new Color(209,139,71));
                        }
                    }
                }
                checkColor=Color.RED;
                moveColor=Color.CYAN;
                focusColor=Color.YELLOW;
                highlightColor=Color.GREEN;
                selectColor=Color.BLUE;
                if(tempNewClick!=null){
                    moveToBkgdColor=tempNewClick.getBackground();
                    tempNewClick.setBackground(moveColor);
                }
                break;
            case "Type1":
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            chessBoardBlocks[i][j].setBackground(new Color(245,245,245));
                        }else{
                            chessBoardBlocks[i][j].setBackground(new Color(40,40,40));
                        }
                    }
                }
                checkColor=Color.RED;
                moveColor=Color.CYAN;
                focusColor=Color.YELLOW;
                highlightColor=Color.GREEN;
                selectColor=Color.BLUE;
                if(tempNewClick!=null){
                    moveToBkgdColor=tempNewClick.getBackground();
                    tempNewClick.setBackground(moveColor);
                }
                break;
            case "Type2":
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            chessBoardBlocks[i][j].setBackground(new Color(255,255,255));
                        }else{
                            chessBoardBlocks[i][j].setBackground(new Color(255,0,0));
                        }
                    }
                }
                checkColor=Color.BLACK;
                moveColor=Color.CYAN;
                focusColor=Color.YELLOW;
                highlightColor=Color.GREEN;
                selectColor=Color.BLUE;
                if(tempNewClick!=null){
                    moveToBkgdColor=tempNewClick.getBackground();
                    tempNewClick.setBackground(moveColor);
                }
                break;
            case "Type3":
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            chessBoardBlocks[i][j].setBackground(new Color(255,255,255));
                        }else{
                            chessBoardBlocks[i][j].setBackground(new Color(0,255,0));
                        }
                    }
                }
                checkColor=Color.RED;
                moveColor=Color.CYAN;
                focusColor=Color.YELLOW;
                highlightColor=Color.MAGENTA;
                selectColor=Color.BLUE;
                if(tempNewClick!=null){
                    moveToBkgdColor=tempNewClick.getBackground();
                    tempNewClick.setBackground(moveColor);
                }
                break;
            case "Type4":
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            chessBoardBlocks[i][j].setBackground(new Color(240,230,175));
                        }else{
                            chessBoardBlocks[i][j].setBackground(new Color(215,115,20));
                        }
                    }
                }
                checkColor=Color.RED;
                moveColor=Color.CYAN;
                focusColor=Color.YELLOW;
                highlightColor=Color.GREEN;
                selectColor=Color.BLUE;
                if(tempNewClick!=null){
                    moveToBkgdColor=tempNewClick.getBackground();
                    tempNewClick.setBackground(moveColor);
                }
                break;
            case "Type5":
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            chessBoardBlocks[i][j].setBackground(new Color(255,255,255));
                        }else{
                            chessBoardBlocks[i][j].setBackground(new Color(0,0,255));
                        }
                    }
                }
                checkColor=Color.RED;
                moveColor=Color.CYAN;
                focusColor=Color.YELLOW;
                highlightColor=Color.GREEN;
                selectColor=Color.MAGENTA;
                if(tempNewClick!=null){
                    moveToBkgdColor=tempNewClick.getBackground();
                    tempNewClick.setBackground(moveColor);
                }
                break;
            case "Type6":
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if((i+j)%2==0){
                            chessBoardBlocks[i][j].setBackground(new Color(255,233,127));
                        }else{
                            chessBoardBlocks[i][j].setBackground(new Color(255,0,0));
                        }
                    }
                }
                checkColor=Color.BLACK;
                moveColor=Color.CYAN;
                focusColor=Color.YELLOW;
                highlightColor=Color.GREEN;
                selectColor=Color.BLUE;
                if(tempNewClick!=null){
                    moveToBkgdColor=tempNewClick.getBackground();
                    tempNewClick.setBackground(moveColor);
                }
                break;
        }
        pack();
        //</editor-fold>
    }

    private void highlightDestination() {
        //<editor-fold defaultstate="collapsed">
        for(ChessBoardBlocks cbb:destinationList) {
            cbb.setBorder(BorderFactory.createLineBorder(highlightColor, 5));
            cbb.setHightlighted();
        }
        //</editor-fold>
    }

    private void unhighlightDestination() {
        //<editor-fold defaultstate="collapsed">
        for(ChessBoardBlocks cbb:destinationList) {
            cbb.setBorder(null);
            cbb.setUnhightlighted();
        }
        //</editor-fold>
    }

    private boolean filterKingMove(ChessBoardBlocks cbb) {
        //<editor-fold defaultstate="collapsed">
        int x=cbb.x, y=cbb.y;
        
        //<editor-fold defaultstate="collapsed" desc="king move">
        if(x!=7 && y!=7) {
            for(int i=x+1,j=y+1; i<8 && j<8; i++,j++) {
                if(chessBoardBlocks[i][j].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                                || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                    return true;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[i][j].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        if(x!=0 && y!=0) {
            for(int i=x-1,j=y-1; i>=0 && j>=0; i--,j--) {
                if(chessBoardBlocks[i][j].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                                || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                    return true;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[i][j].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        if(x!=7 && y!=0) {
            for(int i=x+1,j=y-1; i<8 && j>=0; i++,j--) {
                if(chessBoardBlocks[i][j].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                                || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                    return true;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[i][j].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        if(x!=0 && y!=7) {
            for(int i=x-1,j=y+1; i>=0 && j<8; i--,j++) {
                if(chessBoardBlocks[i][j].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                                || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                    return true;
                } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[i][j].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        if(x!=0) {
            for(int i=x-1; i>=0; i--) {
                if(chessBoardBlocks[i][y].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[i][y].getPiece() instanceof Rook
                                || chessBoardBlocks[i][y].getPiece() instanceof Queen)) {
                    return true;
                } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[i][y].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        if(x!=7) {
            for(int i=x+1; i<8; i++) {
                if(chessBoardBlocks[i][y].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[i][y].getPiece() instanceof Rook
                                || chessBoardBlocks[i][y].getPiece() instanceof Queen)) {
                    return true;
                } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[i][y].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        if(y!=0) {
            for(int j=y-1; j>=0; j--) {
                if(chessBoardBlocks[x][j].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[x][j].getPiece() instanceof Rook
                                || chessBoardBlocks[x][j].getPiece() instanceof Queen)) {
                    return true;
                } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[x][j].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        if(y!=7) {
            for(int j=y+1; j<8; j++) {
                if(chessBoardBlocks[x][j].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                                && (chessBoardBlocks[x][j].getPiece() instanceof Rook
                                || chessBoardBlocks[x][j].getPiece() instanceof Queen)) {
                    return true;
                } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[x][j].getPiece() instanceof King) {
                    continue;
                } else {
                    break;
                }
            }
        }

        int[] _x={ x+1, x+1, x-1, x-1, x+2, x+2, x-2, x-2 };
        int[] _y={ y+2, y-2, y+2, y-2, y+1, y-1, y+1, y-1 };
        for(int i=0; i<8; i++) {
            if(_x[i]>=0 && _y[i]>=0 && _x[i]<8 && _y[i]<8) {
                if(chessBoardBlocks[_x[i]][_y[i]].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[_x[i]][_y[i]].getPiece().getPieceColor().equals(opponentPieceColor)
                                && chessBoardBlocks[_x[i]][_y[i]].getPiece() instanceof Knight) {
                    return true;
                }
            }
        }
        
        if(chance.equals(myColor)) {
            if(x>1 && y>0 && y<7) {
                if(chessBoardBlocks[x-1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y+1].getPiece().getPieceColor().equals(opponentColor))
                    return true;
                
                if(chessBoardBlocks[x-1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y-1].getPiece().getPieceColor().equals(opponentColor))
                    return true;
            }
            if(x>1 && y==0) {
                if(chessBoardBlocks[x-1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y+1].getPiece().getPieceColor().equals(opponentColor))
                    return true;
            }
            if(x>1 && y==7) {
                if(chessBoardBlocks[x-1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y-1].getPiece().getPieceColor().equals(opponentColor))
                    return true;
            }
            
        } else {
            if(x<6 && y>0 && y<7) {
                if(chessBoardBlocks[x+1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y+1].getPiece().getPieceColor().equals(myColor))
                    return true;
                
                if(chessBoardBlocks[x+1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y-1].getPiece().getPieceColor().equals(myColor))
                    return true;
            }
            if(x<6 && y==0) {
                if(chessBoardBlocks[x+1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y+1].getPiece().getPieceColor().equals(myColor))
                    return true;
            }
            if(x<6 && y==7) {
                if(chessBoardBlocks[x+1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y-1].getPiece().getPieceColor().equals(myColor))
                    return true;
            }
        }
        
        if(x!=7 && y!=7)
                if(chessBoardBlocks[x+1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y+1].getPiece().getPieceColor().equals(opponentPieceColor)
                                && chessBoardBlocks[x+1][y+1].getPiece() instanceof King) {
                    return true;
                }
            
            if(x!=0 && y!=0)
                if(chessBoardBlocks[x-1][y-1].getPiece()!=null 
                        && chessBoardBlocks[x-1][y-1].getPiece().getPieceColor().equals(opponentPieceColor)
                        && chessBoardBlocks[x-1][y-1].getPiece() instanceof King) {
                    return true;
                }
            
            if(x!=0)
                if(chessBoardBlocks[x-1][y].getPiece()!=null 
                        && chessBoardBlocks[x-1][y].getPiece().getPieceColor().equals(opponentPieceColor)
                        && chessBoardBlocks[x-1][y].getPiece() instanceof King) {
                    return true;
                }
            
            if(y!=0)
                if(chessBoardBlocks[x][y-1].getPiece()!=null 
                        && chessBoardBlocks[x][y-1].getPiece().getPieceColor().equals(opponentPieceColor)
                        && chessBoardBlocks[x][y-1].getPiece() instanceof King) {
                    return true;
                }
            
            if(x!=7)
                if(chessBoardBlocks[x+1][y].getPiece()!=null 
                        && chessBoardBlocks[x+1][y].getPiece().getPieceColor().equals(opponentPieceColor)
                        && chessBoardBlocks[x+1][y].getPiece() instanceof King) {
                    return true;
                }
            
            if(y!=7)
                if(chessBoardBlocks[x][y+1].getPiece()!=null 
                        && chessBoardBlocks[x][y+1].getPiece().getPieceColor().equals(opponentPieceColor)
                        && chessBoardBlocks[x][y+1].getPiece() instanceof King) {
                    return true;
                }
            
            if(x!=7 && y!=0)
                if(chessBoardBlocks[x+1][y-1].getPiece()!=null 
                        && chessBoardBlocks[x+1][y-1].getPiece().getPieceColor().equals(opponentPieceColor)
                        && chessBoardBlocks[x+1][y-1].getPiece() instanceof King) {
                    return true;
                }
            
            if(x!=0 && y!=7)
                if(chessBoardBlocks[x-1][y+1].getPiece()!=null 
                        && chessBoardBlocks[x-1][y+1].getPiece().getPieceColor().equals(opponentPieceColor)
                        && chessBoardBlocks[x-1][y+1].getPiece() instanceof King) {
                    return true;
                }
        
        //</editor-fold>
        
        return false;
        //</editor-fold>
    }
    
    private boolean filterKingWillBeInCheck() {
        //<editor-fold defaultstate="collapsed">
        int x=previousClick.x, y=previousClick.y;
        
        canMove.clear();
        checkFrom.clear();
        
        for(int i=x+1,j=y+1; i<8 && j<8; i++,j++) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int _i=x-1,_j=y-1; _i>=0 && _j>=0; _i--,_j--) {
                    if(chessBoardBlocks[_i][_j].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[_i][_j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[_i][_j].getPiece() instanceof King) {
                        for(int ii=x+1,jj=y+1; ii<=i && jj<=j; ii++,jj++) {
                            canMove.add(chessBoardBlocks[ii][jj]);
                        }
                        for(int _ii=x-1,_jj=y-1; _ii>=_i && _jj>=_j; _ii--,_jj--) {
                            canMove.add(chessBoardBlocks[_ii][_jj]);
                        }
                        checkFrom.add(chessBoardBlocks[i][j]);
                        return true;
                    } else {
                        break;
                    }   
                }

            } else {
                break;
            }
        }
        
        for(int i=x-1,j=y+1; i>=0 && j<8; i--,j++) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int _i=x+1,_j=y-1; _i<8 && _j>=0; _i++,_j--) {
                    if(chessBoardBlocks[_i][_j].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[_i][_j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[_i][_j].getPiece() instanceof King) {
                        for(int ii=x-1,jj=y+1; ii>=i && jj<=j; ii--,jj++) {
                            canMove.add(chessBoardBlocks[ii][jj]);
                        }
                        for(int _ii=x+1,_jj=y-1; _ii<=_i && _jj>=_j; _ii++,_jj--) {
                            canMove.add(chessBoardBlocks[_ii][_jj]);
                        }
                        checkFrom.add(chessBoardBlocks[i][j]);
                        return true;
                    } else {
                        break;
                    }   
                }

            } else {
                break;
            }
        }
        
        for(int i=x-1,j=y-1; i>=0 && j>=0; i--,j--) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int _i=x+1,_j=y+1; _i<8 && _j<8; _i++,_j++) {
                    if(chessBoardBlocks[_i][_j].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[_i][_j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[_i][_j].getPiece() instanceof King) {
                        for(int ii=x-1,jj=y-1; ii>=i && jj>=j; ii--,jj--) {
                            canMove.add(chessBoardBlocks[ii][jj]);
                        }
                        for(int _ii=x+1,_jj=y+1; _ii<=_i && _jj<=_j; _ii++,_jj++) {
                            canMove.add(chessBoardBlocks[_ii][_jj]);
                        }
                        checkFrom.add(chessBoardBlocks[i][j]);
                        return true;
                    } else {
                        break;
                    }   
                }

            } else {
                break;
            }
        }
        
        for(int i=x+1,j=y-1; i<8 && j>=0; i++,j--) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int _i=x-1,_j=y+1; _i>=0 && _j<8; _i--,_j++) {
                    if(chessBoardBlocks[_i][_j].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[_i][_j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[_i][_j].getPiece() instanceof King) {
                        for(int ii=x+1,jj=y-1; ii<=i && jj>=j; ii++,jj--) {
                            canMove.add(chessBoardBlocks[ii][jj]);
                        }
                        for(int _ii=x-1,_jj=y+1; _ii>=_i && _jj<=_j; _ii--,_jj++) {
                            canMove.add(chessBoardBlocks[_ii][_jj]);
                        }
                        checkFrom.add(chessBoardBlocks[i][j]);
                        return true;
                    } else {
                        break;
                    }   
                }

            } else {
                break;
            }
        }
        
        for(int i=x+1; i<8; i++) {
            if(chessBoardBlocks[i][y].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][y].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][y].getPiece() instanceof Rook)) {
                for(int _i=x-1; _i>=0; _i--) {
                    if(chessBoardBlocks[_i][y].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[_i][y].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[_i][y].getPiece() instanceof King) {
                        for(int ii=x+1; ii<=i; ii++) {
                            canMove.add(chessBoardBlocks[ii][y]);
                        }
                        for(int _ii=x-1; _ii>=_i; _ii--) {
                            canMove.add(chessBoardBlocks[_ii][y]);
                        }
                        checkFrom.add(chessBoardBlocks[i][y]);
                        return true;
                    } else {
                        break;
                    }   
                }

            } else {
                break;
            }
        }
        
        for(int j=y+1; j<8; j++) {
            if(chessBoardBlocks[x][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[x][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[x][j].getPiece() instanceof Rook)) {
                for(int _j=y-1; _j>=0; _j--) {
                    if(chessBoardBlocks[x][_j].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[x][_j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[x][_j].getPiece() instanceof King) {
                        for(int jj=y+1; jj<=j; jj++) {
                            canMove.add(chessBoardBlocks[x][jj]);
                        }
                        for(int _jj=y-1; _jj>=_j; _jj--) {
                            canMove.add(chessBoardBlocks[x][_jj]);
                        }
                        checkFrom.add(chessBoardBlocks[x][j]);
                        return true;
                    } else {
                        break;
                    }
                }

            } else {
                break;
            }
        }
        
        for(int i=x-1; i>=0; i--) {
            if(chessBoardBlocks[i][y].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][y].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][y].getPiece() instanceof Rook)) {
                for(int _i=x+1; _i<8; _i++) {
                    if(chessBoardBlocks[_i][y].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[_i][y].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[_i][y].getPiece() instanceof King) {
                        for(int ii=x-1; ii>=i; ii--) {
                            canMove.add(chessBoardBlocks[ii][y]);
                        }
                        for(int _ii=x+1; _ii<=_i; _ii++) {
                            canMove.add(chessBoardBlocks[_ii][y]);
                        }
                        checkFrom.add(chessBoardBlocks[i][y]);
                        return true;
                    } else {
                        break;
                    }   
                }

            } else {
                break;
            }
        }
        
        for(int j=y-1; j>=0; j--) {
            if(chessBoardBlocks[x][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[x][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[x][j].getPiece() instanceof Rook)) {
                for(int _j=y+1; _j<8; _j++) {
                    if(chessBoardBlocks[x][_j].getPiece()==null) {
                        continue;
                    } else if(chessBoardBlocks[x][_j].getPiece().getPieceColor().equals(myPieceColor)
                                && chessBoardBlocks[x][_j].getPiece() instanceof King) {
                        for(int jj=y-1; jj>=j; jj--) {
                            canMove.add(chessBoardBlocks[x][jj]);
                        }
                        for(int _jj=y+1; _jj<=_j; _jj++) {
                            canMove.add(chessBoardBlocks[x][_jj]);
                        }
                        checkFrom.add(chessBoardBlocks[x][j]);
                        return true;
                    } else {
                        break;
                    }
                }

            } else {
                break;
            }
        }
        
        return false;
        //</editor-fold>
    }
    
    private ArrayList<ChessBoardBlocks> filterDestinationList() {
        //<editor-fold defaultstate="collapsed">
        ArrayList<ChessBoardBlocks> newDestinationList=new ArrayList<ChessBoardBlocks>();
        
        if(previousClick.getPiece() instanceof King) {
            for(ChessBoardBlocks cbb:destinationList) {
                if(filterKingMove(cbb))
                    continue;
                else
                    newDestinationList.add(cbb);
            }
            return newDestinationList;
        } else {
            
            if(kingIsInCheck(getKing())) {
                if(checkFrom.size()==1) {
                    kingIsInCheckPath(getKing());
                    for(ChessBoardBlocks cbb:destinationList) {
                        for(ChessBoardBlocks cf:canMove) {
                            if(cbb.equals(cf)) {
                                newDestinationList.add(cbb);
                            }
                        }
                    }
                } else {
                    destinationList.clear();
                    return destinationList;
                }
                return newDestinationList;
            }
            if(filterKingWillBeInCheck()) {
                if(checkFrom.size()==1) {
                    for(ChessBoardBlocks cbb:destinationList) {
                        for(ChessBoardBlocks cf:canMove) {
                            if(cbb.equals(cf)) {
                                newDestinationList.add(cbb);
                            }
                        }
                    }
                }
                return newDestinationList;
            }
            
            return destinationList;
        }
        //</editor-fold>
    }
    
    private ChessBoardBlocks getKing() {
        //<editor-fold defaultstate="collapsed">
        if(chance.equals("Black")) {
            return chessBoardBlocks[bk.x][bk.y];
        } else {
            return chessBoardBlocks[wk.x][wk.y];
        }
        //</editor-fold>
    }
    
    private void setFirstMoveFalse(ChessBoardBlocks cbb) {
        //<editor-fold defaultstate="collapsed">
        if(cbb.getPiece() instanceof King) {
            ((King)cbb.getPiece()).firstMove=false;
        } else {
            ((Rook)cbb.getPiece()).firstMove=false;
        }
        //</editor-fold>
    }
    
    private void setKingNotInDanger(String kingColor) {
        //<editor-fold defaultstate="collapsed">
        if(kingColor.equals("White")) {
            kingOldPosition.setBackground(whiteKingBkColor);
            whiteKingBkColor=null;
            kingOldPosition=null;
        } else {
            kingOldPosition.setBackground(blackKingBkColor);
            blackKingBkColor=null;
            kingOldPosition=null;
        }
        //</editor-fold>
    }
    
    private void setKingInDanger(String kingColor) {
        //<editor-fold defaultstate="collapsed">
        if(kingColor.equals("White")) {
            kingOldPosition=chessBoardBlocks[wk.x][wk.y];
            whiteKingBkColor=kingOldPosition.getBackground();
            kingOldPosition.setBackground(checkColor);
        } else {
            kingOldPosition=chessBoardBlocks[bk.x][bk.y];
            blackKingBkColor=kingOldPosition.getBackground();
            kingOldPosition.setBackground(checkColor);
        }
        //</editor-fold>
    }
    
    private void performCastling() {
        //<editor-fold defaultstate="collapsed">
        Piece rook=null;
        
        if(newClick.x==0) {
            switch(newClick.y) {
                case 1:
                    try {
                        rook=chessBoardBlocks[0][0].getPiece().getCopy();
                        chessBoardBlocks[0][0].removePiece();
                        chessBoardBlocks[0][2].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[0][3]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
                case 2:
                    try {
                        rook=chessBoardBlocks[0][0].getPiece().getCopy();
                        chessBoardBlocks[0][0].removePiece();
                        chessBoardBlocks[0][3].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[0][4]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
                case 5:
                    try {
                        rook=chessBoardBlocks[0][7].getPiece().getCopy();
                        chessBoardBlocks[0][7].removePiece();
                        chessBoardBlocks[0][4].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[0][3]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
                case 6:
                    try {
                        rook=chessBoardBlocks[0][7].getPiece().getCopy();
                        chessBoardBlocks[0][7].removePiece();
                        chessBoardBlocks[0][5].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[0][4]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
            }
        } else {
            switch(newClick.y) {
                case 1:
                    try {
                        rook=chessBoardBlocks[7][0].getPiece().getCopy();
                        chessBoardBlocks[7][0].removePiece();
                        chessBoardBlocks[7][2].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[7][3]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
                case 2:
                    try {
                        rook=chessBoardBlocks[7][0].getPiece().getCopy();
                        chessBoardBlocks[7][0].removePiece();
                        chessBoardBlocks[7][3].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[7][4]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
                case 5:
                    try {
                        rook=chessBoardBlocks[7][7].getPiece().getCopy();
                        chessBoardBlocks[7][7].removePiece();
                        chessBoardBlocks[7][4].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[7][3]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
                case 6:
                    try {
                        rook=chessBoardBlocks[7][7].getPiece().getCopy();
                        chessBoardBlocks[7][7].removePiece();
                        chessBoardBlocks[7][5].setPiece(rook);
                        setFirstMoveFalse(chessBoardBlocks[7][4]);
                    } catch (CloneNotSupportedException ex) {}
                    break;
            }
        }
        //</editor-fold>
    }
    
    private boolean kingIsInCheck(ChessBoardBlocks cbb) {
        //<editor-fold defaultstate="collapsed">
        int x=cbb.x, y=cbb.y;
        
        checkFrom.clear();
        
        for(int i=x+1,j=y+1; i<8 && j<8; i++,j++) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                checkFrom.add(chessBoardBlocks[i][j]);
                break;
            } else {
                break;
            }
        }
        
        for(int i=x-1,j=y+1; i>=0 && j<8; i--,j++) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                checkFrom.add(chessBoardBlocks[i][j]);
                break;
            } else {
                break;
            }
        }
        
        for(int i=x-1,j=y-1; i>=0 && j>=0; i--,j--) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                checkFrom.add(chessBoardBlocks[i][j]);
                break;
            } else {
                break;
            }
        }
        
        for(int i=x+1,j=y-1; i<8 && j>=0; i++,j--) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                checkFrom.add(chessBoardBlocks[i][j]);
                break;
            } else {
                break;
            }
        }
        
        for(int i=x+1; i<8; i++) {
            if(chessBoardBlocks[i][y].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][y].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][y].getPiece() instanceof Rook)) {
                checkFrom.add(chessBoardBlocks[i][y]);
                break;
            } else {
                break;
            }
        }
        
        for(int j=y+1; j<8; j++) {
            if(chessBoardBlocks[x][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[x][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[x][j].getPiece() instanceof Rook)) {
                checkFrom.add(chessBoardBlocks[x][j]);
                break;
            } else {
                break;
            }
        }
        
        for(int i=x-1; i>=0; i--) {
            if(chessBoardBlocks[i][y].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][y].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][y].getPiece() instanceof Rook)) {
                checkFrom.add(chessBoardBlocks[i][y]);
                break;
            } else {
                break;
            }
        }
        
        for(int j=y-1; j>=0; j--) {
            if(chessBoardBlocks[x][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[x][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[x][j].getPiece() instanceof Rook)) {
                checkFrom.add(chessBoardBlocks[x][j]);
                break;
            } else {
                break;
            }
        }
        
        int[] _x={ x+1, x+1, x-1, x-1, x+2, x+2, x-2, x-2 };
        int[] _y={ y+2, y-2, y+2, y-2, y+1, y-1, y+1, y-1 };
        for(int i=0; i<8; i++) {
            if(_x[i]>=0 && _y[i]>=0 && _x[i]<8 && _y[i]<8) {
                if(chessBoardBlocks[_x[i]][_y[i]].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[_x[i]][_y[i]].getPiece().getPieceColor().equals(opponentPieceColor)
                                && chessBoardBlocks[_x[i]][_y[i]].getPiece() instanceof Knight) {
                    checkFrom.add(chessBoardBlocks[_x[i]][_y[i]]);
                }
            }
        }
        
        if(chance.equals(myColor)) {
            if(x>1 && y>0 && y<7) {
                if(chessBoardBlocks[x-1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y+1].getPiece().getPieceColor().equals(opponentColor))
                    checkFrom.add(chessBoardBlocks[x-1][y+1]);
                
                if(chessBoardBlocks[x-1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y-1].getPiece().getPieceColor().equals(opponentColor))
                    checkFrom.add(chessBoardBlocks[x-1][y-1]);
            }
            if(x>1 && y==0) {
                if(chessBoardBlocks[x-1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y+1].getPiece().getPieceColor().equals(opponentColor))
                    checkFrom.add(chessBoardBlocks[x-1][y+1]);
            }
            if(x>1 && y==7) {
                if(chessBoardBlocks[x-1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y-1].getPiece().getPieceColor().equals(opponentColor))
                    checkFrom.add(chessBoardBlocks[x-1][y-1]);
            }
            
        } else {
            if(x<6 && y>0 && y<7) {
                if(chessBoardBlocks[x+1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y+1].getPiece().getPieceColor().equals(myColor))
                    checkFrom.add(chessBoardBlocks[x+1][y+1]);
                
                if(chessBoardBlocks[x+1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y-1].getPiece().getPieceColor().equals(myColor))
                    checkFrom.add(chessBoardBlocks[x+1][y-1]);
            }
            if(x<6 && y==0) {
                if(chessBoardBlocks[x+1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y+1].getPiece().getPieceColor().equals(myColor))
                    checkFrom.add(chessBoardBlocks[x+1][y+1]);
            }
            if(x<6 && y==7) {
                if(chessBoardBlocks[x+1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y-1].getPiece().getPieceColor().equals(myColor))
                    checkFrom.add(chessBoardBlocks[x+1][y-1]);
            }
        }
        
        if(checkFrom.isEmpty())
            return false;
        else
            return true;
        //</editor-fold>
    }
    
    private void kingIsInCheckPath(ChessBoardBlocks cbb) {
        //<editor-fold defaultstate="collapsed">
        int x=cbb.x, y=cbb.y;
        
        canMove.clear();
        
        for(int i=x+1,j=y+1; i<8 && j<8; i++,j++) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int ii=x+1,jj=y+1; ii<=i && jj<=j; ii++,jj++) {
                    canMove.add(chessBoardBlocks[ii][jj]);
                }
                break;
            } else {
                break;
            }
        }
        
        for(int i=x-1,j=y+1; i>=0 && j<8; i--,j++) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int ii=x-1,jj=y+1; ii>=i && jj<=j; ii--,jj++) {
                    canMove.add(chessBoardBlocks[ii][jj]);
                }
                break;
            } else {
                break;
            }
        }
        
        for(int i=x-1,j=y-1; i>=0 && j>=0; i--,j--) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int ii=x-1,jj=y-1; ii>=i && jj>=j; ii--,jj--) {
                    canMove.add(chessBoardBlocks[ii][jj]);
                }
                break;
            } else {
                break;
            }
        }
        
        for(int i=x+1,j=y-1; i<8 && j>=0; i++,j--) {
            if(chessBoardBlocks[i][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][j].getPiece() instanceof Bishop)) {
                for(int ii=x+1,jj=y-1; ii<=i && jj>=j; ii++,jj--) {
                    canMove.add(chessBoardBlocks[ii][jj]);
                }
                break;
            } else {
                break;
            }
        }
        
        for(int i=x+1; i<8; i++) {
            if(chessBoardBlocks[i][y].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][y].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][y].getPiece() instanceof Rook)) {
                for(int ii=x+1; ii<=i; ii++) {
                    canMove.add(chessBoardBlocks[ii][y]);
                }
                break;
            } else {
                break;
            }
        }
        
        for(int j=y+1; j<8; j++) {
            if(chessBoardBlocks[x][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[x][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[x][j].getPiece() instanceof Rook)) {
                for(int jj=y+1; jj<=j; jj++) {
                    canMove.add(chessBoardBlocks[x][jj]);
                }
                break;
            } else {
                break;
            }
        }
        
        for(int i=x-1; i>=0; i--) {
            if(chessBoardBlocks[i][y].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[i][y].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[i][y].getPiece() instanceof Queen 
                            || chessBoardBlocks[i][y].getPiece() instanceof Rook)) {
                for(int ii=x-1; ii>=i; ii--) {
                    canMove.add(chessBoardBlocks[ii][y]);
                }
                break;
            } else {
                break;
            }
        }
        
        for(int j=y-1; j>=0; j--) {
            if(chessBoardBlocks[x][j].getPiece()==null) {
                continue;
            } else if(chessBoardBlocks[x][j].getPiece().getPieceColor().equals(opponentPieceColor)
                            && (chessBoardBlocks[x][j].getPiece() instanceof Queen 
                            || chessBoardBlocks[x][j].getPiece() instanceof Rook)) {
                for(int jj=y-1; jj>=j; jj--) {
                    canMove.add(chessBoardBlocks[x][jj]);
                }
                break;
            } else {
                break;
            }
        }
        
        int[] _x={ x+1, x+1, x-1, x-1, x+2, x+2, x-2, x-2 };
        int[] _y={ y+2, y-2, y+2, y-2, y+1, y-1, y+1, y-1 };
        for(int i=0; i<8; i++) {
            if(_x[i]>=0 && _y[i]>=0 && _x[i]<8 && _y[i]<8) {
                if(chessBoardBlocks[_x[i]][_y[i]].getPiece()==null) {
                    continue;
                } else if(chessBoardBlocks[_x[i]][_y[i]].getPiece().getPieceColor().equals(opponentPieceColor)
                                && chessBoardBlocks[_x[i]][_y[i]].getPiece() instanceof Knight) {
                    canMove.add(chessBoardBlocks[_x[i]][_y[i]]);
                }
            }
        }
        
        if(chance.equals(myColor)) {
            if(x>1 && y>0 && y<7) {
                if(chessBoardBlocks[x-1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y+1].getPiece().getPieceColor().equals(opponentColor))
                    canMove.add(chessBoardBlocks[x-1][y+1]);
                
                if(chessBoardBlocks[x-1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y-1].getPiece().getPieceColor().equals(opponentColor))
                    canMove.add(chessBoardBlocks[x-1][y-1]);
            }
            if(x>1 && y==0) {
                if(chessBoardBlocks[x-1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y+1].getPiece().getPieceColor().equals(opponentColor))
                    canMove.add(chessBoardBlocks[x-1][y+1]);
            }
            if(x>1 && y==7) {
                if(chessBoardBlocks[x-1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x-1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x-1][y-1].getPiece().getPieceColor().equals(opponentColor))
                    canMove.add(chessBoardBlocks[x-1][y-1]);
            }
            
        } else {
            if(x<6 && y>0 && y<7) {
                if(chessBoardBlocks[x+1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y+1].getPiece().getPieceColor().equals(myColor))
                    canMove.add(chessBoardBlocks[x+1][y+1]);
                
                if(chessBoardBlocks[x+1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y-1].getPiece().getPieceColor().equals(myColor))
                    canMove.add(chessBoardBlocks[x+1][y-1]);
            }
            if(x<6 && y==0) {
                if(chessBoardBlocks[x+1][y+1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y+1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y+1].getPiece().getPieceColor().equals(myColor))
                    canMove.add(chessBoardBlocks[x+1][y+1]);
            }
            if(x<6 && y==7) {
                if(chessBoardBlocks[x+1][y-1].getPiece()!=null 
                                && chessBoardBlocks[x+1][y-1].getPiece() instanceof Pawn
                                && chessBoardBlocks[x+1][y-1].getPiece().getPieceColor().equals(myColor))
                    canMove.add(chessBoardBlocks[x+1][y-1]);
            }
        }
        //</editor-fold>
    }
    
    private void canCastle(ChessBoardBlocks cbb) {
        //<editor-fold defaultstate="collapsed">
        if(myColor.equals("White")) {//<editor-fold defaultstate="collapsed">
            if(cbb.getPiece().getPieceColor().equals("White")) {
                if(!kingIsInCheck(chessBoardBlocks[7][4])) {
                    if(wk.firstMove) {
                        if(chessBoardBlocks[7][3].getPiece()==null
                                && chessBoardBlocks[7][2].getPiece()==null
                                && chessBoardBlocks[7][1].getPiece()==null) {
                            if(chessBoardBlocks[7][0].getPiece()!=null 
                                    && chessBoardBlocks[7][0].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[7][0].getPiece()).firstMove) {
                                if(!filterKingMove(chessBoardBlocks[7][3]) 
                                        && !filterKingMove(chessBoardBlocks[7][2]))
                                    destinationList.add(chessBoardBlocks[7][2]);
                            }
                        }
                        if(chessBoardBlocks[7][5].getPiece()==null
                                && chessBoardBlocks[7][6].getPiece()==null) {
                            if(chessBoardBlocks[7][7].getPiece()!=null 
                                    && chessBoardBlocks[7][7].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[7][7].getPiece()).firstMove) {
                                if(!filterKingMove(chessBoardBlocks[7][5]) 
                                        && !filterKingMove(chessBoardBlocks[7][6]))
                                    destinationList.add(chessBoardBlocks[7][6]);
                            }
                        }
                    }
                }
            } else {
                if(!kingIsInCheck(chessBoardBlocks[0][4])) {
                    if(bk.firstMove) {
                        if(chessBoardBlocks[0][3].getPiece()==null
                                && chessBoardBlocks[0][2].getPiece()==null
                                && chessBoardBlocks[0][1].getPiece()==null) {
                            if(chessBoardBlocks[0][0].getPiece()!=null 
                                    && chessBoardBlocks[0][0].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[0][0].getPiece()).firstMove ) {
                                if(!filterKingMove(chessBoardBlocks[0][3]) 
                                        && !filterKingMove(chessBoardBlocks[0][2]))
                                    destinationList.add(chessBoardBlocks[0][2]);
                            }
                        }
                        if(chessBoardBlocks[0][5].getPiece()==null
                                && chessBoardBlocks[0][6].getPiece()==null) {
                            if(chessBoardBlocks[0][7].getPiece()!=null 
                                    && chessBoardBlocks[0][7].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[0][7].getPiece()).firstMove) {
                                if(!filterKingMove(chessBoardBlocks[0][5]) 
                                        && !filterKingMove(chessBoardBlocks[0][6]))
                                    destinationList.add(chessBoardBlocks[0][6]);
                            }
                        }
                    }
                }
            }
        //</editor-fold>
        } else {
            if(cbb.getPiece().getPieceColor().equals("Black")) {
                if(!kingIsInCheck(chessBoardBlocks[7][3])) {
                    if(bk.firstMove) {
                        if(chessBoardBlocks[7][2]==null
                                && chessBoardBlocks[7][1]==null) {
                            if(chessBoardBlocks[7][0].getPiece()!=null 
                                    && chessBoardBlocks[7][0].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[7][0].getPiece()).firstMove) {
                                if(!filterKingMove(chessBoardBlocks[7][2])
                                        && !filterKingMove(chessBoardBlocks[7][1]))
                                    destinationList.add(chessBoardBlocks[7][1]);
                            }
                        }
                        if(chessBoardBlocks[7][4]==null
                                && chessBoardBlocks[7][5]==null
                                && chessBoardBlocks[7][6]==null) {
                            if(chessBoardBlocks[7][7].getPiece()!=null 
                                    && chessBoardBlocks[7][7].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[7][7].getPiece()).firstMove) {
                                if(!filterKingMove(chessBoardBlocks[7][4]) 
                                        && !filterKingMove(chessBoardBlocks[7][5]))
                                    destinationList.add(chessBoardBlocks[7][5]);
                            }
                        }
                    }
                }
            } else {
                if(!kingIsInCheck(chessBoardBlocks[0][3])) {
                    if(wk.firstMove) {
                        if(chessBoardBlocks[0][2]==null
                                && chessBoardBlocks[0][1]==null) {
                            if(chessBoardBlocks[0][0].getPiece()!=null 
                                    && chessBoardBlocks[0][0].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[0][0].getPiece()).firstMove) {
                                if(!filterKingMove(chessBoardBlocks[0][2])
                                        && !filterKingMove(chessBoardBlocks[0][1]))
                                    destinationList.add(chessBoardBlocks[0][1]);
                            }
                        }
                        if(chessBoardBlocks[0][4]==null
                                && chessBoardBlocks[0][5]==null
                                && chessBoardBlocks[0][6]==null) {
                            if(chessBoardBlocks[0][7].getPiece()!=null 
                                    && chessBoardBlocks[0][7].getPiece() instanceof Rook
                                    && ((Rook)chessBoardBlocks[0][7].getPiece()).firstMove) {
                                if(!filterKingMove(chessBoardBlocks[0][4]) 
                                        && !filterKingMove(chessBoardBlocks[0][5]))
                                    destinationList.add(chessBoardBlocks[0][5]);
                            }
                        }
                    }
                }
            }
        }
        //</editor-fold>
    }
    
    private void performEnpassant() {
        tempNewClick.removePiece();
    }
    
    private boolean canEnpassant(ChessBoardBlocks cbb) {
        //<editor-fold defaultstate="collapsed">
        if(chance.equals(myColor)) {
            if(tempNewClick.getPiece().getPieceColor().equals(opponentColor)) {
                if(tempPreviousClick.x-tempNewClick.x==2 
                                || tempPreviousClick.x-tempNewClick.x==-2) {
                    switch (cbb.y) {
                        case 0:
                            if((tempNewClick.y-cbb.y==1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x-1][tempNewClick.y]);
                                return true;
                            }
                        case 7:
                            if((tempNewClick.y-cbb.y==-1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x-1][tempNewClick.y]);
                                return true;
                            }
                        default:
                            //for (y<7 && y>0)
                            if((tempNewClick.y-cbb.y==1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x-1][tempNewClick.y]);
                                return true;
                            }   if((tempNewClick.y-cbb.y==-1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x-1][tempNewClick.y]);
                                return true;
                            }
                    }
                }
            }
        } else {
            if(tempNewClick.getPiece().getPieceColor().equals(myColor)) {
                if(tempPreviousClick.x-tempNewClick.x==2 
                                || tempPreviousClick.x-tempNewClick.x==-2) {
                    switch (cbb.y) {
                        case 0:
                            if((tempNewClick.y-cbb.y==1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x+1][tempNewClick.y]);
                                return true;
                            }
                        case 7:
                            if((tempNewClick.y-cbb.y==-1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x+1][tempNewClick.y]);
                                return true;
                            }
                        default:
                            //for (y<7 && y>0)
                            if((tempNewClick.y-cbb.y==1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x+1][tempNewClick.y]);
                                return true;
                            }   if((tempNewClick.y-cbb.y==-1) && (tempNewClick.x==cbb.x)) {
                                destinationList.add(chessBoardBlocks[tempNewClick.x+1][tempNewClick.y]);
                                return true;
                            }
                    }
                }
            }
        }
        
        return false;
        //</editor-fold>
    }
    
    private void checkmate(String chance) {
        gameStarted=false;
        gameOver=true;
        //new Checkmate();
        if(chance.equals("White")) {
            JOptionPane.showMessageDialog(null, "Black won the match.", "Checkmate", JOptionPane.OK_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "White won the match.", "Checkmate", JOptionPane.OK_OPTION);
        }
    }
    
    private void drawByInsufficientPieces() {
        //<editor-fold defaultstate="collapsed">
        int totalWhitePieces=0, whiteKnight=0, whiteRook=0, whiteQueen=0, whitePawn=0, whiteBishop=0;
        int totalBlackPieces=0, blackKnight=0, blackRook=0, blackQueen=0, blackPawn=0, blackBishop=0;
        ArrayList<ChessBoardBlocks> whitebishop= new ArrayList<ChessBoardBlocks>();
        ArrayList<ChessBoardBlocks> blackbishop= new ArrayList<ChessBoardBlocks>();
        
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(chessBoardBlocks[i][j].getPiece()!=null) {
                    if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals("White")) {
                        if(chessBoardBlocks[i][j].getPiece() instanceof Pawn) {
                            whitePawn++;
                            totalWhitePieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Rook) {
                            whiteRook++;
                            totalWhitePieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Bishop) {
                            whiteBishop++;
                            totalWhitePieces++;
                            whitebishop.add(chessBoardBlocks[i][j]);
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Knight) {
                            whiteKnight++;
                            totalWhitePieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Queen) {
                            whiteQueen++;
                            totalWhitePieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof King) {
                            totalWhitePieces++;
                        }
                        
                    } else {
                        if(chessBoardBlocks[i][j].getPiece() instanceof Pawn) {
                            blackPawn++;
                            totalBlackPieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Rook) {
                            blackRook++;
                            totalBlackPieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Bishop) {
                            blackBishop++;
                            totalBlackPieces++;
                            blackbishop.add(chessBoardBlocks[i][j]);
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Knight) {
                            blackKnight++;
                            totalBlackPieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof Queen) {
                            blackQueen++;
                            totalBlackPieces++;
                        } else if(chessBoardBlocks[i][j].getPiece() instanceof King) {
                            totalBlackPieces++;
                        }
                    }
                }
                
                if(totalWhitePieces<3) {
                    if(whitePawn>0 || whiteQueen>0 || whiteRook>0 ) {
                        return;
                    }
                } else if(totalWhitePieces==3) {
                    if (whiteBishop>1) {
                        int temp=0;
                        for (ChessBoardBlocks cbb: whitebishop) {
                            if((cbb.x+cbb.y)%2==0) {
                                temp++;
                            }
                        }
                        if(temp!=whiteBishop) {
                            return;
                        }
                    }else if(whiteKnight>0 && whiteBishop>0) {
                        return;
                    }
                } else if(totalWhitePieces>3) {
                    return;
                }

                if(totalBlackPieces<3) {
                    if(blackPawn>0 || blackQueen>0 || blackRook>0 ) {
                        return;
                    }
                } else if(totalBlackPieces==3) {
                    if (blackBishop>1) {
                        int temp=0;
                        for (ChessBoardBlocks cbb: blackbishop) {
                            if((cbb.x+cbb.y)%2==0) {
                                temp++;
                            }
                        }
                        if(temp!=blackBishop) {
                            return;
                        }
                    } else if(blackKnight>0 && blackBishop>0) {
                        return;
                    }
                } else if(totalBlackPieces>3) {
                    return;
                }

            }
        }

        matchDraw();
        //</editor-fold>
    }
    
    private void matchDraw() {
        gameStarted=false;
        gameOver=true;
        //new Stalemate();
        JOptionPane.showMessageDialog(null, "Match draw.", "Draw", JOptionPane.OK_OPTION);
    }
    
    private void fiftyMove() {
        gameStarted=false;
        gameOver=true;
        //new FiftyMove();
        JOptionPane.showMessageDialog(null, "Match draw.", "Draw", JOptionPane.OK_OPTION);
    }
    
    private boolean isMoveLeft() {
        //<editor-fold defaultstate="collapsed">
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(chessBoardBlocks[i][j].getPiece()!=null) {
                    if(chessBoardBlocks[i][j].getPiece().getPieceColor().equals(chance)) {
                        destinationList.clear();
                        previousClick=chessBoardBlocks[i][j];
                        destinationList=chessBoardBlocks[i][j].getPiece().pieceMove(chessBoardBlocks, i, j);
                        if(chessBoardBlocks[i][j].getPiece() instanceof King) {
                            if(((King)chessBoardBlocks[i][j].getPiece()).firstMove) {
                                canCastle(chessBoardBlocks[i][j]);
                            }
                        }
                        if(tempNewClick!=null) {
                            if(tempNewClick.getPiece() instanceof Pawn
                                        && chessBoardBlocks[i][j].getPiece() instanceof Pawn) {
                                canEnpassant(chessBoardBlocks[i][j]);
                            }
                        }
                        destinationList=filterDestinationList();
                        if(destinationList.size()>0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
        //</editor-fold>
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //<editor-fold defaultstate="collapsed">
        if(gameOver) {
            return;
        }
        newClick=(ChessBoardBlocks)e.getSource();
        if(previousClick==null) {
            if(newClick.getPiece()!=null) {
                if(!(newClick.getPiece().getPieceColor().equals(chance))) {
                    return;
                }
                previousClick=newClick;
                newClick.select();
                newClick.setSelected();
                destinationList.clear();
                destinationList=newClick.getPiece().pieceMove(chessBoardBlocks, newClick.x, newClick.y);
                if(newClick.getPiece() instanceof King) {
                    if(((King)newClick.getPiece()).firstMove) {
                        canCastle(newClick);
                    }
                }
                if(tempNewClick!=null) {
                    if(tempNewClick.getPiece() instanceof Pawn
                                && newClick.getPiece() instanceof Pawn) {
                        isEnpassantPossible=canEnpassant(newClick);
                    }
                }
                destinationList=filterDestinationList();
                highlightDestination();
            }
        } else { //code for previousClick != null
            if(newClick.equals(previousClick)) {
                unhighlightDestination();
                destinationList.clear();
                previousClick.deSelect();
                previousClick.setDeselected();
                if(tempPreviousClick!=null){
                    tempPreviousClick.setBorder(BorderFactory.createLineBorder(moveColor, 5));
                }
                previousClick=null;
                return;
            } else if(newClick.getPiece()!=null && (newClick.getPiece().getPieceColor().equals(chance))) {
                unhighlightDestination();
                previousClick.deSelect();
                previousClick.setDeselected();
                if(tempPreviousClick!=null){
                    tempPreviousClick.setBorder(BorderFactory.createLineBorder(moveColor, 5));
                }
                previousClick=newClick;
                newClick.select();
                newClick.setSelected();
                destinationList.clear();
                destinationList=newClick.getPiece().pieceMove(chessBoardBlocks, newClick.x, newClick.y);
                if(newClick.getPiece() instanceof King) {
                    if(((King)newClick.getPiece()).firstMove) {
                        canCastle(newClick);
                    }
                }
                if(tempNewClick!=null) {
                    if(tempNewClick.getPiece() instanceof Pawn
                                && newClick.getPiece() instanceof Pawn) {
                        isEnpassantPossible=canEnpassant(newClick);
                    }
                }
                destinationList=filterDestinationList();
                highlightDestination();
                return;
            }
            
            for(ChessBoardBlocks cbb:destinationList) {
                if(cbb.equals(newClick)) {
                    Piece p=null;
                    JLabel j=new JLabel();
                    try {
                        p = previousClick.getPiece().getCopy();
                    } catch (CloneNotSupportedException ex) {}
                    
                    //<editor-fold defaultstate="collapsed" desc="Capture Piece">
                    if(newClick.getPiece()!=null) {
                        if(newClick.getPiece() instanceof King) {
                            break;
                        } else {
                            j.setIcon(new javax.swing.ImageIcon(this.getClass().getResource(newClick.getPiece().getPath())));
                            if(myTime.getText().equals("Your's Move")) {
                                opponentPiecesDead.add(j);
                            } else {
                                myPiecesDead.add(j);
                            }
                            deadPiece.add(j);
                            newClick.removePiece();
                            pieceCaptured=true;
                        }
                    }
                    //</editor-fold>
                    
                    unhighlightDestination();
                    
                    //<editor-fold defaultstate="collapsed" desc="Perform Castling">
                    if(previousClick.getPiece() instanceof King) {
                        if((previousClick.y-newClick.y)==2 
                                || (previousClick.y-newClick.y)==-2) {
                            performCastling();
                        }
                    }
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="Perform En-Passant">
                    if(isEnpassantPossible) {
                        if(tempNewClick!=null) {
                            if(tempNewClick.getPiece() instanceof Pawn
                                        && previousClick.getPiece() instanceof Pawn) {
                                if(newClick.getPiece()==null 
                                            && ((newClick.x-tempNewClick.x==1) 
                                                || (newClick.x-tempNewClick.x==-1))
                                            && ((previousClick.y-newClick.y==1) 
                                                || (previousClick.y-newClick.y==-1))) {
                                    for(ChessBoardBlocks c:destinationList) {
                                        if(newClick.equals(c)) {
                                            j.setIcon(new javax.swing.ImageIcon(this.getClass().getResource(tempNewClick.getPiece().getPath())));
                                            if(myTime.getText().equals("Your's Move")) {
                                                opponentPiecesDead.add(j);
                                            } else {
                                                myPiecesDead.add(j);
                                            }
                                            performEnpassant();
                                            pieceCaptured=true;
                                            isEnpassantPossible=false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc="Pawn Promotion Code">
                    if(previousClick.getPiece() instanceof Pawn) {
                        if(newClick.x==0) {
                            new PawnPromotion();
                            String str=previousClick.getPiece().getPieceColor();
                            if(str.equals("White")) {
                                switch(promotedTo) {
                                    case "Queen":
                                        try {
                                            p=wq.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Rook":
                                        try {
                                            p=wr1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Bishop":
                                        try {
                                            p=wb1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Knight":
                                        try {
                                            p=wk1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                }
                            } else {
                                switch(promotedTo) {
                                    case "Queen":
                                        try {
                                            p=bq.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Rook":
                                        try {
                                            p=br1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Bishop":
                                        try {
                                            p=bb1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Knight":
                                        try {
                                            p=bk1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                }
                            }
                            promotedTo=null;
                        } else if(newClick.x==7) {
                            new PawnPromotion();
                            String str=previousClick.getPiece().getPieceColor();
                            if(str.equals("White")) {
                                switch(promotedTo) {
                                    case "Queen":
                                        try {
                                            p=wq.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Rook":
                                        try {
                                            p=wr1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Bishop":
                                        try {
                                            p=wb1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Knight":
                                        try {
                                            p=wk1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                }
                            } else {
                                switch(promotedTo) {
                                    case "Queen":
                                        try {
                                            p=bq.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Rook":
                                        try {
                                            p=br1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Bishop":
                                        try {
                                            p=bb1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                    case "Knight":
                                        try {
                                            p=bk1.getCopy();
                                        } catch (CloneNotSupportedException ex) {}
                                        break;
                                }
                            }
                            promotedTo=null;
                        }
                    }
                    //</editor-fold>
                    
                    previousClick.removePiece();
                    previousClick.deSelect();
                    previousClick.setDeselected();
                    newClick.setPiece(p);
                    if(newClick.getPiece() instanceof King 
                            || newClick.getPiece() instanceof Rook) {
                        setFirstMoveFalse(newClick);
                    }
                    if(newClick.getPiece() instanceof King){
                        if(newClick.getPiece().getPieceColor().equals("White")) {
                            wk.x=newClick.x;
                            wk.y=newClick.y;
                        } else {
                            bk.x=newClick.x;
                            bk.y=newClick.y;
                        }
                    }
                    if(tempNewClick!=null) {
                        tempPreviousClick.setBorder(null);
                        tempNewClick.setBackground(moveToBkgdColor);
                    }
                    moveToBkgdColor=newClick.getBackground();
                    tempPreviousClick=previousClick;
                    tempNewClick=newClick;
                    tempPreviousClick.setBorder(BorderFactory.createLineBorder(moveColor, 5));
                    tempNewClick.setBackground(moveColor);
                    
                    if(kingIsInCheck(getKing())) {
                        setKingInDanger(getKing().getPiece().getPieceColor());
                    } else if(kingOldPosition!=null) {
                        setKingNotInDanger(getKing().getPiece().getPieceColor());
                    }
                    
                    if(chance.equals("White")) {
                        if(pieceCaptured || newClick.getPiece() instanceof Pawn) {
                            whiteMovesWithoutPieceCaptureAndPawnMove=0;
                        } else {
                            whiteMovesWithoutPieceCaptureAndPawnMove++;
                        }
                    } else {
                        if(pieceCaptured || newClick.getPiece() instanceof Pawn) {
                            blackMovesWithoutPieceCaptureAndPawnMove=0;
                        } else {
                            blackMovesWithoutPieceCaptureAndPawnMove++;
                        }
                    }
                    
                    if(whiteMovesWithoutPieceCaptureAndPawnMove==50
                                || blackMovesWithoutPieceCaptureAndPawnMove==50) {
                        fiftyMove();
                    }
                    
                    //<editor-fold defaultstate="collapsed" desc="Change Chance">
                    if(myColor.equals("White")) {
                        if(chance.equals("White")) {
                            chance="Black";
                            opponentTime.setText("Opponent's Move");
                            myTime.setText("");
                            opponentPieceColor="White";
                            myPieceColor="Black";
                        } else {
                            chance="White";
                            myTime.setText("Your's Move");
                            opponentTime.setText("");
                            opponentPieceColor="Black";
                            myPieceColor="White";
                        }
                    } else {
                        if(chance.equals("White")) {
                            chance="Black";
                            myTime.setText("Your's Move");
                            opponentTime.setText("");
                            opponentPieceColor="White";
                            myPieceColor="Black";
                        } else {
                            chance="White";
                            opponentTime.setText("Opponent's Move");
                            myTime.setText("");
                            opponentPieceColor="Black";
                            myPieceColor="White";
                        }
                    }
                    //</editor-fold>
                    
                    if(kingIsInCheck(getKing())) {
                        setKingInDanger(getKing().getPiece().getPieceColor());
                    } else if(kingOldPosition!=null) {
                        setKingNotInDanger(getKing().getPiece().getPieceColor());
                    }
                    
                    if(!isMoveLeft()) {
                        if(kingIsInCheck(getKing())) {
                            checkmate(chance);
                        } else {
                            matchDraw();
                        }
                    }
                    
                    drawByInsufficientPieces();
                    
                    pack();
                    repaint();
                    previousClick=null;
                    newClick=null;
                    destinationList.clear();
                    pieceCaptured=false;
                    break;
                }
            }
        }
        //</editor-fold>
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //<editor-fold defaultstate="collapsed">
        if(e.getComponent().isOpaque()) {
            
            if(e.getSource().equals(tempPreviousClick))
                return;
            
            ChessBoardBlocks newBlock=(ChessBoardBlocks)e.getSource();
            
            if(newClick!=null && newBlock.getIsSelected()==true)
                return;

            newBlock.setBorder(BorderFactory.createLineBorder(focusColor, 5));
        }
        //</editor-fold>
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //<editor-fold defaultstate="collapsed">
        if(e.getComponent().isOpaque()) {
            if(e.getSource().equals(tempPreviousClick))
                return;
            
            ChessBoardBlocks newBlock=(ChessBoardBlocks)e.getSource();
            
            if(newClick!=null && newBlock.getIsSelected()==true)
                return;
            
            if(newBlock.getHightlighted()) {
                newBlock.setBorder(BorderFactory.createLineBorder(highlightColor, 5));
                return;
            }
            
            newBlock.setBorder(null);
        }
        //</editor-fold>
    }
    
}
