package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HorasTrabalhadas;
import entidades.Trabalhador;
import entidadesEnum.NivelDoTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Digite o nome do departamento: ");
		String nomeDepartamento = input.nextLine();
		System.out.println("Dados do Trabalhador: ");
		System.out.println("Nome do Trabalhador: ");
		String nomeTrabalhador = input.nextLine();
		System.out.println("Nível do trabalhador: ");
		String nivelTrabalhador = input.nextLine();
		System.out.println("Salário Mínimo: ");
		double salarioMinimo = input.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDoTrabalhador.valueOf(nivelTrabalhador),
				salarioMinimo, new Departamento(nomeDepartamento));

		System.out.println("Quantos contratos esse trabalhador vai ter?");
		int n = input.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite o " + i + "° contrato: ");
			System.out.print("Data (DD/MM/AAAA): ");
			Date contratoData = sdf.parse(input.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = input.nextDouble();
			System.out.print("Duração em horas: ");
			int horas = input.nextInt();
			HorasTrabalhadas contrato = new HorasTrabalhadas(contratoData, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		System.out.println();
		System.out.print("Digite o mês e o ano para calcular a renda do trabalhador(MM/YYYY): ");
		String mesEAno = input.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda de " + mesEAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
		input.close();
	}

}