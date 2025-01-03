package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UIBuilderLibrary
{
    private static Color CornFlowerBlue = new Color(100, 149, 237);


    /**
     * the code to run to make a label
     * @param width
     * @param height
     * @param text
     * @param xPad
     * @param yPad
     * @param layout
     * @param other
     * @return
     */
    public static JLabel BuildAJLabel(int width,int height, String text, int xPad, int yPad, SpringLayout layout, Component other)
    {
        final int w = width;
        final int h = height;
        // Create a new JLabel object with the text provided by the parameters
        JLabel label = new JLabel(text)
        {
            {
                setPreferredSize(new Dimension(w, h));
            }
        };
        // Set the position of the input label using the SpringLayout object
        layout.putConstraint(SpringLayout.WEST,label,xPad,SpringLayout.WEST,other);
        layout.putConstraint(SpringLayout.NORTH,label,yPad,SpringLayout.NORTH,other);
        label.setOpaque(true);
        label.setBackground(CornFlowerBlue);
        return label;
    }

    /**
     * the code to run to make a text field
     * @param width
     * @param height
     * @param text
     * @param xPad
     * @param yPad
     * @param layout
     * @param other
     * @return
     */
    public static JTextField BuildATextField(int width,int height, String text, int xPad, int yPad, SpringLayout layout, Component other)
    {
        // Create a new JTextField object with a size as specified by the parameters
        final int w = width;
        final int h = height;
        // Create a new JLabel object with the text provided by the parameters
        JTextField textField = new JTextField(text)
        {
            {
                setPreferredSize(new Dimension(w, h));
            }
        };        // Set the position of the input text field using the SpringLayout object
        layout.putConstraint(SpringLayout.WEST,textField,xPad,SpringLayout.WEST,other);
        layout.putConstraint(SpringLayout.NORTH,textField,yPad,SpringLayout.NORTH,other);
        return textField;
    }

    /**
     * the code to run to make a text field
     * @param size
     * @param xPad
     * @param yPad
     * @param layout
     * @param other
     * @return
     */
    public static JTextField BuildATextField(int size, int xPad, int yPad, SpringLayout layout, Component other)
    {
        // Create a new JTextField object with a size as specified by the parameters
        JTextField textfield = new JTextField(size);
        // Set the position of the input text field using the SpringLayout object
        layout.putConstraint(SpringLayout.WEST,textfield,xPad,SpringLayout.WEST,other);
        layout.putConstraint(SpringLayout.NORTH,textfield,yPad,SpringLayout.NORTH,other);
        return textfield;
    }

    /**
     * the code to run to make a text field to the right of another component
     * @param size
     * @param xPad
     * @param layout
     * @param other
     * @return
     */
    public static JTextField BuildATextFieldInlineToRight(int size, int xPad, SpringLayout layout, Component other)
    {
        // Create a new JTextField object with a size as specified by the parameters
        JTextField textfield = new JTextField(size);
        // Set the position of the input text field using the SpringLayout object
        layout.putConstraint(SpringLayout.WEST,textfield,xPad,SpringLayout.EAST,other);
        layout.putConstraint(SpringLayout.NORTH,textfield,0,SpringLayout.NORTH,other);
        return textfield;
    }

    /**
     * the code to run to make a button
     * @param width
     * @param height
     * @param text
     * @param xPad
     * @param yPad
     * @param listener
     * @param layout
     * @param other
     * @return
     */
    public static JButton BuildAButton(int width,int height,String text,int xPad, int yPad, ActionListener listener,SpringLayout layout, Component other)
    {
        final int w = width;
        final int h = height;
        JButton button = new JButton(text)
        {
            {
                setPreferredSize(new Dimension(w, h));
            }
        };
        // Create a new JButton object with the text passed in the parameters
        //JButton button = new JButton(text);
        //Sets the size of the button based upon the provided parameters
        //button.setSize(width,height);
        //Add an action Listener(receiver) that the button needs to inform when it has been pressed
        button.addActionListener(listener);
        // Set the position of the button using the SpringLayout object
        layout.putConstraint(SpringLayout.WEST,button,xPad,SpringLayout.WEST,other);
        layout.putConstraint(SpringLayout.NORTH,button,yPad,SpringLayout.NORTH,other);
        button.setBackground(Color.lightGray);
        return button;


    }

    /**
     * the code to run to make a buttons
     * @param width
     * @param height
     * @param text
     * @param xPad
     * @param yPad
     * @param listener
     * @param layout
     * @param frame
     * @return
     */
    public static JButton BuildAButton(int width,int height,String text,int xPad, int yPad, ActionListener listener,SpringLayout layout, JFrame frame)
    {
        final int w = width;
        final int h = height;
        JButton button = new JButton(text)
        {
            {
                setPreferredSize(new Dimension(w, h));
            }
        };
        // Create a new JButton object with the text passed in the parameters
        //JButton button = new JButton(text);
        //Sets the size of the button based upon the provided parameters
        //button.setSize(width,height);
        //Add an action Listener(receiver) that the button needs to inform when it has been pressed
        button.addActionListener(listener);
        // Set the position of the button using the SpringLayout object
        layout.putConstraint(SpringLayout.WEST,button,xPad,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.NORTH,button,yPad,SpringLayout.NORTH,frame);
        button.setBackground(Color.lightGray);
        return button;


    }
}

