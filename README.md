# Ordenação Externa

Este projeto implementa uma demonstração de **ordenação externa**, técnica usada
para ordenar conjuntos de dados maiores do que a memória disponível. Em vez de
carregar todos os dados de uma vez, o programa divide os números em blocos,
ordena cada bloco em memória e depois intercala os blocos ordenados.

## Como o algoritmo funciona

Ao executar o programa, a classe `Main` realiza estas etapas:

1. **Geração da entrada:** `GerarNumeros` cria o arquivo `entrada.txt` com 200
   números aleatórios entre 0 e 999, um por linha.
2. **Ordenação dos blocos:** `OrdenacaoExterna` lê os números em blocos de 50.
   Cada bloco é ordenado pelo algoritmo Merge Sort, implementado em `MergeSort`,
   e gravado nos arquivos `bloco 1`, `bloco 2`, `bloco 3` e `bloco 4`.
3. **Intercalação:** o programa compara os valores disponíveis nos quatro blocos
   e grava sempre o menor no arquivo `saida_final.txt`. O resultado fica em
   ordem crescente.

## Como compilar e executar

Instale o JDK e abra um terminal na pasta do projeto. Compile os arquivos Java:

```bash
javac Main.java GerarNumeros.java OrdenacaoExterna.java MergeSort.java
```

Depois, execute a classe principal:

```bash
java Main
```

Ao terminar, `saida_final.txt` conterá os números ordenados, um por linha. A
execução também cria ou substitui `entrada.txt` e os quatro arquivos de bloco.

## Configuração atual

O exemplo gera 200 números, divide-os em blocos de 50 e intercala exatamente
quatro blocos. Esses valores estão definidos no código; a quantidade de números
deve continuar compatível com o tamanho dos blocos e com os quatro blocos que a
intercalação espera processar.
