
public class SquareSubMatrice {

    private int dimension;
    private int[][] matrix;
    private int firstLine;
    private int lastLine;
    private int firstColone;
    private int lastColone;

    //constructeur par defaut
    public SquareSubMatrice(){

    }

    public SquareSubMatrice(int dimension){
        this.dimension=dimension;
        this.matrix=new int[dimension][dimension];
        this.firstLine=0;
        this.firstColone=0;
        this.lastLine=dimension-1;
        this.lastColone=dimension-1;
    }

    public SquareSubMatrice(int[][] matrix, int firstLine, int lastLine, int firstColone, int lastColone){
        this.matrix=matrix;
        this.dimension=matrix.length;
        this.firstLine=firstLine;
        this.firstColone=firstColone;
        this.lastLine=lastLine;
        this.lastColone=lastColone;
    }

    @Override
    public SquareSubMatrice clone(){
        SquareSubMatrice copy=new SquareSubMatrice();
        copy.dimension=this.dimension;
        copy.matrix=new int[dimension][dimension];
        copy.firstLine=firstLine;
        copy.firstColone=firstColone;
        copy.lastLine=lastLine;
        copy.lastColone=lastColone;
        for(int i=0; i<this.dimension; i++){
            for(int j=0; j<this.dimension; j++){
                copy.matrix[i][j]=this.matrix[i][j];
            }
        }
        return copy;
    }

    public int getMatriceDimension(){
        return this.dimension;
    }

    public int getSubMatriceDimension(){
        return (this.lastLine-this.firstLine+1);
    }

    public int get(int row, int col){
        return this.matrix[row +firstLine][col+firstColone];
    }

    public void set(int row, int col, int value){
        this.matrix[row+firstLine][col+firstColone]=value;
    }

    public void sum(SquareSubMatrice matrix){
        for(int i=0; i<getSubMatriceDimension(); i++){
            for(int j=0; j<getSubMatriceDimension(); j++){
                this.set(i,j,this.get(i,j)+matrix.get(i,j));
            }
        }
    }

    public void product(SquareSubMatrice matrix){
        int sum=0;
        SquareSubMatrice product=new SquareSubMatrice(getSubMatriceDimension());
        for(int i=0; i<getSubMatriceDimension(); i++){
            for(int j=0; j<getSubMatriceDimension(); j++){
                for(int k=0; k<getSubMatriceDimension(); k++){
                    sum+=this.get(i,k)*matrix.get(k,j);
                }
                product.set(i,j,sum);
                sum=0;
            }
        }
        for(int i=0; i<getSubMatriceDimension(); i++){
            for(int j=0; j<getSubMatriceDimension(); j++){
                this.set(i,j,product.get(i,j));
            }
        }
    }


    public void power(int n){
        if(n!=1){
            SquareSubMatrice x=this.clone();
            x.power(n-1);
            this.product(x);
        }
    }

    public void quickpower(int n){
        if(n!=1){
            SquareSubMatrice x=this.clone();
            if(n%2==0){
                quickpower(n/2);
                this.product(this);
            }else{
                quickpower((n-1)/2);
                x.product(this);
                this.product(x);
            }
        }
    }


    public void show(){
        for(int i=0; i<getSubMatriceDimension(); i++){
            System.out.print("[ ");
            for(int j=0; j<getSubMatriceDimension(); j++){
                System.out.print(this.get(i,j)+" ");
            }
            System.out.println("]");
        }
    }
}
