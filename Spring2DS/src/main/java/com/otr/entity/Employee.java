package com.otr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author SPAR
 */
@Entity
public class Employee implements Serializable {
        
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, unique = true, length=10)
    private String emp_RN_No;
    @Column(nullable = false, unique = true, length=10)
    private String emp_IPN_No;
    @Column(nullable = false, length=30)
    private String first_Name;
    @Column(nullable = false, length=15)
    private String last_Name;
    @Column(nullable = false, length=15)
    private String designation;
    @Column(nullable = false, length=10)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;
    @Column(nullable = false, length=15)
    private String blood_Group;
    @Column(nullable = false, unique = true, length=35)
    private String email_Id;
    @Column(nullable = false, length=15)
    private String contact_No;
    @Column(nullable = false, length=100)
    private String local_Address;
    @Column(nullable = false, length=100)
    private String permanent_Address;
    @Column(nullable = false, length=40)
    private String nomanee_Name;
    @Column(nullable = false, length=15)
    private String emergency_Contact_No;
    
    public String getEmp_RN_No() {
        return emp_RN_No;
    }

    public void setEmp_RN_No(String emp_RN_No) {
        this.emp_RN_No = emp_RN_No;
    }

    public String getEmp_IPN_No() {
        return emp_IPN_No;
    }

    public void setEmp_IPN_No(String emp_IPN_No) {
        this.emp_IPN_No = emp_IPN_No;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBlood_Group() {
        return blood_Group;
    }

    public void setBlood_Group(String blood_Group) {
        this.blood_Group = blood_Group;
    }

    public String getEmail_Id() {
        return email_Id;
    }

    public void setEmail_Id(String email_Id) {
        this.email_Id = email_Id;
    }

    public String getContact_No() {
        return contact_No;
    }

    public void setContact_No(String contact_No) {
        this.contact_No = contact_No;
    }

    public String getLocal_Address() {
        return local_Address;
    }

    public void setLocal_Address(String local_Address) {
        this.local_Address = local_Address;
    }

    public String getPermanent_Address() {
        return permanent_Address;
    }

    public void setPermanent_Address(String permanent_Address) {
        this.permanent_Address = permanent_Address;
    }

    public String getNomanee_Name() {
        return nomanee_Name;
    }

    public void setNomanee_Name(String nomanee_Name) {
        this.nomanee_Name = nomanee_Name;
    }

    public String getEmergency_Contact_No() {
        return emergency_Contact_No;
    }

    public void setEmergency_Contact_No(String emergency_Contact_No) {
        this.emergency_Contact_No = emergency_Contact_No;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "emp_RN_No=" + emp_RN_No + ", emp_IPN_No=" + emp_IPN_No + ", first_Name=" + first_Name + ", second_Name=" + last_Name + ", designation=" + designation + ", dob=" + dob + ", blood_Group=" + blood_Group + ", email_Id=" + email_Id + ", contact_No=" + contact_No + ", local_Address=" + local_Address + ", permanent_Address=" + permanent_Address + ", nomanee_Name=" + nomanee_Name + ", emergency_Contact_No=" + emergency_Contact_No + '}';
    }
    
    
}

