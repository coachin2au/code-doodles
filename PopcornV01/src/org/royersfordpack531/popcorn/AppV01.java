package org.royersfordpack531.popcorn;

import java.util.ArrayList;
import java.util.Arrays;

public class AppV01 
{

    public static Sale getSale(Event   donation_or_sale,
                               Popcorn popcorn_for_sale, 
                               int     bags_per_sale,
                               int     sale_amount)
    {
        Sale next_sale;
        
        // BFTODO - lets pull this from a file or something for testing
        next_sale = new Sale (donation_or_sale,         // event type
                              popcorn_for_sale,         // type
                              bags_per_sale,            // bag count
                              sale_amount);             // amount
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
        
        // Adjsut CASH value to 0, this will be a special handling case
        inventory.addInventory(Popcorn.CASH, 0);
        
        return (inventory);
    }       // end setupInventory()

    public static void main(String[] args) 
    {
        ArrayList<Sale> sales               = new ArrayList<Sale>();
        Sale            tempSale;
        InventoryList   pack531_inventory   = new InventoryList();   
        
        // BFDEBUG - show inventory
        System.out.println("Time, time, time for action");
        System.out.println("Here is our inventory before setup");
        pack531_inventory.printInventory();
        
        // BFTODO - this is ugly and needs refactoring
        pack531_inventory = setupInventory(pack531_inventory);
        
        // BFDEBUG - show inventory
        System.out.println("Here is our inventory after setup");
        pack531_inventory.printInventory();
        
        // BFDEBUG - get a test sale and add it to our sales list
        // And yeah, this should all be buried in a test bench
        tempSale = getSale(Event.SALE, Popcorn.BACON_RANCH, 2, 30);
        sales.add(tempSale);
        pack531_inventory.sellInventory(tempSale.getPopcorn_type(), 
                tempSale.getBag_quantity());
        
        tempSale = getSale(Event.SALE, Popcorn.CARMEL, 5, 100);
        sales.add(tempSale);
        pack531_inventory.sellInventory(tempSale.getPopcorn_type(), 
                tempSale.getBag_quantity());
        
        tempSale = getSale(Event.SALE, Popcorn.KERNELS, 40, 320);
        sales.add(tempSale);
        pack531_inventory.sellInventory(tempSale.getPopcorn_type(), 
                tempSale.getBag_quantity());
        
        tempSale = getSale(Event.SALE, Popcorn.BUFFALO_CHEDDAR, 1, 15);
        sales.add(tempSale);
        pack531_inventory.sellInventory(tempSale.getPopcorn_type(), 
                tempSale.getBag_quantity());
        
        tempSale = getSale(Event.DONATION, Popcorn.CASH, 0, 1000);
        sales.add(tempSale);
        // Donations go into the sales list but not into the Inventory adjustments
        
        // BFDEBUG - show inventory
        System.out.println("Here is our inventory after making a sale");
        pack531_inventory.printInventory();
        System.out.println("Here is our sales list ");
        for (int i = 0; i < sales.size(); i++) 
        {
            sales.get(i).printSale();
       }
    }       // end main()
}           // end CLASS AppV01
