package mx.com.nuseiv.ctpsyacce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by tuxedo21 on 2/26/16.
 */
public class Shoe {

    List<Card> Deck = new ArrayList<Card>();
    List<Card> Graveyard = new ArrayList<Card>();

    //Declare the whole stack of cards
    public Shoe() {
        //Clubs
        Card ace1clubs = new Card(new int[] {1,11} , R.drawable.ace_of_clubs);
        Card ace2clubs = new Card(new int[] {1,11} , R.drawable.ace_of_clubs);
        Card ace3clubs = new Card(new int[] {1,11} , R.drawable.ace_of_clubs);
        Card ace4clubs = new Card(new int[] {1,11} , R.drawable.ace_of_clubs);

        Card king1clubs = new Card(new int[] {10} , R.drawable.king_of_clubs2);
        Card king2clubs = new Card(new int[] {10} , R.drawable.king_of_clubs2);
        Card king3clubs = new Card(new int[] {10} , R.drawable.king_of_clubs2);
        Card king4clubs = new Card(new int[] {10} , R.drawable.king_of_clubs2);

        Card queen1clubs = new Card(new int[] {10} , R.drawable.queen_of_clubs2);
        Card queen2clubs = new Card(new int[] {10} , R.drawable.queen_of_clubs2);
        Card queen3clubs = new Card(new int[] {10} , R.drawable.queen_of_clubs2);
        Card queen4clubs = new Card(new int[] {10} , R.drawable.queen_of_clubs2);

        Card jack1clubs = new Card(new int[] {10} , R.drawable.jack_of_clubs2);
        Card jack2clubs = new Card(new int[] {10} , R.drawable.jack_of_clubs2);
        Card jack3clubs = new Card(new int[] {10} , R.drawable.jack_of_clubs2);
        Card jack4clubs = new Card(new int[] {10} , R.drawable.jack_of_clubs2);

        Card ten1clubs = new Card(new int[] {10} , R.drawable.c10_of_clubs);
        Card ten2clubs = new Card(new int[] {10} , R.drawable.c10_of_clubs);
        Card ten3clubs = new Card(new int[] {10} , R.drawable.c10_of_clubs);
        Card ten4clubs = new Card(new int[] {10} , R.drawable.c10_of_clubs);

        Card nine1clubs = new Card(new int[] {9}, R.drawable.c9_of_clubs);
        Card nine2clubs = new Card(new int[] {9}, R.drawable.c9_of_clubs);
        Card nine3clubs = new Card(new int[] {9}, R.drawable.c9_of_clubs);
        Card nine4clubs = new Card(new int[] {9}, R.drawable.c9_of_clubs);

        Card eight1clubs = new Card(new int[] {8}, R.drawable.c8_of_clubs);
        Card eight2clubs = new Card(new int[] {8}, R.drawable.c8_of_clubs);
        Card eight3clubs = new Card(new int[] {8}, R.drawable.c8_of_clubs);
        Card eight4clubs = new Card(new int[] {8}, R.drawable.c8_of_clubs);

        Card seven1clubs = new Card(new int[] {7}, R.drawable.c7_of_clubs);
        Card seven2clubs = new Card(new int[] {7}, R.drawable.c7_of_clubs);
        Card seven3clubs = new Card(new int[] {7}, R.drawable.c7_of_clubs);
        Card seven4clubs = new Card(new int[] {7}, R.drawable.c7_of_clubs);

        Card six1clubs = new Card(new int[] {6}, R.drawable.c6_of_clubs);
        Card six2clubs = new Card(new int[] {6}, R.drawable.c6_of_clubs);
        Card six3clubs = new Card(new int[] {6}, R.drawable.c6_of_clubs);
        Card six4clubs = new Card(new int[] {6}, R.drawable.c6_of_clubs);

        Card five1clubs = new Card(new int[] {5}, R.drawable.c5_of_clubs);
        Card five2clubs = new Card(new int[] {5}, R.drawable.c5_of_clubs);
        Card five3clubs = new Card(new int[] {5}, R.drawable.c5_of_clubs);
        Card five4clubs = new Card(new int[] {5}, R.drawable.c5_of_clubs);

        Card four1clubs = new Card(new int[] {4}, R.drawable.c4_of_clubs);
        Card four2clubs = new Card(new int[] {4}, R.drawable.c4_of_clubs);
        Card four3clubs = new Card(new int[] {4}, R.drawable.c4_of_clubs);
        Card four4clubs = new Card(new int[] {4}, R.drawable.c4_of_clubs);

        Card three1clubs = new Card(new int[] {3}, R.drawable.c3_of_clubs);
        Card three2clubs = new Card(new int[] {3}, R.drawable.c3_of_clubs);
        Card three3clubs = new Card(new int[] {3}, R.drawable.c3_of_clubs);
        Card three4clubs = new Card(new int[] {3}, R.drawable.c3_of_clubs);

        Card two1clubs = new Card(new int[] {2}, R.drawable.c2_of_clubs);
        Card two2clubs = new Card(new int[] {2}, R.drawable.c2_of_clubs);
        Card two3clubs = new Card(new int[] {2}, R.drawable.c2_of_clubs);
        Card two4clubs = new Card(new int[] {2}, R.drawable.c2_of_clubs);

        //Dimonds
        Card ace1diamonds = new Card(new int[] {1,11} , R.drawable.ace_of_diamonds);
        Card ace2diamonds = new Card(new int[] {1,11} , R.drawable.ace_of_diamonds);
        Card ace3diamonds = new Card(new int[] {1,11} , R.drawable.ace_of_diamonds);
        Card ace4diamonds = new Card(new int[] {1,11} , R.drawable.ace_of_diamonds);

        Card king1diamonds = new Card(new int[] {10} , R.drawable.king_of_diamonds2);
        Card king2diamonds = new Card(new int[] {10} , R.drawable.king_of_diamonds2);
        Card king3diamonds = new Card(new int[] {10} , R.drawable.king_of_diamonds2);
        Card king4diamonds = new Card(new int[] {10} , R.drawable.king_of_diamonds2);

        Card queen1diamonds = new Card(new int[] {10} , R.drawable.queen_of_diamonds2);
        Card queen2diamonds = new Card(new int[] {10} , R.drawable.queen_of_diamonds2);
        Card queen3diamonds = new Card(new int[] {10} , R.drawable.queen_of_diamonds2);
        Card queen4diamonds = new Card(new int[] {10} , R.drawable.queen_of_diamonds2);

        Card jack1diamonds = new Card(new int[] {10} , R.drawable.jack_of_diamonds2);
        Card jack2diamonds = new Card(new int[] {10} , R.drawable.jack_of_diamonds2);
        Card jack3diamonds = new Card(new int[] {10} , R.drawable.jack_of_diamonds2);
        Card jack4diamonds = new Card(new int[] {10} , R.drawable.jack_of_diamonds2);

        Card ten1diamonds = new Card(new int[] {10} , R.drawable.c10_of_diamonds);
        Card ten2diamonds = new Card(new int[] {10} , R.drawable.c10_of_diamonds);
        Card ten3diamonds = new Card(new int[] {10} , R.drawable.c10_of_diamonds);
        Card ten4diamonds = new Card(new int[] {10} , R.drawable.c10_of_diamonds);

        Card nine1diamonds = new Card(new int[] {9}, R.drawable.c9_of_diamonds);
        Card nine2diamonds = new Card(new int[] {9}, R.drawable.c9_of_diamonds);
        Card nine3diamonds = new Card(new int[] {9}, R.drawable.c9_of_diamonds);
        Card nine4diamonds = new Card(new int[] {9}, R.drawable.c9_of_diamonds);

        Card eight1diamonds = new Card(new int[] {8}, R.drawable.c8_of_diamonds);
        Card eight2diamonds = new Card(new int[] {8}, R.drawable.c8_of_diamonds);
        Card eight3diamonds = new Card(new int[] {8}, R.drawable.c8_of_diamonds);
        Card eight4diamonds = new Card(new int[] {8}, R.drawable.c8_of_diamonds);

        Card seven1diamonds = new Card(new int[] {7}, R.drawable.c7_of_diamonds);
        Card seven2diamonds = new Card(new int[] {7}, R.drawable.c7_of_diamonds);
        Card seven3diamonds = new Card(new int[] {7}, R.drawable.c7_of_diamonds);
        Card seven4diamonds = new Card(new int[] {7}, R.drawable.c7_of_diamonds);

        Card six1diamonds = new Card(new int[] {6}, R.drawable.c6_of_diamonds);
        Card six2diamonds = new Card(new int[] {6}, R.drawable.c6_of_diamonds);
        Card six3diamonds = new Card(new int[] {6}, R.drawable.c6_of_diamonds);
        Card six4diamonds = new Card(new int[] {6}, R.drawable.c6_of_diamonds);

        Card five1diamonds = new Card(new int[] {5}, R.drawable.c5_of_diamonds);
        Card five2diamonds = new Card(new int[] {5}, R.drawable.c5_of_diamonds);
        Card five3diamonds = new Card(new int[] {5}, R.drawable.c5_of_diamonds);
        Card five4diamonds = new Card(new int[] {5}, R.drawable.c5_of_diamonds);

        Card four1diamonds = new Card(new int[] {4}, R.drawable.c4_of_diamonds);
        Card four2diamonds = new Card(new int[] {4}, R.drawable.c4_of_diamonds);
        Card four3diamonds = new Card(new int[] {4}, R.drawable.c4_of_diamonds);
        Card four4diamonds = new Card(new int[] {4}, R.drawable.c4_of_diamonds);

        Card three1diamonds = new Card(new int[] {3}, R.drawable.c3_of_diamonds);
        Card three2diamonds = new Card(new int[] {3}, R.drawable.c3_of_diamonds);
        Card three3diamonds = new Card(new int[] {3}, R.drawable.c3_of_diamonds);
        Card three4diamonds = new Card(new int[] {3}, R.drawable.c3_of_diamonds);

        Card two1diamonds = new Card(new int[] {2}, R.drawable.c2_of_diamonds);
        Card two2diamonds = new Card(new int[] {2}, R.drawable.c2_of_diamonds);
        Card two3diamonds = new Card(new int[] {2}, R.drawable.c2_of_diamonds);
        Card two4diamonds = new Card(new int[] {2}, R.drawable.c2_of_diamonds);

        //Spades
        Card ace1spades = new Card(new int[] {1,11} , R.drawable.ace_of_spades);
        Card ace2spades = new Card(new int[] {1,11} , R.drawable.ace_of_spades);
        Card ace3spades = new Card(new int[] {1,11} , R.drawable.ace_of_spades);
        Card ace4spades = new Card(new int[] {1,11} , R.drawable.ace_of_spades);

        Card king1spades = new Card(new int[] {10} , R.drawable.king_of_spades2);
        Card king2spades = new Card(new int[] {10} , R.drawable.king_of_spades2);
        Card king3spades = new Card(new int[] {10} , R.drawable.king_of_spades2);
        Card king4spades = new Card(new int[] {10} , R.drawable.king_of_spades2);

        Card queen1spades = new Card(new int[] {10} , R.drawable.queen_of_spades2);
        Card queen2spades = new Card(new int[] {10} , R.drawable.queen_of_spades2);
        Card queen3spades = new Card(new int[] {10} , R.drawable.queen_of_spades2);
        Card queen4spades = new Card(new int[] {10} , R.drawable.queen_of_spades2);

        Card jack1spades = new Card(new int[] {10} , R.drawable.jack_of_spades2);
        Card jack2spades = new Card(new int[] {10} , R.drawable.jack_of_spades2);
        Card jack3spades = new Card(new int[] {10} , R.drawable.jack_of_spades2);
        Card jack4spades = new Card(new int[] {10} , R.drawable.jack_of_spades2);

        Card ten1spades = new Card(new int[] {10} , R.drawable.c10_of_spades);
        Card ten2spades = new Card(new int[] {10} , R.drawable.c10_of_spades);
        Card ten3spades = new Card(new int[] {10} , R.drawable.c10_of_spades);
        Card ten4spades = new Card(new int[] {10} , R.drawable.c10_of_spades);

        Card nine1spades = new Card(new int[] {9}, R.drawable.c9_of_spades);
        Card nine2spades = new Card(new int[] {9}, R.drawable.c9_of_spades);
        Card nine3spades = new Card(new int[] {9}, R.drawable.c9_of_spades);
        Card nine4spades = new Card(new int[] {9}, R.drawable.c9_of_spades);

        Card eight1spades = new Card(new int[] {8}, R.drawable.c8_of_spades);
        Card eight2spades = new Card(new int[] {8}, R.drawable.c8_of_spades);
        Card eight3spades = new Card(new int[] {8}, R.drawable.c8_of_spades);
        Card eight4spades = new Card(new int[] {8}, R.drawable.c8_of_spades);

        Card seven1spades = new Card(new int[] {7}, R.drawable.c7_of_spades);
        Card seven2spades = new Card(new int[] {7}, R.drawable.c7_of_spades);
        Card seven3spades = new Card(new int[] {7}, R.drawable.c7_of_spades);
        Card seven4spades = new Card(new int[] {7}, R.drawable.c7_of_spades);

        Card six1spades = new Card(new int[] {6}, R.drawable.c6_of_spades);
        Card six2spades = new Card(new int[] {6}, R.drawable.c6_of_spades);
        Card six3spades = new Card(new int[] {6}, R.drawable.c6_of_spades);
        Card six4spades = new Card(new int[] {6}, R.drawable.c6_of_spades);

        Card five1spades = new Card(new int[] {5}, R.drawable.c5_of_spades);
        Card five2spades = new Card(new int[] {5}, R.drawable.c5_of_spades);
        Card five3spades = new Card(new int[] {5}, R.drawable.c5_of_spades);
        Card five4spades = new Card(new int[] {5}, R.drawable.c5_of_spades);

        Card four1spades = new Card(new int[] {4}, R.drawable.c4_of_spades);
        Card four2spades = new Card(new int[] {4}, R.drawable.c4_of_spades);
        Card four3spades = new Card(new int[] {4}, R.drawable.c4_of_spades);
        Card four4spades = new Card(new int[] {4}, R.drawable.c4_of_spades);

        Card three1spades = new Card(new int[] {3}, R.drawable.c3_of_spades);
        Card three2spades = new Card(new int[] {3}, R.drawable.c3_of_spades);
        Card three3spades = new Card(new int[] {3}, R.drawable.c3_of_spades);
        Card three4spades = new Card(new int[] {3}, R.drawable.c3_of_spades);

        Card two1spades = new Card(new int[] {2}, R.drawable.c2_of_spades);
        Card two2spades = new Card(new int[] {2}, R.drawable.c2_of_spades);
        Card two3spades = new Card(new int[] {2}, R.drawable.c2_of_spades);
        Card two4spades = new Card(new int[] {2}, R.drawable.c2_of_spades);

        //Hearts
        Card ace1hearts = new Card(new int[] {1,11} , R.drawable.ace_of_hearts);
        Card ace2hearts = new Card(new int[] {1,11} , R.drawable.ace_of_hearts);
        Card ace3hearts = new Card(new int[] {1,11} , R.drawable.ace_of_hearts);
        Card ace4hearts = new Card(new int[] {1,11} , R.drawable.ace_of_hearts);

        Card king1hearts = new Card(new int[] {10} , R.drawable.king_of_hearts2);
        Card king2hearts = new Card(new int[] {10} , R.drawable.king_of_hearts2);
        Card king3hearts = new Card(new int[] {10} , R.drawable.king_of_hearts2);
        Card king4hearts = new Card(new int[] {10} , R.drawable.king_of_hearts2);

        Card queen1hearts = new Card(new int[] {10} , R.drawable.queen_of_hearts2);
        Card queen2hearts = new Card(new int[] {10} , R.drawable.queen_of_hearts2);
        Card queen3hearts = new Card(new int[] {10} , R.drawable.queen_of_hearts2);
        Card queen4hearts = new Card(new int[] {10} , R.drawable.queen_of_hearts2);

        Card jack1hearts = new Card(new int[] {10} , R.drawable.jack_of_hearts2);
        Card jack2hearts = new Card(new int[] {10} , R.drawable.jack_of_hearts2);
        Card jack3hearts = new Card(new int[] {10} , R.drawable.jack_of_hearts2);
        Card jack4hearts = new Card(new int[] {10} , R.drawable.jack_of_hearts2);

        Card ten1hearts = new Card(new int[] {10} , R.drawable.c10_of_hearts);
        Card ten2hearts = new Card(new int[] {10} , R.drawable.c10_of_hearts);
        Card ten3hearts = new Card(new int[] {10} , R.drawable.c10_of_hearts);
        Card ten4hearts = new Card(new int[] {10} , R.drawable.c10_of_hearts);

        Card nine1hearts = new Card(new int[] {9}, R.drawable.c9_of_hearts);
        Card nine2hearts = new Card(new int[] {9}, R.drawable.c9_of_hearts);
        Card nine3hearts = new Card(new int[] {9}, R.drawable.c9_of_hearts);
        Card nine4hearts = new Card(new int[] {9}, R.drawable.c9_of_hearts);

        Card eight1hearts = new Card(new int[] {8}, R.drawable.c8_of_hearts);
        Card eight2hearts = new Card(new int[] {8}, R.drawable.c8_of_hearts);
        Card eight3hearts = new Card(new int[] {8}, R.drawable.c8_of_hearts);
        Card eight4hearts = new Card(new int[] {8}, R.drawable.c8_of_hearts);

        Card seven1hearts = new Card(new int[] {7}, R.drawable.c7_of_hearts);
        Card seven2hearts = new Card(new int[] {7}, R.drawable.c7_of_hearts);
        Card seven3hearts = new Card(new int[] {7}, R.drawable.c7_of_hearts);
        Card seven4hearts = new Card(new int[] {7}, R.drawable.c7_of_hearts);

        Card six1hearts = new Card(new int[] {6}, R.drawable.c6_of_hearts);
        Card six2hearts = new Card(new int[] {6}, R.drawable.c6_of_hearts);
        Card six3hearts = new Card(new int[] {6}, R.drawable.c6_of_hearts);
        Card six4hearts = new Card(new int[] {6}, R.drawable.c6_of_hearts);

        Card five1hearts = new Card(new int[] {5}, R.drawable.c5_of_hearts);
        Card five2hearts = new Card(new int[] {5}, R.drawable.c5_of_hearts);
        Card five3hearts = new Card(new int[] {5}, R.drawable.c5_of_hearts);
        Card five4hearts = new Card(new int[] {5}, R.drawable.c5_of_hearts);

        Card four1hearts = new Card(new int[] {4}, R.drawable.c4_of_hearts);
        Card four2hearts = new Card(new int[] {4}, R.drawable.c4_of_hearts);
        Card four3hearts = new Card(new int[] {4}, R.drawable.c4_of_hearts);
        Card four4hearts = new Card(new int[] {4}, R.drawable.c4_of_hearts);

        Card three1hearts = new Card(new int[] {3}, R.drawable.c3_of_hearts);
        Card three2hearts = new Card(new int[] {3}, R.drawable.c3_of_hearts);
        Card three3hearts = new Card(new int[] {3}, R.drawable.c3_of_hearts);
        Card three4hearts = new Card(new int[] {3}, R.drawable.c3_of_hearts);

        Card two1hearts = new Card(new int[] {2}, R.drawable.c2_of_hearts);
        Card two2hearts = new Card(new int[] {2}, R.drawable.c2_of_hearts);
        Card two3hearts = new Card(new int[] {2}, R.drawable.c2_of_hearts);
        Card two4hearts = new Card(new int[] {2}, R.drawable.c2_of_hearts);

        Deck.add(ace1clubs);
        Deck.add(ace2clubs);
        Deck.add(ace3clubs);
        Deck.add(ace4clubs);

        Deck.add(king1clubs);
        Deck.add(king2clubs);
        Deck.add(king3clubs);
        Deck.add(king4clubs);

        Deck.add(queen1clubs);
        Deck.add(queen2clubs);
        Deck.add(queen3clubs);
        Deck.add(queen4clubs);

        Deck.add(jack1clubs);
        Deck.add(jack2clubs);
        Deck.add(jack3clubs);
        Deck.add(jack4clubs);

        Deck.add(ten1clubs);
        Deck.add(ten2clubs);
        Deck.add(ten3clubs);
        Deck.add(ten4clubs);

        Deck.add(nine1clubs);
        Deck.add(nine2clubs);
        Deck.add(nine3clubs);
        Deck.add(nine4clubs);

        Deck.add(eight1clubs);
        Deck.add(eight2clubs);
        Deck.add(eight3clubs);
        Deck.add(eight4clubs);

        Deck.add(seven1clubs);
        Deck.add(seven2clubs);
        Deck.add(seven3clubs);
        Deck.add(seven4clubs);

        Deck.add(six1clubs);
        Deck.add(six2clubs);
        Deck.add(six3clubs);
        Deck.add(six4clubs);

        Deck.add(five1clubs);
        Deck.add(five2clubs);
        Deck.add(five3clubs);
        Deck.add(five4clubs);

        Deck.add(four1clubs);
        Deck.add(four2clubs);
        Deck.add(four3clubs);
        Deck.add(four4clubs);

        Deck.add(three1clubs);
        Deck.add(three2clubs);
        Deck.add(three3clubs);
        Deck.add(three4clubs);

        Deck.add(two1clubs);
        Deck.add(two2clubs);
        Deck.add(two3clubs);
        Deck.add(two4clubs);

        Deck.add(ace1spades);
        Deck.add(ace2spades);
        Deck.add(ace3spades);
        Deck.add(ace4spades);

        Deck.add(king1spades);
        Deck.add(king2spades);
        Deck.add(king3spades);
        Deck.add(king4spades);

        Deck.add(queen1spades);
        Deck.add(queen2spades);
        Deck.add(queen3spades);
        Deck.add(queen4spades);

        Deck.add(jack1spades);
        Deck.add(jack2spades);
        Deck.add(jack3spades);
        Deck.add(jack4spades);

        Deck.add(ten1spades);
        Deck.add(ten2spades);
        Deck.add(ten3spades);
        Deck.add(ten4spades);

        Deck.add(nine1spades);
        Deck.add(nine2spades);
        Deck.add(nine3spades);
        Deck.add(nine4spades);

        Deck.add(eight1spades);
        Deck.add(eight2spades);
        Deck.add(eight3spades);
        Deck.add(eight4spades);

        Deck.add(seven1spades);
        Deck.add(seven2spades);
        Deck.add(seven3spades);
        Deck.add(seven4spades);

        Deck.add(six1spades);
        Deck.add(six2spades);
        Deck.add(six3spades);
        Deck.add(six4spades);

        Deck.add(five1spades);
        Deck.add(five2spades);
        Deck.add(five3spades);
        Deck.add(five4spades);

        Deck.add(four1spades);
        Deck.add(four2spades);
        Deck.add(four3spades);
        Deck.add(four4spades);

        Deck.add(three1spades);
        Deck.add(three2spades);
        Deck.add(three3spades);
        Deck.add(three4spades);

        Deck.add(two1spades);
        Deck.add(two2spades);
        Deck.add(two3spades);
        Deck.add(two4spades);

        Deck.add(ace1hearts);
        Deck.add(ace2hearts);
        Deck.add(ace3hearts);
        Deck.add(ace4hearts);

        Deck.add(king1hearts);
        Deck.add(king2hearts);
        Deck.add(king3hearts);
        Deck.add(king4hearts);

        Deck.add(queen1hearts);
        Deck.add(queen2hearts);
        Deck.add(queen3hearts);
        Deck.add(queen4hearts);

        Deck.add(jack1hearts);
        Deck.add(jack2hearts);
        Deck.add(jack3hearts);
        Deck.add(jack4hearts);

        Deck.add(ten1hearts);
        Deck.add(ten2hearts);
        Deck.add(ten3hearts);
        Deck.add(ten4hearts);

        Deck.add(nine1hearts);
        Deck.add(nine2hearts);
        Deck.add(nine3hearts);
        Deck.add(nine4hearts);

        Deck.add(eight1hearts);
        Deck.add(eight2hearts);
        Deck.add(eight3hearts);
        Deck.add(eight4hearts);

        Deck.add(seven1hearts);
        Deck.add(seven2hearts);
        Deck.add(seven3hearts);
        Deck.add(seven4hearts);

        Deck.add(six1hearts);
        Deck.add(six2hearts);
        Deck.add(six3hearts);
        Deck.add(six4hearts);

        Deck.add(five1hearts);
        Deck.add(five2hearts);
        Deck.add(five3hearts);
        Deck.add(five4hearts);

        Deck.add(four1hearts);
        Deck.add(four2hearts);
        Deck.add(four3hearts);
        Deck.add(four4hearts);

        Deck.add(three1hearts);
        Deck.add(three2hearts);
        Deck.add(three3hearts);
        Deck.add(three4hearts);

        Deck.add(two1hearts);
        Deck.add(two2hearts);
        Deck.add(two3hearts);
        Deck.add(two4hearts);

        Deck.add(ace1diamonds);
        Deck.add(ace2diamonds);
        Deck.add(ace3diamonds);
        Deck.add(ace4diamonds);

        Deck.add(king1diamonds);
        Deck.add(king2diamonds);
        Deck.add(king3diamonds);
        Deck.add(king4diamonds);

        Deck.add(queen1diamonds);
        Deck.add(queen2diamonds);
        Deck.add(queen3diamonds);
        Deck.add(queen4diamonds);

        Deck.add(jack1diamonds);
        Deck.add(jack2diamonds);
        Deck.add(jack3diamonds);
        Deck.add(jack4diamonds);

        Deck.add(ten1diamonds);
        Deck.add(ten2diamonds);
        Deck.add(ten3diamonds);
        Deck.add(ten4diamonds);

        Deck.add(nine1diamonds);
        Deck.add(nine2diamonds);
        Deck.add(nine3diamonds);
        Deck.add(nine4diamonds);

        Deck.add(eight1diamonds);
        Deck.add(eight2diamonds);
        Deck.add(eight3diamonds);
        Deck.add(eight4diamonds);

        Deck.add(seven1diamonds);
        Deck.add(seven2diamonds);
        Deck.add(seven3diamonds);
        Deck.add(seven4diamonds);

        Deck.add(six1diamonds);
        Deck.add(six2diamonds);
        Deck.add(six3diamonds);
        Deck.add(six4diamonds);

        Deck.add(five1diamonds);
        Deck.add(five2diamonds);
        Deck.add(five3diamonds);
        Deck.add(five4diamonds);

        Deck.add(four1diamonds);
        Deck.add(four2diamonds);
        Deck.add(four3diamonds);
        Deck.add(four4diamonds);

        Deck.add(three1diamonds);
        Deck.add(three2diamonds);
        Deck.add(three3diamonds);
        Deck.add(three4diamonds);

        Deck.add(two1diamonds);
        Deck.add(two2diamonds);
        Deck.add(two3diamonds);
        Deck.add(two4diamonds);

        shuffleDeck(Deck);

    }

    //TODO understand this shuffle code
    private void shuffleDeck(List<Card> deck) {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public Card getTopDeckCard() {
        return Deck.get(0);
    }

    public void sendTopDeckCardToGrave() {
       // Card topCard =  Deck.get(0);
        Graveyard.add(Deck.get(0));
        Deck.remove(0);
    }

    @Override
    public String toString() {

        List<String> deckToPrint = new ArrayList<>();

        for (Card card: Deck ){
            deckToPrint.add(card.toString());
        }
        return "Shoe{" + "Deck=" + deckToPrint + ", Graveyard=" + Graveyard + '}';
    }


}
