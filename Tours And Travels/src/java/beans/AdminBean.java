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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author meet
 */
@Stateless
public class AdminBean implements AdminBeanLocal {
@PersistenceContext(unitName = "TestPU")
    EntityManager em;

 @Override
    public Collection<User> get_all_users() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    
    @Override
    public void update_user(Integer user_id, String first_name, String last_name, String email, String mobile, String gender, Date date_of_birth, String password, String address, String role, Boolean status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         User u = em.find(User.class, user_id);
         u.setFirstName(first_name);
         u.setLastName(last_name);
         u.setEmail(email);
         u.setMobile(mobile);
         u.setGender(gender);
         u.setDateOfBirth(date_of_birth);
         u.setPassword(password);
         u.setAddress(address);
         u.setRole(role);
         u.setStatus(status);
         em.persist(u);
    }
    
    @Override
    public void remove_user(Integer user_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 em.remove(em.find(User.class, user_id));
    }

    @Override
    public void add_package(String name, String description, String place, Integer price, Integer number_of_day, String package_type, String transportation_type, String food_detail, String hotel_name, String package_images, Boolean package_status) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PackageTbl p = new PackageTbl();
        p.setName(name);
        p.setDescription(description);
        p.setPlace(place);
        p.setPrice(price);
        p.setNumberOfDays(number_of_day);
        p.setType(package_type);
        p.setTransportationType(transportation_type);
        p.setFoodDetail(food_detail);
        p.setHotelName(hotel_name);
        p.setPackageImages(package_images);
        p.setStatus(package_status);
        em.persist(p);
    }

    @Override
    public void remove_package(Integer package_id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PackageTbl p = em.find(PackageTbl.class, package_id);
        em.remove(p);
    }

    @Override
    public void update_package(Integer package_id, String name, String description, String place, Integer price, Integer number_of_day, String package_type, String transportation_type, String food_detail, String hotel_name, String package_images, Boolean package_status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PackageTbl p = em.find(PackageTbl.class, package_id);
        p.setName(name);
        p.setDescription(description);
        p.setPlace(place);
        p.setPrice(price);
        p.setNumberOfDays(number_of_day);
        p.setType(package_type);
        p.setTransportationType(transportation_type);
        p.setFoodDetail(food_detail);
        p.setHotelName(hotel_name);
        p.setPackageImages(package_images);
        p.setStatus(package_status);
        em.persist(p);
    }

    @Override
    public Collection<PackageTbl> get_all_packages() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("PackageTbl.findAll").getResultList();
    }

    @Override
    public PackageTbl find_package_by_id(Integer package_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.find(PackageTbl.class, package_id);
    }

    @Override
    public Collection<PackageTbl> get_packages_by_name(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 Collection<PackageTbl> packages = em.createNamedQuery("PackageTbl.findByName")
                                    .setParameter("name", name)
                                    .getResultList();
 return packages;
    }

    @Override
    public Collection<PackageTbl> get_packages_by_number_of_days(Integer num_of_days) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 Collection<PackageTbl> packages = em.createNamedQuery("PackageTbl.findByNumberOfDays")
                                    .setParameter("number_of_days", num_of_days)
                                    .getResultList();
 return packages;
    }

    @Override
    public Collection<PackageTbl> get_packages_by_type(String type) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 Collection<PackageTbl> packages = em.createNamedQuery("PackageTbl.findByType")
                                    .setParameter("type", type)
                                    .getResultList();
 return packages;
    }

    @Override
    public Collection<PackageTbl> get_packages_by_transpotation_type(String transportation_type) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
Collection<PackageTbl> packages = em.createNamedQuery("PackageTbl.findByTransportationType")
                                    .setParameter("transportationType", transportation_type)
                                    .getResultList();
 return packages;
    }

    
    @Override
    public Collection<Support> get_all_support_request() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Support.findAll").getResultList();
    }
    
    @Override
    public void update_supportRequest(Integer support_id, String email, String name, Integer mobile, String subject, String description, Boolean is_active) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Support s = em.find(Support.class, support_id);
   s.setEmail(email);
   s.setName(name);
   s.setMobile(mobile);
   s.setSubject(subject);
   s.setDescription(description);
   s.setIsActive(is_active);
   em.persist(s);
    }

    @Override
    public void remove_supportRequest(Integer support_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.\
        Support s = em.find(Support.class, support_id);
        em.remove(s);
    }

    @Override
    public Support get_request_by_id(Integer support_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.find(Support.class, support_id);
    }

    @Override
    public Collection<Booking> get_all_booking() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return em.createNamedQuery("Booking.findAll").getResultList();
    }

    @Override
    public Booking get_booking_by_id(Integer booking_id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.find(Booking.class, booking_id);
    }

    @Override
    public void update_booking(Integer booking_id, Integer user_id, Integer package_id, Integer amount, Boolean is_active) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Booking b = em.find(Booking.class, booking_id);
        b.setUserId(em.find(User.class, user_id));
        b.setPackageId(em.find(PackageTbl.class, package_id));
        b.setAmount(amount);
        b.setStatus(is_active);
        em.persist(b);
    }

    @Override
    public void remove_booking(Integer booking_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        em.remove(em.find(Booking.class, booking_id));
    }

    @Override
    public Collection<Payment> get_all_payments() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Payment.findAll").getResultList();
    }

    @Override
    public Payment get_payments_by_id(Integer payment_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.find(Payment.class, payment_id);
    }

    @Override
    public void update_payments(Integer payment_id, Integer user_id, Integer package_id, Integer amount, Boolean is_active) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Payment p = em.find(Payment.class, payment_id);
        p.setUserId(em.find(User.class, user_id));
        p.setPackageId(em.find(PackageTbl.class, package_id));
        p.setAmount(amount);
        p.setStatus(is_active);
em.persist(p);
    }

    @Override
    public void remove_payments(Integer payment_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            em.remove(em.find(Payment.class, payment_id));
    }

}
