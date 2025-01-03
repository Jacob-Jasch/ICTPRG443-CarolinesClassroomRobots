package com.company;


//----------------------------------------------------------------------------------------------------------------------


import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.LinkedList;


//----------------------------------------------------------------------------------------------------------------------


/**
 * Creates the main form, and starts all required code
 *
 */
public class MainForm extends JFrame implements ActionListener, MouseListener
{

    //defines the name for all buttons
    JButton btnClear, btnSave, btnOpen, btnSort, btnFind, btnRaf, btnExit;

    //defines the name for all labels
    JLabel lblTeacher, lblTeacherName, lblClass, lblClassName, lblRoom, lblRoomName, lblDate, lblDateTitle, lblSearch;
    //defines the name for all text fields
    JTextField txtSearch;
    //defines the name for all spring layouts
    SpringLayout myLayout = new SpringLayout();

    //defines the colour cornFlowerBlue for use latter
    private static Color CornFlowerBlue = new Color(100, 149, 237);
    //set's the file name to blank
    public String FileName = "";
    //set's the size of the data grid to be 10 by 19
    public int xValue = 10;
    public int yValue = 19;
    int width = 10;
    int height = 19;

    // This constructor calls ReadFile.
    com.company.FileManager method = new FileManager();

    //defines the data grid
    JTextField[][] DataGrid;


//----------------------------------------------------------------------------------------------------------------------


