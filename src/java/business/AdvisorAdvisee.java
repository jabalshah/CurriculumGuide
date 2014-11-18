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
public class AdvisorAdvisee implements Serializable{
    private int idadvisoradvisee;
    private String advisor;
    private String advisee;

    public AdvisorAdvisee() {
    }

    public int getIdadvisoradvisee() {
        return idadvisoradvisee;
    }

    public void setIdadvisoradvisee(int idadvisoradvisee) {
        this.idadvisoradvisee = idadvisoradvisee;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getAdvisee() {
        return advisee;
    }

    public void setAdvisee(String advisee) {
        this.advisee = advisee;
    }   
}
