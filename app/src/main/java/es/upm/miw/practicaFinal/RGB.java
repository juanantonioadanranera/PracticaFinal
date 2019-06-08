package es.upm.miw.practicaFinal;

public class RGB {
    public int red;
    public int green;
    public int blue;

    RGB() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    RGB(int brightness) {
        this.red = brightness;
        this.green = brightness;
        this.blue = brightness;
    }

    RGB(int r, int g, int b) {
      this.red = r;
      this.green = g;
      this.blue = b;
    }


    RGB suma(RGB other) {
        return new RGB(red + other.red, green + other.green, blue + other.blue);
    }

    RGB div(int scalar) {
        return new RGB(red/scalar, green/scalar, blue/scalar);
    }

}