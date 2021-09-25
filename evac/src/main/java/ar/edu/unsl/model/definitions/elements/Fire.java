package ar.edu.unsl.model.definitions.elements;

public class Fire {

    private float temp;

    public Fire() {
        this.temp = 500; // celcius
    }

    public float getTemp() {
        return this.temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }
}
