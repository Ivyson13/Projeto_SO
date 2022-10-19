package test;
import java.util.Scanner;

import projeto.Escalonador;
import projeto.GeradorDeProcessos;

public class CpuTeste {

	public static void main(String[] args) throws InterruptedException {

		Scanner entrada = new Scanner(System.in);
		Escalonador escalonador = new Escalonador();

		int opcao;
		boolean loop;
		boolean prioridade;

		System.out.print("tipo de escalonamento: ");
		opcao = entrada.nextInt();

		if (opcao == 4) {
			prioridade = true;
		} else {
			prioridade = false;
		}
		
		loop = true;
		
		// criando poresseos para simular uma demada previa do processaor
		int nProcessos = 5;
		
		while (loop) {

			if (nProcessos > 0) {
				// criando processos e adicionando ao escalonador
				escalonador.addProcesso(opcao, GeradorDeProcessos.gerar(prioridade));
				nProcessos -= 1;
			}

			// velifica se ha processos e execulta processos
			if (!escalonador.isEmpty()) {
				escalonador.execultarProcesso(opcao).executar();

			} else {
				System.out.println("Fila vasia");
				Thread.sleep(1000);
			}
			escalonador.printFila();
		}

	}

	public static void finalizarProcesso() {
		Escalonador.atualizarFila();
	}
}