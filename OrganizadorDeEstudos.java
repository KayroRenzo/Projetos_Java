package projetos;

import java.util.ArrayList;
import java.util.Scanner;

public class OrganizadorDeEstudos {
    public static void main(String[] args) {
        ArrayList<String> dias = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("== ORGANIZADOR DE ESTUDOS ==");

        while (true) {
            System.out.println("\n1 - Adicionar dia");
            System.out.println("2 - Ver dias");
            System.out.println("3 - Ver percentual");
            System.out.println("4 - Marcar como concluido");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o dia: ");
                String dia = input.nextLine();
                dias.add(dia);
                status.add("Pendente");
                System.out.println("Dia adicionado!");

            } else if (opcao == 2) {
                System.out.println("\n=== DIAS ===");
                if (dias.isEmpty()) {
                    System.out.println("Nenhum dia cadastrado!");
                } else {
                    for (int i = 0; i < dias.size(); i++) {
                        System.out.println(i + " - " + dias.get(i) + " - " + status.get(i));
                    }
                }

            } else if (opcao == 3) {
                System.out.println("\n=== PERCENTUAL ===");
                if (dias.isEmpty()) {
                    System.out.println("Nenhum dia cadastrado!");
                } else {
                    int pendentes = 0;
                    for (int i = 0; i < status.size(); i++) {
                        if (status.get(i).equals("Pendente")) {
                            pendentes++;
                        }
                    }
                    int total = status.size();
                    int concluidos = total - pendentes;
                    double percentual = (concluidos * 100.0) / total;
                    System.out.println("Total: " + total);
                    System.out.println("Concluidos: " + concluidos);
                    System.out.println("Percentual: " + percentual + "%");
                }

            } else if (opcao == 4) {
                System.out.println("\n=== MARCAR CONCLUIDO ===");
                if (dias.isEmpty()) {
                    System.out.println("Nenhum dia cadastrado!");
                } else {
                    // Mostra só os pendentes
                    System.out.println("Dias pendentes:");
                    for (int i = 0; i < dias.size(); i++) {
                        if (status.get(i).equals("Pendente")) {
                            System.out.println(i + " - " + dias.get(i));
                        }
                    }
                    System.out.print("Digite a posicao: ");
                    int posicao = input.nextInt();
                    input.nextLine();

                    if (posicao >= 0 && posicao < dias.size()) {
                        if (status.get(posicao).equals("Pendente")) {
                            status.set(posicao, "Concluido");
                            System.out.println("Dia marcado como concluido!");
                        } else {
                            System.out.println("Esse dia ja foi concluido!");
                        }
                    } else {
                        System.out.println("Posicao invalida!");
                    }
                }

            } else if (opcao == 5) {
                System.out.println("Saindo...");
                input.close();
                break;

            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }
}
