package poa.controle;

import poa.dominio.Tarefa;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlaAgenda {
    private final ArrayList<Tarefa> agendamentos;
    private final String arquivoAgendas = "tarefas.txt";

    public ControlaAgenda() {
        this.agendamentos = new ArrayList<>();
        carregarAgendas();
    }

    public void adicionarAgenda(String jogo, String data, String nickname) {
        Tarefa Tarefa = new Tarefa(jogo, data, nickname);
        agendamentos.add(Tarefa);
        salvarAgendas();
    }

    public void excluirAgenda(String data) {
        Tarefa task = buscarAgenda(data);

        if (task != null) {
            agendamentos.remove(task);
            salvarAgendas();
        } else {
            System.out.println("Tarefa nao encontrado!");
        }
    }

    public void listarTodosTarefas() {
        if (agendamentos.isEmpty()) {
            System.out.println("lista vazia");
        }else{
            for (Tarefa Tarefa : agendamentos) {
                Tarefa.listarTarefa();
            }
        }
    }

    public void listarUmAgenda(String data) {
        Tarefa task = buscarAgenda(data);

        if (task != null) {
            task.listarTarefa();
        }else{
            System.out.println("Tarefa nao encontrada");
        }
    }

    public void alterarAgenda(String data1) {
        Tarefa task = buscarAgenda(data1);

        if (task != null) {
            Scanner in = new Scanner(System.in);

            System.out.println("Insira uma nova data: ");
            String data = in.next();
            System.out.println("Insira um novo jogo: ");
            String jogo = in.next();
            System.out.println("Insira um novo nick: ");
            String nickname = in.next();

            task.setData(data);
            task.setJogo(jogo);
            task.setNickname(nickname);

            salvarAgendas();

            in.close();
        } else {
            System.out.println("Tarefa nao encontrado!");
        }

    }

    private Tarefa buscarAgenda(String data) {
        for (Tarefa task : agendamentos) {
            if (task.getData().equals(data)){
                return task;
            }
        }

        return null;
    }

    private void salvarAgendas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoAgendas))) {
            for (Tarefa Tarefa : agendamentos) {
                writer.write(Tarefa.getJogo() + ";" + Tarefa.getData() + ";" + Tarefa.getNickname());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar agendamentos: " + e.getMessage());
        }
    }

    private void carregarAgendas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoAgendas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String jogo = dados[0];
                String data = dados[1];
                String nickname = dados[2];
                agendamentos.add(new Tarefa(jogo, data, nickname));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de agendamentos não encontrado. Será criado ao salvar novos agendamentos.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar agendamentos: " + e.getMessage());
        }
    }

    private void limparTodasTarefas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoAgendas, false))) {
            System.out.println("Arquivo limpo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao limpar o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ControlaAgenda control = new ControlaAgenda();
        Scanner in = new Scanner(System.in);
        int op;

        String jogo;
        String data;
        String nickname;

        do {

            System.out.println("\n---------MENU-----------");
            System.out.println("1: Adicionar Tarefa");
            System.out.println("2: Alterar Tarefa");
            System.out.println("3: Excluir Tarefa");
            System.out.println("4: Listar um Tarefa");
            System.out.println("5: Listar todos Tarefas");
            System.out.println("6: Limpar todas Tarefas");
            System.out.println("0: Sair");
            System.out.println("Selecione uma opcao: ");
            op = in.nextInt();
            System.out.println("------------------------");

            switch(op) {
                case 0:
                    break;
                case 1:
                    System.out.println("Insira o jogo: ");
                    jogo = in.next();
                    in.nextLine();
                    System.out.println("Insira a data(00/00/0000: ");
                    data = in.next();
                    System.out.println("Insira o nickname do amigo: ");
                    nickname = in.next();

                    control.adicionarAgenda(jogo, data, nickname);
                    break;

                case 2:
                    System.out.println("Insira a data da Tarefa a ser alterado: ");
                    data = in.next();

                    control.alterarAgenda(data);
                    break;

                case 3:
                    System.out.println("Insira a data da Tarefa a ser excluida: ");
                    data = in.next();

                    control.excluirAgenda(data);
                    break;

                case 4:
                    System.out.println("Insira a data da Tarefa a ser listada: ");
                    data = in.next();

                    control.listarUmAgenda(data);
                    break;

                case 5:
                    control.listarTodosTarefas();
                    break;

                case 6:
                    control.limparTodasTarefas();
                    break;

                default:
                    System.out.println("Opcao invalida!!");
                    break;
            }

        } while(op != 0);

        in.close();
    }
}