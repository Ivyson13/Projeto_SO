package projeto.escalonadores;

import java.util.ArrayList;
import projeto.Processo;

public class FirstComeFirstServed {

	public static void addProcesso(ArrayList<Processo> filaDeProcessos, Processo processo) {
		filaDeProcessos.add(processo);
	}

	public static Processo execultarProcesso(ArrayList<Processo> filaDeProcessos) {
		return filaDeProcessos.get(0);
	}
}
