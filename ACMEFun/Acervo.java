package ACMEFun;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    //Classe catálogo de Audios visuais
public class Acervo {
    protected ArrayList<AudioVisual> avs; //Coleção de Audios visuais
    public int qtdAVs; //Contador de Autiods Visuaus
    public int qtdRPGs; //contador de rpgs
    protected ArrayList<BluRay> blurays; //Colação de BluRyas

    public Acervo(){
        avs = new ArrayList<AudioVisual>();
        blurays = new ArrayList<BluRay>();
        qtdAVs = 0;
        qtdRPGs = 0;
    }

    //Cadastra todos os Ojbetos AudioVisuais lidos do arquivo "dados.csv" e retorna a quantidade de objetos cadastrados.
    public int AdicionarAudioVisual(){
        try (BufferedReader br = new BufferedReader(new FileReader("ACMEFun/dados.csv"))) {
            String linha;
            boolean PrimeiraLinha = true;
    
            while ((linha = br.readLine()) != null) {
                if (PrimeiraLinha) {
                    PrimeiraLinha = false;
                    continue; // Pular a primeira linha (Cabeçalho)
                }
                String[] dados = linha.split(";");
    
                if (dados.length >= 4) {
                    String titulo = dados[0];
                    double precoBase = Double.parseDouble(dados[1]);
                    int tipo = Integer.parseInt(dados[2]);
    
                    if (tipo == 1) {
                        int duracao = Integer.parseInt(dados[3]);
                        BluRay bluRay = new BluRay(titulo, precoBase, duracao);
                        avs.add(bluRay);
                        blurays.add(bluRay);
                        qtdAVs++;
                    } else if (tipo == 2) {
                        String categoria = dados[3];
                            if(categoria.equals("ACAO") || categoria.equals("ESTRATEGIA") || categoria.equals("ESPORTE") || categoria.equals("SIMULACAO") || categoria.equals("RPG")){ 
                            Game game = new Game(titulo, precoBase, categoria);
                            avs.add(game);
                            qtdAVs++;
                        if(categoria.equals("RPG")){qtdRPGs++;} //Soma 1 no contador de RPG
                        }
                    }
                } 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return qtdAVs;
    }

    public int GetQtdRPGs(){
        return qtdRPGs;
    }
    
    //Calcula e devolve a média dos impostos dos blurays
    public double mediaImpostoBluRays(){
        double somaImpostos = 0;
        double mediaImpostos;
        double aux;
            for(int i=0; i<blurays.size(); i++){
               aux = blurays.get(i).calculaImposto();
               somaImpostos += aux;
            }
        mediaImpostos = somaImpostos/blurays.size();
      
        return mediaImpostos;
    }
}