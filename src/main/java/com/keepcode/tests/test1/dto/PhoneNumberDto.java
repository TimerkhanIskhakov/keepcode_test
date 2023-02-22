package com.keepcode.tests.test1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class PhoneNumberDto {

    private String number;

    private CountryDto countryDto;

    private LocalDateTime updatedAt;

    private String dataHumans;

    private String fullNumber;

    private LocalDateTime maxDate;

    private String status;

    public PhoneNumberDto() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumberDto that = (PhoneNumberDto) o;
        return Objects.equals(number, that.number) && Objects.equals(countryDto, that.countryDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, countryDto);
    }
}
