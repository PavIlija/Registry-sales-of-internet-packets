
package controller;

import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Buyer;
import model.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BuyerController {
    ObservableList<String>speedBoxList=FXCollections.observableArrayList("2mb","5mb","10mb","20mb","50mb","100mb");
    ObservableList<String>bandwidthBoxList=FXCollections.observableArrayList("1gb","5gb","10gb","100gb","Flat");
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField adress;
    @FXML private ChoiceBox speedBox;
    @FXML private ChoiceBox bandwidthBox;
    @FXML private TableView<Buyer> tableView;
    @FXML RadioButton radioButton1;
    @FXML RadioButton radioButton2;
   
    Buyer buyer;
    @FXML
    private Button minBtn;
    @FXML
    private Button maxBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Label Title;
    @FXML
    private ToggleGroup contract;
    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn lastNameCol;
    @FXML
    private TableColumn adressCol;
    @FXML
    private TableColumn speedCol;
    @FXML
    private TableColumn bandwidthCol;
    @FXML
    private TableColumn contractCol;
    @FXML
    private TableColumn idCol;
    
    
    @FXML
    public void initialize(){
        buyer = new Buyer();
        speedBox.setValue("2mb");
        speedBox.setItems(speedBoxList);
        bandwidthBox.setValue("1gb");
        bandwidthBox.setItems(bandwidthBoxList);
        setColumns();
        fillTable();
        

    }
    @FXML 
    public void saveBuyer(){
        Session session= HibernateUtil.getFactory().openSession();
        buyer.setlastName(lastName.getText());
        buyer.setfirstName(firstName.getText());
        buyer.setAdress(adress.getText());
        buyer.setSpeed(speedBox.getValue().toString());
        buyer.setBandiwdth(bandwidthBox.getValue().toString());
        if(radioButton1.isSelected()){
            buyer.setContract(radioButton1.getText());
        }else buyer.setContract(radioButton2.getText());
        
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
          
            session.save(buyer);
            
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
            }
            System.out.println(e);
        }finally{
            session.close();

        }
       setColumns();
       fillTable();
    }
    
     @FXML
    private void closeForm(){
        Platform.exit();
        System.exit(0);
    }
    @FXML
    private void fillTable(){
       Session session= HibernateUtil.getFactory().openSession();
       
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<Buyer> buyers=session.createCriteria(Buyer.class).list();
            ObservableList<Buyer>tableData=FXCollections.observableArrayList();
            for(Buyer buy:buyers){
                tableData.add(buy);
            }
            
            tableView.setItems(tableData);
            
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
            }
            System.out.println(e);
        }finally{
            session.close();
            
        }
        
            
     
    } 
    @FXML
    public void deleteContract(){
        int index=tableView.getSelectionModel().getSelectedIndex();
        if(index!=-1){
        Buyer data = tableView.getItems().get(tableView.getFocusModel().getFocusedIndex());
        Session session= HibernateUtil.getFactory().openSession();
       
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
          
           buyer=(Buyer)session.load(Buyer.class, data.getId());
           session.delete(buyer);
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
            }
            System.out.println(e);
        }finally{
            session.close();
            setColumns();
            fillTable();
        }
           
            System.out.println("Radi");
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("You must select contract from table!");
            alert.showAndWait();
        }
       
        
    }
    @FXML
     public void  clearInput(){
            firstName.setText("");
            lastName.setText("");
            adress.setText("");
        }        
            
       
       
        
    
    private void setColumns(){
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Buyer,String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Buyer,String>("lastName"));
        adressCol.setCellValueFactory(new PropertyValueFactory<Buyer,String>("adress"));
        speedCol.setCellValueFactory(new PropertyValueFactory<Buyer,String>("speed"));
        bandwidthCol.setCellValueFactory(new PropertyValueFactory<Buyer,String>("bandiwdth"));
        contractCol.setCellValueFactory(new PropertyValueFactory<Buyer,String>("contract"));
        idCol.setCellValueFactory(new PropertyValueFactory<Buyer,String>("id"));
    }
    
    
}
