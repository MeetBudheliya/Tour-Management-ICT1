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
public class UserBean implements UserBeanLocal {

    @PersistenceContext(unitName = "TestPU")
    EntityManager em;

    @Override
    public void register_user(String first_name, String last_name, String email, String mobile, String gender, Date date_of_birth, String password, String address, String role, Boolean status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        User u = new User();
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
    public Collection<PackageTbl> get_all_packages() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("PackageTbl.findAll").getResultList();
    }

    @Override
    public Collection<PackageTbl> get_packages_by_name(String name) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("PackageTbl.findByName").setParameter("name", name).getResultList();
    }

    @Override
    public Collection<PackageTbl> get_packages_by_number_of_days(Integer num_of_days) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("PackageTbl.findByNumberOfDays").setParameter("numberOfDays", num_of_days).getResultList();
    }

    @Override
    public Collection<PackageTbl> get_packages_by_type(String type) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("PackageTbl.findByType").setParameter("type", type).getResultList();
    }

    @Override
    public Collection<PackageTbl> get_packages_by_transpotation_type(String transportation_type) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("PackageTbl.findByTransportationType").setParameter("transportationType", transportation_type).getResultList();
    }

    @Override
    public void add_booking(Integer user_id, Integer package_id, Integer amount, Boolean status) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Booking b = new Booking();
        b.setUserId(em.find(User.class, user_id));
        b.setPackageId(em.find(PackageTbl.class, package_id));
        b.setAmount(amount);
        b.setStatus(status);
        em.persist(b);
    }

    @Override
    public Collection<Booking> get_booking_by_user_id(Integer user_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Booking.findByUserId").setParameter("user_id", user_id).getResultList();
    }

    @Override
    public void update_booking(Integer booking_id, Integer user_id, Integer package_id, Integer amount, Boolean status) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Booking b = em.find(Booking.class, booking_id);
        b.setUserId(em.find(User.class, user_id));
        b.setPackageId(em.find(PackageTbl.class, package_id));
        b.setAmount(amount);
        b.setStatus(status);
        em.persist(b);
    }

    @Override
    public void add_payment(Integer amount, Integer user_id, Integer booking_id, Integer package_id, Boolean status) {
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Payment p = new Payment();
        p.setAmount(amount);
        p.setUserId(em.find(User.class, user_id));
        p.setBookingId(em.find(Booking.class, booking_id));
        p.setPackageId(em.find(PackageTbl.class, package_id));
        p.setStatus(status);
        em.persist(p);
    }

    @Override
    public void update_payment(Integer payment_id, Integer amount, Integer user_id, Integer booking_id, Integer package_id, Boolean status) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Payment p = em.find(Payment.class, payment_id);
        p.setBookingId(em.find(Booking.class, booking_id));
        p.setAmount(amount);
        p.setUserId(em.find(User.class, user_id));
        p.setPackageId(em.find(PackageTbl.class, package_id));
        p.setStatus(status);
        em.persist(p);
    }

    @Override
    public Collection<Payment> get_payment_by_user_id(Integer user_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Payment.findByUserId").setParameter("user_id", user_id).getResultList();
    }

    @Override
    public void add_support_request(String email, String name, Integer mobile, String subject, String description, Boolean is_active) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Support s = new Support();
        s.setEmail(email);
        s.setName(name);
        s.setMobile(mobile);
        s.setSubject(subject);
        s.setDescription(description);
        s.setIsActive(is_active);
        em.persist(s);
    }

    @Override
    public Collection<Support> get_support_requests_by_email(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
return em.createNamedQuery("Support.findByEmail").setParameter("email", email).getResultList();
    }

  
}
