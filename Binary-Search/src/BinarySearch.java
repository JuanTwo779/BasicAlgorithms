
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class BinarySearch
    {
        private int[] values;

        public BinarySearch()
        {
            values = new int[]{0, 0, 0};
        }

        public boolean binarySearch(int[] data, int target, int low, int high)
        {
            if (low > high)
                return false;
            else
            {
                int mid = (low + high) / 2;
                if (target == data[mid])
                    return true;
                else if (target < data[mid])
                    return binarySearch(data, target, low, mid - 1);
                else //target > data[mid]
                    return binarySearch(data, target, mid + 1, high);
            }
        }

        public int defineMaxNos()
        {
            int max = 10;
            try
            {
                System.out.println("Number of numbers to generate?");
                Scanner console = new Scanner(System.in);
                max = Integer.parseInt(console.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Valid integer not entered. Using default!");
            }
            return max;
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
                    if(!binarySearch(values, val, 0, values.length))
                        System.out.println("Element not found in array");
                    else
                        System.out.println("Element found in array");
                }
            }while(cont);
        }

        public void populateRandomList(int max)
        {
            Random rnd = new Random();
            values = new int[max];
            for(int i = 0; i < max; i++)
            {
                values[i] = rnd.nextInt(20000);
            }
            Arrays.sort(values);
            System.out.println("Array elements include:");
            for(int i = 0; i < max; i++)
            {
                System.out.print(values[i] + " ");
            }
            System.out.println();
        }

        public void startDemo()
        {
            populateRandomList(defineMaxNos());
            getUserInput();
        }

        public static void main(String[] args)
        {
            BinarySearch bs = new BinarySearch();
            bs.startDemo();
        }
    }
