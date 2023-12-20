package ACMEFun;
public abstract class AudioVisual implements Cobravel {
    protected String titulo;
    protected double precoBase;

    public AudioVisual(String titulo, double precoBase){
        this.titulo = titulo;
        this.precoBase = precoBase;
    }

    @Override
    public double calculaPrecoVenda(){
        return precoBase + precoBase*0.5; //Genérico para ser sobreescrito nas subclasses
    }

    @Override 
    public double calculaImposto(){
        return calculaPrecoVenda()*0.5; //Genérico para ser sobreescrito nas subclasses
    }

   public abstract double getPrecoBase();
   public abstract String getTitulo();
}