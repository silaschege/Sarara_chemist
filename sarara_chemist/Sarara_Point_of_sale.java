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
	import java.sql.SQLException;
	import java.sql.Statement;

	import javafx.application.Application;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextField;
	import javafx.scene.input.MouseEvent;
	import javafx.stage.Stage;
	import javafx.scene.layout.GridPane;
	import javafx.scene.text.Text;
	import java.sql.ResultSet;
import javafx.event.ActionEvent;


	public class Sarara_Point_of_sale extends Application{
           
            @Override
	    public void start(Stage primaryStage) throws SQLException {
	       Text text1= new Text("Product:");
	       Text text2=new Text("Quantity:");
	       Text text3=new Text ("Customer Name;");
	        Text text4=new Text ("Phone Number:");
	        Text text5 =new Text("Total:");
	        Text text6 =new Text(" ");
                Text  text7=new Text();
                  Text  text8=new Text();
                  Text  text9=new Text();
	     
	      
	        ComboBox combobox1=new ComboBox();
	        TextField textfield2 =new TextField();
	        TextField textfield3 =new TextField();
	        TextField textfield4 =new TextField();
	        
	        Button button1= new Button("Check for item");
            
	        Button button5=new Button("Sale");
	        Button button6 = new Button("Dashboard");
	        
	        
	       GridPane grid=new GridPane();
	       grid.setAlignment(Pos.CENTER);
	       grid.setHgap(10);
	       grid.setVgap(6);
	       grid.setPadding(new Insets(25,25,25,25));
	       
	       grid.add(text1,0,1);
	       grid.add(combobox1,0,2);
	       grid.add(button1,0,3);
	       
	       grid.add(text2,0,4);
	       grid.add(textfield2,0,5);
	     
	       
	       grid.add(text3,0,6);
	       grid.add(textfield3,0,7);
	       
	       
	       grid.add(text4,0,8);
	       grid.add(textfield4,0,9);
	       
	       grid.add(text5,0,10);
	       grid.add(text6,0,11);
             
	       grid.add(button5,0,12);
               grid.add(button6,0,13);
	   
	       
	   
	       try{
	    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	    	   Statement st=con.createStatement();

	    	   String statement = "SELECT * FROM  Item_Table";
	    	   ResultSet resultSet = st.executeQuery(statement);


	    	   while (resultSet.next()) { // loop
	    	       combobox1.getItems().addAll(resultSet.getString("Item_Name"));
                       text7.setText(resultSet.getString("Number_of_Items"));
                       text8.setText(resultSet.getString("Item_Id"));
	    	   }
	    	   }
	    	   catch(SQLException ee){System.out.println(ee);text4.setText("Something is wrong");}
               
               
              
    	  
	       
	       button1.setOnMouseClicked((new EventHandler<MouseEvent>() {
               @Override
	       public void handle(MouseEvent event) {
                   try{
                 
	       String check =(String)combobox1.getValue();
	       Class.forName("com.mysql.jdbc.Driver");
	      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	       Statement st=con.createStatement();
                String statement = "SELECT Item_Name,Number_of_items,Expire_date FROM Item_Table Where Item_Name='"+check+"'";
	      st.execute(statement);
              ResultSet rs = st.executeQuery(statement);

            while (rs.next()) {
               String Name = rs.getString(1);
               String amount=rs.getString(2);
               String Date =rs.getString(3);
               String all =("Item Name:"+Name+"\n"+"Amount:"+amount+" \n "+"Expiry Date:"+Date);
                text6.setText(all);
            }
	      }
	      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text6.setText("Not Avialable");}
               }
               }));
               
               
               
               
                
            
               
                     
	           
	  
	       button5.setOnMouseClicked((new EventHandler<MouseEvent>() {
               @Override
	       public void handle(MouseEvent event) {
	       try{
	       final String item =(String)combobox1.getValue();
	
	       final String name=textfield3.getText();
	       final String number=textfield4.getText();
                final String quantity=textfield2.getText();
                 int number1=Integer.parseInt(quantity);
                      final String number2=text7.getText();
                      int number3 =Integer.parseInt(number2);
                      int number4 = number3-number1;
	       Class.forName("com.mysql.jdbc.Driver");
	      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	       Statement st=con.createStatement();
	     
	      st.addBatch("INSERT INTO `Sales` (`Sales_Id`, `Customer_Name`, `Customer_Id`, `Item`, `Quantity`, `Phone`) VALUES (NULL, '"+name+"', '1', '"+item+"', '"+quantity+"', '"+number+"')");
	      st.addBatch( "UPDATE Item_table Set Number_of_items = '"+number4+"' WHERE Item_Name='"+item+"';"); 
	      st.executeBatch();
	      
	      text6.setText("Successfully Sold");
	      }
	      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text6.setText("Not Sold");}

	    }
	    }));
               
               
               
               
               
               button6.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        

 try{
    	 Sarara_Dashboard dash = new Sarara_Dashboard ();
         dash.start(primaryStage);
 }
    	   catch(Exception ee){System.out.println(ee);text6.setText("Something went wrong");}
    }
       }));
	             
	       Scene scene =new Scene (grid,350,395);
	       primaryStage.setTitle("Point of Sale");
	       primaryStage.setScene(scene);
	       primaryStage.show();
	         
	    } 

	   
	       public static void main(String[] args) {
	        launch(args);
	    }
	}











    

