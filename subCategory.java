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
public class subCategory {
    private static ObservableList<subCategory> allSubCategory = FXCollections.observableArrayList();

    private String name;
    
    public subCategory(String subCategoryName){
        this.name = subCategoryName;
    }
    
    public static void addSubCategory(subCategory newSubCategory){
        allSubCategory.add(newSubCategory);
    }
    
    public static ObservableList<subCategory> getAllSubCategory() {
        return allSubCategory;
    }
    
    public static void removeSubCategory(subCategory subCategory){
        allSubCategory.remove(subCategory);
    }

    public String getName(){
        return name;
    }      
    
    public void setName(String name) {
        
        this.name = name;        
    }   

}