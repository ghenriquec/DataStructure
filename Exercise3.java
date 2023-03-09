import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a frase a ser criptografada: ");
        String frase = scanner.nextLine();
        String fraseInvertida = inverterFrase(frase);
        System.out.println("Frase criptografada: " + fraseInvertida);
    }

    public static String inverterFrase(String frase) {
        StringBuilder sb = new StringBuilder(frase);
        return sb.reverse().toString();
    }
}