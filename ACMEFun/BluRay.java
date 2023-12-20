package ACMEFun;
public class BluRay extends AudioVisual{
    private int duracao;

    //Construtor
    public BluRay(String titulo, double precoBase, int duracao){
        super(titulo, precoBase);
        this.duracao = duracao;
    }
    //-----------------------------------------------------------------------------------------------------
    @Override
    public double getPrecoBase(){
        return precoBase;
    }
  
    @Override
    public String getTitulo(){                          //                   Getters
        return titulo;
    }

    public int getDuracao(){
        return duracao;
    }
    //------------------------------------------------------------------------------------------------------
    
    @Override
    public double calculaPrecoVenda(){
        double aux = precoBase * duracao;
        return aux/100;
    }

    @Override 
    public double calculaImposto(){
        return calculaPrecoVenda()*0.4;
    }

}