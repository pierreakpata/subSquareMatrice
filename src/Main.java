
public class Main {

    public static void main(String args[]){
        SquareSubMatrice matrix=new SquareSubMatrice(3);
        matrix.set(0,0,1);
        matrix.set(0,1, 1);
        matrix.set(0,2, 1);

        matrix.set(1,0,2);
        matrix.set(1,1, 1);
        matrix.set(1,2, 2);

        matrix.set(2,0,0);
        matrix.set(2,1, 3);
        matrix.set(2,2, 1);

        matrix.show();
        System.out.println();
        SquareSubMatrice copy=matrix.clone();
        //matrix.product(copy);
        //SquareSubMatrice res=matrix.power(6);
        SquareSubMatrice res=matrix.quickpower(3);
        res.show();

    }
}
