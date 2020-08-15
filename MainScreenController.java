/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.inventory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import generic.inventory.mainCategory;
import generic.inventory.subCategory;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author jerem
 */
public class MainScreenController implements Initializable {
    
    @FXML private TableView<mainCategory> mainCategoryTable;
    @FXML private TableColumn<mainCategory, String> mainCategoryColumn;
    @FXML private Button addCategoryButton;
    @FXML private TableView<subCategory> subCategoryTable;
    @FXML private TableColumn<subCategory, String> subCategoryColumn;
    
    @FXML private TextField itemNameTextField;
    @FXML private TextField locationTextField;
    @FXML private TextField serialTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextArea discriptionTextArea;
    @FXML private Button addItemButton;
        
    @FXML private TableView<Item> itemTable;
    @FXML private TableColumn<Item, String> itemColumn;
    
    
    
    @FXML private void addMainCategoryButtonPressed(ActionEvent event) throws IOException {
    // create a text input dialog 
        TextInputDialog textInput = new TextInputDialog("Enter New Category");
        textInput.setTitle("Enter New Category");
        textInput.getDialogPane().setContentText("Enter New Main Category:");
        Optional<String> result = textInput.showAndWait();
        TextField input = textInput.getEditor();        
        if(input.getText() != null && input.getText().toString().length() != 0){
           // mainCategory newMainCategory = new mainCategory(input.getText());
           // mainCategory.addMainCategory(newMainCategory);
            System.out.println("InputText is: " + input.getText().toString());
            mainCategory newMainCategory = new mainCategory(input.getText());
            mainCategory.addMainCategory(newMainCategory);
            
        }
        else
        {
            System.out.println("User did not enter anything");
        }
        //mainCategoryTable.setItems(mainCategory.getAllMainCategory());
       // mainCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                        
        
        
    }
    
    @FXML private void addItemButtonPressed(ActionEvent event) throws IOException {
         // create a text input dialog 
        TextInputDialog textInput = new TextInputDialog("Enter New Item Name");
        textInput.setTitle("Enter New Item Name");
        textInput.getDialogPane().setContentText("Enter New Item Name:");
        Optional<String> result = textInput.showAndWait();
        TextField input = textInput.getEditor();        
        if(input.getText() != null && input.getText().toString().length() != 0){
           
           // mainCategory newMainCategory = new mainCategory(input.getText());
           // mainCategory.addMainCategory(newMainCategory);
            System.out.println("InputText is: " + input.getText().toString());
            Item newItem = new Item(input.getText().toString());
            Item.addItem(newItem);
            
        }
        else
        {
            System.out.println("User did not enter anything");
        }     
    }
    
    @FXML private void selectedItemFromItemTable(ActionEvent event) throws IOException{
        System.out.println("You Picked Something");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mainCategory newMainCategory = new mainCategory("Appliance");
        mainCategory.addMainCategory(newMainCategory);
        mainCategory newMainCategorytwo = new mainCategory("Electronic");
        mainCategory.addMainCategory(newMainCategorytwo);
        mainCategory newMainCategorythree = new mainCategory("Funiture");
        mainCategory.addMainCategory(newMainCategorythree);
        
        
        //setup the main category table
        System.out.println(mainCategory.getAllMainCategory().toString());
        mainCategoryTable.setItems(mainCategory.getAllMainCategory());
        mainCategoryColumn.setCellValueFactory(new PropertyValueFactory<mainCategory, String>("name"));
        
        //setup the subcategory table
        mainCategoryTable.getSelectionModel().selectedItemProperty().addListener((mainCategory) -> {
        if (mainCategory != null) {
        subCategoryTable.setItems(subCategory.getAllSubCategory());
        subCategoryColumn.setCellValueFactory(new PropertyValueFactory<subCategory, String>("name"));        
        }
        });
        
        
        //setup the items table
        itemTable.setItems(Item.getAllItems());
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        //this chunk of code is the listener to update the text fields when an item is selected.
        //from the item table
        itemTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, item) -> {
        if (item != null) {
            itemNameTextField.setText(item.getName());
            locationTextField.setText(item.getLocation());
            serialTextField.setText(item.getSerialNum());
            quantityTextField.setText(Integer.toString(item.getQuantity()));
            discriptionTextArea.setText(item.getDescription());
            }
        });
        
        
        //mainCategoryList.setItems(mainCategory.getName());
        
        
        
        
    }    
    
}
