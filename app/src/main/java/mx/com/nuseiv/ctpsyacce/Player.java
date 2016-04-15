package mx.com.nuseiv.ctpsyacce;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuxedo21 on 2/27/16.
 */
public class Player {

    private ArrayList<ArrayList<Card>> handValues = new  ArrayList<>();
    private List<Integer> betForHand = new ArrayList<>();
    private int wallet; //int cant be in an List
    private int currentBet = 0;
    private ArrayList<Card> currentHand = new ArrayList<>();

    public Player(int wallet) {
        this.setAllHandsToEmpty();
        this.setAllBetsToEmpty();
        this.currentHand = handValues.get(0);
        this.wallet = wallet;
    }


            //BET METHODS
    public void setBetForHand(int index) {
        this.currentBet = index;
    }

    public int getCurrentBet() {
        Log.e("Get current bet", currentBet + "");
        return currentBet;
    }

    public void setCurrentBet(int index) {
        Log.e("Set current bet", currentBet + "<-should be:" + index);
        this.currentBet = index;
    }

    public Integer getBetForHand()
    {
        return betForHand.get(currentBet);
    }

    public void modBetForHand(Integer mod, int index){

        betForHand.set(index, betForHand.get(index) + mod);
    }

    private void setAllBetsToEmpty() {
        for (int i = 0; i < 5; i++) {
            Integer genericInteger = new Integer(0);
            betForHand.add(genericInteger);
        }
    }

            //HAND METHODS

    //Add a card to player's hand, the boolean tells if hand is over 21
    public void addCardToAHand(Card card,int handNumber){
        this.handValues.get(handNumber).add(card);
    }

    //Empty all hands
    public void setAllHandsToEmpty(){
        for (int i = 0; i < 5; i++) {
            Card genericCard = new Card(new int[] {0}, 0);
            ArrayList<Card> genericArrayList = new ArrayList<>();
            genericArrayList.add(genericCard);
            handValues.add(genericArrayList);
        }

        Log.e("setAllHandsToEmpty", "Emptying hands" +handValues.toString());
    }

    //Empty all hands the good way
    public void setAllHandsToEmpty(boolean clear){

        handValues.get(0).clear();
        handValues.get(1).clear();
        handValues.get(2).clear();
        handValues.get(3).clear();
        handValues.get(4).clear();
        Log.e("setAllHandsToEmpty", "Emptying hands" + handValues.toString());
    }

    public ArrayList<ArrayList<Card>> getHandValues() {
        return handValues;
    }



    public Integer getHandSum(int handNumber) {
        ArrayList<Card> hand = handValues.get(handNumber);
        Log.e("Hand Amount", handValues.get(handNumber).toString() );
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

    public ArrayList<Card> getHand(int hand){
        return handValues.get(hand);
    }

    public ArrayList<Card> getCurrentHand() {
        return currentHand;
    }

    public void setCurrentHand(int index) {
        this.currentHand = handValues.get(index);
    }

    //double down

    //split


         //WALLET METHODS

    public void modWallet(int amount){
        wallet = wallet + amount;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

}
