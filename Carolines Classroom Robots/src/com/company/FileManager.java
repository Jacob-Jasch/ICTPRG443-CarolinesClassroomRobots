package com.company;


//----------------------------------------------------------------------------------------------------------------------


import javax.swing.*;
import java.awt.*;
import java.io.*;


//----------------------------------------------------------------------------------------------------------------------


/**
 * defines the class and sets up some variables
 */
public class FileManager
{

    public String Teacher;
    public String Class;
    public String Room;
    public String Date;


//----------------------------------------------------------------------------------------------------------------------
// Reads "ClassroomLayout.csv"


    /**
     * Reads the data from a csv file and displays in in the main datagrid
     * @param width
     * @param height
     * @param filePath
     * @param DataGrid
     * @return
     */
    public static RecordData ReadDataFromCSV(int width, int height, String filePath, JTextField[][] DataGrid)
    {
        RecordData data = new RecordData();
        data.textGrid = new String[width][height];

        try
        {
            //declares a new file readers
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            //reads all the data into the 4 titles at the top of the page
            data.TeacherName = reader.readLine().split(",")[1];
            data.Room = reader.readLine().split(",")[1];
            data.Class = reader.readLine().split(",")[1];
            data.Date = reader.readLine().split(",")[1];

            String line;
            //runs through every line of the file
            while((line = reader.readLine()) != null && line.isEmpty() == false)
            {
                String[] temp = line.split(",");
                int xPos = Integer.parseInt(temp[0]);
                int yPos = Integer.parseInt(temp[1]);

                //set's the test of the datagrid cell at x y to the text of the file
                if (!temp[2].contains("ThisIsLightGrey") && !temp[2].contains("BKGRND FILL"))
                {
                    data.textGrid[xPos][yPos] = temp[2];
                }
                //else if it's a desk, set's the backgrowned to light gray at x y
                else if (temp[2].contains("ThisIsLightGrey") || temp[2].contains("BKGRND FILL") || temp[3].contains("blue"))
                {
                    DataGrid[xPos][yPos].setBackground(Color.lightGray);
                }
            }
            //close's the reader and returns data
            reader.close();
            return data;

        }
        //if the above fails, prints the error
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * saves the data from the data grid in to a csv file
     * @param data
     * @param filePath
     * @param DataGrid
     */
    public static void SaveDataToCSV(RecordData data, String filePath, JTextField[][] DataGrid)
    {
        //trys to write data to file
        try
        {
            //Declares a new file writer
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            //Print the headers of the screen data.
            //writes the contents of the top 4 titles to the file
            writer.write("Name," + data.TeacherName + "\n");
            writer.write("Class," + data.Class + "\n");
            writer.write("Room," + data.Room + "\n");
            writer.write("Date," + data.Date + "\n");
            //Iterate through the 2D array in our data.
            for (int x = 0; x < DataGrid.length; x++)
            {
                for (int y = 0; y < DataGrid[x].length; y++)
                {
                    if (DataGrid[x][y].getBackground() == Color.lightGray)
                    {
                        //Write the 2 indexes of the element alongside the element contents.
                        writer.write(x + "," + y + "," + "ThisIsLightGrey");
                        writer.newLine();
                    }
                    //If the current grid position has text, write its details.
                    else if (DataGrid[x][y].getText().isEmpty() == false)
                    {
                        //Write the 2 indexes of the element alongside the element contents.
                        writer.write(x + "," + y + "," + DataGrid[x][y].getText());
                        writer.newLine();
                    }
                }
            }

            writer.close();
        }
        catch(Exception e)
        {
            //if writeing data failed, prints the error message
            System.out.println(e.getMessage());
        }
    }


//----------------------------------------------------------------------------------------------------------------------


    /**
     * saves the data to a raf file from the main data grid
     * @param data
     * @param filePath
     * @param DataGrid
     */
    public static void WriteDataToRAF(RecordData data, String filePath, JTextField[][] DataGrid)
    {
        try
        {
            //declares a new raf file
            RandomAccessFile raf = new RandomAccessFile(filePath,"rw");

            //writes the 4 titles to the raf file
            raf.seek(0);
            raf.writeUTF(data.TeacherName);
            raf.seek(50);
            raf.writeUTF(data.Class);
            raf.seek(100);
            raf.writeUTF(data.Room);
            raf.seek(150);
            raf.writeUTF(data.Date);

            int counter = 0;
            int pointer = 0;
            int recordSpacing = 160;
            //goes through the datagrid cell by cell and writes all data found in to the file
            for (int x = 0; x < data.textGrid.length; x++)
            {
                for (int y = 0; y < data.textGrid[x].length; y++)
                {
                    //goes through the datagrid cell by cell to check if it's a desk. if it is, save that it is a desk
                    // instead of data
                    if (DataGrid[x][y].getBackground() == Color.lightGray)
                    {

                        //Calculate the pointer position for the new entry. The position is calculated by
                        //multiplying the how many entries are already written(counter) by the size of each
                        //entry(recordSpacing) and then adding the size needed for the header data (100 bytes).
                        pointer = counter * recordSpacing + 200;
                        raf.seek(pointer);
                        raf.writeInt(x);
                        raf.seek(pointer + 5);
                        raf.writeInt(y);
                        raf.seek(pointer + 10);
                        raf.writeUTF("ThisIsLightGrey");

                        counter++;

                    }
                    //if not a desk, goes through the datagrid cell by cell and writes all data found in to the file
                    else if (data.textGrid[x][y].isEmpty() == false)
                    {
                        //Calculate the pointer position for the new entry. The position is calculated by
                        //multiplying the how many entries are already written(counter) by the size of each
                        //entry(recordSpacing) and then adding the size needed for the header data (100 bytes).
                        pointer = counter * recordSpacing + 200;
                        raf.seek(pointer);
                        raf.writeInt(x);
                        raf.seek(pointer + 5);
                        raf.writeInt(y);
                        raf.seek(pointer + 10);
                        raf.writeUTF(data.textGrid[x][y]);

                        counter++;
                    }
                }
            }
            //close's the file
            raf.close();
        }
        catch(Exception e)
        {
            //prints a error message if failed to write to file
            System.out.println(e.getMessage());
        }
    }



//----------------------------------------------------------------------------------------------------------------------


    /**
     * reads the data from a raf file and puts it in the main data grid
     * @param width
     * @param height
     * @param filePath
     * @param DataGrid
     * @return
     */
    public static RecordData ReadDataFromRAF(int width, int height, String filePath, JTextField[][] DataGrid)
    {
        RecordData data = new RecordData();
        data.textGrid = new String[width][height];
        //try's to read file
        try
        {
            //set's raf as the name of a raf file
            RandomAccessFile raf = new RandomAccessFile(filePath,"r");

            //reads the titles from the raf to to the title spot
            raf.seek(0);
            data.TeacherName = raf.readUTF();
            raf.seek(50);
            data.Class = raf.readUTF();
            raf.seek(100);
            data.Room = raf.readUTF();
            raf.seek(150);
            data.Date = raf.readUTF();

            int counter = 0;
            int recordSpacing = 160;
            int pointer = 200;

            //runs through all the contents of the files
            while (pointer < raf.length())
            {
                raf.seek(pointer);
                int xPos = raf.readInt();
                raf.seek(pointer + 5);
                int yPos = raf.readInt();
                raf.seek(pointer + 10);
                String text = raf.readUTF();

                //if it's a desk, go to x y and set's the background to light gray
                if (text.contains("ThisIsLightGrey") || text.contains("BKGRND FILL"))
                {
                    DataGrid[xPos][yPos].setBackground(Color.lightGray);
                }
                //if not a desk, go to x y and set's it to the text from the file
                else if(!text.contains("ThisIsLightGrey"))
                {
                    data.textGrid[xPos][yPos] = text;
                }

                counter ++;
                pointer = counter * recordSpacing + 200;
            }

            //closes the file and returns data
            raf.close();
            return data;
        }
        catch(Exception e)
        {
            //if read data fails, prints the error
            System.out.println(e.getMessage());
        }
        return null;
    }
}