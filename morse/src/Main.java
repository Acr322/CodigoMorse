import java.util.Scanner;

class Nodo {
    char caractere;           // Caractere armazenado no nó
    Nodo filhoEsquerdo;      // Representa o ponto (.)
    Nodo filhoDireito;       // Representa o traço (-)

    public Nodo() {
        this.caractere = '\0'; // Caractere vazio
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }
}

class ArvoreBinariaMorse {
    private Nodo raiz;

    public ArvoreBinariaMorse() {
        raiz = new Nodo();
        inicializar();
    }

    // Método para inicializar a árvore com caracteres e seus códigos Morse
    private void inicializar() {
        String[][] morseDict = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
                {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                {"Z", "--.."},
                {"0", "-----"}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"},
                {"4", "....-"}, {"5", "....."}, {"6", "-...."}, {"7", "--..."},
                {"8", "---.."}, {"9", "----."}
        };

        // Insere cada caractere na árvore de acordo com o código Morse
        for (String[] par : morseDict) {
            inserir(par[1], par[0].charAt(0));
        }
    }

    // Método para inserir um caractere na árvore de acordo com o código Morse
    public void inserir(String codigoMorse, char caractere) {
        Nodo nodoAtual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                if (nodoAtual.filhoEsquerdo == null) {
                    nodoAtual.filhoEsquerdo = new Nodo();
                }
                nodoAtual = nodoAtual.filhoEsquerdo;
            } else if (simbolo == '-') {
                if (nodoAtual.filhoDireito == null) {
                    nodoAtual.filhoDireito = new Nodo();
                }
                nodoAtual = nodoAtual.filhoDireito;
            }
        }
        nodoAtual.caractere = caractere; // Armazena o caractere no nó correspondente
    }

    // Método para buscar o código Morse de um caractere
    public String buscar(String caractere) {
        return buscarMorse(raiz, caractere.toUpperCase(), "");
    }

    // Método auxiliar para buscar o código Morse recursivamente
    private String buscarMorse(Nodo nodo, String caractere, String codigo) {
        if (nodo == null) {
            return null; // Se o nó for nulo, retorna null
        }
        if (nodo.caractere == caractere.charAt(0)) {
            return codigo; // Retorna o código Morse se encontrado
        }

        // Busca na subárvore esquerda (ponto)
        String resultado = buscarMorse(nodo.filhoEsquerdo, caractere, codigo + ".");
        if (resultado != null) {
            return resultado;
        }

        // Busca na subárvore direita (traço)
        return buscarMorse(nodo.filhoDireito, caractere, codigo + "-");
    }

    // Método para buscar um caractere na árvore usando seu código Morse
    public Character buscarPorCodigo(String codigoMorse) {
        Nodo nodoAtual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                nodoAtual = nodoAtual.filhoEsquerdo;
            } else if (simbolo == '-') {
                nodoAtual = nodoAtual.filhoDireito;
            }
            if (nodoAtual == null) {
                return null; // Código Morse inválido
            }
        }
        return nodoAtual.caractere != '\0' ? nodoAtual.caractere : null; // Retorna o caractere, se válido
    }

    // Método para exibir a árvore de forma hierárquica
    public void exibir() {
        exibir(raiz, 0);
    }

    // Método auxiliar para exibir a árvore
    private void exibir(Nodo nodo, int nivel) {
        if (nodo != null) {
            if (nodo.filhoDireito != null) { // Traços
                exibir(nodo.filhoDireito, nivel + 1);
            }
            if (nodo.caractere != '\0') { // Apenas exibe se o caractere não for vazio
                System.out.println(" ".repeat(4 * nivel) + "-> " + nodo.caractere);
            }
            if (nodo.filhoEsquerdo != null) { // Pontos
                exibir(nodo.filhoEsquerdo, nivel + 1);
            }
        }
    }

    // Método principal para execução do programa
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        Scanner scanner = new Scanner(System.in);

        // Interação com o usuário para buscar código Morse a partir do caractere
        System.out.println("Digite um caractere para buscar seu código Morse (ou 'sair' para encerrar):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) {
                break; // Encerra o loop se o usuário digitar 'sair'
            }
            if (input.length() == 1 && Character.isLetterOrDigit(input.charAt(0))) {
                String resultado = arvore.buscar(input);
                System.out.println("Código Morse correspondente: " + (resultado != null ? resultado : "Não encontrado."));
            } else {
                System.out.println("Por favor, insira apenas um caractere alfanumérico.");
            }
        }

        // Interação com o usuário para buscar caractere a partir do código Morse
        System.out.println("Digite um código Morse para buscar o caractere correspondente (ou 'sair' para encerrar):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) {
                break; // Encerra o loop se o usuário digitar 'sair'
            }
            if (input.matches("[.-]+")) { // Verifica se a entrada é apenas pontos e traços
                Character resultado = arvore.buscarPorCodigo(input);
                System.out.println("Caractere correspondente: " + (resultado != null ? resultado : "Código Morse inválido."));
            } else {
                System.out.println("Por favor, insira um código Morse válido (apenas '.' e '-').");
            }
        }

        System.out.println("\nExibição da Árvore:");
        arvore.exibir(); // Exibe a estrutura da árvore
        scanner.close(); // Fecha o scanner
    }
}
