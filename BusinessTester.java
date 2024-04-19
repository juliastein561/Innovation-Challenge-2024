import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.util.HashMap;
import java.util.Scanner;

// authors: Julia Stein
//          Aiden Spoerndle
//          Dr. Sims Osborne
public class BusinessTester {
    public static void main(String[] args) {
        ArrayList<SupplyTable> supplyTables = new ArrayList<>();

        // Create an object of the SupplyTable class
        SupplyTable supplyList1 = new SupplyTable(5000, 1, 2000, 7000, 10, 0, 0, 0, 0, 0, 240);
        SupplyTable supplyList2 = new SupplyTable(5000, 2, 6000, 11000, 25, 15, 267, 240, 200, 240, 200);
        SupplyTable supplyList3 = new SupplyTable(5000, 3, 9000, 14000, 45, 20, 150, 200, 111, 311, 160);
        SupplyTable supplyList4 = new SupplyTable(5000, 4, 12000, 17000, 58, 13, 231, 207, 86, 293, 120);
        SupplyTable supplyList5 = new SupplyTable(5000, 5, 15000, 20000, 65, 7, 429, 231, 77, 308, 80);
        SupplyTable supplyList6 = new SupplyTable(5000, 6, 18000, 23000, 70, 5, 600, 257, 71, 329, 40);

        supplyTables.add(supplyList1);
        supplyTables.add(supplyList2);
        supplyTables.add(supplyList3);
        supplyTables.add(supplyList4);
        supplyTables.add(supplyList5);
        supplyTables.add(supplyList6);


        ArrayList<Event> Events = getEvents(); // events defined at bottom


        // Call the addSupplyTables method
        //supplyTable.addSupplyTables(supplyTables);
        System.out.println("\n" +
                "  ______             _______        _ _ \n" +
                " |  ____|           |__   __|      (_) |\n" +
                " | |__   ___ ___  _ __ | |_ __ __ _ _| |\n" +
                " |  __| / __/ _ \\| '_ \\| | '__/ _` | | |\n" +
                " | |___| (_| (_) | | | | | | | (_| | | |\n" +
                " |______\\___\\___/|_| |_|_|_|  \\__,_|_|_|\n" +
                "                                        ");
        System.out.println("Created by Julia Stein and Aiden Spoerndle,\n" +
                "Under the guidance of Dr. Sims Osborne.");
        System.out.println();
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        // START OF GAME /////////////////////
        Scanner scnr = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Welcome to EconTrail, a game about microeconomics.\n\t-- " +
                "Press e/E and hit return to see explanation,\n\t-- Press s/S and hit return to skip explanation: ");

        String explanation = scnr.nextLine();  // Read user input
        if (explanation.equals("E") || explanation.equals("e")) {
            System.out.println("""
                In this game, you will be in the position of a business owner who is trying to make a profit\s
                across four business cycles. You will be able to do this by setting the price of your product\s
                per unit and the quantity produced when responding to events in the economy which result in\s
                corresponding supply and demand shifts. Need advice? Hire a consultant for $500.""");
        } else {
            System.out.println("Let's begin.");
        }
        System.out.print("What is your Business name?: ");
        String businessName = scnr.nextLine();
        System.out.print("What is your product?: ");
        String product = scnr.nextLine();
        System.out.print("What is your goal for profit?: ");
        int profitGoal = scnr.nextInt();
        System.out.print("How many events would you like to have in your game?: ");
        int gameLength = scnr.nextInt();
        System.out.println("--------------------------------");

