package mx.com.nuseiv.ctpsyacce;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuxedo21 on 2/27/16.
 */
public class House {


    private ArrayList<Card> HouseValues = new  ArrayList<>();

    public House(){
        this.setHandToEmpty();
    }

    public void setHandToEmpty(){
        Card genericCard = new Card(new int[] {0}, 0);
        HouseValues.add(genericCard);
    }

    public void addCardToAHand(Card card){
        this.HouseValues.add(card);
    }

    public Integer getHandSum() {
        ArrayList<Card> hand = HouseValues;
        Log.e("Hand Amount", HouseValues.toString());
        Integer sum = 0;
        int numOfAces=0;
        for(int i = 0; i < hand.size(); i++)
        {
            if (hand.get(i).getFace() == R.drawable.ace_of_clubs || hand.get(i).getFace() == R.drawable.ace_of_diamonds
                    ||hand.get(i).getFace() == R.drawable.ace_of_hearts ||hand.get(i).getFace() == R.drawable.ace_of_spades){
                sum += hand.get(i).getValue(true);//add
                numOfAces++;
            }else {
                sum += hand.get(i).getValue(false);
            }
        }
        while (sum > 21 && numOfAces > 0){
            sum-=10;
            numOfAces--;
        }
        return sum;
    }

}
