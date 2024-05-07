import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        try {
            // Solicita e valida o primeiro parâmetro
            System.out.println("Digite o primeiro parâmetro:");
            int parametroUm = solicitarInt(terminal);

            // Solicita e valida o segundo parâmetro
            System.out.println("Digite o segundo parâmetro:");
            int parametroDois = solicitarInt(terminal);

            // Validação adicional (opcional)
            validarParametros(parametroUm, parametroDois);

            // Realiza a contagem e imprime os números
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Erro: Tipo de dado inválido. Digite apenas números inteiros.");
            terminal.next(); // Consumir o valor de entrada incorreto
        } finally {
            terminal.close(); // Fechando o Scanner para liberar recursos
        }
    }

    // Método para solicitar e validar um número inteiro
    static int solicitarInt(Scanner terminal) {
        int valor;
        while (!terminal.hasNextInt()) {
            System.err.println("Erro: Digite um número inteiro válido.");
            terminal.next(); // Consumir o valor de entrada incorreto
        }

        valor = terminal.nextInt();
        terminal.nextLine(); // Consumir a quebra de linha

        return valor;
    }

    // Método para validar os parâmetros
    static void validarParametros(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm <= 0 || parametroDois <= 0) {
            throw new ParametrosInvalidosException("Os parâmetros devem ser maiores que zero.");
        }
    }

    // Método para realizar a contagem e imprimir os números
    static void contar(int parametroUm, int parametroDois) {
        if (parametroUm >= parametroDois) {
            System.err.println("Erro: O segundo parâmetro deve ser maior que o primeiro.");
        } else {
            for (int i = parametroUm; i <= parametroDois; i++) {
                System.out.println(i);
            }
        }
    }
}

// Classe de exceção personalizada para parâmetros inválidos
class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String mensagem) {
        super(mensagem);
    }
}
