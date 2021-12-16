package finalproject;

/** @author Stephen Koch */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrameMaker extends JFrame{
    private static final int FRAME_WIDTH = 425;
    private static final int FRAME_HEIGHT = 400;
    private SnowmanComponent sc;
    private ActionListener listener;
    
    private JRadioButton nightButton;
    private JRadioButton dayButton;
    private JComboBox hatCombo;
    
    public FrameMaker(){
        setSize(425,400);
        JPanel controlPanel = new JPanel();
        JPanel hatPanel = createComboBox();
        JPanel timePanel = createRadioButtons();
        sc = new SnowmanComponent();
        add(sc, BorderLayout.CENTER);
        controlPanel.add(hatPanel);
        controlPanel.add(timePanel);
        controlPanel.setLayout(new GridLayout(1,2));
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(),"Control Panel"));
        add(controlPanel, BorderLayout.SOUTH);
        repaint();
    }
    
    class ChoiceListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            setSnowman();
        }
    }
    
    public JPanel createComboBox(){
        hatCombo = new JComboBox();
        hatCombo.addItem("Black");
        hatCombo.addItem("Blue");
        hatCombo.addItem("Green");
        hatCombo.setEditable(true);
        hatCombo.addActionListener(listener);
        
        JPanel panel = new JPanel();
        panel.add(hatCombo);
        return panel;
    }
    
    public JPanel createRadioButtons(){
        nightButton = new JRadioButton("Night");
        nightButton.addActionListener(listener);
        
        dayButton = new JRadioButton("Day");
        dayButton.addActionListener(listener);
        
        ButtonGroup group = new ButtonGroup();
        group.add(nightButton);
        group.add(dayButton);
        
        JPanel panel = new JPanel();
        panel.add(nightButton);
        panel.add(dayButton);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
        
        return panel;
    }
    
    public void setSnowman(){
        String hatSelected = (String) hatCombo.getSelectedItem();
        if(hatSelected.equals("black")) sc.setHatColor("black");
        else if(hatSelected.equals("blue")) sc.setHatColor("blue");
        else if(hatSelected.equals("green")) sc.setHatColor("green");
        
        if (dayButton.isSelected()) sc.setTime("day");
        else if (nightButton.isSelected()) sc.setTime("night");
        
        repaint();
    }
}
