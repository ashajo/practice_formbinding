package se.lexicon.practice_formbinding.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false)
    @NotNull
    private String customerId;
    @NotNull
    private String email;
    @CreationTimestamp
    @Column(nullable = false,columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDate regDate;
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean active;
    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private CustomerDetails customerDetails;

    public Customer(String email,CustomerDetails customerDetails){
        this.customerId= UUID.randomUUID().toString();
        this.email=email;
        this.active=true;
        this.regDate=LocalDate.now();
        this.customerDetails=customerDetails;
    }

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active && Objects.equals(customerId, customer.customerId) && Objects.equals(email, customer.email) && Objects.equals(regDate, customer.regDate) && Objects.equals(customerDetails, customer.customerDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, regDate, active, customerDetails);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", active=" + active +
                ", customerDetails=" + customerDetails +
                '}';
    }
}

