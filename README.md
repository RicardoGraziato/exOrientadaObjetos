# exOrientadaObjetos

Trabalho desenvolvido no primeiro semestre de 2023 durante a cadeira de Programação Orientada a Objetos, visando trabalhar aprendizados gerais durante toda a cadeira.
(Como polimorfismo, herança, classes abstratas, interfaces, tratamento de execções, encapsulamento e leitura de dados em arquivo).

RESUMO:
Uma empresa que trabalha com audiovisual (blu-rays e games) já possui dado armazenados em arquivo-texto, portanto o projeto é responsável por ler os dados apartir de um arquivo "dados.csv" e registrar (criar objetos) dos audiovisuais, calcular impostos e preços finais destes e devolver um "resultado.csv" com algumas informações como [1] Quantos "itens" foram registrados; [2] Algumas informações como: título; valor do preço final; valor do imposto (estes valores que foram calculados dentro do programa); [3] Informar quantos "Games" da categoria "RPG" foram registrados; [4] Informar qual foi o "BluRay" com imposto mais próximo da média dos impostos de bluray.

As subclasses Blu-ray e Game possuem várias diferenças que estarão descritas no enunciado abaixo, assim como também algumas outras classes utilizadas como por exemplo a classe interface "Cobravel".

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ENUNCIADO:
A ACMEFun comercializa itens de audiovisual (blu-rays e games) e já possui dados de seu acervo armazenados em arquivo-texto e deseja uma aplicação que faça o processamento de dados deste acervo.
Você será responsável pelo desenvolvimento da aplicação. O analista de sistemas gerou um diagrama de classes inicial, com alguns atributos, operaçõese relacionamentos apresentados a seguir
![image](https://github.com/RicardoGraziato/exOrientadaObjetos/assets/112730538/0eda6ddc-906e-40c4-95a1-bb91f3c3ecf4)

O analista definiu as seguintes operações da interface Cobravel:
• calculaPrecoVenda(): calcula e retorna o preço de venda de um item.
• calculaImposto(): calcula e retorna o valor de imposto de um item.
Sabe-se que será necessário haver subclasses da classe abstrata Audiovisual. Cada subclasse possui informações adicionais específicas: 
• BluRay: possui uma duração (em minutos).
• Game: possui uma categoria (que pode ser: ACAO, ESPORTE, ESTRATEGIA, SIMULACAO ou RPG)

O método calculaPrecoVenda() depende da subclasse:
• BluRay: (precoBase x duracao) / 100
• Game: é o preço base acrescido de um percentual sobre o preço base conforme a categoria: 20% se for ACAO; 30% se for ESPORTE; 40% se for ESTRATEGIA; 50% se for SIMULACAO ou 70% se for RPG

O método calculaImposto() depende da subclasse:
• BluRay: 40% do valor do preço de venda.
• Game: 50% do valor do preço de venda

O método executa() da classe App deve realizar a sequência de passos:
1. Ler audiovisuais: lê todos os dados de audiovisuais e escreve a quantidade de itens carregados com sucesso no formato: 1;quantidade de itens carregados
2. Escrever informações dos itens: escreve algumas informações para cada item carregado com sucesso no sistema, no formato: 2;título;valor do preço final;valor do imposto
3. Escrever quantos games RPG foram cadastrados: escreve a quantidade de games da categoria RPG que foram carregados no sistema no formato: 3;quantidade de games RPG
4. Escrever o BluRay com imposto mais próximo da média: calcula a média dos valores de imposto de BluRays carregados e escreve qual BluRay possui o valor de imposto mais próximo da média calculada,
no formato: 4:média dos valores de impostos de BluRays;título do BluRay com imposto mais próximo da média. Caso não haja BluRays, escreve no formato: 4:Nenhum BluRay

A leitura de dados deverá ser realizada no arquivo dados.csv e a escrita de dados deverá ser realizada no arquivo resultado.csv. Exemplos destes arquivos encontram-se no Apêndice.

O objetivo do exercício é implementar um sistema capaz de atender as necessidades da empresa descrita no enunciado geral, e que atenda as restrições que a seguir:
• É permitida a criação de novas classes, atributos e métodos; mas os relacionamentos, atributos e métodos definidos no diagrama de classes original não podem ser alterados.
• Toda entrada e saída de dados deve ocorrer nas classes App ou Acervo por meio de arquivos.
• Deve haver tratamento de exceções para que a aplicação não falhe na execução. Em caso de falha, deve ser apresentada no terminal (console) uma mensagem de erro com descrição da falha.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ESTRUTURA DE ARQUIVO PARA ENTRADA DE DADOS (dados.csv):
titulo;precobase;tipo;duração_categoria
• titulo: nome do audiovisual
• precobase: preço base do audiovisual
• tipo: 1 para BluRay, ou 2 para Game
• duracao_categoria: 
  o se o tipo for 1, indica a duração em minutos do BluRay
  o se o tipo for 2, indica a categoria do game

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

EEXEMPLO de arquivo para ENTRADA de dados (dados.csv):
titulo;precobase;tipo;duracao_categoria
Star Wars;11.11;1;121
Star Wars: Battle Front;131.11;2;ACAO
Dungeons and Dragons;222.22;2;RPG
Matrix;100.00;1;136
FIFA 23;333.33;2;ESPORTE
World of Warcraft;444.44;2;RPG
Gravidade;66.66;1;91
Xadrez;30.50;2;ESTRATEGIA
The SIMS;50.00;2;SIMULACAO  

EEXEMPLO de arquivo de SAÍDA de dados (resultado.csv):
1;9
2;Star Wars;13.44;5.38
2;Star Wars: Battle Front;157.33;78.67
2;Dungeons and Dragons;377.77;188.89
2;Matrix;136.00;54.40
2;FIFA 23;433.33;216.66
2;World of Warcraft;755.55;377.77
2;Gravidade;60.66;24.26
2;Xadrez;42.70;21.35
2;The SIMS;75.00;37.50
3;2
4;28.01;Gravidade

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Enunciado fornecido por Marcelo H. Yamaguti (Professor de Programação Orientada a Objetos na PUCRS).

