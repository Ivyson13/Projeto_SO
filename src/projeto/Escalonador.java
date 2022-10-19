package projeto;

import java.util.ArrayList;
import projeto.escalonadores.*;

public class Escalonador {

	static ArrayList<Processo> filaDeProcessos = new ArrayList<Processo>();

	public void addProcesso(int algoritimo, Processo novoProcesso) {

		switch (algoritimo) {
		case 1: { // FirstComeFirstServed
			FirstComeFirstServed.addProcesso(filaDeProcessos, novoProcesso);
			break;
		}
		case 2: { // ShortestJobFirst
			ShortestJobFirst.addProcesso(filaDeProcessos, novoProcesso);
			break;
		}
		case 3: { // RoundRobin
			RoundRobin.addProcesso(filaDeProcessos, novoProcesso);
			break;
		}
		case 4: { // Priority
			Priority.addProcesso(filaDeProcessos, novoProcesso);
			break;
		}
		default:

		}

	}

	public Processo execultarProcesso(int algoritimo) {

		Processo processo = null;

		switch (algoritimo) {
		case 1: { // FirstComeFirstServed
			processo = FirstComeFirstServed.execultarProcesso(filaDeProcessos);
			break;
		}
		case 2: { // ShortestJobFirst
			processo = ShortestJobFirst.execultarProcesso(filaDeProcessos);
			break;
		}
		case 3: { // RoundRobin
			processo = RoundRobin.execultarProcesso(filaDeProcessos);
			break;
		}
		case 4: { // Priority
			processo = Priority.execultarProcesso(filaDeProcessos);
			break;
		}
		default:

		}

		return processo;

	}

	public static void atualizarFila() {
		filaDeProcessos.remove(0);
	}

	public boolean isEmpty() {
		return filaDeProcessos.isEmpty();
	}

	public Processo getProcessoDaFila(int valor) {
		return filaDeProcessos.get(valor);
	}

	public void printFila() {
		System.out.println(filaDeProcessos.toString());
	}

}
