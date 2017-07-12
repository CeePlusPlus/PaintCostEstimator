package paintcostestimator;

import java.util.Scanner;
//hi
/**
 *
 * @author MANOJ
 */
public class PaintCostEstimator {

    /**
     * @param args the command line arguments
     */
    private static final int MAX_SIZE = 10;
    int No_of_rooms = 0;
    double[] length = new double[MAX_SIZE];
    double[] width = new double[MAX_SIZE];
    public int flag = 0;
    char option;
    
    Scanner read = new Scanner(System.in);

    public PaintCostEstimator() {
        System.out.print("Enter No. Of Rooms: ");
        No_of_rooms = read.nextInt();
        for (int count = 1; count <= No_of_rooms; count++) {
            System.out.print("Enter Length of room " + count +": ");
            length[count] = read.nextDouble();
            System.out.print("Enter Width of room " + count +": ");
            width[count] = read.nextDouble();
            System.out.print("Select Height: 1. 8ft \n2. 9ft \n3. 10ft: ");
            int choice = read.nextInt();
            System.out.print("Include Ceiling for room " + No_of_rooms + "(Y or N)? ");
            option = read.next().charAt(0);
        }

    }

    public void display() {
        for (int index = 1; index <= No_of_rooms; index++) {
            System.out.println(length[index]);
            System.out.println(width[index]);
            System.out.println(option);
        }
    }

    public static void main(String[] args) {

        PaintCostEstimator Estimate = new PaintCostEstimator();
        Estimate.display();
    }

}
