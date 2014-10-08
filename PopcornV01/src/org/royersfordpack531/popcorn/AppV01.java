package org.royersfordpack531.popcorn;

import java.util.ArrayList;

public class AppV01 
{

    public static Sale getSale()
    {
        Sale next_sale;
        
        // BFTODO - lets pull this from a file or something for testing
        
        next_sale = new Sale (Event.DONATION,           // event type
                              Popcorn.MICROWAVE_BUTTER, // type
                              3,                        // bag count
                              45);                      // amount
        return next_sale;
    }       // end getSale()
    
    // set up test inventory
    public static InventoryList setupInventory(InventoryList inventory)
    {
        int quantity = 10;

        for (Popcorn pop : Popcorn.values())
        {
            inventory.addInventory(pop, quantity);
            quantity += 10;             // add more of the next one
        }
        
        return (inventory);
    }       // end setupInventory()

    public static void printInventory(InventoryList inventory)
    {
        // use Popcorn values for print
        for (Popcorn pop : Popcorn.values())
        {
            System.out.println("key: "    + pop + 
                               " value: " + inventory.getInventoryCount(pop));
        }
    }       // end printInventory()

    public static void main(String[] args) 
    {
        ArrayList<Sale> sales               = new ArrayList<Sale>();
        Sale            tempSale;
        InventoryList   pack531_inventory   = new InventoryList();   
        
        // BFDEBUG - show inventory
        System.out.println("Time, time, time for action");
        System.out.println("Here is our inventory before setup");
        printInventory(pack531_inventory);
        
        // BFTODO - this is ugly and needs refactoring
        pack531_inventory = setupInventory(pack531_inventory);
        
        // BFDEBUG - show inventory
        System.out.println("Here is our inventory after setup");
        printInventory(pack531_inventory);
        
        // BFDEBUG - get a test sale
        tempSale = getSale();
        
        // BFDEBUG - add it to our sales list
        sales.add(tempSale);
        
        // BFDEBUG - adjust inventory
        pack531_inventory.sellInventory(tempSale.getPopcorn_type(), 
                                        tempSale.getBag_quantity());
        
        // BFDEBUG - show inventory
        System.out.println("Here is our inventory after making a sale");
        printInventory(pack531_inventory);
    }       // end main()
}           // end CLASS AppV01
