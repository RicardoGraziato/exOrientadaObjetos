package ACMEFun;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.io.File;
import java.text.DecimalFormat;

public class App {
    private Acervo acervo;


// Construtor da Aplicação
    public App() {
        try {
            PrintStream streamSaida =
            new PrintStream (new File("ACMEFun/resultado.csv"), Charset.forName("UTF-8"));
            System.setOut(streamSaida); // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }

        acervo = new Acervo();
    }

    public void executa(){
        LerAVS(); //1
        Infos(); //2
        QtdRPGs(); //3
        BlurayMaisProxMedia(); //4
    }
    
    //Passo 1
    public void LerAVS(){
        int leitura = acervo.AdicionarAudioVisual();  //Le todos os AudioVisuais e retorna a quantidade lida.
        System.out.println("1;" + leitura );
    }

    //Passo 2
    public void Infos(){
        DecimalFormat DF = new DecimalFormat("#.00");  //padrão de decimal: 2 números depois da virgula
        for(int i=0; i<acervo.avs.size(); i++){
            AudioVisual aux = acervo.avs.get(i);
            double precoFinal = aux.calculaPrecoVenda();
            String precoFinalFormatado = DF.format(precoFinal);
            double imposto = aux.calculaImposto();
            String impostoFormatado = DF.format(imposto);
            System.out.println("2;" + aux.getTitulo() + ";" + precoFinalFormatado + ";" + impostoFormatado);
        }
    }

    //Passo 3
    public void QtdRPGs(){
        System.out.println("3;" + acervo.GetQtdRPGs());
    }

    //Passo 4
    public void BlurayMaisProxMedia(){
        DecimalFormat DF = new DecimalFormat("#.00");   //Padrão de decimal: 2 números depois da virgula.
        if(acervo.blurays.size() != 0){
            double media = acervo.mediaImpostoBluRays();
            String mediaFormatada = DF.format(media);
            BluRay maisProximo = null;   //Variavel auxiliar para armazenar o bluray com imposto mais perto da média.
            double diferencaMaisProx = Double.MAX_VALUE; //Variavel que defina a diferença mais proxima, inicia com o valor maximo possivel para um double para que qualquer valor que receba seja menor e entre no if abaixo.
            for(int i=0; i<acervo.blurays.size(); i++){
                BluRay aux = acervo.blurays.get(i);
                double diferenca = Math.abs(aux.calculaImposto() - media);  //calcula diferença do imposto de aux para a média.
                if(diferenca < diferencaMaisProx){    //Se a diferença for menor doque a até então mais proxima, ela se torna a mais proxima.
                    diferencaMaisProx = diferenca;    
                    maisProximo = aux;     //a variavel bluray "maisProximo" agora guarda o bluray que estava no aux e que teve a diferença mais proxima.  
                }
            }
            System.out.println("4;" + mediaFormatada + ";" + maisProximo.getTitulo());
        }
        else if(acervo.blurays.size() == 0){
            System.out.println("4: Nenhum BluRay.");
        }
    }
}