package ACMEFun;
public class Game extends AudioVisual{
    private String categoria;

    public Game(String titulo, double precoBase, String categoria){
        super(titulo, precoBase);
        this.categoria = categoria;
    }
//------------------------------------------------------------------------------------------------------------
    @Override
    public double getPrecoBase(){
        return precoBase;
    }    

    @Override
    public String getTitulo(){                   //                        Getters
        return titulo;
    }

    public String getCategoria(){
        return categoria;
    }
//-----------------------------------------------------------------------------------------------------------
    
    public enum Categoria{
        ACAO,
        ESPORTE,
        ESTRATEGIA,
        SIMULACAO,
        RPG,
    }

    @Override
    public double calculaPrecoVenda(){
        double precovenda;
        
        switch (categoria.toUpperCase()) {
            case "ACAO":
                precovenda = getPrecoBase() + getPrecoBase() * 0.2; // ACAO: preçoBase + 20%
                break;
            case "ESPORTE":
                precovenda = getPrecoBase() + getPrecoBase() * 0.3; // ESPORTE: precoBase + 30%
                break;
            case "ESTRATEGIA":
                precovenda = getPrecoBase() + getPrecoBase() * 0.4; // ESTRATEGIA: precoBase + 40%
                break;
            case "SIMULACAO":
                precovenda = getPrecoBase() + getPrecoBase() * 0.5; // SIMULACAO: precoBase + 50%
                break;
            case "RPG":
                precovenda = getPrecoBase() + getPrecoBase() * 0.7; // RPG: precoBase + 70%
                break;
            default:
            throw new RuntimeException(); // Erro caso a categoria recebida não for esperada.
        }
        
        return precovenda;
    }

    @Override
    public double calculaImposto() {
        return calculaPrecoVenda()*0.5;   
    }  
}