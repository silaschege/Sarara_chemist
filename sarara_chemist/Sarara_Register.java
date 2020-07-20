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


	 


	public class Sarara_Register extends Application {
             private final Sarara_Dashboard dashboard = new Sarara_Dashboard();
         


	
            @Override
	public void start(Stage primaryStage) {
	Text text1= new Text("First Name:");
	Text text2= new Text("Second Name:");
	Text text3= new Text("Enter Email:");
	Text text4= new Text("Enter Password:");
	Text text6=new Text("");
	


	TextField textfield1 =new TextField();
	TextField textfield2 =new TextField();
	TextField textfield3 =new TextField();
	PasswordField enterpass =new PasswordField();

	

	Button button6= new Button("Register");
        Button button7 = new Button("Dashboard");


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
	grid.add(textfield3,0,6);
	
	grid.add(text4,0,7);
	grid.add(enterpass,0,8);


	grid.add(button6,0,10);
         grid.add(button7,0,11);
	grid.add(text6,0,12);
        
    
        
        button6.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
     final String enter_pass = enterpass.getText();
     final String first_name = textfield1.getText();
     final String second_name = textfield2.getText();
     final String email = textfield3.getText();
  
      
    

 try{
      
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement ="INSERT INTO Users(User_Email,First_Name,Second_Name,User_Password) VALUES ('"+email+"','"+first_name+"','"+second_name+"','"+enter_pass+"')";
       
           st.execute(statement);
           text6.setText("Registration succesfull");

 }
    	   catch(SQLException ee){System.out.println(ee);text6.setText("Registration failed");}
    }
       }));

        
        button7.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
 try{
              dashboard.start(primaryStage);
    	 


 }
    	   catch(Exception ee){System.out.println(ee);text3.setText("An error occourd");}
    }
       }));

        
	


	Scene scene =new Scene (grid,300,450);
	primaryStage.setTitle("Register New User");
	primaryStage.setScene(scene);
	primaryStage.show();

	}

	public static void main(String[] args) {
	launch(args);
	}

	}




    

