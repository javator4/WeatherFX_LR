package pl.sda.weather.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.sda.WeatherService;

public class RootController {
    @FXML
    private TextField city;
    @FXML
    private Button button;
    @FXML
    private Label temperature;
    private String  adress = "http://api.apixu.com/v1/current.json",
                    apiKEY = "c43efeb2af124a358ca81413191307";
    private WeatherService weatherService = new WeatherService(adress, apiKEY);


    public void getWeather(ActionEvent actionEvent) {
        setTemperature(weatherService.getWeather(getCityInput()).getCurrent().getTemp_c());
    }

    private String getCityInput(){
        return city.getText();
    }

    private void setTemperature(float temp){
        this.temperature.setText(Float.toString(temp));
    }
}
