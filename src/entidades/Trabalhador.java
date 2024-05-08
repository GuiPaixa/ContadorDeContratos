package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidadesEnum.NivelDoTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelDoTrabalhador nivel;
	private double salarioMinimo;

	private Departamento departamento;
	private List<HorasTrabalhadas> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String nome, NivelDoTrabalhador nivel, double salarioMinimo, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioMinimo = salarioMinimo;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDoTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelDoTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasTrabalhadas> getContratos() {
		return contratos;
	}

	public void addContrato(HorasTrabalhadas contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(HorasTrabalhadas contrato) {
		contratos.remove(contrato);
	}

	public double renda(int ano, int mes) {
		double soma = salarioMinimo;
		Calendar cal = Calendar.getInstance();
		for (HorasTrabalhadas c : contratos) {
			cal.setTime(c.getData());
			int cAno = cal.get(Calendar.YEAR);
			int cMes = 1 + cal.get(Calendar.MONTH);
			if (ano == cAno && mes == cMes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}