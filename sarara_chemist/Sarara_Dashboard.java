package sarara_chemist;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author silas
 */



import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

 


public class Sarara_Dashboard extends Application{
          


@Override
public void start(Stage primaryStage) {
Button button1= new Button("Point of Sale");
Button button2= new Button("Sales");
Button button3= new Button("Customers");
Button button4= new Button("Inventory");
Button button5= new Button("Purchases");
Button button6= new Button("Register");
Text text1 = new Text("");







GridPane grid=new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25,25,25,25));

grid.add(button1,0,1);
grid.add(button2,1,1);

grid.add(button3,0,2);
grid.add(button4,1,2);
grid.add(button5,0,3);
grid.add(button6,1,3);
grid.add(text1,0,5);



//pos
button1.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
         Sarara_Point_of_sale pos = new Sarara_Point_of_sale();
 try{
      
            pos.start(primaryStage);
 }
    	   catch(SQLException ee){System.out.println(ee);text1.setText("An error occured");}
    }
       }));

//accounting

button2.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
         Sarara_Sales sale = new Sarara_Sales();
         sale.start(primaryStage);
    }
       }));

//customers
button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
         Sarara__Custom customer = new Sarara__Custom();
         customer.start(primaryStage);
    }
       }));

//inventory
button4.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
         Inventory inventory = new Inventory();
         inventory.start(primaryStage);
    }
       }));

//purchase
button5.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
         Sarara_Purchase purchase = new Sarara_Purchase();
         purchase.start(primaryStage);
    }
       }));


//register
button6.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
         Sarara_Register register = new Sarara_Register();
         register.start(primaryStage);
    }
       }));


	      
	

Scene scene =new Scene (grid,310,300);
primaryStage.setTitle("Sarara Chemist");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);
}

}

    



