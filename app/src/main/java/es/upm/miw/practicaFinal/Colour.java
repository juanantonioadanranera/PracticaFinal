package es.upm.miw.practicaFinal;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Colour {
    private static final int NUM_COLORS = 7;
    private static final double MAX_TEMP = 37.0;
    private static final double MIN_TEMP = 3.0;

    RGB[] colors = new RGB[7];

    void init () {
        colors[0] = new RGB(255, 255, 255); // White
        colors[1] = new RGB(255, 0, 255); // Purple
        colors[2] = new RGB(0, 0, 255); // Blue
        colors[2] = new RGB(0, 255, 255); // Cyan
        colors[3] = new RGB(0, 255, 0); // Green
        colors[4] = new RGB(255, 255, 0); // Yellow
        colors[5] = new RGB(255, 0, 0); // Red
    }

    int interpolate(int col1, int col2, double dx) {
        return (int)((1-dx)*col1 + dx*col2);
    };

    RGB interpolate(RGB col1, RGB col2, double dx) {
        RGB rgb = new RGB (
                interpolate(col1.red, col2.red, dx),
                interpolate(col1.green, col2.green, dx),
                interpolate(col1.blue, col2.blue, dx)
        );
        return rgb;
    };

    RGB pick_color(int index) {
        index = Math.max(0, Math.min(NUM_COLORS-1, index));
        return colors[index];
    }

    RGB color_for_temperature(double t) {
        double normalised = (t-MIN_TEMP)/(MAX_TEMP-MIN_TEMP);
        double col = normalised*(NUM_COLORS-1);
        int col_low = (int)Math.floor(col);
        int col_high = (int)Math.ceil(col);

        double dx = col_high - col;
        if ( t < MIN_TEMP || t > MAX_TEMP ) {
            dx = 0;
        }

        RGB rgb_high = pick_color(col_high),
                rgb_low  = pick_color(col_low);
        RGB rgb = interpolate(rgb_high, rgb_low, dx);
        //print_rgb(rgb);
        return rgb;
    }
}
