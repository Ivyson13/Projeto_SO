package projeto;

import java.util.Random;
import java.util.Scanner;

public class Cpu {
	public static void main(String[] args) throws InterruptedException {

		int opcao;
		boolean loop;
		boolean prioridade;

		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		Escalonador escalonador = new Escalonador();
		Random random = new Random();

		// Menu.
		System.out.println("	Escalonadores");
		System.out.println("1. First Come First Served ");
		System.out.println("2. Shortest Job First");
		System.out.println("3. Round Robin");
		System.out.println("4. Priority");
		System.out.print("Digite uma das opções: ");

		opcao = entrada.nextInt();

		/*
		 * Se o escalonador for usar o escalonamento com prioridade o sistema deverá
		 * gerar processos com um valor de prioridade.
		 */
		if (opcao == 4) {
			prioridade = true;
		} else {
			prioridade = false;
		}

		loop = true;

		// Probabilidade do escalonador receber um novo processo. Onde, 1 = 100%.
		double novoPoecesso = 0.01;

		// Criando processos para simular uma demanda prévia do sistema ao processador
		int nProcessos = 5;

		while (nProcessos > 0) {
			// Criando processos e adicionando ao escalonador.
			escalonador.addProcesso(opcao, GeradorDeProcessos.gerar(prioridade));
			nProcessos -= 1;
		}

		// Laço infinito da Cpu.
		while (loop) {

			if (random.nextDouble(1) < novoPoecesso) {
				// Criar processos e adicionar ao escalonador.
				escalonador.addProcesso(opcao, GeradorDeProcessos.gerar(prioridade));
			}

			// Verificar se há processos antes de tentar executar.
			if (!escalonador.isEmpty()) {
				escalonador.execultarProcesso(opcao).executar();

			} else {
				System.out.println("Sem processos para executar!");
			}
			
			System.out.print("Fila :");
			escalonador.printFila();
			System.out.println("");
		}

	}

	public static void finalizarProcesso() {
		Escalonador.atualizarFila();
	}
}
