package com.example.projetoDioBancoDeDados;

import com.example.projetoDioBancoDeDados.service.ColunaService;
import com.example.projetoDioBancoDeDados.service.PainelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProjetoDioBancoDeDadosApplication implements CommandLineRunner {

	@Autowired
	PainelService painelService;

	@Autowired
	ColunaService colunaService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDioBancoDeDadosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		int opcao;

		do {
			exibirMenuPrincipal();
			opcao = lerOpcao(scanner);

			switch (opcao) {
				case 1 -> menuTarefasPrincipais(scanner);
				case 0 -> System.out.println("Encerrando aplicação...");
				default -> System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 0);

		scanner.close();
	}

	private void exibirMenuPrincipal() {
		System.out.println("\n--- PAINEL DE CONTROLE DE TAREFAS ---");
		System.out.println("1 - Lista de Tarefas Principais");
		System.out.println("0 - Sair");
		System.out.print("Opção: ");
	}

	private void menuTarefasPrincipais(Scanner scanner) {
		System.out.println("\n--- TAREFAS PRINCIPAIS ---");
		painelService.listarPaineis();

		System.out.println("\n1 - Acessar uma Tarefa Principal");
		System.out.println("2 - Adicionar Tarefa Principal");
		System.out.println("3 - Excluir Tarefa Principal");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");

		int subOpcao = lerOpcao(scanner);

		switch (subOpcao) {
			case 1 -> acessarTarefa(scanner);
			case 2 -> adicionarTarefa(scanner);
			case 3 -> excluirTarefa(scanner);
			case 0 -> System.out.println("Voltando ao menu principal...");
			default -> System.out.println("Opção inválida. Tente novamente.");
		}
	}

	private void acessarTarefa(Scanner scanner) {
		System.out.print("Digite o ID da tarefa para acessar: ");
		Long idAcessar = scanner.nextLong();
		scanner.nextLine();
		painelService.acessarTarefa(idAcessar);

		System.out.println("1 - Acessar cards da atividade");
		System.out.println("2 - Adicionar uma atividade");
		System.out.println("0 - Voltar");
		System.out.print("Opção: ");
		int subOpcao = lerOpcao(scanner);


		switch (subOpcao) {
			case 1 -> acessarCads(scanner);
			case 2 -> adicionarAtividade(scanner);
			case 0 -> System.out.println("Voltando...");
			default -> System.out.println("Opção inválida.");
		}
	}

	private void adicionarTarefa(Scanner scanner) {
		System.out.print("Digite o nome da nova tafera: ");
		String nome = scanner.nextLine();
		painelService.adicionarPainel(nome, "Não Concluido");
		System.out.println("Tarefa adicionada com sucesso!");
	}

	public void adicionarAtividade(Scanner scanner){
		System.out.println("Digite o nome da atividade:");
		String nome = scanner.nextLine();

		System.out.println("Digite o status da atividade:");
		String status = scanner.nextLine();

		painelService.adicionarAtividade(nome, status);
	}

	private void excluirTarefa(Scanner scanner) {
		System.out.print("Digite o ID da tarefa para excluir: ");
		Long idExcluir = scanner.nextLong();
		scanner.nextLine();
		// painelService.excluirTarefa(idExcluir); // Descomente quando o método estiver implementado
		System.out.println("Função de exclusão ainda não implementada.");
	}

	private void acessarCads(Scanner scanner){
		System.out.println("Digite o id da atividade: ");
		Long id = scanner.nextLong();
		painelService.acessarAtividade(id);
	}

	private int lerOpcao(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.print("Por favor, digite um número: ");
			scanner.next();
		}
		int opcao = scanner.nextInt();
		scanner.nextLine();
		return opcao;
	}
}
