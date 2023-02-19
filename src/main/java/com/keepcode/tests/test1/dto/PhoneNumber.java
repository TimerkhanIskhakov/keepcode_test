package com.keepcode.tests.test1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, country);
    }
}
