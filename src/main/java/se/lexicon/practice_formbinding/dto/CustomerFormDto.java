package se.lexicon.practice_formbinding.dto;

public class CustomerFormDto {
    private String email;
    private String adress;
    private String city;
    private String zipCode;
    private String homePhone;
    private String cellPhone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
    public String checkAdressIsEmpty(String adress){
        if (adress.isEmpty()){
            return this.adress="Unknown";
        }
        return this.adress;
    }
}
