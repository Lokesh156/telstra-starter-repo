package au.com.telstra.simcardactivator;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String iccid;

    @Column(nullable=false)
    private String customerEmail;

    @Column(nullable=false)
    private boolean active;

    public SimCard(String iccid, String customerEmail, boolean active){
        this.iccid=iccid;
        this.customerEmail=customerEmail;
        this.active=active;
    }
    public SimCard() {
    }


    public String getIccid() {
        return iccid;
    }


    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean getActive(){
        return active;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public void setActive(boolean active){
        this.active=active;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SimCard that = (SimCard) o;
        return Objects.equals(iccid, that.iccid) && Objects.equals(customerEmail, that.customerEmail) &&Objects.equals(active,that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iccid, customerEmail);
    }

    @Override
    public String toString() {
        return "SimCard{" +
                "iccid='" + iccid + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                "active"+active+'\''+
                '}';
    }
}
