/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static chess.MainFrame.chessPiecesType;
import static chess.MainFrame.oldPieceType;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author jitesh
 */
public class ChangePieces extends JDialog {
    
    private String selectedPiece=chessPiecesType, tempPieces=chessPiecesType;
    
    public ChangePieces() {
        Dimension d=new Dimension(684,460);
        setTitle("Change Chess Pieces");
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        chessPiecesPreview = new javax.swing.JLabel();
        selectButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        jPanel=new javax.swing.JPanel();
        jPanel.setBackground(new java.awt.Color(240,240,240));
        this.add(jPanel);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                oldPieceType=chessPiecesType;
                chessPiecesType=selectedPiece;
                dispose();
            }
        });
        
        chessPiecesPreview.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 44, 44)), null));
        chessPiecesPreview.setOpaque(true);
        chessPiecesPreview.setBackground(new java.awt.Color(255,255,255));
        
        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedPiece=tempPieces;
                setChangeView();
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch (tempPieces) {
                    case "Default":
                    tempPieces="Type1";
                    previousButton.setEnabled(true);
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type1":
                    tempPieces="Type2";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type2":
                    tempPieces="Type3";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type3":
                    tempPieces="Type4";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type4":
                    tempPieces="Type5";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type5":
                    tempPieces="Type6";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type6":
                    tempPieces="Type7";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type7":
                    tempPieces="Type8";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type8":
                    tempPieces="Type9";
                    nextButton.setEnabled(false);
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                }
            }
        });

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch (tempPieces) {
                    case "Type1":
                    tempPieces="Default";
                    previousButton.setEnabled(false);
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type2":
                    tempPieces="Type1";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type3":
                    tempPieces="Type2";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type4":
                    tempPieces="Type3";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type5":
                    tempPieces="Type4";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type6":
                    tempPieces="Type5";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type7":
                    tempPieces="Type6";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type8":
                    tempPieces="Type7";
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                case "Type9":
                    tempPieces="Type8";
                    nextButton.setEnabled(true);
                    if(tempPieces.equals(selectedPiece)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                    break;
                }
            }
        });

        jLabel.setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("Select the pieces which you want");

        javax.swing.GroupLayout changeChessBoardLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(changeChessBoardLayout);
        changeChessBoardLayout.setHorizontalGroup(
            changeChessBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeChessBoardLayout.createSequentialGroup()
                .addGroup(changeChessBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changeChessBoardLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(changeChessBoardLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(previousButton)
                        .addGap(54, 54, 54)
                        .addGroup(changeChessBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(chessPiecesPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );
        changeChessBoardLayout.setVerticalGroup(
            changeChessBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changeChessBoardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(changeChessBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chessPiecesPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(changeChessBoardLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(changeChessBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(previousButton)
                            .addComponent(nextButton))))
                .addGap(18, 18, 18)
                .addComponent(selectButton)
                .addGap(22, 22, 22))
        );
        setChangeView();
        pack();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.show();
    
    }

    private void setChangeView(){
        switch (tempPieces) {
            case "Default":
                previousButton.setEnabled(false);
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type1":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type2":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type3":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type4":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type5":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type6":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type7":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type8":
                selectButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            case "Type9":
                selectButton.setEnabled(false);
                nextButton.setEnabled(false);
                chessPiecesPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/pieces/"
                            +tempPieces+"/preview.png")));
                break;
            default:
                break;
        }
    }

    private javax.swing.JLabel chessPiecesPreview;
    private final javax.swing.JLabel jLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton selectButton;
    
}
