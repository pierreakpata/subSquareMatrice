
public class Main {

    public static void main(String args[]){

        int[][] tab={{1,1,1,1,1,1},{1,1,1,1,1,1}
        ,{1,2,1,2,1,1},{1,0,3,1,1,1},
                {1,1,1,1,1,1},{1,1,1,1,1,1}};

        //utilisation du premier constructeur
        SquareSubMatrice matrix1=new SquareSubMatrice(tab,1,3,1,3);
        matrix1.show();
        System.out.println();
        //SquareSubMatrice copy=matrix1.clone();
        //matrix.product(copy);
        //matrix.power(5);
        matrix1.quickpower(5);
        matrix1.show();
        System.out.println();

        //utlisation du deuxième constructeur
        SquareSubMatrice matrix2=new SquareSubMatrice(3);

        matrix2.set(0,0,1);
        matrix2.set(0,1, 1);
        matrix2.set(0,2, 1);

        matrix2.set(1,0,2);
        matrix2.set(1,1, 1);
        matrix2.set(1,2, 2);

        matrix2.set(2,0,0);
        matrix2.set(2,1, 3);
        matrix2.set(2,2, 1);

        matrix2.show();
        SquareSubMatrice copy=matrix2.clone();
        System.out.println();
        //matrix2.sum(copy);
        //matrix2.product(copy);
        //matrix2.power(4);
        matrix2.quickpower(5);
        matrix2.show();

    }
}
