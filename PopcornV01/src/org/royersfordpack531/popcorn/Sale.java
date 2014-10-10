package org.royersfordpack531.popcorn;

public class Sale 
{
// BFTODO  private time time_of_sale;
    private Event   sale_type;
    private Popcorn popcorn_type;
    private int     bag_quantity = 0;
    private int     sale_value   = 0;

    public Sale(Event   sale_type,
                Popcorn brand,
                int     bag_count,
                int     sale_total) 
    {
        this.sale_type      = sale_type;
        this.popcorn_type   = brand;
        this.bag_quantity   = bag_count;
        this.sale_value     = sale_total;
    }
    
    public void printSale() 
    {
        System.out.println("Sale type     : " + this.sale_type + " " + 
                           "Sale brand    : " + this.popcorn_type + " " +
                           "Sale quantity : " + this.bag_quantity + " " +
                           "Sale value    : " + this.sale_value);
    }
    
    public Event getSale_type ()
    {
        return this.sale_type;
    }

    public Popcorn getPopcorn_type ()
    {
        return this.popcorn_type;
    }

    public int getBag_quantity ()
    {
        return this.bag_quantity;
    }
    
    public int getSale_value ()
    {
        return this.sale_value;
    }

}
