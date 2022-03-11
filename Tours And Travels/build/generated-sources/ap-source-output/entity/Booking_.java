package entity;

import entity.PackageTbl;
import entity.Payment;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:30:18")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Integer> amount;
    public static volatile SingularAttribute<Booking, PackageTbl> packageId;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, User> userId;
    public static volatile CollectionAttribute<Booking, Payment> paymentCollection;
    public static volatile SingularAttribute<Booking, Boolean> status;

}