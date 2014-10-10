package org.royersfordpack531.popcorn;

import java.util.HashMap;

public class InventoryList 
{
    private HashMap<Popcorn,Integer> invetory_list = new HashMap<Popcorn,Integer>(); 
    
    public InventoryList () 
    {     
        // populate the basic inventory with all types of popcorn and set value to 0
        for (Popcorn pop : Popcorn.values())
        {
            this.invetory_list.put(pop, 0);
        }
    }       // end InventoryList()
    
    // Send in what popcorn type you're adding to and how many bags
    // RETURNS : Updated inventory count
    public int addInventory (Popcorn popcorn_type, int bags_to_add)
    {
        //safe check that we have a matching key
        if (this.invetory_list.containsKey(popcorn_type))
        {
            // update the list entry for this popcorn type
            this.invetory_list.put(popcorn_type, 
                                   (this.invetory_list.get(popcorn_type) + bags_to_add));
            
            // return the new value for that key item
            return (this.invetory_list.get(popcorn_type));
        }
        else
        {
            // BFTODO - really need to enhance error handling scenarios and support
            return (-1);        // should make a constant for ERROR
        }
    }       // end addInventory()

    // Send in what popcorn type you sold and how many bags
    // RETURNS : Updated inventory count
    public int sellInventory (Popcorn popcorn_type, int bags_sold)
    {
       if (this.invetory_list.containsKey(popcorn_type) &&
           this.invetory_list.get(popcorn_type) > bags_sold )
        {
            // update the list entry for this popcorn type
            this.invetory_list.put(popcorn_type, 
                                   (this.invetory_list.get(popcorn_type) - bags_sold));
            
            // return the new value for that key item
            return (this.invetory_list.get(popcorn_type));
        }
        else
        {
            // BFTODO - update error handling, account for insufficient inventory case
            return (-1);        // should make a constant for ERROR
        }
    }       // end sellInventory()
    
    public int getInventoryCount (Popcorn popcorn_type)
    {
        if (this.invetory_list.containsKey(popcorn_type))
        {
            return (this.invetory_list.get(popcorn_type));
        }
        else
        {
            return (-1);
        }
    }       // end getInventoryCount()
    
    public  void printInventory()
    {
        // use Popcorn values for print
        for (Popcorn pop : Popcorn.values())
        {
            System.out.println("key: "    + pop + 
                               " value: " + this.getInventoryCount(pop));
        }
    }       // end printInventory()


}           // end CLASS InventoryList
