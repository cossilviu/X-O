package Game;

import sun.awt.Symbol;

import java.util.Scanner;

public class Player {
    Tabla.Symbol op;


    Player(Tabla.Symbol op){
        this.op = op;
    }

    public int getValidIndex(){
        Scanner sc=new Scanner (System.in);
        int a;

        while(true){
            a=sc.nextInt();
            if (a>=0 && a<=2){
                break;
            } else {
                System.out.println("Introduceti 0, 1, sau 2.");
            }
        }
        return a;
    }

    public void nextMove(Tabla t){
        int a=getValidIndex();
        int b=getValidIndex();

        t.completeaza(a,b,op);

        //showTable(t);
    }
}
