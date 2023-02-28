/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static chess.MainFrame.chessBoardType;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.JDialog;

/**
 *
 * @author jitesh
 */
public class ChangeBoard extends JDialog {
    
    private String tempBoard=chessBoardType;
    URL imgpath;
    
    public ChangeBoard() {
        Dimension d=new Dimension(684,460);
        setTitle("Change Chess Board");
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        chessBoardPreview = new javax.swing.JLabel();
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
                dispose();
            }
        });
        
        chessBoardPreview.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 44, 44)), null));
        chessBoardPreview.setOpaque(true);
        chessBoardPreview.setBackground(new java.awt.Color(255,255,255));
        
        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chessBoardType=tempBoard;
                setChangeView();
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch (tempBoard) {
                    case "Default":
                    tempBoard="Type1";
                    previousButton.setEnabled(true);
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type1":
                    tempBoard="Type2";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type2":
                    tempBoard="Type3";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type3":
                    tempBoard="Type4";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type4":
                    tempBoard="Type5";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type5":
                    tempBoard="Type6";
                    nextButton.setEnabled(false);
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                }
            }
        });

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch (tempBoard) {
                    case "Type1":
                    tempBoard="Default";
                    previousButton.setEnabled(false);
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type2":
                    tempBoard="Type1";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type3":
                    tempBoard="Type2";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type4":
                    tempBoard="Type3";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type5":
                    tempBoard="Type4";
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                case "Type6":
                    tempBoard="Type5";
                    nextButton.setEnabled(true);
                    if(tempBoard.equals(chessBoardType)){
                        selectButton.setEnabled(false);
                    }else{
                        selectButton.setEnabled(true);
                    }
                    chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                    break;
                }
            }
        });

        jLabel.setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("Select the board which you want");

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
                            .addComponent(chessBoardPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(chessBoardPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        switch (tempBoard) {
            case "Default":
                previousButton.setEnabled(false);
                selectButton.setEnabled(false);
                chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                break;
            case "Type1":
                selectButton.setEnabled(false);
                chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                break;
            case "Type2":
                selectButton.setEnabled(false);
                chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                break;
            case "Type3":
                selectButton.setEnabled(false);
                chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                break;
            case "Type4":
                selectButton.setEnabled(false);
                chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                break;
            case "Type5":
                selectButton.setEnabled(false);
                chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                break;
            case "Type6":
                selectButton.setEnabled(false);
                nextButton.setEnabled(false);
                chessBoardPreview.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/boards/"
                            +tempBoard+"/preview.png")));
                break;
            default:
                break;
        }
    }

    private javax.swing.JLabel chessBoardPreview;
    private final javax.swing.JLabel jLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton selectButton;
    
}
