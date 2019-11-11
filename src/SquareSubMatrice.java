
public class SquareSubMatrice {

    private int dimension;
    private int[][] matrix;
    private int firstLine;
    private int lastLine;
    private int firstColone;
    private int lastColone;

    public SquareSubMatrice(int dimension){
        this.dimension=dimension;
        this.matrix=new int[dimension][dimension];
        this.firstLine=0;
        this.firstColone=0;
        this.lastLine=dimension-1;
        this.lastColone=dimension-1;
    }

    public SquareSubMatrice clone(){
        SquareSubMatrice copy=new SquareSubMatrice(dimension);
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
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

    public SquareSubMatrice product(SquareSubMatrice matrix){
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
        return this;
    }

    public SquareSubMatrice power(int n){
        if(n==1){
            return this;
        }else{
            SquareSubMatrice x=this.clone();
            return x.product(this.power(n-1));
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

    public SquareSubMatrice quickpower(int n){
        if(n==1){
            return this;
        }else{
            if(n%2==0){
                return this.product(this).quickpower(n/2);
            }else{
                SquareSubMatrice x=this.clone();
                return x.product(this.product(this).quickpower((n-1)/2));
            }
        }
    }
}
