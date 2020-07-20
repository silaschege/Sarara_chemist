/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarara_chemist;

/**
 *
 * @author silas
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
    import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Sarara_Purchase extends Application {
    private final Sarara_New_Inventory inventory_add = new Sarara_New_Inventory();

@Override
public void start(Stage primaryStage) {
Text text1= new Text("Inventory Category");
Text text2=new Text("Item Name ");
Text text3 =new Text("Sellers Name");
Text text4 =new Text("Quantity");
Text text5 =new Text(" Expiry date");
Text text6 = new Text();

ComboBox combobox1 = new ComboBox();
ComboBox combobox2 = new ComboBox();
ComboBox combobox3 = new ComboBox();
TextField textfield4 =new TextField();
DatePicker datepicker5 = new DatePicker();

Button button1= new Button("New Inventory Category");
Button button2= new Button("New item");
Button button3= new Button("New Supplier");
Button button6= new Button("Purchase");
Button button7 = new Button("Dashoard");



GridPane grid=new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25,25,25,25));

grid.add(text1,0,1);
grid.add(combobox1,0,2);
grid.add(button1,0,3);

grid.add(text2,0,4);
grid.add(combobox2,0,5);
grid.add(button2,0,6);

grid.add(text3,0,7);
grid.add(combobox3,0,8);
grid.add(button3,0,9);

grid.add(text4,0,10);
grid.add(textfield4,0,11);
grid.add(text5,0,12);
grid.add(datepicker5,0,13);
grid.add(text6,0,14);
grid.add(button6,0,15);
grid.add(button7,0,16);


try{
	    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	    	   Statement st=con.createStatement();

	    	   String statement = "SELECT * FROM  Inventory_Category";
	    	   ResultSet resultSet = st.executeQuery(statement);


	    	   while (resultSet.next()) { // loop
	    	       combobox1.getItems().addAll(resultSet.getString("Inventory_Category"));
	    	   }
	    	   }
	    	   catch(SQLException ee){System.out.println(ee);text4.setText("Something is wrong");}
               


try{
	    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	    	   Statement st=con.createStatement();

	    	   String statement = "SELECT * FROM  Item_Table";
	    	   ResultSet resultSet = st.executeQuery(statement);


	    	   while (resultSet.next()) { // loop
	    	       combobox2.getItems().addAll(resultSet.getString("Item_Name"));
	    	   }
	    	   }
	    	   catch(SQLException ee){System.out.println(ee);text4.setText("Something is wrong");}
               



try{
	    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	    	   Statement st=con.createStatement();

	    	   String statement = "SELECT * FROM  Suppliers";
	    	   ResultSet resultSet = st.executeQuery(statement);


	    	   while (resultSet.next()) { // loop
	    	       combobox3.getItems().addAll(resultSet.getString("Supplier_Name"));
	    	   }
	    	   }
	    	   catch(SQLException ee){System.out.println(ee);text4.setText("Something is wrong");}
               

button1.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
 try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
    	   Statement st=con.createStatement();
    	  
            inventory_add.start(primaryStage);
            
 }
    	   catch(SQLException ee){System.out.println(ee);text3.setText("Ann error occured");}
    }
       }));



button2.setOnMouseClicked((new EventHandler<MouseEvent>() {
    Sarara_New_Item newitem= new  Sarara_New_Item ();
    public void handle(MouseEvent event) {
    

        newitem.start(primaryStage);
    }
       }));


button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
    Sarara_New_Supplier newsupplier= new  Sarara_New_Supplier ();
    public void handle(MouseEvent event) {
    

        newsupplier.start(primaryStage);
    }
       }));

button7.setOnMouseClicked((new EventHandler<MouseEvent>() {
    Sarara_Dashboard dashboard= new  Sarara_Dashboard ();
    public void handle(MouseEvent event) {
    

        dashboard.start(primaryStage);
    }
       }));
    
	      

Scene scene =new Scene (grid,310,550);
primaryStage.setTitle("Purchase");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);
}


}
    

