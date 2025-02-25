package au.com.telstra.simcardactivator;

import java.util.Objects;

public class SimDetails {
    private String iccid;
    private String customerEmail;

    public SimDetails(String iccid, String customerEmail){
        this.iccid=iccid;
        this.customerEmail=customerEmail;
    }


    public String getIccid() {
        return iccid;
    }

    public SimDetails() {
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SimDetails that = (SimDetails) o;
        return Objects.equals(iccid, that.iccid) && Objects.equals(customerEmail, that.customerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iccid, customerEmail);
    }

    @Override
    public String toString() {
        return "SimDetails{" +
                "iccid='" + iccid + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
