package mx.com.nuseiv.ctpsyacce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


/*  GAME PLAY
*
*  SET BETS
*
*   USE MORE AND LESS PER HAND
*
*  DEAL
*   --FOR EVERY CARD DEALT MOD COUNT--
*   TWO CARDS PER HAND, HAND OF HOUSE MUST BE ONE SHOWING ONE FACE DOWN
*   CHECK FOR BLACKJACKS
*   ASK FOR HAND
*   GOTO: ASK FOR HAND
*   HOUSE ASKS FOR HAND AND SHOWS FACE DOWN
*
*  CHECK HANDS AND EXCHANGE
*
*  COMPARE VALUES OF HANDS
*  EXCHANGE THE AMOUNT BET
*
*  GOTO: SET BETS
* */


// if hand is busted subtract 1
// if hand is less than house, subtract 1
// if hand is more than house, add 1
// if hand is bj and house is not, add 1.5


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnLongClickListener {

    //Settings TODO this has to be set from another activity
    Settings mSettings = new Settings(4,10,250,16);


    //For Players Hands
    ImageView handOne, handTwo, handThree, handFour,
            handFive, handHouseOne,handHouseTwo;
    ArrayList<ImageView> ArrayOfHands = new ArrayList<>();
    ArrayList<ImageView> HouseHand = new ArrayList<>();

    //For Players Hands
    TextView  valueOne, valueTwo, valueThree,
            valueFour, valueFive, houseValue;
    ArrayList<TextView> ArrayOfValues = new ArrayList<>();
    //The Deck
    Shoe shoe;
        House house;
        Player player;
        TextView playerWallet, playerBet, playerHand;
    Button dealBtn,showCountBtn,moreBetBtn,lessBetBtn;

    final int dealTag = 20, lessTag = 21, moreTag =22;
    final int handOneTag = 11, handTwoTag = 12,
            handThreeTag = 13, handFourTag =14, handFiveTag =15;
    final int handOneBetTag = 1, handTwoBetTag = 2,
            handThreeBetTag = 3, handFourBetTag =4, handFiveBetTag =5;

    boolean doneWithBets = false;
    boolean dealing = true;


      //SETUP CODE
    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        house = new House();
        player = new Player(mSettings.getPlayerWallet());
        setupImageViews(); //Card Views
        setupTextViews(); //Card sum Views
        setupButtons();
        setupPlayerStats();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        shoe = new Shoe();
        Log.v("Deck", shoe.toString());

        placeMinBets();
    }

    //I believe this is done
    public void setupPlayerStats(){
        playerWallet = (TextView)findViewById(R.id.player_wallet);
        playerWallet.setText(player.getWallet() + "");
        playerBet = (TextView)findViewById(R.id.player_bet);
        playerHand = (TextView)findViewById(R.id.what_hand);
    }

    //This should take in as many hands as the player states, done
    public void setupTextViews(){

        int[] playerHandTextViewsIds = {R.id.valueOne, R.id.valueTwo,R.id.valueThree,R.id.valueFour,R.id.valueFive};
        TextView[] playerHandTextViews = { valueOne,valueTwo,valueThree,valueFour,valueFive};
        int[] playerHandTextViewsTags = { handOneBetTag,handTwoBetTag, handThreeBetTag, handFourBetTag, handFiveBetTag};

        for (int i = 0; i < mSettings.getNumberOfHands(); i++){

            playerHandTextViews[i] = (TextView)findViewById(playerHandTextViewsIds[i]);
            playerHandTextViews[i].setTag(playerHandTextViewsTags[i]);
            playerHandTextViews[i].setOnTouchListener(this);
            ArrayOfValues.add(playerHandTextViews[i]);
        }

        houseValue = (TextView)findViewById(R.id.houseValue);

    }

    //this should mostly be a static setup
    public  void setupButtons(){
        dealBtn = (Button)findViewById(R.id.deal);
        showCountBtn = (Button)findViewById(R.id.show_count);
        moreBetBtn = (Button)findViewById(R.id.more);
        lessBetBtn = (Button)findViewById(R.id.less);

        dealBtn.setOnClickListener(this);
        showCountBtn.setOnClickListener(this);
        moreBetBtn.setOnClickListener(this);
        lessBetBtn.setOnClickListener(this);

        dealBtn.setTag(dealTag);
        moreBetBtn.setTag(moreTag);
        lessBetBtn.setTag(lessTag);
    }

    // Sets house and players imageViews, tags, and adds them to an array list
    public void setupImageViews(){

        ImageView[] playerImageViews = {handOne, handTwo, handThree, handFour,handFive};
        int[] playerImageViewsTags = {handOneTag, handTwoTag,handThreeTag, handFourTag, handFiveTag};
        int[] playerImageViewsIds = {R.id.handOne, R.id.handTwo,R.id.handThree,R.id.handFour,R.id.handFive};

        for (int i = 0; i < mSettings.getNumberOfHands(); i++){
            playerImageViews[i] = (ImageView)findViewById(playerImageViewsIds[i]);
            playerImageViews[i].setTag(playerImageViewsTags[i]); // can change this to an arithmetic operacion
            playerImageViews[i].setImageResource(0);
            playerImageViews[i].setOnTouchListener(this);
            ArrayOfHands.add(playerImageViews[i]);
        }

        handHouseOne = (ImageView)findViewById(R.id.house_left);
        handHouseTwo = (ImageView)findViewById(R.id.house_right);
        handHouseOne.setImageResource(0);
        handHouseTwo.setImageResource(0);

        HouseHand.add(handHouseOne);
       // HouseHand.add(handHouseTwo);
    }



    //UI CODE AND GAMEPLAY
    @Override
    public void onClick(View v) {

        //DEAL PART
        if (v.getTag() == dealTag){
            doneWithBets = true;
            player.setAllHandsToEmpty(true);
            house.setHandToEmpty();
            Log.e("Dealing Cards", shoe.toString() + "");
            Toast.makeText(MainActivity.this,"Dealing",Toast.LENGTH_SHORT).show();

            for (int i = 0; i < mSettings.getNumberOfHands(); i++) {
                player.addCardToAHand(shoe.getTopDeckCard(),i);
                Log.e("Hand " + i + " Card x", shoe.getTopDeckCard() + "");
                shoe.sendTopDeckCardToGrave();
                player.addCardToAHand(shoe.getTopDeckCard(), i);
                Log.e("Hand " + i + " Card x", shoe.getTopDeckCard() + "");
                ArrayOfHands.get(i).setBackgroundResource(shoe.getTopDeckCard().getFace());
                shoe.sendTopDeckCardToGrave();
                ArrayOfValues.get(i).setText(player.getHandSum(i) + "");
            }

            for (int i = 0; i < HouseHand.size(); i++) {
                house.addCardToAHand(shoe.getTopDeckCard());
                Log.e("House Hand " + i + " Card x", shoe.getTopDeckCard() + "");
                shoe.sendTopDeckCardToGrave();
                house.addCardToAHand(shoe.getTopDeckCard());
                HouseHand.get(i).setBackgroundResource(shoe.getTopDeckCard().getFace());
                Log.e("House Hand " + i + " Card x", shoe.getTopDeckCard() + "");
                shoe.sendTopDeckCardToGrave();
                houseValue.setText(house.getHandSum() + "");
               // Log.e("Full House Hand" + house.getHandValues());
            }

        }
        //Less
        else if (v.getTag() == lessTag) {

            if (player.getBetForHand() - mSettings.getBetInc() >= mSettings.getBetInc()) {
                player.modWallet(mSettings.getBetInc());   //mod wallet value
                player.modBetForHand(-mSettings.getBetInc(), player.getCurrentBet()); // mod the bet of current hand
                playerWallet.setText(player.getWallet() + "");
                playerBet.setText("$"+ player.getBetForHand() + "");
                player.setBetForHand(player.getCurrentBet());
            }else {
                Toast.makeText(MainActivity.this,"There is no more money to take from hand", Toast.LENGTH_SHORT).show();
            }
        }
        //More
        else if (v.getTag() == moreTag){
            addOneBetUnit();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

           //TODO add that you cant add cards to hand 4 if you have add to hand 2


            if (doneWithBets && (v.getTag() == handOneTag || v.getTag() == handTwoTag || v.getTag() == handThreeTag ||
                    v.getTag() == handFourTag || v.getTag() == handFiveTag)) { //handOneView
                if (player.getHandSum((int)v.getTag() - 11) >= 21){
                    return false;
                }
                hitThisHand(((int)v.getTag() - 11));
            }

            else if (v.getTag() == handOneBetTag || v.getTag() == handTwoBetTag ||
                    v.getTag() == handThreeBetTag || v.getTag() == handFourBetTag || v.getTag() ==  handFiveBetTag){
                playerHand.setText(v.getTag().toString());
                int i = (Integer) v.getTag() - 1;
                player.setCurrentHand(i);
                player.setBetForHand(i);
                player.setCurrentBet(i);
                playerBet.setText("$" + player.getBetForHand() + "");
                Log.e("Current Hand", player.getCurrentHand() + "");
            }
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }



    //// TODO: 4/3/16 get the menu & settings ready
    public void hitThisHand(int index) {
        playerHand.setText(index + 1 + ""); //Set UI witch hand
        player.addCardToAHand(shoe.getTopDeckCard(), index);
        ArrayOfHands.get(index).setBackgroundResource(shoe.getTopDeckCard().getFace());
        shoe.sendTopDeckCardToGrave();
        ArrayOfValues.get(index).setText(player.getHandSum(index) + ""); //Set UI hand value
        player.setCurrentBet(index);
        playerBet.setText("$" + player.getBetForHand() + ""); //Set UI bet for hand
    }

    //TODO house self deal
    public void HouseSelfDeal(){
        //flipcard

        houseValue.setText(house.getHandSum() + "");

        if(house.getHandSum() < mSettings.getHouseBetStop()){
            //hithouse
        }

        exchangeCash();

    }

    public void exchangeCash(){

        //Compare values of hands to house
        //do transactions
        clearTable();
    }

    public void clearTable(){
        //set everything to 0
        //and let player set bets
        placeMinBets();
    }

    public void placeMinBets() {
        for(int i =0 ; i < mSettings.getNumberOfHands(); i++){

            player.setCurrentBet(i);

            addOneBetUnit();


        }
    }

    public void addOneBetUnit(){

        if (player.getWallet() - mSettings.getBetInc() > 0){
            player.modWallet(-mSettings.getBetInc());
            player.modBetForHand(mSettings.getBetInc(), player.getCurrentBet());
            playerWallet.setText(player.getWallet() + "");
            playerBet.setText("$"+ player.getBetForHand() + "");
            player.setBetForHand(player.getCurrentBet());
        } else{
            Toast.makeText(MainActivity.this,"You don't have enough money",Toast.LENGTH_LONG);
        }

    }


    //MENU CODE
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.new_game) {
            Toast.makeText(MainActivity.this,"Going to settings",Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        else if (id == R.id.see_score){

            Toast.makeText(MainActivity.this,"Going to Scores",Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.set_house){

            Toast.makeText(MainActivity.this,"Player",Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.set_house){
            Toast.makeText(MainActivity.this,"House",Toast.LENGTH_SHORT).show();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
