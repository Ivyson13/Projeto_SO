package projeto;

import java.util.Random;

public class GeradorDeProcessos {

	public static int QtdInstruçõesMin = 10;
	public static int QtdInstruçõesMax = 50;

	public static Processo gerar(boolean prioritade) {

		Processo processo;
		
		Random random = new Random();

		int QtdInstruções = random.nextInt((QtdInstruçõesMax - QtdInstruçõesMin) + 1) + QtdInstruçõesMin;

		// Caso o sistema necessite gerar processos com um valor de prioridade.
		if (prioritade) {
			int prioridade = random.nextInt(10) + 1;
			processo = new Processo(QtdInstruções, prioridade);
		} else {
			processo = new Processo(QtdInstruções);
		}

		return processo;
	}

}
