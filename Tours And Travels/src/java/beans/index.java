/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;

/**
 *
 * @author meet
 */
@Named(value = "index")
@RequestScoped
public class index {

    private int user_id;
    private String first_name = "temp_first_name";
    private String last_name = "temp_last_name";
    private String email = "";
    private String gender = "temp_gender";
    private String date_of_birth;
    private String password = "";
    private String address = "temp_address";
     private String mobile = "temp_mobile";
    private Boolean status = true;
    private Collection<User> users;
    
//    public String[] menus = {""};
    static final String[] menus = new String[]{""};


    @EJB
    UserBeanLocal ubl;

    public index() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UserBeanLocal getUbl() {
        return ubl;
    }

    public void setUbl(UserBeanLocal ubl) {
        this.ubl = ubl;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public String insertUser() {
        try {
            ubl.register_user(first_name, last_name, email, mobile, gender, convertStringToDate(date_of_birth), password, address, "user", Boolean.TRUE);
            System.out.print("User Registered Successfully!!!");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return "";
    }

    public Date convertStringToDate(String date) throws ParseException {
//        Date date = new Date();
//        Format format = new SimpleDateFormat("DD/MM/YYYY");
//        return format.format(date);
        
    Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(date); 
    return new Date();
    }
    
//    
//     public void validatePasswordError(FacesContext context, UIComponent component,
//            Object value) {
//
//        if (!ubl.getPassword().equals(passwordConfirm)) {
//            String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['nomatch']}", String.class);
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
//            throw new ValidatorException(msg);
//        }
//    }
}


