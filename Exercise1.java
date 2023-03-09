import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gabarito = lerGabarito(scanner);
        String[] respostasAlunos = lerRespostasAlunos(scanner);
        int[] notas = calcularNotas(gabarito, respostasAlunos);

        mostrarNotasAlunos(notas);

        double porcentagemAprovados = calcularPorcentagemAprovados(notas);

        mostrarPorcentagemAprovados(porcentagemAprovados);
    }

    private static String[] lerGabarito(Scanner scanner) {
        String[] gabarito = new String[8];
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Digite o gabarito da prova (8 caracteres): ");
            String entrada = scanner.nextLine().toUpperCase().replaceAll("\\s", ""); 
            entradaValida = true;

            if (entrada.length() != 8) {
                entradaValida = false;
                System.out.println("O gabarito deve ter exatamente 8 caracteres.");
                continue;
            }

            for (int i = 0; i < 8; i++) {
                char resposta = entrada.charAt(i);
                if (resposta != 'A' && resposta != 'B' && resposta != 'C' && resposta != 'D') {
                    entradaValida = false;
                    System.out.println("Resposta inválida. Digite novamente o gabarito da prova: ");
                    break;
                }
                gabarito[i] = String.valueOf(resposta);
            }
        }
        return gabarito;
    }

    private static String[] lerRespostasAlunos(Scanner scanner) {
        String[] respostas = new String[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite as respostas do aluno " + (i+1) + ":");
            respostas[i] = scanner.nextLine();
        }
        return respostas;
    }

    private static int[] calcularNotas(String[] gabarito, String[] respostasAlunos) {
        int[] notas = new int[10];
        for (int i = 0; i < 10; i++) {
            int nota = 0;
            for (int j = 0; j < 8; j++) {
                if (gabarito[j].equals(respostasAlunos[i].split(" ")[j])) {
                    nota++;
                }
            }
            notas[i] = nota;
        }
        return notas;
    }

    private static void mostrarNotasAlunos(int[] notas) {
        System.out.println("Notas dos alunos: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Aluno " + (i+1) + ": " + notas[i]);
        }
    }

    private static double calcularPorcentagemAprovados(int[] notas) {
        int aprovados = 0;
        for (int nota : notas) {
            if (nota >= 5) {
                aprovados++;
            }
        }
        return ((double)aprovados / 10) * 100;
    }

    private static void mostrarPorcentagemAprovados(double porcentagem) {
        System.out.printf("Porcentagem de aprovados: %.2f%%", porcentagem);
    }
}