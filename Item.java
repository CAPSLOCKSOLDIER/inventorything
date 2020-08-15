/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jerem
 */
public class Item {
        private static ObservableList<Item> allItems = FXCollections.observableArrayList();

    private String name;
    private String location;
    private String serialNum;
    private int quantity;
    private String description;
    
    
    public Item(String name){
        this.name = name;
        this.location = "Bin E9";
        this.serialNum = "S0442q9";
        this.quantity = 10;
        this.description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    }
    
    public void setName(String name) {        
        this.name = name;        
    } 
    public String getName(){
       return name;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
    
    public void setSerialNum(String serialNum) {        
        this.serialNum = serialNum;        
    }
    public  String getSerialNum(){
        return serialNum;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
    
    public static void removeItem(Item item){
        allItems.remove(item);
    }
    
    public static ObservableList<Item> getAllItems() {
        return allItems;
    }
    
    public static void addItem(Item newItem){
        allItems.add(newItem);
        
    }

    
}
