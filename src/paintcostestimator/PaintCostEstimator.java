package paintcostestimator;

import java.util.Scanner;

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
    int[] choice = new int[MAX_SIZE];
    int[] paintChoice = new int[MAX_SIZE];

    double[] area = new double[MAX_SIZE];
    double finalArea = 0;
    double finalCost = 0;
    int oil_Based = 120;
    int Water_Based = 100;
    int labour = 10;

    public int flag = 0;
    String[] option = new String[MAX_SIZE];
    Scanner read = new Scanner(System.in);

    public PaintCostEstimator() {
        System.out.print("Enter No. Of Rooms: ");
        No_of_rooms = read.nextInt();
        for (int count = 1; count <= No_of_rooms; count++) {
            System.out.print("Enter Length of room (in ft.)" + count + ": ");
            length[count] = read.nextDouble();
            System.out.print("Enter Width of room (in ft.)" + count + ": ");
            width[count] = read.nextDouble();
            System.out.print("Select Height:8/9/10(in ft.)");
            choice[count] = read.nextInt();
            System.out.print("Include Ceiling for room " + No_of_rooms + "(Y or N)? ");
            option[count] = read.next();
            System.out.print("Select type of paint 1.Oil Based 2.Water Based");
            paintChoice[count] = read.nextInt();
        }

    }

    public void display() {
        for (int index = 1; index <= No_of_rooms; index++) {
            System.out.println(length[index]);
            System.out.println(width[index]);
            System.out.println(option[index]);
            System.out.println(finalCost);
        }
    }

    public void estimateCost() {
        for (int count = 1; count <= No_of_rooms; count++) {
            area[count] = (length[count] * choice[count]) + (width[count] * choice[count]);
            if (option[count] == "y" || option[count] == "Y") {
                area[count] = area[count] + (length[count] * width[count]);

            }
            finalArea = finalArea + area[count];

            switch (paintChoice[count]) {
                case 1:
                    finalCost = oil_Based * finalArea * labour;
                case 2:
                    finalCost = Water_Based * finalArea * labour;
            }

        }

    }

    public static void main(String[] args) {

        PaintCostEstimator Estimate = new PaintCostEstimator();
        Estimate.estimateCost();
        Estimate.display();
    }

}
