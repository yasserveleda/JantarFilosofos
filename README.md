# JantarFilosofos
(Parcial) Solução do problema "Jantar dos Filosofos"

"Falta sincronizar as threads para ambas terminarem juntos e deixar dinamico o numero de filosofos"

Problema: Jantar para N filósofos

Este exercício prático consiste na implementação de uma aplicação multithreading capaz de
modelar o problema do jantar dos filósofos para N filósofos.
Cada filósofo deve ser modelado como uma thread em linguagem Java, conforme visto em
aula. Os garfos consistem em semáforos. Cada par de filósofos adjacentes possuem um garfo
compartilhado.
Os filósofos devem alternar entre os estados PENSANDO e COMENDO. Um filósofo gasta 5
segundos pensando e 2 segundos comendo. Para poder comer, o filósofo deve ter sido capaz de
segurar os garfos da esquerda e da direita simultaneamente. Se ele não conseguir pegar os garfos
ele deve voltar a pensar durante um tempo aleatório entre 0 e 3 segundos antes de tentar
novamente.
O usuário da aplicação deve ser capaz de escolher a quantidade de filósofos e o tempo de
execução da aplicação​. Ao final da execução, a aplicação deve exibir um relatório indicando
quantas vezes cada filósofo comeu, pensou e tentou mas não conseguiu pegar os garfos.