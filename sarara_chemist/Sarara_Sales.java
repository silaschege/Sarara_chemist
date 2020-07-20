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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

 


public class Sarara_Sales extends Application{
        //private final Sarara_Purchase back = new Sarara_Purchase();




@Override
public void start(Stage primaryStage) {
Text text1= new Text("Select your inventory");
Text text3 =new Text(" ");

ComboBox combobox1 = new ComboBox();
ListView<String> listview = new ListView<>();


Button button3= new Button("Show");
Button button4=new Button("Show all");
Button button5 = new Button("Dashboard");


GridPane grid=new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25,25,25,25));

grid.add(text1,0,1);
grid.add(combobox1,0,2);


grid.add(button3,0,3);
grid.add(text3,0,4);
grid.add(button4,0,5);
grid.add(button5,0,6);
try{
	    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	    	   Statement st=con.createStatement();

	    	   String statement = "SELECT * FROM  Sales";
	    	   ResultSet resultSet = st.executeQuery(statement);


	    	   while (resultSet.next()) { // loop
	    	       combobox1.getItems().addAll(resultSet.getString("Customer_Name"));
	    	   }
	    	   }
	    	   catch(SQLException ee){System.out.println(ee);text3.setText("Something is wrong");}
               

   String customer =(String)combobox1.getValue();
   
   
   
    	  
	       
	       button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
               @Override
	       public void handle(MouseEvent event) {
                   try{
                 
	       String check =(String)combobox1.getValue();
	       Class.forName("com.mysql.jdbc.Driver");
	      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
	       Statement st=con.createStatement();
                String statement = "SELECT Customer_Name,Item,Quantity,Phone FROM Sales Where Customer_Name='"+check+"'";
	      st.execute(statement);
              ResultSet rs = st.executeQuery(statement);

            while (rs.next()) {
               String Name = rs.getString(1);
               String item=rs.getString(2);
               String quantity =rs.getString(3);
               String Phone =rs.getString(4);
               String all =("Item Name:"+Name+"\n"+"Item:"+item+" \n "+"Quantity:"+quantity+"\n"+"Phone Number:"+Phone);
                text3.setText(all);
            }
	      }
	      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text3.setText("Not Avialable");}
               }
               }));


button4.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
 try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/Sarara_Chemist?useSSL=false","root","root");
    	   Statement st=con.createStatement();
           JasperDesign Jdesign= JRXmlLoader.load("/Users/silas/NetBeansProjects/Sarara_Chemist/src/sarara_chemist/Sarara_Salesreport.jrxml");
    	  String query="Select Customer_Name,Item,Quantity,Phone From Sales";
          JRDesignQuery updateDesign = new JRDesignQuery();
          updateDesign.setText(query);
          Jdesign.setQuery(updateDesign);
          JasperReport jreport = JasperCompileManager.compileReport(Jdesign);
          JasperPrint jprint = JasperFillManager.fillReport(jreport,null, con);
          JasperViewer.viewReport(jprint);
          
 }
    	   catch(SQLException ee){System.out.println(ee);text3.setText("Ann error occured");} catch (JRException ex) {
            Logger.getLogger(Sarara_Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       }));

               button5.setOnMouseClicked((new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        

 try{
    	 Sarara_Dashboard dash = new Sarara_Dashboard ();
         dash.start(primaryStage);
 }
    	   catch(Exception ee){System.out.println(ee);text3.setText("Something went wrong");}
    }
       }));



    
	      

Scene scene =new Scene (grid,360,400);
primaryStage.setTitle("Sales");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);
}

}

    

