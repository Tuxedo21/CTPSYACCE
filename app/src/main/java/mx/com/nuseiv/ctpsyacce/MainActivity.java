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


// if hand is busted subtract 1
// if hand is less than house, subtract 1
// if hand is more than house, add 1
// if hand is bj and house is not, add 1.5


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

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

    // Must get these values from settings module
    private int betModValue = 10;
    private int walletValue = 2500;

      //SETUP CODE
    @Override
    protected void onCreate(Bundle savedInstanceState)  {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        house = new House();
        player = new Player(walletValue);
        setupImageViews(); //Card Views
        setupTextViews(); //Card sum Views
        setupButtons();
        setupPlayerStats();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        shoe = new Shoe();
        Log.v("Deck", shoe.toString());


    }

    //I belive this is done
    public void setupPlayerStats(){
        playerWallet = (TextView)findViewById(R.id.player_wallet);
        playerWallet.setText(player.getWallet() + "");
        playerBet = (TextView)findViewById(R.id.player_bet);
        playerHand = (TextView)findViewById(R.id.what_hand);
    }

    //This sould take in as many hands as the player states
    public void setupTextViews(){
        valueOne = (TextView)findViewById(R.id.valueOne);
        valueTwo = (TextView)findViewById(R.id.valueTwo);
        valueThree = (TextView)findViewById(R.id.valueThree);
        valueFour = (TextView)findViewById(R.id.valueFour);
        valueFive = (TextView)findViewById(R.id.valueFive);
        houseValue = (TextView)findViewById(R.id.houseValue);

        valueOne.setTag(handOneBetTag);
        valueTwo.setTag(handTwoBetTag);
        valueThree.setTag(handThreeBetTag);
        valueFour.setTag(handFourBetTag);
        valueFive.setTag(handFiveBetTag);

        valueOne.setOnTouchListener(this);
        valueTwo.setOnTouchListener(this);
        valueThree.setOnTouchListener(this);
        valueFour.setOnTouchListener(this);
        valueFive.setOnTouchListener(this);

        ArrayOfValues.add(valueOne);
        ArrayOfValues.add(valueTwo);
        ArrayOfValues.add(valueThree);
        ArrayOfValues.add(valueFour);
        ArrayOfValues.add(valueFive);
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
        handOne = (ImageView)findViewById(R.id.handOne);
        handOne.setTag(handOneTag);
        handTwo = (ImageView)findViewById(R.id.handTwo);
        handTwo.setTag(handTwoTag);
        handThree = (ImageView)findViewById(R.id.handThree);
        handThree.setTag(handThreeTag);
        handFour = (ImageView)findViewById(R.id.handFour);
        handFour.setTag(handFourTag);
        handFive = (ImageView)findViewById(R.id.handFive);
        handFive.setTag(handFiveTag);
        handOne.setImageResource(0);
        handTwo.setImageResource(0);
        handThree.setImageResource(0);
        handFour.setImageResource(0);
        handFive.setImageResource(0);

        handHouseOne = (ImageView)findViewById(R.id.house_left);
        handHouseTwo = (ImageView)findViewById(R.id.house_right);
        handHouseOne.setImageResource(0);
        handHouseTwo.setImageResource(0);

        //On Touch
        handOne.setOnTouchListener(this);
        handTwo.setOnTouchListener(this);
        handThree.setOnTouchListener(this);
        handFour.setOnTouchListener(this);
        handFive.setOnTouchListener(this);

        ArrayOfHands.add(handOne);
        ArrayOfHands.add(handTwo);
        ArrayOfHands.add(handThree);
        ArrayOfHands.add(handFour);
        ArrayOfHands.add(handFive);

        HouseHand.add(handHouseOne);
       // HouseHand.add(handHouseTwo);
    }
            //UI CODE
    @Override
    public void onClick(View v) {

        if (v.getTag() == dealTag){ //DEAL
            player.setAllHandsToEmpty(true);
            house.setHandToEmpty(0);
            Log.e("Dealing Cards", shoe.toString() + "");
            Toast.makeText(MainActivity.this,"Dealing",Toast.LENGTH_SHORT).show();

            for (int i = 0; i < ArrayOfHands.size(); i++) {
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
                house.addCardToAHand(shoe.getTopDeckCard(),i);
                Log.e("House Hand " + i + " Card x", shoe.getTopDeckCard() + "");
                shoe.sendTopDeckCardToGrave();
                house.addCardToAHand(shoe.getTopDeckCard(), i);
                HouseHand.get(i).setBackgroundResource(shoe.getTopDeckCard().getFace());
                Log.e("House Hand " + i + " Card x", shoe.getTopDeckCard() + "");
                shoe.sendTopDeckCardToGrave();
                houseValue.setText(house.getHandSum(i) + "");
               // Log.e("Full House Hand" + house.getHandValues());
            }

        }

        else if (v.getTag() == lessTag) {  //Less

            if (player.getBetForHand() >= betModValue) {
                player.modWallet(betModValue);   //mod hand
                player.modBetForHand(-betModValue, player.getCurrentBet());
                playerWallet.setText(player.getWallet() + "");
                playerWallet.setText(player.getWallet() + "");
                playerBet.setText("$"+ player.getBetForHand() + "");
                player.setBetForHand(player.getCurrentBet());
            }else {
                Toast.makeText(MainActivity.this,"No more money to take from hand", Toast.LENGTH_SHORT).show();
            }
        }

        else if (v.getTag() == moreTag){ //More
            if (player.getWallet() - betModValue > 0){
                player.modWallet(-betModValue);
                player.modBetForHand(betModValue, player.getCurrentBet());
                playerWallet.setText(player.getWallet() + "");
                playerBet.setText("$"+ player.getBetForHand() + "");
                player.setBetForHand(player.getCurrentBet());
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

           //TODO it looks like this can have some abstraction
            if (v.getTag() == handOneTag) { //handOneView
                if (player.getHandSum(0) >= 21){
                    return false;
                }
                playerHand.setText("1");
                player.addCardToAHand(shoe.getTopDeckCard(), 0);
                handOne.setBackgroundResource(shoe.getTopDeckCard().getFace());
                shoe.sendTopDeckCardToGrave();
                valueOne.setText(player.getHandSum(0).toString());

            }
            else if (v.getTag() == handTwoTag){
                if (player.getHandSum(1) >= 21){
                    return false;
                }
                playerHand.setText("2");
                player.addCardToAHand(shoe.getTopDeckCard(), 1);
                handTwo.setBackgroundResource(shoe.getTopDeckCard().getFace());
                shoe.sendTopDeckCardToGrave();
                valueTwo.setText(player.getHandSum(1) + "");
            }
            else if (v.getTag() == handThreeTag){
                if (player.getHandSum(2) >= 21){
                    return false;
                }
                playerHand.setText("3");
                player.addCardToAHand(shoe.getTopDeckCard(), 2);
                handThree.setBackgroundResource(shoe.getTopDeckCard().getFace());
                shoe.sendTopDeckCardToGrave();
                valueThree.setText(player.getHandSum(2) + "");
            }
            else if (v.getTag() == handFourTag){
                if (player.getHandSum(3) >= 21){
                    return false;
                }
                hitThisHand(3);
            }
            else if (v.getTag() == handFiveTag){
                if (player.getHandSum(4) >= 21){
                    return false;
                }
                hitThisHand(4);
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
            }return false;
    }

    //// TODO: 4/3/16 get the menu & settings ready
    public void hitThisHand(int index) {
        playerHand.setText(index + 1 + ""); //Set UI witch hand
        player.addCardToAHand(shoe.getTopDeckCard(), index);
        ArrayOfHands.get(index).setBackgroundResource(shoe.getTopDeckCard().getFace());
        shoe.sendTopDeckCardToGrave();
        ArrayOfValues.get(index).setText(player.getHandSum(index) + ""); //Set UI hand value
        player.setCurrentBet(index);

        playerBet.setText("$"+ player.getBetForHand() + ""); //Set UI bet for hand
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
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this,"Going to settings",Toast.LENGTH_SHORT).show();
            //Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            //  startActivity(settingsIntent);
            return true;
        }

        else if (id == R.id.see_score){

            Toast.makeText(MainActivity.this,"Going to Scores",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
