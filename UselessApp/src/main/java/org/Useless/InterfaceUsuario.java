package org.Useless;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    soloRachelDAO dao;
    Scanner in;

    public InterfaceUsuario(soloRachelDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Inserir novo solo");
            System.out.println("\t2. Listar todos os solos");
            System.out.println("\t3. Alterar dados de um solo");
            System.out.println("\t4. Apagar um solo");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();

            in.nextLine();

            switch (opc) {
                case 1:
                    this.novoSolo();
                    break;
                case 2:
                    this.listar();
                    break;
                case 3:
                    this.alterarSolo();
                    break;
                case 4:
                    this.apagarSolo();
                    break;
                case 5:
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (opc != 5);
    }

    private void novoSolo() {
        soloRachel solo = new soloRachel();

        System.out.println("\n***********************");
        System.out.println("*** Inserir novo solo ***");
        System.out.println("*************************");

        System.out.print("\nInforme o NUMERO DO EPISODIO (Ex: 0103): ");
        solo.setnEpisodio(in.nextInt());
        in.nextLine();

        System.out.print("Informe a MUSICA: ");
        solo.setMusica(in.nextLine());

        System.out.print("Informe de quem é a VERSÃO ORIGINAL: ");
        solo.setVersaoOriginal(in.nextLine());

        System.out.print("Informe a NOTA que você daria pro solo: ");
        solo.setNota(in.nextInt());


        if (dao.novoSolo(solo)) {
            System.out.println("\nSolo adicionado ao banco de Dados");
        } else {
            System.out.println("\nOps: problema ao adicionar o pais");
        }
    }
    private void listar() {
        List<soloRachel> solos = dao.listar();

        System.out.println("\n***********************************");
        System.out.println("*** Solos da Rachel cadastrados ****");
        System.out.println("***********************************");
        for(soloRachel solo : solos) {
            System.out.println(solo);
        }
    }
    private void alterarSolo() {
        soloRachel solo = new soloRachel();
        List<soloRachel> solos = dao.listar();

        while (true) {
            //Mostra todos os solos cadastrados
            System.out.println("\n***********************************");
            System.out.println("*** Solos da Rachel cadastrados ****");
            System.out.println("***********************************");

            int i = 0;
            for (soloRachel solo1 : solos) {
                System.out.println(i + " - " + solo1);
                i++;
            }
            System.out.println(+i + " - Cancelar operação");

            //escolhe qual solo quer alterar os dados

            System.out.print("\nDe qual solo deseja alterar os dados?: ");
            int opc = in.nextInt();
            in.nextLine();

            System.out.print("\nInforme a MUSICA: ");
            solo.setMusica(in.nextLine());

            System.out.print("Informe de quem é a VERSÃO ORIGINAL: ");
            solo.setVersaoOriginal(in.nextLine());

            System.out.print("Informe a NOTA que você daria pro solo: ");
            solo.setNota(in.nextInt());

            System.out.print("Informe o NUMERO DO EPISODIO (Ex: 0103): ");
            solo.setnEpisodio(in.nextInt());

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= solos.size() || opc < 0) {
                System.out.println("\nEsta opção não é válida");
            } else {
                if (dao.alterarSolo(solo)) {
                    System.out.println("\nDados de "+solo.getMusica()+" alterados!");
                } else {
                    System.out.println("\nOPS: falar ao tentar alterar dados");
                }
                break;
            }
        }
    }
    private void apagarSolo() {
        List<soloRachel> solos = dao.listar();

        while (true) {
            //Mostra todos os solos cadastrados
            System.out.println("\n***********************************");
            System.out.println("*** Solos da Rachel cadastrados ****");
            System.out.println("***********************************");

            int i = 0;
            for (soloRachel solo1 : solos) {
                System.out.println(i + " - " + solo1);
                i++;
            }

            System.out.println(i + " - Cancelar operação");

            System.out.print("\nQual solo deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= solos.size() || opc < 0) {
                System.out.println("\nEsta opção não é válida");
            } else {
                if (dao.apagarSolo(solos.get(opc))) {
                    System.out.println("\n"+solos.get(opc).getMusica()+
                            " removido com sucesso");
                } else {
                    System.out.println("\nOPS: falar ao tentar remover");
                }
                //Isso para o while infinito
                break;
            }
        }
    }


}
