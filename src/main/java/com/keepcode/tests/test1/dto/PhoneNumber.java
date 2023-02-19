package com.keepcode.tests.test1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PhoneNumber {

    private String number;

    private Country country;

    private LocalDateTime updatedAt;

    private String dataHumans;

    private String fullNumber;

    private LocalDateTime maxDate;

    private String status;

    public PhoneNumber() {

    }
}
