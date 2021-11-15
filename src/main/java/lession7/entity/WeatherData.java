package lession7.entity;


import lession7.ApplicationGlobalState;

public class WeatherData {

    private String city;
    private String localDate;
    private String text;
    private float temperature;

    public WeatherData() {
    }

    public WeatherData(String city, String localDate, String text, float temperature) {
        this.city = city;
        this.localDate = localDate;
        this.text = text;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float  getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void print() {
        System.out.println("========================================================================++++++++++++++++");
        System.out.printf("At city %s for date %s the weather conditions are %s, temperature is %f%n",
                city, localDate, text, temperature);
//        System.out.println( ApplicationGlobalState.getInstance().getSelectedCity() + ": the weather conditions is: " + text +
//                " and the temperature is " + temperature + "C");
        System.out.println("========================================================================++++++++++++++++");
    }
}