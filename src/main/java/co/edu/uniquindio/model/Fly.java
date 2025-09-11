package co.edu.uniquindio.model;

public abstract class Fly {

    private String id,destino;
    private int numPassegers;

    public Fly(String id,String destino,int numPassegers){
        this.destino=destino;
        this.id=id;
        this.numPassegers=numPassegers;
    }

    public String getId(){
        return id;
    }

    public String getDestino(){
        return destino;
    }

    public int numPassegers(){
        return numPassegers;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setDestino(String destino){
        this.destino=destino;
    }

    public void numPassegers(int numPassegers){
        this.numPassegers=numPassegers;
    }

    
    

}
