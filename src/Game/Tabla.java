package Game;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.awt.Symbol;

import java.util.Random;

public class Tabla {
    private static final String RED="\033[0;91m";
    private static final String BLUE="\033[0;94m";
    private static final String RESET="\033[0;0m";
    public static enum Symbol{SX, SO, S_};
    private Symbol[][] t;

    Tabla(){
        t = new Symbol[3][3];
        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                t[i][j]=Symbol.S_; //introducem _ pe fiecare pozitie
            }
        }
    }

    public void showTable(){
        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j)
                switch(t[i][j]){
                    case SX:
                        System.out.print(RED + 'X' + RESET);
                        break;
                    case SO:
                        System.out.print(BLUE + 'O' + RESET);
                        break;
                    default:
                        System.out.print('_');
                        break;
                }
            System.out.println();
        }
    }

    public boolean isXFirst(){
        Random r=new Random();
        return r.nextBoolean();
    }

    public boolean completeaza(int a, int b, Symbol s){
        if(t[a][b]==Symbol.S_){
            t[a][b]=s;
            return true;
        } else {
            return false;
        }
    }


    public boolean hasXWon(){
        if(     t[0][0]==Symbol.SX && t[0][1]==Symbol.SX && t[0][2]==Symbol.SX ||
                t[1][0]==Symbol.SX && t[1][1]==Symbol.SX && t[1][2]==Symbol.SX ||
                t[2][0]==Symbol.SX && t[2][1]==Symbol.SX && t[2][2]==Symbol.SX ||
                t[0][0]==Symbol.SX && t[1][1]==Symbol.SX && t[2][2]==Symbol.SX ||
                t[2][2]==Symbol.SX && t[1][1]==Symbol.SX && t[0][0]==Symbol.SX ||
                t[0][0]==Symbol.SX && t[1][0]==Symbol.SX && t[2][0]==Symbol.SX ||
                t[0][1]==Symbol.SX && t[1][1]==Symbol.SX && t[2][1]==Symbol.SX ||
                t[0][2]==Symbol.SX && t[1][2]==Symbol.SX && t[2][2]==Symbol.SX      ){
            System.out.println("Player X won!");
            return true;
        } else {
            return false;
        }
    }

    public boolean hasOWon(){
        if(     t[0][0]==Symbol.SO && t[0][1]==Symbol.SO && t[0][2]==Symbol.SO ||
                t[1][0]==Symbol.SO && t[1][1]==Symbol.SO && t[1][2]==Symbol.SO ||
                t[2][0]==Symbol.SO && t[2][1]==Symbol.SO && t[2][2]==Symbol.SO ||
                t[0][0]==Symbol.SO && t[1][1]==Symbol.SO && t[2][2]==Symbol.SO ||
                t[2][2]==Symbol.SO && t[1][1]==Symbol.SO && t[0][0]==Symbol.SO ||
                t[0][0]==Symbol.SO && t[1][0]==Symbol.SO && t[2][0]==Symbol.SO ||
                t[0][1]==Symbol.SO && t[1][1]==Symbol.SO && t[2][1]==Symbol.SO ||
                t[0][2]==Symbol.SO && t[1][2]==Symbol.SO && t[2][2]==Symbol.SO      ){
            System.out.println("Player O won!");
            return true;
        } else {
            return false;
        }
    }

    public boolean isDraw(){
        if(hasXWon()==false && hasOWon()==false &&
            t[0][0]!=Symbol.S_ && t[0][1]!=Symbol.S_ && t[0][2]!=Symbol.S_ &&
            t[1][0]!=Symbol.S_ && t[1][1]!=Symbol.S_ && t[1][2]!=Symbol.S_ &&
            t[2][0]!=Symbol.S_ && t[2][1]!=Symbol.S_ && t[2][2]!=Symbol.S_
                ){

            System.out.println("Remiza!");
            return true;
        } else {
            return false;
        }

    }
}
