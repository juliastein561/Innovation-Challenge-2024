import java.util.ArrayList;
import java.util.Random;

public class SupplyTable extends ArrayList<SupplyTable> {
    private int fixedCosts;
    private int laborUnits;
    private int variableCost;
    private static int totalCost;
    private int totalOutput;
    private int MPL;
    private double marginalCost;
    private static double averageVariableCost;
    private static double averageFixedCost;
    private double averageTotalCost;
    private double marginalRevenue;
    //private double price; // NOTE: I know price is not usually calculated with the supply costs table
                            // but for this i have to do it sorry.

    // Constructor
    public SupplyTable(int fixedCosts, int laborUnits, int variableCost, int totalCost,
                  int totalOutput, int MPL, double marginalCost, double averageVariableCost,
                  double averageFixedCost, double averageTotalCost, double marginalRevenue) {
        this.fixedCosts = fixedCosts;
        this.laborUnits = laborUnits;
        this.variableCost = variableCost;
        this.totalCost = totalCost;
        this.totalOutput = totalOutput;
        this.MPL = MPL;
        this.marginalCost = marginalCost;
        this.averageVariableCost = averageVariableCost;
        this.averageFixedCost = averageFixedCost;
        this.averageTotalCost = averageTotalCost;
        this.marginalRevenue = marginalRevenue;
    }

    // Getters and Setters
    public int getFixedCosts() { return fixedCosts; }
    public void setFixedCosts(int fixedCosts) { this.fixedCosts = fixedCosts; }
    public int getLaborUnits() { return laborUnits; }
    public void setLaborUnits(int laborUnits) { this.laborUnits = laborUnits; }
    public int getVariableCost() { return variableCost; }
    public void setVariableCost(int variableCost) { this.variableCost = variableCost; }
    public static int getTotalCost() { return totalCost; }
    public void setTotalCost(int totalCost) { this.totalCost = totalCost; }
    public int getTotalOutput() { return totalOutput; }
    //public static void setTotalOutput(int totalOutput) { this.totalOutput = totalOutput; }
    public int getMPL() { return MPL; }
    public void setMPL(int MPL) { this.MPL = MPL; }
    public double getMarginalCost() { return marginalCost; }
    public void setMarginalCost(double marginalCost) { this.marginalCost = marginalCost; }
    public static double getAverageVariableCost() { return averageVariableCost; }
    public void setAverageVariableCost(double averageVariableCost) { this.averageVariableCost = averageVariableCost; }
    public double getAverageFixedCost() { return averageFixedCost; }
    public void setAverageFixedCost(double averageFixedCost) { this.averageFixedCost = averageFixedCost; }
    public static double getAverageTotalCost() { return averageVariableCost + averageFixedCost; }
    public static void setAverageTotalCost(double averageTotalCost) { averageTotalCost = averageVariableCost + averageFixedCost; }
    public double getMarginalRevenue() {return marginalRevenue;}
    public void setMarginalRevenue(int marginalRevenue){this.marginalRevenue = marginalRevenue;}

    public String toString() {
        return String.format("%1d %5d %10d %10d %10d %10d %10.2f %10.2f %10.2f %10.2f %10.2f",
                fixedCosts, laborUnits, variableCost, totalCost, totalOutput,
                MPL, marginalCost, averageVariableCost, averageFixedCost,
                averageTotalCost, marginalRevenue);
    }
    public void changeATC(double rand) {
        double effect = 1 + 0.5 * Math.abs(0.5 - rand); // effect for supply/demand
        for(int i = 0; i < 6; i++){
            if (Event.getSupplyShift().contains("D")) {
                SupplyTable.setAverageTotalCost(SupplyTable.getAverageTotalCost() + effect);
            } else {
                SupplyTable.setAverageTotalCost(SupplyTable.getAverageTotalCost() - effect);
            }
        }
    }
}
