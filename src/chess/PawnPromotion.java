/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static chess.MainFrame.chessPiecesType;
import static chess.MainFrame.myPieceColor;
import javax.swing.*;
import static chess.MainFrame.promotedTo;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author jitesh
 */
public class PawnPromotion extends JDialog {
    
    private javax.swing.JRadioButton bishopRadioButton;
    private javax.swing.JLabel bishopIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel knightIcon;
    private javax.swing.JRadioButton knightRadioButton;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel queenIcon;
    private javax.swing.JRadioButton queenRadioButton;
    private javax.swing.ButtonGroup radioButtonGroup;
    private javax.swing.JLabel rookIcon;
    private javax.swing.JRadioButton rookRadioButton;
    
    public PawnPromotion() {

        radioButtonGroup = new javax.swing.ButtonGroup();
        queenIcon = new javax.swing.JLabel();
        rookIcon = new javax.swing.JLabel();
        bishopIcon = new javax.swing.JLabel();
        knightIcon = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        queenRadioButton = new javax.swing.JRadioButton();
        rookRadioButton = new javax.swing.JRadioButton();
        bishopRadioButton = new javax.swing.JRadioButton();
        knightRadioButton = new javax.swing.JRadioButton();

        this.setMaximumSize(new java.awt.Dimension(486, 350));
        this.setMinimumSize(new java.awt.Dimension(486, 350));
        this.setPreferredSize(new java.awt.Dimension(486, 350));
        this.setTitle("Pawn Promotion");

        queenIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        queenIcon.setPreferredSize(new Dimension(100, 100));
        queenIcon.setMinimumSize(new Dimension(100, 100));
        queenIcon.setMaximumSize(new Dimension(100, 100));
        queenIcon.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                    +chessPiecesType+"/"+myPieceColor.toLowerCase()
                    +"/queen.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout queenIconLayout = new javax.swing.GroupLayout(queenIcon);
        queenIcon.setLayout(queenIconLayout);
        queenIconLayout.setHorizontalGroup(
            queenIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        queenIconLayout.setVerticalGroup(
            queenIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        rookIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rookIcon.setPreferredSize(new Dimension(100, 100));
        rookIcon.setMinimumSize(new Dimension(100, 100));
        rookIcon.setMaximumSize(new Dimension(100, 100));
        rookIcon.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                    +chessPiecesType+"/"+myPieceColor.toLowerCase()
                    +"/rook.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout rookIconLayout = new javax.swing.GroupLayout(rookIcon);
        rookIcon.setLayout(rookIconLayout);
        rookIconLayout.setHorizontalGroup(
            rookIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        rookIconLayout.setVerticalGroup(
            rookIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        bishopIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bishopIcon.setPreferredSize(new Dimension(100, 100));
        bishopIcon.setMinimumSize(new Dimension(100, 100));
        bishopIcon.setMaximumSize(new Dimension(100, 100));
        bishopIcon.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                    +chessPiecesType+"/"+myPieceColor.toLowerCase()
                    +"/bishop.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout bishopIconLayout = new javax.swing.GroupLayout(bishopIcon);
        bishopIcon.setLayout(bishopIconLayout);
        bishopIconLayout.setHorizontalGroup(
            bishopIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        bishopIconLayout.setVerticalGroup(
            bishopIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        knightIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        knightIcon.setPreferredSize(new Dimension(100, 100));
        knightIcon.setMinimumSize(new Dimension(100, 100));
        knightIcon.setMaximumSize(new Dimension(100, 100));
        knightIcon.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                    +chessPiecesType+"/"+myPieceColor.toLowerCase()
                    +"/knight.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout knightIconLayout = new javax.swing.GroupLayout(knightIcon);
        knightIcon.setLayout(knightIconLayout);
        knightIconLayout.setHorizontalGroup(
            knightIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        knightIconLayout.setVerticalGroup(
            knightIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(queenRadioButton.isSelected()) {
                    promotedTo="Queen";
                    dispose();
                } else if(rookRadioButton.isSelected()) {
                    promotedTo="Rook";
                    dispose();
                } else if(bishopRadioButton.isSelected()) {
                    promotedTo="Bishop";
                    dispose();
                } else if(knightRadioButton.isSelected()) {
                    promotedTo="Knight";
                    dispose();
                }
            }
        });

        jLabel1.setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N
        jLabel1.setText("Choose the piece you want to promote the pawn");

        radioButtonGroup.add(queenRadioButton);
        queenRadioButton.setText("Queen");

        radioButtonGroup.add(rookRadioButton);
        rookRadioButton.setText("Rook");

        radioButtonGroup.add(bishopRadioButton);
        bishopRadioButton.setText("Bishop");

        radioButtonGroup.add(knightRadioButton);
        knightRadioButton.setText("Knight");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(queenIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queenRadioButton))
                                .addGap(18, 18, 18)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rookRadioButton))
                                .addGap(18, 18, 18)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bishopIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bishopRadioButton))
                                .addGap(18, 18, 18)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(knightRadioButton)
                                    .addComponent(knightIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(knightIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bishopIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queenIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queenRadioButton)
                    .addComponent(rookRadioButton)
                    .addComponent(bishopRadioButton)
                    .addComponent(knightRadioButton))
                .addGap(22, 22, 22)
                .addComponent(okButton)
                .addGap(42, 42, 42))
        );
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        pack();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.show();
    }
    
}
