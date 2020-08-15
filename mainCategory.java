/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.inventory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;


/**
 *
 * @author jerem
 */
public class mainCategory {
    private static ObservableList<mainCategory> allMainCategory = FXCollections.observableArrayList();
    private static ObservableList<subCategory> allSubCategory = FXCollections.observableArrayList();
    //if you make your variable static then its all the same dumbass
    private String name;
        
    public mainCategory(String mainCategoryName){   
        this.name = mainCategoryName;   
        subCategory newSubCategory = new subCategory(mainCategoryName);
        subCategory.addSubCategory(newSubCategory);
    }
   // public static void addSubCategory(subCategory newSubCategory){          
   //       allSubCategory.add(newSubCategory);        
   // }
    public static void addMainCategory(mainCategory newMainCategory){
        allMainCategory.add(newMainCategory);
        //iterate through the list
        ObservableList<mainCategory> mainCategorys = allMainCategory;
            mainCategorys.forEach((mainCategory) -> { 
            System.out.println("Stuff with " + mainCategory);
});
        
        
   }    
    public static ObservableList<mainCategory> getAllMainCategory() {
        return allMainCategory;
    }    
    public static void removeMainCategory(mainCategory mainCategory){
        allMainCategory.remove(mainCategory);
    }    
    public String getName(){
        return name;
    }      
    
    public void setName(String name) {
        this.name = name;        
    }
    
   // public static ObservableList<subCategory> getAllSubCategory() {
   // return allSubCategory;
   // }   

   
    
    
    
    
    
    
}
