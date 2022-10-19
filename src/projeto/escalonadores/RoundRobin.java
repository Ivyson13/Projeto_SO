package projeto.escalonadores;

import java.util.ArrayList;
import projeto.Processo;

public class RoundRobin {

	static long TEMPO_MAXIMO = 1000;

	public static void addProcesso(ArrayList<Processo> filaDeProcessos, Processo processo) {
		filaDeProcessos.add(processo);
	}

	public static Processo execultarProcesso(ArrayList<Processo> filaDeProcessos) {

		Processo processo;

		// Se tiver só um elemento na fila, executar ele.
		if (filaDeProcessos.size() == 1) {
			processo = filaDeProcessos.get(0);
		} else {
			/*
			 * Verificar se o tempo de processamento do processo da vez é menor do que o
			 * máximo permitido.
			 */
			if (filaDeProcessos.get(0).getTempoExecucao() < TEMPO_MAXIMO) {
				processo = filaDeProcessos.get(0);
			} else { // Se for maior.
				// Zerar o tempo dele
				filaDeProcessos.get(0).setTempoExecucao(0);
				// Mover para o final da fila.
				filaDeProcessos.add(filaDeProcessos.get(0));
				filaDeProcessos.remove(0);

				/*
				 * Retornar o próximo processo, que antes estava na posição 1 e agora esta na
				 * posição 0.
				 */
				processo = filaDeProcessos.get(0);
			}
		}
		return processo;
	}
}
