package entity;

import entity.Booking;
import entity.Payment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-10T10:30:18")
@StaticMetamodel(PackageTbl.class)
public class PackageTbl_ { 

    public static volatile SingularAttribute<PackageTbl, String> foodDetail;
    public static volatile SingularAttribute<PackageTbl, String> description;
    public static volatile SingularAttribute<PackageTbl, Integer> numberOfDays;
    public static volatile SingularAttribute<PackageTbl, String> type;
    public static volatile SingularAttribute<PackageTbl, String> transportationType;
    public static volatile SingularAttribute<PackageTbl, String> hotelName;
    public static volatile CollectionAttribute<PackageTbl, Booking> bookingCollection;
    public static volatile CollectionAttribute<PackageTbl, Payment> paymentCollection;
    public static volatile SingularAttribute<PackageTbl, Integer> price;
    public static volatile SingularAttribute<PackageTbl, String> name;
    public static volatile SingularAttribute<PackageTbl, Integer> id;
    public static volatile SingularAttribute<PackageTbl, String> place;
    public static volatile SingularAttribute<PackageTbl, String> packageImages;
    public static volatile SingularAttribute<PackageTbl, Boolean> status;

}