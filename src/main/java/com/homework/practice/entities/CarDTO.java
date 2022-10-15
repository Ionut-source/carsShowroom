package com.homework.practice.entities;

import com.homework.practice.enums.Currency;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {

    private long id;
    private String carBrand;
    private String carModel;
    private String carColor;
    private double carPrice;
    private Currency currency;
}
