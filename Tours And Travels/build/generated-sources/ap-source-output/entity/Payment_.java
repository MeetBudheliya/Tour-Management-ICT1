package entity;

import entity.Booking;
import entity.PackageTbl;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:30:18")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Integer> amount;
    public static volatile SingularAttribute<Payment, PackageTbl> packageId;
    public static volatile SingularAttribute<Payment, Integer> id;
    public static volatile SingularAttribute<Payment, User> userId;
    public static volatile SingularAttribute<Payment, Booking> bookingId;
    public static volatile SingularAttribute<Payment, Boolean> status;

}