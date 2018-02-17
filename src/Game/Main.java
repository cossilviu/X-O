package Game;

public class Main {
    public static void main(String[] args){
        Tabla t=new Tabla();
        t.showTable();
        System.out.println(t.isXFirst());
        Player x=new Player(Tabla.Symbol.SX);
        Player o=new Player(Tabla.Symbol.SO);
        int a = x.getValidIndex();
        int b = x.getValidIndex();
        t.showTable();
    }
}
