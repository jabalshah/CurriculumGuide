/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.io.Serializable;

/**
 *
 * @author Jabal
 */
public class Registration implements Serializable {
    private int idregistration;
    private String userName;
    private String course_id;
    private int semester;
    private String grade;
    private String category;
    private String satisfies;

    public int getIdregistration() {
        return idregistration;
    }

    public void setIdregistration(int idregistration) {
        this.idregistration = idregistration;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSatisfies() {
        return satisfies;
    }

    public void setSatisfies(String satisfies) {
        this.satisfies = satisfies;
    }
    
}
