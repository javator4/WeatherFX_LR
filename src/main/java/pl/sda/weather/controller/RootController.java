package pl.sda.weather.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pl.sda.WeatherService;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML
    private TextField city;
    @FXML
    private Button button;
    @FXML
    private Label temperature;
    private String  adress = "http://api.apixu.com/v1/current.json",
                    apiKEY = "c43efeb2af124a358ca81413191307";
    private WeatherService weatherService = new WeatherService(adress, apiKEY);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("URUCHOMILEM OKNO");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText("To jest moja aplikacja");
        alert.show();

        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Potwierdzenie");
        alert1.setContentText("Jesteś pewien?");
        Optional<ButtonType> result = alert1.showAndWait();
        if(result.get() == ButtonType.OK){
            System.out.println("Użyszkodnik wybrał OK");
        } else {
            System.out.println("Użyszkodnik wybrał cancel");
        }
    }

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
