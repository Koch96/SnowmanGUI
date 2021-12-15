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
        sc = new SnowmanComponent();
        add(sc, BorderLayout.CENTER);
        listener = new ChoiceListener();
        
        setSize(425,400);
        
        createControlPanel();
        setSnowman();
    }
    
    class ChoiceListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            setSnowman();
        }
    }
    
    public void createControlPanel(){
        JPanel hatPanel = createComboBox();
        JPanel timePanel = createRadioButtons();
        
        JPanel controlPanel = new JPanel();
        controlPanel.add(hatPanel);
        controlPanel.add(timePanel);
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
        if(hatCombo.getSelectedItem()=="black") sc.setHatColor("black");
        if(hatCombo.getSelectedItem()=="blue") sc.setHatColor("blue");
        if(hatCombo.getSelectedItem()=="green") sc.setHatColor("green");
        
        if (dayButton.isSelected()) sc.setTime("day");
        else if (nightButton.isSelected()) sc.setTime("night");
        
        repaint();
    }
}
