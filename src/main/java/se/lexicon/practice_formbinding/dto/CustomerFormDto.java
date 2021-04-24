package se.lexicon.practice_formbinding.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerFormDto {
    @NotEmpty(message = "Field cannot be empty")
    @Email(message = "Specified email address is not valid")
    private String email;
    @Pattern(regexp = "CITY_VALIDATION_PATTERN",
            message = "VALID_CITY_NAME")
    private String city;
    @Pattern(regexp =" SWEDISH_ZIPCODE_PATTERN",
            message = "SWEDISH_ZIPCODE_FORMAT")
    private String zipCode;
    @Pattern(regexp =" SWEDISH_PHONE_NUMBER_PATTERN",
            message = "PHONE_FORMAT_MESSAGE")
    private String homePhone;
    @Pattern(regexp = "SWEDISH_CELLPHONE_NUMBER",
            message = "CELLPHONE_FORMAT_MESSAGE")
    private String cellPhone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String checkCityIsEmpty(String city){
        if (city.isEmpty()){
            return this.city="Unknown";
        }
        return this.city;
    }
}
