package projeto;

import java.util.Random;

public class Processo implements Comparable<Processo> {

	private int id;
	private int qtdInstruções;
	private int qtdTotalInstruções;
	private int prioridade;
	private long tempoDeExecucao;

	Random random = new Random();

	public Processo(int quantidadeInstruções) {
		this.qtdInstruções = quantidadeInstruções;
		this.qtdTotalInstruções = quantidadeInstruções;

		id = random.nextInt(1000);

	}

	public Processo(int quantidadeInstruções, int prioridade) {
		this.qtdInstruções = quantidadeInstruções;
		this.qtdTotalInstruções = quantidadeInstruções;
		this.prioridade = prioridade;

		id = random.nextInt(100);

	}

	public void executar() throws InterruptedException {

		qtdInstruções -= 1;

		long tempoInicial = System.currentTimeMillis();

		System.out.println("Executando o Processo [Id] " + id + " - " + qtdInstruções + " instruções restantes de "
				+ qtdTotalInstruções);
		

		// Simular um processamento pesado.
		Thread.sleep(100);

		// Se for a última instrução finalizar o processo.
		if (qtdInstruções == 0) {
			finalizar();
			System.out.println("Processo [Id " + id + "] foi finalizado");
		}

		long tempoFinal = System.currentTimeMillis();

		addTempoExecucao(tempoFinal - tempoInicial);
	}

	public void finalizar() {
		Cpu.finalizarProcesso();
	}

	public int getQtdTotalInstruções() {
		return qtdTotalInstruções;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public long getTempoExecucao() {
		return tempoDeExecucao;
	}

	public void setTempoExecucao(long tempo) {
		this.tempoDeExecucao = tempo;
	}

	public void addTempoExecucao(long tempo) {
		this.tempoDeExecucao = tempoDeExecucao + tempo;
	}

	@Override
	public String toString() {
		return "Id"+id + " QtdInst" + qtdTotalInstruções + " Pri-" + prioridade + " Temp" + tempoDeExecucao;
	}

	@Override
	public int compareTo(Processo outroProcesso) {
		int retorno = 0; // TODO

		// Se o processo não tiver prioridade, então, fazer a comparação por seu tamanho
		if (prioridade == 0) {
			if (this.qtdTotalInstruções < outroProcesso.getQtdTotalInstruções()) {
				retorno = -1;
			}
			if (this.qtdTotalInstruções > outroProcesso.getQtdTotalInstruções()) {
				retorno = 1;
			}
		} else {
			if (this.prioridade < outroProcesso.getPrioridade()) {
				retorno = -1;
			}
			if (this.prioridade > outroProcesso.getPrioridade()) {
				retorno = 1;
			}
		}

		return retorno;
	}

}
