//Authors: Modester_Samwel
//github handles: Modester_Samwel

package model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
		private UUID id;
		private String Name;
	    private double Price;
	    private int Quantity;


	    public Product(@JsonProperty("id") UUID id, @JsonProperty("name")String Name, @JsonProperty("price")double Price, @JsonProperty("quantity")int Quantity){
	    	this.id = id;
	        this.Name = Name;
	        this.Price = Price;
	        this.Quantity = Quantity; }

	    public UUID getId(){
	        return id;
	    }
	   

		public String getName(){
	        return Name;
	    }
	    

	    public double getPrice(){
	        return Price;
	    }
	    
	    public int getQuantity() {
	    	return Quantity;
	    }
	  
}
