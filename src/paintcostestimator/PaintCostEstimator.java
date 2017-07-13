package paintcostestimator;

import java.util.Scanner;

/**
 * PROGRAM TO ESTIMATE THE COST OF PAINTING A HOUSE
 * THE COST INCLUDES:
 * 1. lABOUR COST/SQ_FT
 * 2. COST OF MATERIALS/SQ_FT
 */
public class PaintCostEstimator {

    /**
     * @param args the command line arguments
     */
    private static final int MAX_SIZE = 10;
    public int No_of_rooms = 0;
    double[] length = new double[MAX_SIZE];
    double[] width = new double[MAX_SIZE];
    double[] paintCost = new double[MAX_SIZE];
    double[] labourCost = new double[MAX_SIZE];
    double[] area = new double[MAX_SIZE];
    double[] carpet_area = new double[MAX_SIZE];
    double roomArea;
    double paintInLitres;
    double BasicPaintCost = 150;
    double PremiumPaintCost = 250;
    double PaintCost;
    double LabourCost = 3;
    double TotalCost;

    int doors;
    int windows;
    char option;
    int height;
    int paintChoice;

    public int flag = 0;

    Scanner read = new Scanner(System.in);
/**
 * 
 * @return RETURNS NO OF ROOMS TO BE PAINTED 
 */
    public int NoOfRooms() {                                                        //Enter No of Rooms
        System.out.print("Enter No. Of Rooms: ");
        No_of_rooms = read.nextInt();
        return No_of_rooms;
    }
/**
 * ADITIONAL DETAILS TO BE INPUT
 */
    public void roomDetails() {
        for (int count = 1; count <= No_of_rooms; count++) {
            System.out.print("Enter Length of room (in ft.)" + count + ": ");       //READS LENGTH
            length[count] = read.nextDouble();
            System.out.print("Enter Width of room (in ft.)" + count + ": ");        //READS WIDTH
            width[count] = read.nextDouble();
        }
    }
/**
 * 
 * @return RETURNS HEIGHT OF WALLS
 */
    public int height() {                                                           //READS HEIGHT
        System.out.print("Select Height:8/9/10(in ft.) :");
        height = read.nextInt();
        //TODO Switch case
        return height;
    }
/**
 * CHECKS WHETHER CEILNG HAS TO BE INCLUDED OR NOT
 */
    public void ceiling() {
        System.out.print("Include Ceiling (Y or N)? ");
        option = read.next().charAt(0);                                             //READS CEILING INPUT
        switch (option) {
            case 'Y':
                carpetArea();
                break;
            case 'y':
                carpetArea();
                break;

        }
    }
/**
 * 
 * @return RETURNS THE PAINT TYPE  
 */
    public double paintChoice() {
        System.out.print("Select type of paint\n 1.Basic Paint(non-Waterproof)\n 2.Premium Paint(waterproof) ");
        paintChoice = read.nextInt();                                             //READS TYPE OF PAINT
        switch (paintChoice) {

            case 2:
                return (PremiumPaintCost);                                         //RETURNS PREMIUM PAINT COST

            default:
                return (BasicPaintCost);                                           //RETURNS BASIC PAINT COST

        }
    }
/**
 * READS NO OF DOORS AND WINDOWS PRESENT
 */
    public void inputDoorsWindows() {
        System.out.print("Enter No of doors: ");                                    //READS NO OF DOORS
        doors = read.nextInt();
        System.out.print("Enter No of windows: ");                                  //READS NO OF WINDOWS
        windows = read.nextInt();   
    }
/**
 * 
 * @return RETURNS THE AREA OF CEILING IF THE USER WISHES TO PAINT THE CEILING
 */
    public double[] carpetArea() {
        for (int count = 1; count <= No_of_rooms; count++) {
            carpet_area[count] = length[count] * width[count];

        }
        return carpet_area;
    }
/**
 * AFTER THE INPUT THE COMPUTATION STARTS FROM THIS SECTION
 */
    public void calculateRoomArea() {

        for (int index = 1; index <= No_of_rooms; index++) {
            roomArea += 2 * ((length[index] * height) + (width[index] * height));   //ROOM AREA COMPUTED AS 2 WALLS * LENGTH OF A WALL * HEIGHT
                                                                                    //PLUS WIDTH OF A WALL * HEIGHT
            roomArea += carpet_area[index];                                         //IF CARPET AREA HAS TO BE PAINTED ADD IT TO THE ROOM AREA
        }

    }
/**
 * 
 * @param type IS A PARAMETER WHICH IS THE TYPE OF PAINT TO BE USED
 * @return RETURNS THE TOTAL COST OF THE PAINT REQUIRED
 */
    public double paintCostEstimate(double type) {
        roomArea = roomArea - ((doors * 21) + (windows * 16));                      //ASSUMING door dimension 7X3ft ;Window dimension 4X4ft
        paintInLitres = roomArea / 100;                                             //To Calculate No.of Litres of paint needed
        PaintCost = type * paintInLitres;                                           //TOTAL COST OF THE PAINT REQUIRED
        return (PaintCost);
    }
/**
 * 
 * @return RETURNS THE TOTAL ROOM AREA TO BE PAINTED 
 */
    public double TotalroomArea() {
        return roomArea;
    }
/**
 * 
 * @return RETURNS THE TOTAL COST OF LABOUR 
 */
    public double labourCostEstimate() {
        return (LabourCost *= roomArea);
    }
/**
 * 
 * @return RETURNS THE TOTAL COST REQUIRED TO PAINT!
 */
    public double totalCostEstimate() {
        return (TotalCost = PaintCost + LabourCost);
    }
}
