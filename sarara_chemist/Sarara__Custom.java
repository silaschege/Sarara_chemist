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
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

 


public class Sarara__Custom extends Application{
      


@Override
public void start(Stage primaryStage) {
Text text1= new Text("Username:");
Text text2=new Text("Phone Number");
Text text3 =new Text();


TextField textfield1 =new TextField();
TextField textfield2 =new TextField();


Button button3= new Button("Register User");
Button button4= new Button("Dashboard");



GridPane grid=new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25,25,25,25));

grid.add(text1,0,1);
grid.add(textfield1,0,2);

grid.add(text2,0,3);
grid.add(textfield2,0,4);
grid.add(button3,0,5);
grid.add(button4,1,5);
grid.add(text3,0,6);

button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        final String name = textfield1.getText();
          final String phone = textfield1.getText();
      

 try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement ="INSERT INTO `Customer_Table` (`Name`,`Phone_Number`) VALUES ('"+name+"','"+phone+"')";
                st.executeUpdate(statement);
            //dashboard.start(primaryStage);
            text3.setText("Customer Added");
 }
    	   catch(SQLException ee){System.out.println(ee);text3.setText("Custmer Not added");}
    }
       }));


button4.setOnMouseClicked((new EventHandler<MouseEvent>() {
  Sarara_Dashboard dashboard = new Sarara_Dashboard();
    @Override
    public void handle(MouseEvent event) {
 
        dashboard.start(primaryStage);
        // ResultSet resultSet = st.executeQuery(statement);
    }
       }));

    
	      

Scene scene =new Scene (grid,310,300);
primaryStage.setTitle("Register New Customer");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);
}

}

    

  //ListView<String> educationListView = new ListView<>(names);