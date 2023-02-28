/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import javax.swing.*;

/**
 *
 * @author jitesh
 */
public class Rules extends JDialog{

    private final JPanel ruleViewPanel;
    private final JScrollPane jScrollPane3;
    private final JTextArea ruleText;
    private final JMenu otherRules;
    private final JMenuItem closeMenu;
    private final JPopupMenu.Separator jSeparator1;
    private final JMenuItem rookMenu;
    private final JMenuItem queenMenu;
    private final JMenuItem pawnMenu;
    private final JMenuItem knightMenu;
    private final JMenuItem kingMenu;
    private final JMenuItem bishopMenu;
    private final JMenu rules;
    private final JMenuBar jMenuBar2;
    private final JLabel jLabel3;
    private final JPanel defaultPanel;
    private final JButton right;
    private final JButton left;
    private final JLabel ruleImage;
    private final JMenuItem aboutMenu;
    private final JMenu about;
    private final JMenuItem touchAndMoveMenu;
    private final JMenuItem timeControlMenu;
    private final JMenuItem threefoldRepetitionMenu;
    private final JMenuItem resigningMenu;
    private final JMenuItem promotionMenu;
    private final JMenuItem fiftyMoveMenu;
    private final JMenuItem enPassantMenu;
    private final JMenuItem drawByAgreementMenu;
    private final JMenuItem drawMenu;
    private final JMenuItem checkmateMenu;
    private final JMenuItem checkMenu;
    private final JMenuItem castlingMenu;
    
