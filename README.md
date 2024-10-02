Documentação do Código: ArvoreBinariaMorse
Visão Geral

Este projeto implementa uma árvore binária que armazena caracteres e seus códigos Morse correspondentes. A aplicação é desenvolvida em Java e permite ao usuário buscar códigos Morse a partir de caracteres alfanuméricos e vice-versa.
Estrutura do Código
Classes

    Nodo
        Representa um nó na árvore binária.
        Atributos:
            caractere: Armazena o caractere associado ao nó.
            filhoEsquerdo: Referência ao nó filho que representa um ponto (.).
            filhoDireito: Referência ao nó filho que representa um traço (-).
        Métodos:
            public Nodo(): Construtor que inicializa o nó com um caractere vazio e filhos nulos.

    ArvoreBinariaMorse
        Representa a árvore binária que contém os códigos Morse.
        Atributos:
            raiz: Referência ao nó raiz da árvore.
        Métodos:
            public ArvoreBinariaMorse(): Construtor que inicializa a árvore e chama o método inicializar().
            private void inicializar(): Preenche a árvore com os caracteres e seus respectivos códigos Morse.
            public void inserir(String codigoMorse, char caractere): Insere um caractere na árvore de acordo com seu código Morse.
            public String buscar(String caractere): Retorna o código Morse correspondente ao caractere fornecido.
            private String buscarMorse(Nodo nodo, String caractere, String codigo): Método auxiliar para busca recursiva do código Morse.
            public Character buscarPorCodigo(String codigoMorse): Retorna o caractere correspondente ao código Morse dado.
            public void exibir(): Exibe a árvore de forma hierárquica.
            private void exibir(Nodo nodo, int nivel): Método auxiliar para exibir a árvore.

    Método Principal (main)
        Inicializa a árvore e interage com o usuário.
        Permite ao usuário buscar o código Morse a partir de um caractere ou buscar o caractere a partir de um código Morse.
        Inclui validações para garantir entradas corretas do usuário.

Funcionamento
Inicialização da Árvore

    A árvore é inicializada com os caracteres de A a Z e os números de 0 a 9, cada um associado ao seu código Morse.
    O método inicializar() insere esses caracteres na árvore utilizando o método inserir().

Inserção de Caracteres

    O método inserir(String codigoMorse, char caractere) percorre a árvore de acordo com os símbolos do código Morse:
        Para cada ponto (.), move-se para o filho esquerdo.
        Para cada traço (-), move-se para o filho direito.
    Quando chega ao final do código, armazena o caractere no nó correspondente.

Busca de Códigos Morse

    O método buscar(String caractere) utiliza buscarMorse() para encontrar o código Morse associado a um caractere.
    O método buscarPorCodigo(String codigoMorse) percorre a árvore usando os símbolos do código Morse para retornar o caractere correspondente.

Exibição da Árvore

    O método exibir() exibe a estrutura da árvore de forma hierárquica, facilitando a visualização da relação entre os nós.

Interação com o Usuário

    O programa permite ao usuário:
        Buscar o código Morse de um caractere.
        Buscar o caractere correspondente a um código Morse.
    Valida entradas para garantir que apenas caracteres alfanuméricos e códigos Morse válidos sejam aceitos.

Considerações Finais

Este projeto é uma implementação básica de uma árvore binária para armazenar e buscar códigos Morse. Ele pode ser expandido para incluir mais funcionalidades, como a adição de caracteres personalizados ou a leitura de arquivos para inicializar a árvore.

Sinta-se à vontade para personalizar ou adicionar qualquer outra informação que julgar necessária! Se precisar de mais alguma coisa, é só avisar.
