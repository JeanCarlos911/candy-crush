package Game;

public class Tablero {

    private Dulce matriz[][];

    public Tablero()
    {
        this.matriz = new Dulce[9][9];
    }

    public void setDulce(int fila,int columna,Dulce dulce){
        this.matriz[fila][columna] = dulce;
    }

    public Dulce getDulce(int fila,int columna){
        return matriz[fila][columna];
    }

    public void generarTablero()
    {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                this.setDulce(i, j, new Dulce());          
            }
        }
    }

    public void moverDulce(int xi,int yi,int xf,int yf){
        
        Dulce cambio = this.getDulce(xf, yf);
        Dulce dulceAmover = this.getDulce(xi,yi);

        this.setDulce(xi, yi, cambio);
        this.setDulce(xf, yf, dulceAmover);
    }

    public void actualizarTablero()
    {
        for(int i = 0; i < 8; i++){
            for(int j = 0; i < 8; j++){
                if(this.getDulce(i, j) == null){
                    this.setDulce(i, j,new Dulce());
                } 
            }
        }
    }

    public void caerDulces()
    {
        for(int i = 0; i < 8; i++){
            for(int j = 0; i < 8; j++){
                try{
                    if(this.getDulce(i,j) != null && this.getDulce(i+1,j) == null){
                        Dulce dulceCayo = this.getDulce(i,j);
                        this.setDulce(i, j, null);
                        this.setDulce(j+1, j, dulceCayo);
                        this.actualizarTablero();

                    }
                }catch(ArrayIndexOutOfBoundsException e){}
            }
                
        }
    }
    
}