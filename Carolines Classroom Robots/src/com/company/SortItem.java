package com.company;

public class SortItem implements Comparable<SortItem>
{
    //Details about each entry being sorted.
    public int xIndex;
    public int yIndex;
    public String text;

    /**
     * a list of x/y values to be displayed with sorted data
     * @param x
     * @param y
     * @param text
     */
    public SortItem(int x, int y, String text)
    {
        xIndex = x;
        yIndex = y;
        this.text = text;
    }

    /**
     * compares the data to sort it
     * @param other
     * @return
     */
    @Override
    public int compareTo(SortItem other)
    {
        //Compare the objects using the text variable as the basis of the comparison.
        return text.compareTo(other.text);
    }
}
