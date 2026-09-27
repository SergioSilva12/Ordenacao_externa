# Ordenação externa

Este projeto demonstra uma **ordenação externa**: uma técnica para ordenar grandes
conjuntos de dados que não cabem inteiros na memória. Em vez de carregar todos os
valores de uma vez, o programa divide a entrada em blocos, ordena cada bloco e,
por fim, intercala os blocos ordenados para produzir o resultado.

## Como funciona

O programa segue estas etapas:

1. `GerarNumeros` cria o arquivo `entrada.txt` com 200 números inteiros aleatórios
   entre 0 e 999, um número por linha.
2. `OrdenacaoExterna.gerarBlocosOrdenados` lê a entrada em blocos de 50 números e
   ordena cada bloco usando o `MergeSort`. Os blocos são gravados nos arquivos
   `bloco 1`, `bloco 2`, `bloco 3` e `bloco 4`.
3. `OrdenacaoExterna.intercalarBlocos` intercala os quatro blocos ordenados,
   gravando todos os valores em ordem crescente no arquivo `saida_final.txt`.

O `MergeSort` ordena cada bloco em memória. Na intercalação, o programa compara
os valores atuais dos blocos e grava o menor no arquivo final, avançando no bloco
de onde o valor foi lido.

## Como compilar e executar

É necessário ter o JDK instalado e os comandos `javac` e `java` disponíveis no
terminal. Na pasta do projeto, execute:

```bash
javac *.java
java Main
```

O `Main` executa automaticamente as três etapas na ordem correta: gera a entrada,
cria os blocos ordenados e intercala os blocos. Ao final, confira o resultado em
`saida_final.txt`.

Cada execução substitui `entrada.txt`, os arquivos `bloco 1` a `bloco 4` e
`saida_final.txt`. Na configuração atual, são gerados 200 números e cada bloco
contém 50; portanto, a intercalação está configurada para processar exatamente
quatro blocos.
