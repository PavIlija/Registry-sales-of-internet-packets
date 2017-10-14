
package model;
import javax.persistence.Entity;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Buyer {
    
   private final IntegerProperty id = new SimpleIntegerProperty();

    @Override
    public String toString() {
        return "id=" + id.get() + ", lastName=" + lastName.get() + ", firstName=" + firstName.get() + ", adress=" + adress.get() + ", speed=" + speed.get() + ", bandiwdth=" + bandiwdth.get() + ", contract=" + contract.get();
    }
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }
    
    private final StringProperty lastName = new SimpleStringProperty();

    public String getlastName() {
        return lastName.get();
    }

    public void setlastName(String value) {
        lastName.set(value);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }
    private final StringProperty firstName = new SimpleStringProperty();

    public String getfirstName() {
        return firstName.get();
    }

    public void setfirstName(String value) {
        firstName.set(value);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }
    private final StringProperty adress = new SimpleStringProperty();
    public String getAdress() {
        return adress.get();
    }

    public void setAdress(String value) {
        adress.set(value);
    }

    public StringProperty adressProperty() {
        return adress;
    }
    private final StringProperty speed= new SimpleStringProperty();
    public String getSpeed(){
        return speed.get();
    }
    public void setSpeed(String value){
        speed.set(value);
    }
    public StringProperty speedProperty(){
        return speed;
    }
    private final StringProperty bandiwdth= new SimpleStringProperty();
    public String getBandiwdth(){
        return bandiwdth.get();
    }
    public void setBandiwdth(String value){
        bandiwdth.set(value);
    }
    public StringProperty bandiwdthProperty(){
        return bandiwdth;
    }
     private final StringProperty contract= new SimpleStringProperty();
    public String getContract(){
        return contract.get();
    }
    public void setContract(String value){
        contract.set(value);
    }
    public StringProperty contractProperty(){
        return contract;
    }
    
   
  
public Buyer(String firstName,String lastName,String adress,String speed,String bandwidth,String contract,int id){
    
}
   
   
public Buyer(){
    
}
 
    
}
