package com.keepcode.tests.test1.dto;

import com.keepcode.tests.test1.helper.JsonHelper;
import com.keepcode.tests.test1.helper.OnlineSimApiHelper;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.time.LocalDateTime;

@Getter
@Setter
public class OnlineSimPhoneNumberDto extends PhoneNumberDto {

    private LocalDateTime updatedAt;

    private String dataHumans;

    private LocalDateTime maxDate;

    private String status;

    public OnlineSimPhoneNumberDto(JSONObject json) {
        super(json.getString("number"),
                new CountryDto(json.getInt("country"), json.getString("country_text")),
                json.getString("full_number"));
        this.dataHumans = json.getString("data_humans");
        this.status = json.getString("status");
        this.updatedAt = JsonHelper.getDateFromJson(json, "updated_at", OnlineSimApiHelper.ONLINE_SIM_API_DATA_FORMATTER);
        this.maxDate = JsonHelper.getDateFromJson(json, "maxdate", OnlineSimApiHelper.ONLINE_SIM_API_DATA_FORMATTER);
    }
}
