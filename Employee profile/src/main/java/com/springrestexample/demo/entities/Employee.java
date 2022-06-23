package com.springrestexample.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Employee")
@Where(clause = "record=1")
public class Employee {

    @JsonIgnore
    private UUID EmpId;
    @Column(name="EMP_NAME")
    private Date CreateDate;

    @Column
    private String emp_name;
    @Column
    private String emp_desc;
    @Column
    private Date UpdateDate;

    @Where(clause ="RECORD_Status=1")
    @Column
    private int record = 1;

    public Employee(UUID empId, Date createDate,String emp_name, String emp_desc, Date updateDate, int record){
        EmpId = empId;
        CreateDate = createDate;
        this.emp_name = emp_name;
        this.emp_desc = emp_desc;
        UpdateDate = updateDate;
        this.record = record;
    }

    public Employee(){
        super();
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", columnDefinition ="varchar(50")
    @Type(type = "org.hibernate.type.UUIDCharType")

    public UUID getEmpId() {
        return EmpId;
    }

    public void setEmpId(UUID empId) {
        EmpId = empId;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_desc() {
        return emp_desc;
    }

    public void setEmp_desc(String emp_desc) {
        this.emp_desc = emp_desc;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
}