        Random rand = new Random();
        double randDouble = rand.nextDouble(); // probability
        double totalSalesValue;
        double totalMoney = 5000.0; // starting money amount;
        int i = 0;
        double price = 300;
        double quantity = 200;
        while(i < gameLength){
            totalSalesValue = 250 + 300 + 300 + 300 + 350 + 400;
            while (randDouble < 0.75){
                int randInt = rand.nextInt(Events.size());
                Event currentEvent = Events.get(randInt);
                String supplyShift = currentEvent.getSupplyShift();
                String demandShift = currentEvent.getDemandShift();
                boolean comparator = demandShift.isEmpty();
                System.out.println();
                System.out.println("Selection Screen: \n1) See equilibrium costs table \n2) See current profit standing"
                        + "\n3) Change price/quantity \n4) Hire a consultant \n5) Continue to next Event \n6) Leave market --- ");
                int selectionChoice = scnr.nextInt();
                scnr.nextLine();
                if (selectionChoice == 1){
                    System.out.println("Cost Supply Table for Product at Equilibrium:");
                    System.out.println("---------------------------------------------");
                    System.out.println("fc\tlaborUnits\t  vc\t\ttc\t\ttotalOutput\t\tMPL\t\t  mc\t\tavc\t\t\tafc\t\t  atc\t\t mr");
                    for (SupplyTable supplyTable : supplyTables) {
                        System.out.println(supplyTable);
                    }
                } else if (selectionChoice == 2){
                    System.out.println("Your current profit standing is: " + (totalMoney - 5000.0)); // profit standing
                } else if (selectionChoice == 3){
                    System.out.println("Enter 'p/P' to set price \nEnter 'q/Q' to set quantity produced at: ");
                    String input = scnr.nextLine();
                    String input2 = scnr.nextLine();
                    if (input.equals("p") || input.equals("P")){
                        System.out.println("Enter the price you want to set: ");
                        double priceInput = scnr.nextDouble();
                        price = (double)priceInput;
                        System.out.println("You have successfully set your price to " + price);
                    } else if (input.equals("q") || input.equals("Q")){
                        System.out.println("Enter the quantity you want to set: ");
                        double qInput = scnr.nextDouble();
                        quantity = qInput;
                        System.out.println("You have successfully set your quantity to " + quantity);
                    }
                } else if (selectionChoice == 4){
                    totalMoney -= 500; // consultant costs $500
                    System.out.println("1) This is a profit maximizing firm. As a result \n" +
                            "your goal is to produce at the quantity where MR = MC.");
                    System.out.println("End of consultation.");
                    System.out.println();
                } else if (selectionChoice == 5){
                    System.out.println("--------------------------------");
                    System.out.println("New Event: " + currentEvent.getEventName());
                    System.out.println("--------------------------------");
                    i += 1;
                } else if (selectionChoice == 6){
                    i = gameLength;
                    break;
                }
                if (comparator){ // for event, sorry it is down here
                    double totalCost = 0;
                    double currentCost;
                    double effect = 1 - 0.5 * Math.abs(0.5 - rand.nextDouble()); // effect for supply/demand
                    currentCost = SupplyTable.getTotalCost();
                    totalCost += currentCost;
                    if (Event.getSupplyShift().contains("D")) {
                        totalCost *= effect;
                    } else {
                        totalCost /= effect;
                    }

                    totalMoney -= totalCost;
                }
                comparator = supplyShift.isEmpty();
                if (comparator) {
                    if (demandShift.contains("D")){
                        randDouble = 2 - 0.5 * Math.abs(0.5 - rand.nextDouble());
                    } else {
                        randDouble = 10 + Math.abs(0.5 - rand.nextDouble());
                    }
                    totalSalesValue = (totalSalesValue * randDouble);
                    totalMoney += totalSalesValue;
                }
                totalMoney = Math.abs(totalMoney)/3;
                randDouble = rand.nextDouble();
            }
            if (i == gameLength) {
                System.out.println("You have reached the end of the game. Your total profit was " + totalMoney);
                System.out.println("End of Game. Thank you for playing.");
            }
            if (randDouble > 0.75){
                System.out.println("Hit return to keep playing: ");
                String input = scnr.nextLine();
                if (input.isEmpty()){
                    randDouble = rand.nextDouble();
                }
            }
        }
    }

    private static ArrayList<Event> getEvents() {
        ArrayList<Event> Events = new ArrayList<>();

        Event inflationRises = new Event("Inflation Rises", "sD", "dD");
        Event inflationFalls = new Event("Inflation Falls", "sI", "dI");
        Event manufacturingPriceIncreases = new Event("ManufacturingPrice Increases", "sD", "");
        Event manufacturingPriceDecreases = new Event("ManufacturingPrice Decreases", "sI", "");
        Event restrictionsOnWorkEnvironment = new Event("restrictionsOnWorkEnvironment", "sD", "");
        Event oilPriceSurge = new Event("Oil Price Surge", "sD", "");
        Event technologicalBreakthrough = new Event("Technological Breakthrough", "sI", "");
        Event governmentTaxCuts = new Event("Government Tax Cuts", "", "dI");
        Event globalPandemicOutbreak = new Event("Global Pandemic Outbreak", "sD", "dD");
        Event consumerIncomeRises = new Event("Consumer Income Rises", "", "dD");
        Event naturalDisasterStrikes = new Event("Natural Disaster Strikes", "sD", "");
        Event newSubstituteProductIntroduced = new Event("New Substitute Product Introduced", "sI", "");
        Event laborUnionStrike = new Event("Labor Union Strike", "sD", "");
        Event interestRatesDecrease = new Event("Interest Rates Decrease", "", "dI");
        Event consumerConfidencePlummets = new Event("Consumer Confidence Plummets", "", "dD");
        Event supplyChainOptimization = new Event("Supply Chain Optimization", "sI", "");
        Event governmentRegulationsIncrease = new Event("Government Regulations Increase", "sD", "");
        Event breakthroughInRenewableEnergy = new Event("Breakthrough in Renewable Energy", "sI", "");
        Event suddenBankingCrisis = new Event("Sudden Banking Crisis", "", "dD");

        Events.add(inflationRises);
        Events.add(inflationFalls);
        Events.add(manufacturingPriceIncreases);
        Events.add(manufacturingPriceDecreases);
        Events.add(restrictionsOnWorkEnvironment);
        Events.add(oilPriceSurge);
        Events.add(technologicalBreakthrough);
        Events.add(governmentTaxCuts);
        Events.add(globalPandemicOutbreak);
        Events.add(consumerIncomeRises);
        Events.add(naturalDisasterStrikes);
        Events.add(newSubstituteProductIntroduced);
        Events.add(laborUnionStrike);
        Events.add(interestRatesDecrease);
        Events.add(consumerConfidencePlummets);
        Events.add(supplyChainOptimization);
        Events.add(governmentRegulationsIncrease);
        Events.add(breakthroughInRenewableEnergy);
        Events.add(suddenBankingCrisis);








        return Events;
    }
}
