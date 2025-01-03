package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SortDisplayForm extends JFrame
{
    //LIst to hold the sorted items fom the main form.
    LinkedList<SortItem> sortedList;
    //The text grid that will be built on screen.
    JTextField[][] dataGrid;
    //The layout to be used form positioning components.
    SpringLayout layout = new SpringLayout();

    /**
     * sorts the data from the main data grid, then opens a new window
     * which displays the shorted data and where it is in the data grid
     * with x/y values
     * @param data
     * @param searchText
     */
    public SortDisplayForm(LinkedList<SortItem> data, String searchText)
    {
        sortedList = data;
        //Set the size and start location of the form.
        //The height of the form is calculated based upon how many items are in the sorted list.
        setSize(250,sortedList.size() * 25 + 55);
        setLocation(400,200);

        setLayout(layout);
        //Create the textgrid with a size of 3 columns and rows equal to the number of items in the sorted list
        dataGrid = new JTextField[3][sortedList.size()];
        //Iterate through the text grid rows
        for (int y = 0; y < dataGrid[0].length; y++)
        {
            //Calculate the row's horizontal position
            int yPos = y * 25 + 20;
            //Build the 3 columns of the row at the calculated row height.
            dataGrid[0][y] = UIBuilderLibrary.BuildATextField(3,20,yPos,layout,this);
            add(dataGrid[0][y]);
            dataGrid[1][y] = UIBuilderLibrary.BuildATextFieldInlineToRight(3,2,layout, dataGrid[0][y]);
            add(dataGrid[1][y]);
            dataGrid[2][y] = UIBuilderLibrary.BuildATextFieldInlineToRight(8,2,layout, dataGrid[1][y]);
            add(dataGrid[2][y]);
        }
        //Iterate through the sortedList contents.
        for (int i = 0; i < sortedList.size(); i++)
        {
            //Copy the text from the sortedList into the rows of the text grid.
            dataGrid[0][i].setText(sortedList.get(i).xIndex + "");
            dataGrid[1][i].setText(sortedList.get(i).yIndex + "");
            dataGrid[2][i].setText(sortedList.get(i).text);

            //If the textfield currently being filled contains the search keyword.
            if (sortedList.get(i).text.toLowerCase().contains(searchText.toLowerCase()) && searchText.isEmpty() == false)
            {
                //Colour all fields in this row orange.
                dataGrid[0][i].setBackground(Color.orange);
                dataGrid[1][i].setBackground(Color.orange);
                dataGrid[2][i].setBackground(Color.orange);
            }
        }
        //Set the for visible to the user.
        setVisible(true);
    }
}
