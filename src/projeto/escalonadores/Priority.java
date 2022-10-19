package projeto.escalonadores;

import java.util.ArrayList;
import java.util.Collections;
import projeto.Processo;

public class Priority {

	public static void addProcesso(ArrayList<Processo> filaDeProcessos, Processo novoProcesso) {

		int tamanhoFilaProcessos = filaDeProcessos.size();

		/*
		 * Caso seja o primeiro processo a entrar na fila, então será o primeiro a ser
		 * processado. Caso seja o segundo processo a entrar na fila.
		 */
		if (tamanhoFilaProcessos == 0 || tamanhoFilaProcessos == 1) {
			filaDeProcessos.add(novoProcesso);
		} else {
			ArrayList<Processo> tempLista = new ArrayList<Processo>();

			// Adicionando no final da fila.
			filaDeProcessos.add(novoProcesso);

			/*
			 * Guardar todos os processos na lista temporária, menos o primeiro, porque ele
			 * está sendo executado.
			 */
			for (int i = 1; i < filaDeProcessos.size(); i++) {
				tempLista.add(filaDeProcessos.get(i));
			}

			// Ordenar os processos da lista temporaria.
			Collections.sort(tempLista);

			// Guardar todos os processos ordenados da lista temporária de volta na lista
			for (int i = 1; i < filaDeProcessos.size(); i++) {
				filaDeProcessos.set(i, tempLista.get(i - 1));
			}
		}
	}

	public static Processo execultarProcesso(ArrayList<Processo> filaDeProcessos) {
		return filaDeProcessos.get(0);
	}

}
