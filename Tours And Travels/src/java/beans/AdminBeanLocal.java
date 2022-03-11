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
import entity.User;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author meet
 */
@Local
public interface AdminBeanLocal {
    
    //manage user
    Collection<User> get_all_users();
    void update_user(Integer user_id, String first_name, String last_name, String email, String mobile, String gender, Date date_of_birth, String password, String address, String role, Boolean status);
    void remove_user(Integer user_id);

    //manage package
    Collection<PackageTbl> get_all_packages();
    PackageTbl find_package_by_id(Integer package_id);
    Collection<PackageTbl> get_packages_by_name(String name);
    Collection<PackageTbl> get_packages_by_number_of_days(Integer num_of_days);
    Collection<PackageTbl> get_packages_by_type(String type);
    Collection<PackageTbl> get_packages_by_transpotation_type(String transportation_type);   
    void add_package(String name,String description,String place,Integer price,Integer number_of_day, String package_type, String transportation_type, String food_detail, String hotel_name, String package_images, Boolean package_status);
    void remove_package(Integer package_id);
    void update_package(Integer package_id, String name,String description,String place,Integer price,Integer number_of_day, String package_type, String transportation_type, String food_detail, String hotel_name, String package_images, Boolean package_status); 
    
    //support list
     Collection<Support> get_all_support_request();
    Support get_request_by_id(Integer support_id);
    void update_supportRequest(Integer support_id, String email, String name, Integer mobile, String subject, String description, Boolean is_active);
    void remove_supportRequest(Integer support_id);
    
    //booking list
    Collection<Booking> get_all_booking();
    Booking get_booking_by_id(Integer booking_id);
    void update_booking(Integer booking_id, Integer user_id, Integer package_id, Integer amount, Boolean is_active);
    void remove_booking(Integer booking_id);
    
    //payment list
    Collection<Payment> get_all_payments();
    Payment get_payments_by_id(Integer payment_id);
    void update_payments(Integer payment_id, Integer user_id, Integer package_id, Integer amount, Boolean is_active);
    void remove_payments(Integer payment_id);
}
