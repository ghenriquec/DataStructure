import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][4];
        preencherMatriz(matriz, scanner);
        exibirMatriz(matriz);
        int[] posicaoMaior = buscarMaior(matriz);
        int[] posicaoMenor = buscarMenor(matriz);

        System.out.println("Maior elemento: " + matriz[posicaoMaior[0]][posicaoMaior[1]] + " na posição [" + posicaoMaior[0] + ", " + posicaoMaior[1] + "]");
        System.out.println("Menor elemento: " + matriz[posicaoMenor[0]][posicaoMenor[1]] + " na posição [" + posicaoMenor[0] + ", " + posicaoMenor[1] + "]");
    }

    private static void exibirMatriz(int[][] matriz) {
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void preencherMatriz(int[][] matriz, Scanner scanner) {
        System.out.println("Preencha a matriz com números inteiros e positivos:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int valor = -1;
                while (valor < 0) {
                    System.out.print("Digite o valor da posição [" + i + ", " + j + "]: ");
                    valor = scanner.nextInt();
                    if (valor < 0) {
                        System.out.println("O valor não pode ser negativo.");
                    }
                }
                matriz[i][j] = valor;
            }
        }
    }

    private static int[] buscarMaior(int[][] matriz) {
        int[] posicaoMaior = {0, 0};
        int maior = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                    posicaoMaior[0] = i;
                    posicaoMaior[1] = j;
                }
            }
        }
        return posicaoMaior;
    }

    private static int[] buscarMenor(int[][] matriz) {
        int[] posicaoMenor = {0, 0};
        int menor = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    posicaoMenor[0] = i;
                    posicaoMenor[1] = j;
                }
            }
        }
        return posicaoMenor;
    }
}