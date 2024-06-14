package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    String model;
    String series;
    String color;
    public Car(String model, String series, String color) {
        this.model = model;
        this.series = series;
        this.color = color;
    }
    public Car(){}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series='" + series + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}