    public Rules() {

        ruleViewPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ruleText = new javax.swing.JTextArea();
        ruleImage = new javax.swing.JLabel();
        left = new javax.swing.JButton();
        right = new javax.swing.JButton();
        defaultPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        rules = new javax.swing.JMenu();
        bishopMenu = new javax.swing.JMenuItem();
        kingMenu = new javax.swing.JMenuItem();
        knightMenu = new javax.swing.JMenuItem();
        pawnMenu = new javax.swing.JMenuItem();
        queenMenu = new javax.swing.JMenuItem();
        rookMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        closeMenu = new javax.swing.JMenuItem();
        otherRules = new javax.swing.JMenu();
        castlingMenu = new javax.swing.JMenuItem();
        checkMenu = new javax.swing.JMenuItem();
        checkmateMenu = new javax.swing.JMenuItem();
        drawMenu = new javax.swing.JMenuItem();
        drawByAgreementMenu = new javax.swing.JMenuItem();
        enPassantMenu = new javax.swing.JMenuItem();
        fiftyMoveMenu = new javax.swing.JMenuItem();
        promotionMenu = new javax.swing.JMenuItem();
        resigningMenu = new javax.swing.JMenuItem();
        threefoldRepetitionMenu = new javax.swing.JMenuItem();
        timeControlMenu = new javax.swing.JMenuItem();
        touchAndMoveMenu = new javax.swing.JMenuItem();
        about = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        this.setMinimumSize(new java.awt.Dimension(684, 448));
        this.setResizable(false);

        ruleText.setEditable(false);
        ruleText.setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N
        ruleText.setRows(5);
        ruleText.setAutoscrolls(false);
        ruleText.setFocusable(false);
        jScrollPane3.setViewportView(ruleText);

        ruleImage.setMaximumSize(new java.awt.Dimension(210, 210));
        ruleImage.setMinimumSize(new java.awt.Dimension(210, 210));
        ruleImage.setPreferredSize(new java.awt.Dimension(210, 210));

        left.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/leftArrow.png")));
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        right.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/rightArrow.png")));
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ruleViewPanelLayout = new javax.swing.GroupLayout(ruleViewPanel);
        ruleViewPanel.setLayout(ruleViewPanelLayout);
        ruleViewPanelLayout.setHorizontalGroup(
            ruleViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ruleViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ruleViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ruleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ruleViewPanelLayout.createSequentialGroup()
                        .addComponent(left)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(right)))
                .addContainerGap())
        );
        ruleViewPanelLayout.setVerticalGroup(
            ruleViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ruleViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ruleViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ruleViewPanelLayout.createSequentialGroup()
                        .addGroup(ruleViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(left)
                            .addComponent(right))
                        .addGap(25, 25, 25)
                        .addComponent(ruleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        defaultPanel.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("FreeSerif", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Click on menu to view the rules.");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout defaultPanelLayout = new javax.swing.GroupLayout(defaultPanel);
        defaultPanel.setLayout(defaultPanelLayout);
        defaultPanelLayout.setHorizontalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        defaultPanelLayout.setVerticalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        rules.setText("Moves");

        bishopMenu.setText("Bishop");
        bishopMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bishopMenuActionPerformed(evt);
            }
        });
        rules.add(bishopMenu);

        kingMenu.setText("King");
        kingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kingMenuActionPerformed(evt);
            }
        });
        rules.add(kingMenu);

        knightMenu.setText("Knight");
        knightMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knightMenuActionPerformed(evt);
            }
        });
        rules.add(knightMenu);

        pawnMenu.setText("Pawn");
        pawnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pawnMenuActionPerformed(evt);
            }
        });
        rules.add(pawnMenu);

        queenMenu.setText("Queen");
        queenMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queenMenuActionPerformed(evt);
            }
        });
        rules.add(queenMenu);

        rookMenu.setText("Rook");
        rookMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rookMenuActionPerformed(evt);
            }
        });
        rules.add(rookMenu);
        rules.add(jSeparator1);

        closeMenu.setText("Close");
        closeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuActionPerformed(evt);
            }
        });
        rules.add(closeMenu);

        jMenuBar2.add(rules);

        otherRules.setText("Other Rules");

        castlingMenu.setText("Castling");
        castlingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                castlingMenuActionPerformed(evt);
            }
        });
        otherRules.add(castlingMenu);

        checkMenu.setText("Check");
        checkMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMenuActionPerformed(evt);
            }
        });
        otherRules.add(checkMenu);

        checkmateMenu.setText("Checkmate");
        checkmateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkmateMenuActionPerformed(evt);
            }
        });
        otherRules.add(checkmateMenu);

        drawMenu.setText("Draw/ Stalemate");
        drawMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawMenuActionPerformed(evt);
            }
        });
        otherRules.add(drawMenu);

        drawByAgreementMenu.setText("Draw by agreement");
        drawByAgreementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawByAgreementMenuActionPerformed(evt);
            }
        });
        otherRules.add(drawByAgreementMenu);

        enPassantMenu.setText("En passant");
        enPassantMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enPassantMenuActionPerformed(evt);
            }
        });
        otherRules.add(enPassantMenu);

        fiftyMoveMenu.setText("Fifty-move rule");
        fiftyMoveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyMoveMenuActionPerformed(evt);
            }
        });
        otherRules.add(fiftyMoveMenu);

        promotionMenu.setText("Promotion");
        promotionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promotionMenuActionPerformed(evt);
            }
        });
        otherRules.add(promotionMenu);

        resigningMenu.setText("Resigning");
        resigningMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resigningMenuActionPerformed(evt);
            }
        });
        otherRules.add(resigningMenu);

        threefoldRepetitionMenu.setText("Threefold repetition");
        threefoldRepetitionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threefoldRepetitionMenuActionPerformed(evt);
            }
        });
        otherRules.add(threefoldRepetitionMenu);

        timeControlMenu.setText("Time control");
        timeControlMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeControlMenuActionPerformed(evt);
            }
        });
        otherRules.add(timeControlMenu);

        touchAndMoveMenu.setText("Touch-move rule");
        touchAndMoveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                touchAndMoveMenuActionPerformed(evt);
            }
        });
        otherRules.add(touchAndMoveMenu);

        jMenuBar2.add(otherRules);

        about.setText("About");

        aboutMenu.setText("About the game");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        about.add(aboutMenu);

        jMenuBar2.add(about);

        this.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout RulesLayout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(RulesLayout);
        RulesLayout.setHorizontalGroup(
            RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defaultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RulesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ruleViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        RulesLayout.setVerticalGroup(
            RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defaultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RulesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ruleViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rules");
        ruleViewPanel.setVisible(false);

        pack();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.show();
    }
    
    private void closeMenuActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }                                         

    private void bishopMenuActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("How to Move the Bishop in Chess\n\n" +
                "The bishop may move as far as it wants, but\n"
                + "only diagonally.Each bishop starts on one color\n"
                + "(light or dark) and must always stay\n"
                + "on that color.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/bishop.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        left.setEnabled(false);
    }                                          

    private void kingMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("How to Move the King in Chess\n\n"
                + "The king is the most important piece, but is one\n"
                + "of the weakest. The king can only move one square\n"
                + "in any direction - up, down, to the sides, and\n"
                + "diagonally.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/king.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                        

    private void knightMenuActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("How to Move the Knight in Chess\n\n" +
                "Knights move in a very different way from the other\npieces –\n"
                + "going two squares in one direction, and then one more\n"
                + "move at a 90 degree angle, just like the shape of an “L”.\n"
                + "Knights are also the only pieces that can move over\n"
                + "other pieces.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/knight.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                          

    private void pawnMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("How to Move the Pawn in Chess\n\n" +
                "Pawns are unusual because they move and capture in\n"
                + "different ways: they move forward, but capture diagonally.\n"
                + "Pawns can only move forward one square at a time, except\n"
                + "for their very first move where they can move forward\n"
                + "two squares. Pawns can only capture one square diagonally\n"
                + "in front of them. They can never move or capture\nbackwards.\n\n"
                + "If there is another piece directly in front of a pawn he\n"
                + "cannot move past or capture that piece.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/pawn.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                        

    private void queenMenuActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("How to Move the Queen in Chess\n\n"
                + "The queen is the most powerful piece. She can move in\n"
                + "any one straight direction - forward, backward, sideways,\n"
                + "or diagonally - as far as possible as long as she does\n"
                + "not move through any of her own pieces. And, like with\n"
                + "all pieces, if the queen captures an opponent's piece her\n"
                + "move is over.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/queen.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                         

    private void rookMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("How to Move the Rook in Chess\n\n"
                + "The rook may move as far as it wants, but only forward,\n"
                + "backward, and to the sides. The rooks are particularly\n"
                + "powerful pieces when they are protecting each other and\n"
                + "working together!");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/moves/rook.png")));
        if(!left.isEnabled()){
            left.setEnabled(true);
        }
        right.setEnabled(false);
    }                                        

    private void castlingMenuActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("CASTLING RULE:\n\n\n"
                + "One other special chess rule is called castling.\n" +
                "This move allows you to do two important things\n" +
                "all in one move: get your king to safety\n" +
                "(hopefully), and get your rook out of the corner\n" +
                "and into the game. On a player's turn he may\n" +
                "move his king two squares over to one side and\n" +
                "then move the rook from that side's corner to\n" +
                "right next to the king on the opposite side.\n" +
                "However, in order to castle, the following\n" +
                "conditions must be met:\n" +
                "\n" +
                "1) It must be that king's very first move\n" +
                "\n" +
                "2) It must be that rook's very first move\n" +
                "\n" +
                "3) There cannot be any pieces between the king"
                + "\nand rook to move\n" +
                "\n" +
                "4) The king may not be in check or pass through\ncheck" +
                "\n" +
                "\n" +
                "Notice that when you castle one direction the king\n" +
                "is closer to the side of the board. That is called\n" +
                "castling \"kingside\". Castling to the other side,\n" +
                "through where the queen sat, is called castling\n" +
                "\"queenside\". Regardless of which side, the king\n" +
                "always moves only two squares when castling.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/castling.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        left.setEnabled(false);
    }                                            

    private void checkMenuActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("CHECK RULE:\n\n\n"
                + "A king is in check when it is under attack by at\n" +
                "least one enemy piece. A piece unable to move\n" +
                "because it would place its own king in check (it\n" +
                "is pinned against its own king) may still deliver\n" +
                "check to the opposing player.\n" +
                "\n" +
                "It is illegal to make a move that places or leaves\n" +
                "one's king in check. The possible ways to get out\n" +
                "of check are:\n" +
                "\n" +
                "1) Move the king to a square where it is not in\n" +
                "check (though he cannot castle!).\n" +
                "\n" +
                "2) Capture the checking piece (possibly with the\n" +
                "king).\n" +
                "\n" +
                "3) Block the check by placing a piece between the\n" +
                "king and the opponent's threatening piece.\n" +
                "\n" +
                "\n" +
                "If it is not possible to get out of check, the\n" +
                "king is checkmated and the game is over.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/check.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                         

    private void checkmateMenuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("CHECKMATE RULE\n\n\n"
                + "The purpose of the game is to checkmate the\n" +
                "opponent's king. This happens when the king is\n" +
                "put into check and cannot get out of check.\n" +
                "If a king cannot escape checkmate then the game\n" +
                "is over. Customarily the king is not captured or\n" +
                "removed from the board, the game is simply\n" +
                "declared over.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/checkmate.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                             

    private void drawMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("DRAW RULE:\n\n\n"
                + "Occasionally chess games do not end with a winner,\n" +
                "ut with a draw.\n" +
                "\n" +
                "The position reaches a stalemate where it is one\n" +
                "player's turn to move, but his king is NOT in check\n" +
                "and yet he does not have another legal move\n" +
                "\n" +
                "There are not enough pieces on the board to force\n" +
                "a checkmate (example: a king and a bishop vs.a king)\n" +
                "\n" +
                "A player declares a draw if the same exact position\n" +
                "is repeated three times (though not necessarily\n" +
                "three times in a row)\n" +
                "\n" +
                "Fifty consecutive moves have been played where\n" +
                "neither player has moved a pawn or captured a piece"
                + "\n\n"
                + "Stalemate is a situation on the chess board, when\n" +
                "the player whose turn it is to move has no legal\n" +
                "moves available but is not currently in check .");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/stalemate.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                        

    private void drawByAgreementMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("DRAW BY AGREEMENY RULE:\n\n\n"
                + "The both players may simply agree to a draw and\n"
                + "stop playing After making a move, a player can propose\n"
                + "a draw: his opponent can accept the proposal (in which\n"
                + "case the game ends and is a draw) or refuse the\n"
                + "proposal (in which case the game continues).");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/drawbyagreement.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                                   

    private void enPassantMenuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("EN PASSANT RULE:\n\n\n"
                + "If a pawn moves out two squares on its first move,\n" +
                "and by doing so lands to the side of an opponent's\n" +
                "pawn (effectively jumping past the other pawn's\n" +
                "ability to capture it), that other pawn has the\n" +
                "option of capturing the first pawn as it passes by.\n" +
                "\n" +
                "This special move must be done immediately after\n" +
                "the first pawn has moved past, otherwise the\n" +
                "option to capture it is no longer available.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/enpassant.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                             

    private void fiftyMoveMenuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("FIFTY MOVE RULE:\n\n\n"
                + "As per the chess rules, if the last 50 consecutive\n" +
                "moves have been made by each player without the\n" +
                "movement of any pawn and without the capture of\n" +
                "any piece, the game can be declared a draw by\n" +
                "either of the opponents. The other player's\n" +
                "approval is not required, and the game ends\n" +
                "immediately and is recorded as a draw for both\n" +
                "players.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/fiftymove.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                             

    private void promotionMenuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("PROMOTION RULE:\n\n\n"
                + "Promotion is a chess rule that requires a pawn that\n" +
                "reaches its eighth rank to be immediately replaced\n" +
                "by the player's choice of a queen, knight, rook,\n" +
                "or bishop of the same color. The new piece\n" +
                "replaces the pawn on the same square, as part of\n" +
                "the same move.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/promotion.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                             

    private void resigningMenuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("RESINING THE GAME RULE:\n\n\n"
                + "A player can resign the game, which means that he\n" +
                "has lost and his opponent has won.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/resigning.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                             

    private void threefoldRepetitionMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("THREE FOLD REPETITION RULE:\n\n\n"
                + "As per the chess rules, if the current position on\n" +
                "the chess board appeared 3 or more times, the game\n" +
                "can be declared a draw by either of the opponents.\n" +
                "The other player's approval is not required, and\n" +
                "the game ends immediately and is recorded as a\n" +
                "draw for both players. \n" +
                "\n" +
                "Please note that simply repeating the same move 3\n" +
                "or more times by one of the players might not be\n" +
                "enough, as the entire position on the board has to\n" +
                "be repeated. That also includes whose turn it is\n" +
                "to move, all castling possibilities and capture\n" +
                "en passant targets. \n" +
                "\n" +
                "It is not required that the same position occurs\n" +
                "three times during the consecutive moves.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/threefold.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                                       

    private void timeControlMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("TIME CONTROL RULE:\n\n\n"
                + "Most tournaments use timers to regulate the time\n" +
                "spent on each game, not on each move. Each player\n" +
                "gets the same amount of time to use for their\n" +
                "entire game and can decide how to spend that time.\n" +
                "\n" +
                "Once a player makes a move they then touch a\n" +
                "button or hit a lever to start the opponent's\n" +
                "clock. If a player runs out of time and the\n" +
                "opponent calls the time, then the player who ran\n" +
                "out of time loses the game (unless the opponent\n" +
                "does not have enough pieces to checkmate, in\n" +
                "which case it is a draw).");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/timecontrol.png")));
        if(!right.isEnabled())
            right.setEnabled(true);
        if(!left.isEnabled())
            left.setEnabled(true);
        
    }                                               

    private void touchAndMoveMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        
        if(!ruleViewPanel.isVisible()){
            defaultPanel.setVisible(false);
            ruleViewPanel.setVisible(true);
        }
        
        ruleText.setText("TOUCH AND MOVE RULE:\n\n\n"
                + "If a player touches one of their own pieces they\n" +
                "must move that piece as long as it is a legal\n" +
                "move. If a player touches an opponent's piece,\n" +
                "they must capture that piece. A player who wishes\n" +
                "to touch a piece only to adjust it on the board\n" +
                "must first announce the intention, usually by\n" +
                "saying “adjust”.");
        
        ruleImage.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/rules/touchmove.png")));
        if(!left.isEnabled()){
            left.setEnabled(true);
        }
        right.setEnabled(false);
    }                                                

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(ruleViewPanel.isVisible()){
            ruleViewPanel.setVisible(false);
            defaultPanel.setVisible(true);
        }
        
        jLabel3.setText("Appication Version 1.0");
    }                                         

    private void leftActionPerformed(java.awt.event.ActionEvent evt) {                                     

        if(ruleImage.getIcon().toString().contains("moves")){
            if(ruleImage.getIcon().toString().endsWith("king.png"))
                bishopMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("knight.png"))
                kingMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("pawn.png"))
                knightMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("queen.png"))
                pawnMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("rook.png"))
                queenMenuActionPerformed(evt);
        }else{
            if(ruleImage.getIcon().toString().endsWith("check.png"))
                castlingMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("checkmate.png"))
                checkMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("stalemate.png"))
                checkmateMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("drawbyagreement.png"))
                drawMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("enpassant.png"))
                drawByAgreementMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("fiftymove.png"))
                enPassantMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("promotion.png"))
                fiftyMoveMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("resigning.png"))
                promotionMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("threefold.png"))
                resigningMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("timecontrol.png"))
                threefoldRepetitionMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("touchmove.png"))
                timeControlMenuActionPerformed(evt);
        }
        
    }                                    

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        if(ruleImage.getIcon().toString().contains("moves")){
            if(ruleImage.getIcon().toString().endsWith("bishop.png"))
                kingMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("king.png"))
                knightMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("knight.png"))
                pawnMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("pawn.png"))
                queenMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("queen.png"))
                rookMenuActionPerformed(evt);
        }else{
            if(ruleImage.getIcon().toString().endsWith("castling.png"))
                checkMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("check.png"))
                checkmateMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("checkmate.png"))
                drawMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("stalemate.png"))
                drawByAgreementMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("drawbyagreement.png"))
                enPassantMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("enpassant.png"))
                fiftyMoveMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("fiftymove.png"))
                promotionMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("promotion.png"))
                resigningMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("resigning.png"))
                threefoldRepetitionMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("threefold.png"))
                timeControlMenuActionPerformed(evt);
            else if(ruleImage.getIcon().toString().endsWith("timecontrol.png"))
                touchAndMoveMenuActionPerformed(evt);
        }
    }
    
}
