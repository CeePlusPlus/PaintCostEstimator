
package paintcostestimator;
/**
 * Main part of the Code
 * 
 */

public class Main {

    public static void main(String[] args) {

        PaintCostEstimator one = new PaintCostEstimator();
       
        one.NoOfRooms();                                                             
        one.roomDetails();
        one.height();
        one.ceiling();
        double Choice= one.paintChoice();
        one.inputDoorsWindows();
        one.calculateRoomArea();
        double PaintType;
        PaintType = one.paintCostEstimate(Choice);
        double labourCost = one.labourCostEstimate();
        double totalCost = one.totalCostEstimate();
        double area = one.TotalroomArea();
        System.out.println("Room Area= "+area+" Sq.ft");                             //display the total area
        System.out.println("Labour Cost= "+labourCost+" Rs");                        //display the labour cost 
        System.out.println("Painting cost= "+PaintType+" Rs");                       //display the paint cost
        System.out.println("Total Cost= "+totalCost+" Rs");                          //display the total cost
    }

}
