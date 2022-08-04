import java.util.Scanner;
import java.util.Random;

public class Linear
{
    private int[] values;

    public Linear()
    {
        values = new int[]{0,0,0,0};
    }

    public int getMaxNum()
    {
        int max = 5;
        try
        {
            System.out.println("Enter amount of numbers to generate");
            Scanner console = new Scanner(System.in);
            max = Integer.parseInt(console.nextLine());
        }
        catch(Exception e)
        {
            System.out.println("Invalid integer; Default is 5");
        }
        return max;
    }

    public void populateArray(int max)
    {
        Random rand = new Random();
        values = new int[max];
        for (int i = 0; i < max; i++)
        {
            values[i] = rand.nextInt(100);
        }
        System.out.println("Elements in array: ");
        for (int i = 0; i < max; i++)
        {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    //linear search method -- essentially loops array, checking to see if num matches any elements
    public void checkNumber(int val)
    {
        int i = 0;
        boolean found = false;
        while(i < values.length)
        {
            if(values[i] == val)
            {
                System.out.println("Number exists in the array");
                found = true;
                break;
            }
            i++;
        }
        if(!found)
            System.out.println("Number doesn't exist in array!");
    }

    public void getUserInput()
    {
        Scanner console = new Scanner(System.in);
        boolean cont = true;
        do
        {
            int val = -1;
            System.out.println("Please enter a number to search for");
            try
            {
                val = Integer.parseInt(console.nextLine());
                cont = false;
            }
            catch(Exception e)
            {
                System.out.println("Invalid integer entered. Please reenter");
            }
            finally
            {
                checkNumber(val);
            }
        }while(cont);
    }

    public static void main(String[] args)
    {
        Linear ls = new Linear();
        ls.populateArray(ls.getMaxNum());
        ls.getUserInput();
    }

}
