package com.homework.practice.entities;

import com.homework.practice.enums.Currency;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long carId;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_color")
    private String carColor;
    @Column(name = "car_price")
    private double carPrice;
    @Column(name = "car_currency")
    @Enumerated(STRING)
    private Currency currency;

    public CarDTO toDTO() {
        return CarDTO.builder()
                .id(carId)
                .carBrand(carBrand)
                .carModel(carModel)
                .carColor(carColor)
                .carPrice(carPrice)
                .currency(currency)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

