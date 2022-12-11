package kz.altyn.komek.models;import com.google.gson.annotations.SerializedName;import java.io.Serializable;public class Charity implements Serializable {    private Long id;    private String title;    private String address;    private String description;    private String number;    @SerializedName("year_of_foundation")    private String yearOfFoundation;    private String logo;    private String mail;    public Charity(Long id, String title, String address, String description, String number, String yearOfFoundation, String logo, String mail) {        this.id = id;        this.title = title;        this.address = address;        this.description = description;        this.number = number;        this.yearOfFoundation = yearOfFoundation;        this.logo = logo;        this.mail = mail;    }    public Charity() {    }    public Long getId() {        return id;    }    public void setId(Long id) {        this.id = id;    }    public String getTitle() {        return title;    }    public void setTitle(String title) {        this.title = title;    }    public String getAddress() {        return address;    }    public void setAddress(String address) {        this.address = address;    }    public String getDescription() {        return description;    }    public void setDescription(String description) {        this.description = description;    }    public String getNumber() {        return number;    }    public void setNumber(String number) {        this.number = number;    }    public String getYearOfFoundation() {        return yearOfFoundation;    }    public void setYearOfFoundation(String yearOfFoundation) {        this.yearOfFoundation = yearOfFoundation;    }    public String getLogo() {        return logo;    }    public String getMail() {        return mail;    }    public void setMail(String mail) {        this.mail = mail;    }    public void setLogo(String logo) {        this.logo = logo;    }}