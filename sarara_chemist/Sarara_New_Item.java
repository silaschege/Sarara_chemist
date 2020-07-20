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

 

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

 


public class Sarara_New_Item extends Application{
        //private final Sarara_Purchase back = new Sarara_Purchase();


@Override
public void start(Stage primaryStage) {
Text text1= new Text("Item Name");
Text text2 =new Text("Number of Item");
Text text3 =new Text("Expiry Date");
Text text4 =new Text();



TextField textfield1 =new TextField();
TextField textfield2 =new TextField();
DatePicker datepicker3 = new DatePicker();


Button button3= new Button("Add");
Button button4=new Button("Back");


GridPane grid=new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25,25,25,25));

grid.add(text1,0,1);
grid.add(textfield1,0,2);

grid.add(text2,0,3);
grid.add(textfield2,0,4);

grid.add(text3,0,5);
grid.add(datepicker3,0,6);



grid.add(button3,0,7);
grid.add(button4,1,7);
grid.add(text4,0,8);




button4.setOnMouseClicked((new EventHandler<MouseEvent>() {
    Sarara_Purchase purchase=new  Sarara_Purchase();
    public void handle(MouseEvent event) {
        purchase.start(primaryStage);
        
        
        // back.start(primaryStage);
    }
       }));


button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        final String category = textfield1.getText();
      

 try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement ="INSERT INTO `Inventory_Category` (`Category_Id`,`Inventory_Category`) VALUES (NULL,'"+category+"')";
           st.executeUpdate(statement);
//dashboard.start(primaryStage);
            text4.setText("Inventory Category Added");
 }
    	   catch(SQLException ee){System.out.println(ee);text4.setText("Inventory Category Not Added");}
    }
       }));



    
	      

Scene scene =new Scene (grid,310,300);
primaryStage.setTitle("New Items");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);
}

}

    

