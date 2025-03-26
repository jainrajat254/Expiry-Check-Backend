package com.example.ExpiryCheck.data;

import com.example.ExpiryCheck.schemas.Users;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", foreignKey = @ForeignKey(name = "fk_item_user"))
    private Users user;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "date")
    private String date;

    @Column(name = "opening_date")
    private String openingDate;

    @Column(name = "time_span")
    private String timeSpan;

    public Items() {}

    public Items(Users user, String itemName, String date, String openingDate, String timeSpan) {
        this.user = user;
        this.itemName = itemName;
        this.date = date;
        this.openingDate = openingDate;
        this.timeSpan = timeSpan;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan;
    }
}
