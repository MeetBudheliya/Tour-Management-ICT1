/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Booking;
import entity.PackageTbl;
import entity.Payment;
import entity.Support;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author meet
 */
@Local
public interface UserBeanLocal {
    
    //manage user
    void register_user(String first_name, String last_name, String email, String mobile, String gender, Date date_of_birth, String password, String address, String role, Boolean status);
    void update_user(Integer user_id, String first_name, String last_name, String email, String mobile, String gender, Date date_of_birth, String password, String address, String role, Boolean status);
   
     //manage package
    Collection<PackageTbl> get_all_packages();
    Collection<PackageTbl> get_packages_by_name(String name);
    Collection<PackageTbl> get_packages_by_number_of_days(Integer num_of_days);
    Collection<PackageTbl> get_packages_by_type(String type);
    Collection<PackageTbl> get_packages_by_transpotation_type(String transportation_type); 
    
    void add_booking(Integer user_id, Integer package_id, Integer amount, Boolean status);
    void update_booking(Integer booking_id, Integer user_id, Integer package_id, Integer amount, Boolean status);
     Collection<Booking> get_booking_by_user_id(Integer user_id);
    
    void add_payment(Integer amount, Integer user_id, Integer booking_id,Integer package_id, Boolean status);
    void update_payment(Integer payment_id, Integer amount, Integer user_id, Integer booking_id,Integer package_id, Boolean status);
     Collection<Payment> get_payment_by_user_id(Integer user_id);
    
    void add_support_request(String email, String name, Integer mobile, String subject, String description, Boolean is_active);
    Collection<Support> get_support_requests_by_email(String email);
}
