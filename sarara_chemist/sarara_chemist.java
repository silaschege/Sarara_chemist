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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

 


public class sarara_chemist extends Application{
        private final Sarara_Dashboard dashboard = new Sarara_Dashboard();


@Override
public void start(Stage primaryStage) {
Text text1= new Text("Username:");
Text text2=new Text("Password:");
Text text3 =new Text();
Text text5 =new Text();
Text text6 =new Text();


TextField textfield1 =new TextField();
PasswordField passfield2 =new PasswordField();

Button button3= new Button("Login");



GridPane grid=new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25,25,25,25));

grid.add(text1,0,1);
grid.add(textfield1,0,2);

grid.add(text2,0,3);
grid.add(passfield2,0,4);
grid.add(button3,0,5);
grid.add(text3,0,6);




button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        final String Email = textfield1.getText();
        final String Pass = passfield2.getText();

 try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement = "SELECT User_Email,User_Password FROM Users Where User_Email='"+Email+"' and User_Password = '"+Pass+"'";
                 st.execute(statement);
                 ResultSet rs = st.executeQuery(statement);

            while (rs.next()) {
               text5.setText(rs.getString(1));
               text6.setText(rs.getString(2));
                String amount=rs.getString(1);
               String Date =rs.getString(2);
               String all =("Amount:"+amount+" \n "+"Expiry Date:"+Date);
                text3.setText(all);
            }
              final String email1 = text5.getText();
                 final String pass1 = text6.getText();
                 
            if(Email.length()<=0){
                if(Pass.length()<=0){
                text3.setText("Input Username and Password");
                }
            }  
            else{
            if((Email).equals(email1)){
                if(Pass.equals(pass1)){
                dashboard.start(primaryStage);
                }
            }
            else{
                text3.setText("Wrong UserName or password");
            }   
            }


 }
    	   catch(SQLException ee){System.out.println(ee);text3.setText("An error occured");}
    }
       }));

    
	      

Scene scene =new Scene (grid,310,300);
primaryStage.setTitle("Login");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);
}

}

    

  //ListView<String> educationListView = new ListView<>(names);