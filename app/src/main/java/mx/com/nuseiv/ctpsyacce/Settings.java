package mx.com.nuseiv.ctpsyacce;

/**
 * Created by tuxedo21 on 2/27/16.
 */
public class Settings {
    //All things you can set
    private  int numberOfHands;
    private  int betInc;
    private  int playerWallet;
    private  int houseBetStop; //[15,18]


    public Settings(int numberOfHands, int betInc, int playerWallet, int houseBetStop) {
        this.numberOfHands = numberOfHands;
        this.betInc = betInc;
        this.playerWallet = playerWallet;
        this.houseBetStop = houseBetStop;
    }

    public int getNumberOfHands() {
        return numberOfHands;
    }

    public void setNumberOfHands(int numberOfHands) {
        this.numberOfHands = numberOfHands;
    }

    public int getBetInc() {
        return betInc;
    }

    public void setBetInc(int betInc) {
        this.betInc = betInc;
    }

    public int getPlayerWallet() {
        return playerWallet;
    }

    public void setPlayerWallet(int playerWallet) {
        this.playerWallet = playerWallet;
    }

    public int getHouseBetStop() {
        return houseBetStop;
    }

    public void setHouseBetStop(int houseBetStop) {
        this.houseBetStop = houseBetStop;
    }
}
