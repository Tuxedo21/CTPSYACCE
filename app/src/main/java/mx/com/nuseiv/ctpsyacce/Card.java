package mx.com.nuseiv.ctpsyacce;

import java.util.Arrays;

/**
 * Created by tuxedo21 on 2/26/16.
 */
public class Card {

    private final int[] value;
    private final int face;

    public Card(int[] value, int face) {
        this.value = value;
        this.face = face;
    }

    @Override
    public String toString() {
        return "Card " +
                "value = {" + Arrays.toString(value) +
                '}';
    }

    //TODO better this logic
    public int getValue(boolean ace) {
        if (ace){
            return value[1]; //ace 11
        }
        return value[0]; //ace 1 or other card value
    }

    public int getFace() {
        return face;
    }
}
