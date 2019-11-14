
public class Main {

    public static void main(String args[]){

        SquareSubMatrice matrix2=new SquareSubMatrice(9);
        matrix2.randomMatrix();
        matrix2.show();
        //matrix2.power(5);
        matrix2.quickpower(5);
        matrix2.show();
        System.out.println("Nombre de Produit & somme="+matrix2.getCountProductAndSum());

    }
}
