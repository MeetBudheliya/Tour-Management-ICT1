/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author meet
 */
@Entity
@Table(name = "package_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PackageTbl.findAll", query = "SELECT p FROM PackageTbl p"),
    @NamedQuery(name = "PackageTbl.findById", query = "SELECT p FROM PackageTbl p WHERE p.id = :id"),
    @NamedQuery(name = "PackageTbl.findByName", query = "SELECT p FROM PackageTbl p WHERE p.name = :name"),
    @NamedQuery(name = "PackageTbl.findByPlace", query = "SELECT p FROM PackageTbl p WHERE p.place = :place"),
    @NamedQuery(name = "PackageTbl.findByPrice", query = "SELECT p FROM PackageTbl p WHERE p.price = :price"),
    @NamedQuery(name = "PackageTbl.findByNumberOfDays", query = "SELECT p FROM PackageTbl p WHERE p.numberOfDays = :numberOfDays"),
    @NamedQuery(name = "PackageTbl.findByType", query = "SELECT p FROM PackageTbl p WHERE p.type = :type"),
    @NamedQuery(name = "PackageTbl.findByTransportationType", query = "SELECT p FROM PackageTbl p WHERE p.transportationType = :transportationType"),
    @NamedQuery(name = "PackageTbl.findByHotelName", query = "SELECT p FROM PackageTbl p WHERE p.hotelName = :hotelName"),
    @NamedQuery(name = "PackageTbl.findByStatus", query = "SELECT p FROM PackageTbl p WHERE p.status = :status")})
public class PackageTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_of_days")
    private int numberOfDays;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "transportation_type")
    private String transportationType;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "food_detail")
    private String foodDetail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hotel_name")
    private String hotelName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "package_images")
    private String packageImages;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Booking> bookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageId")
    private Collection<Payment> paymentCollection;

    public PackageTbl() {
    }

    public PackageTbl(Integer id) {
        this.id = id;
    }

    public PackageTbl(Integer id, String name, String description, String place, int price, int numberOfDays, String type, String transportationType, String foodDetail, String hotelName, String packageImages, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.price = price;
        this.numberOfDays = numberOfDays;
        this.type = type;
        this.transportationType = transportationType;
        this.foodDetail = foodDetail;
        this.hotelName = hotelName;
        this.packageImages = packageImages;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }

    public String getFoodDetail() {
        return foodDetail;
    }

    public void setFoodDetail(String foodDetail) {
        this.foodDetail = foodDetail;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPackageImages() {
        return packageImages;
    }

    public void setPackageImages(String packageImages) {
        this.packageImages = packageImages;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageTbl)) {
            return false;
        }
        PackageTbl other = (PackageTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PackageTbl[ id=" + id + " ]";
    }
    
}
