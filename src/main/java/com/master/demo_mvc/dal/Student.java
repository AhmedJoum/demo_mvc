package com.master.demo_mvc.dal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
  
    private String name;
  
    private String email;

    private Integer semester;

    private String address;
    
    public Integer getId() {
        return id;
      }
    
      public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

      public Integer getSemester() {
      return semester;
    }

    public void setSemester(Integer semester) {
      this.semester = semester;
    }

      public void setId(Integer id) {
        this.id = id;
      }
    
      public String getName() {
        return name;
      }
    
      public void setName(String name) {
        this.name = name;
      }
    
      public String getEmail() {
        return email;
      }
    
      public void setEmail(String email) {
        this.email = email;
      }
}