    /**
     * runs the code to create all components and create the main window
     */
    public MainForm() {
        setLayout(myLayout);

        // Call Button() method to create and add buttons
        Button();
        Label();
        TextField();
        CreateDataGrid();

        //set's the main window title
        setTitle("Caroline’s Classroom Robots");
        //sets the size of the main window
        setSize(900, 800);
        //where the window will apear on the screen
        setLocation(200, 60);
        //if the screen can be seen or not
        setVisible(true);

        // Add window listener to exit program on window close
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * Creates all the buttons
     */
    public void Button() {
        // Create and configure buttons
        btnClear = UIBuilderLibrary.BuildAButton(90, 30, "Clear", 50, 600, this, myLayout, this);
        btnSave = UIBuilderLibrary.BuildAButton(90, 30, "Save", 150, 600, this, myLayout, this);
        btnOpen = UIBuilderLibrary.BuildAButton(90, 30, "Open", 150, 640, this, myLayout, this);
        btnSort = UIBuilderLibrary.BuildAButton(90, 30, "Sort", 250, 600, this, myLayout, this);
        btnFind = UIBuilderLibrary.BuildAButton(90, 30, "Find", 450, 600, this, myLayout, this);
        btnRaf = UIBuilderLibrary.BuildAButton(90, 30, "Raf", 550, 600, this, myLayout, this);
        btnExit = UIBuilderLibrary.BuildAButton(90, 30, "Exit", 650, 600, this, myLayout, this);

        // Add buttons to frame
        add(btnClear);
        add(btnSave);
        add(btnOpen);
        add(btnSort);
        add(btnFind);
        add(btnRaf);
        add(btnExit);
    }

//----------------------------------------------------------------------------------------------------------------------


    /**
     * Create all the labbels
     */
    public void Label()
    {
        //create and configures all the labels
        lblTeacher = UIBuilderLibrary.BuildAJLabel(60, 30,"Teacher: ", 50, 20, myLayout, this);
        lblTeacherName = UIBuilderLibrary.BuildAJLabel(60, 30,method.Teacher, 110, 20, myLayout, this);
        lblClass = UIBuilderLibrary.BuildAJLabel(60, 30,"Class: ", 200, 20, myLayout, this);
        lblClassName = UIBuilderLibrary.BuildAJLabel(60, 30, method.Class, 260, 20, myLayout, this);
        lblRoom = UIBuilderLibrary.BuildAJLabel(60, 30,"Room: ", 350, 20, myLayout, this);
        lblRoomName = UIBuilderLibrary.BuildAJLabel(60, 30,method.Room, 410, 20, myLayout, this);
        lblDate = UIBuilderLibrary.BuildAJLabel(60, 30,"Date: ", 500, 20, myLayout, this);
        lblDateTitle = UIBuilderLibrary.BuildAJLabel(60, 30,method.Date, 560, 20, myLayout, this);
        lblSearch= UIBuilderLibrary.BuildAJLabel(60, 30,"Search", 350, 570, myLayout, this);
        lblSearch.setOpaque(false);
        lblSearch.setForeground(CornFlowerBlue);

        //add's a mouse listener to lblTeacherName
        lblTeacherName.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                ChangeTitles(lblTeacherName, "Teacher ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //add's a mouse listener to lblClassName
        lblClassName.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                ChangeTitles(lblClassName, "Class ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //add's a mouse listener to lblRoomName
        lblRoomName.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                ChangeTitles(lblRoomName, "Room ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //add's a mouse listener to lblDateTitle
        lblDateTitle.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                ChangeTitles(lblDateTitle, "Date ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //adds all the labels to the window
        add(lblTeacher);
        add(lblTeacherName);
        add(lblClass);
        add(lblClassName);
        add(lblRoom);
        add(lblRoomName);
        add(lblDate);
        add(lblDateTitle);
        add(lblSearch);
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * creates all textFields
     */
    public void TextField()
    {
        //creates and configures all the text fields
        txtSearch = UIBuilderLibrary.BuildATextField(90, 30, "", 350, 600, myLayout, this);

        //adds a focus listener to txtSearch. so that when you click on the text field it will clear it self if the
        // user clicks the text field and the data grid has a cell that is cyan, set's the cell back to white
        txtSearch.addFocusListener(new FocusAdapter()
       {
            @Override
            public void focusGained(FocusEvent e)
            {
                txtSearch.setText("");
                for (int x = 0; x < DataGrid.length; x++)
                {
                    for (int y = 0; y < DataGrid[x].length; y++)
                    {
                        //Get the search term from the Search text field
                        if (DataGrid[x][y].getBackground() == Color.cyan)
                        {
                            //Otherwise, colour it white
                            DataGrid[x][y].setBackground(Color.white);
                        }
                    }
                }
            }
        });

        //adds txtSearch to the main window
        add(txtSearch);
    }


//----------------------------------------------------------------------------------------------------------------------

    /**
     * Creates the main data grid which will be used to display all data
     */
    public void CreateDataGrid()
    {
        DataGrid = new JTextField[xValue][yValue];
        int Row = 80;
        int Column = 90;
        //creates the numbers going around the data grid, x value
        for (int i = 0; i < xValue; i++)
        {
            JLabel myLabel;
            myLabel = UIBuilderLibrary.BuildAJLabel(60, 30, Integer.toString(i), Row, 60, myLayout, this);
            myLabel.setOpaque(false);
            String LabelName = "Row" + i + ". Column 1";
            myLabel.setName(LabelName);
            add(myLabel);
            Row = Row + 80;
        }
        //creates the numbers going around the data grid, y value
        for (int i = 0; i < yValue; i++)
        {
            JLabel myLabel;
            myLabel = UIBuilderLibrary.BuildAJLabel(60, 30, Integer.toString(i), 40, Column, myLayout, this);
            myLabel.setOpaque(false);
            String LabelName = "Row 1. Column " + i;
            myLabel.setName(LabelName);
            add(myLabel);
            Column = Column + 25;
        }
        Column = 90;
        Row = 60;
        //loops through a 2d array of text fields and configures them all
        for (int y = 0; y < yValue; y++)
        {
            for (int x = 0; x < xValue; x++)
            {
                //configures and creates the data grid
                DataGrid[x][y] = UIBuilderLibrary.BuildATextField(80, 25, "", Row, Column, myLayout, this);
                DataGrid[x][y].setBackground(Color.white);
                //adds the data grid to the window
                add(DataGrid[x][y]);
                Row = Row + 80;
                //sets the border of the data grid to light gray
                DataGrid[x][y].setBorder(new LineBorder(Color.LIGHT_GRAY,1));
                //adds a mouse listener to the data grid so that if you right click a cell, it will set it to a desk
                DataGrid[x][y].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {

                    }

                    @Override
                    //if the user right clicks, set that cell to a desk
                    public void mousePressed(MouseEvent e)
                    {
                        if (SwingUtilities.isRightMouseButton(e))
                        {
                            if (e.getComponent().getBackground() == Color.white)
                            {
                                e.getComponent().setBackground(Color.LIGHT_GRAY);
                            }
                            else
                            {
                                e.getComponent().setBackground(Color.white);
                            }
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e)
                    {

                    }

                    //if the mouse enters a cell, set it's border to cornFlowerBlue
                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        //Get the details of the text field that was interacted with.
                        JTextField textField = (JTextField)e.getSource();
                        //When the mouse enters the component's space, colour its border red.
                        textField.setBorder(new LineBorder(CornFlowerBlue,2));
                    }

                    //if the mouse leaves a cell, set it's border back to light gray
                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        //Get the details of the text field that was interacted with.
                        JTextField textField = (JTextField)e.getSource();
                        //Once it leaves the component's space, set the border back to its original setting.
                        textField.setBorder(new LineBorder(Color.LIGHT_GRAY,1));
                    }
                });
            }
            Row = 60;
            Column = Column + 25;
        }
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * Set's the name of a dialog box
     * @param labelName
     * @param name
     */
    public void ChangeTitles(JLabel labelName, String name)
    {
        String newLabel = (String) JOptionPane.showInputDialog(null,
                "You are now editing\n" + name + "!",
                name,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");
        labelName.setText(newLabel);
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * Opens a file apong the user's request
     * this can be csv or raf
     */
    public void openFile()
    {
        //Creates the file dialog and configures it for a save dialog type.
        FileDialog dialog = new FileDialog(this,"Select .csv or .raf File to Open.",FileDialog.LOAD);
        //Sets the dialog visible on screen.
        dialog.setVisible(true);

        //sets the file name to the name of a file
        String fileName = dialog.getFile();
        //if a file is not selected, lets the user know
        if(fileName == null || fileName.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No file selected. Opening empty form.");
            return;
        }


        RecordData data = new RecordData();
        //set's filePath to the path of the selected file
        String filePath = dialog.getDirectory() + fileName;

        //If the selected file is a RAF file, load it.
        if(fileName.toLowerCase().endsWith(".raf"))
        {
            data = com.company.FileManager.ReadDataFromRAF(width,height,filePath,DataGrid);
        }
        ///else if the file is a csv, run the code to load a csv file
        else if(fileName.toLowerCase().endsWith(".csv"))
        {
            data = com.company.FileManager.ReadDataFromCSV(width,height,filePath,DataGrid);
        }
        //if the file does not have a valid file type, let the user know
        else
        {
            JOptionPane.showMessageDialog(this,"The file selected is not a valid type!");
            return;
        }

        //if the data can not be displayed, gives the user an error message
        if (data == null)
        {
            JOptionPane.showMessageDialog(this,"The selected file is corrupted or in an invalid format!");
            return;
        }

        //sets the text in all the titles to text from the file
        lblTeacherName.setText(data.TeacherName);
        lblClassName.setText(data.Class);
        lblRoomName.setText(data.Room);
        lblDateTitle.setText(data.Date);
        //Iterate through the columns ands rows of the text field array.
        for (int x = 0; x < DataGrid.length; x++)
        {
            for (int y = 0; y < DataGrid[x].length; y++)
            {
                //Copy the text from the string array in the data record into text field array in the form.
                DataGrid[x][y].setText(data.textGrid[x][y]);
            }
        }
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * this code save's the file to the selcected loacastoin.
     *  extension is is to determin if it is .csv or .raf
     * @param extension
     */
    public void SaveToSelectedFile(String extension) {
        //Creates the file dialog and configures it for a save dialog type.
        FileDialog dialog = new FileDialog(this, "Select Save Location", FileDialog.SAVE);
        //Specify the desired file extension.
        dialog.setFile("Untitled" + extension);
        //Sets the dialog visible on screen.
        dialog.setVisible(true);

        //sets fileName to the name of the file
        String fileName = dialog.getFile();

        //if there is no file name, stops the saving
        if (fileName == null || fileName.isEmpty() || fileName.equalsIgnoreCase(extension)) {
            return;
        }
        //if the file has no extension (csv/raf) print the file name
        if (fileName.endsWith(extension) == false) {
            String[] temp = fileName.split("\\.");
            fileName = temp[0] + extension;
            System.out.println(fileName);
        }

        //sets filePath to the path of the file
        String filePath = dialog.getDirectory() + fileName;

        //Create new object/container to hold screen details.
        RecordData data = new RecordData();
        //Copy Data from heading text fields into the record.
        data.TeacherName = lblTeacherName.getText();
        data.Class = lblClassName.getText();
        data.Room = lblRoomName.getText();
        data.Date = lblDateTitle.getText();
        //Create the data's String array the same size as our text field array
        data.textGrid = new String[width][height];
        //Iterate through the columns ands rows of the text field array.
        for (int x = 0; x < DataGrid.length; x++) {
            for (int y = 0; y < DataGrid[x].length; y++) {
                //Copy the text from the form text grid into the string array in the data record.
                data.textGrid[x][y] = DataGrid[x][y].getText();
            }
        }

        //Trigger the appropriate save for the selected file extension.
        if (extension.equalsIgnoreCase(".raf")) {
            //Pass the record and the desired file path to the file manager to save it.
            com.company.FileManager.WriteDataToRAF(data, filePath, DataGrid);
        //else if it's a csv file,
        } else if (extension.equalsIgnoreCase(".csv")) {
            //save's all text in the data grid the seleccted file
            com.company.FileManager.SaveDataToCSV(data, filePath, DataGrid);
        }
    }

//----------------------------------------------------------------------------------------------------------------------


    /**
     * this clears the data grid so that it is free for the user to enter new data
     */
    public void ClearDataField()
    {
        //clear's the 4 title things
        FileName = "";
        lblTeacherName.setText("");
        lblClassName.setText("");
        lblRoomName.setText("");
        lblDateTitle.setText("");
        //loops through the data grid, set's it all to white and removes all text
        for (int x = 0; x < xValue; x++)
        {
            for (int y = 0; y < yValue; y++)
            {
                DataGrid[x][y].setBackground(Color.white);
                DataGrid[x][y].setText("");
            }
        }
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * this is where all the code for when any of the buttons get's clicked
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        /**
         * when btnClear is clicked
         */
        if (e.getSource() == btnClear)
        {
            ClearDataField();
        }
        /**
         * when btnSave is clicked
         */
        if (e.getSource() == btnSave)
        {
            SaveToSelectedFile(".csv");
        }
        /**
         * when btnOpen is clicked
         */
        if (e.getSource() == btnOpen)
        {
            ClearDataField();
            openFile();
        }
        /**
         * when btnSort is clicked
         */
        if (e.getSource() == btnSort)
        {
            //Create list to store all our sorted items
            LinkedList<SortItem> sortedItems = new LinkedList<SortItem>();
            //Iterate through the text grid fields
            for (int x = 0; x < DataGrid.length; x++)
            {
                for (int y = 0; y < DataGrid[x].length; y++)
                {
                    //If the current array element is not empty
                    if(DataGrid[x][y].getText().isEmpty() == false)
                    {
                        //Grab the text from the current text grid element
                        String text = DataGrid[x][y].getText();
                        //Add a new item to the sorted list containing the current element indexes and text value.
                        sortedItems.add(new SortItem(x,y,text));
                    }
                }
            }
            //Sort the item list.
            Collections.sort(sortedItems);
            //OPen a new sort form using the new sorted list and the desired search keyword.
            new SortDisplayForm(sortedItems, txtSearch.getText());
        }
        /**
         * when btnFind is clicked
         */
        if (e.getSource() == btnFind)
        {
            //Cycle through the text grid contents
            for (int x = 0; x < DataGrid.length; x++)
            {
                for (int y = 0; y < DataGrid[x].length; y++)
                {
                    //Get the search term from the Search text field
                    String searchText = txtSearch.getText();
                    //If the text field contents ,matches the search term
                    if(DataGrid[x][y].getText().equalsIgnoreCase(searchText) && searchText.isEmpty() == false)
                    {
                        //Colour the field blue
                        DataGrid[x][y].setBackground(Color.CYAN);
                    }
                    else if (DataGrid[x][y].getBackground() == Color.cyan)
                    {
                        //Otherwise, colour it white
                        DataGrid[x][y].setBackground(Color.white);
                    }
                }
            }
        }
        /**
         * when btnRaf is clicked
         */
        if (e.getSource() == btnRaf)
        {
            SaveToSelectedFile(".raf");
        }
        /**
         * when btnExit is clicked
         */
        if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * a bunch of random mouse listeners that when removed, the program won't run
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    /**
     * a bunch of random mouse listeners that when removed, the program won't run
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    /**
     * a bunch of random mouse listeners that when removed, the program won't run
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    /**
     * a bunch of random mouse listeners that when removed, the program won't run
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    /**
     * a bunch of random mouse listeners that when removed, the program won't run
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e)
    {

    }


//----------------------------------------------------------------------------------------------------------------------


}
