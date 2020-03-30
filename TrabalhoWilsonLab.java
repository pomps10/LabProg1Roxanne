
package com.mycompany.exerciciolab;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class TrabalhoWilsonLab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Ao iniciar do código, sera gerar as letras em sua maneira default
        criarTxt();
        
        //Instanciar variaveis
        String txtNome;
        String replacementValue;
        String i = "";
        
        //Menu
        while (!i.equals("x")) {
            System.out.println("a. Remover Roxanne;\n"
                    + "b. Substituir Roxanne;\n"
                    + "c. Contar Roxanne;\n"
                    + "d. Imprimir letra original;\n"
                    + "e. Imprimir letra nova;\n"
                    + "f. Imprimir letra sem Roxanne;\n"
                    + "x. Para sair do codigo;\n"
                    + "Escolha a opção do menu que voce gostaria de acessar");
            i = scanner.nextLine();

            //Menu
            try {
                switch (i) {
                    case "a":
                        txtNome = "letraSemRoxanne.txt";
                        replacementValue = "";
                        //chama a function de Remover Roxanne
                        alterarRoxanne(txtNome, replacementValue);
                        break;

                    case "b":
                        txtNome = "letraNova.txt";
                        System.out.println("Voce gostaria de substituir Roxanne por qual palava?");
                        replacementValue = scanner.nextLine();
                        //chama a function de Substituir Roxanne
                        alterarRoxanne(txtNome, replacementValue);
                        break;

                    case "c":
                        txtNome = "letraSemRoxanne.txt";
                        //Contar quantidades de Roxanne
                        contarRoxanne(txtNome);
                        break;

                    case "d":
                        txtNome = "letraOriginal.txt";
                        //Contar quantidades de Roxanne
                        mostrarLetra(txtNome);
                        break;

                    case "e":
                        txtNome = "letraNova.txt";
                        //Contar quantidades de Roxanne
                        mostrarLetra(txtNome);
                        break;

                    case "f":
                        txtNome = "letraSemRoxanne.txt";
                        //Contar quantidades de Roxanne
                        mostrarLetra(txtNome);
                        break;

                    default:

                }
            } catch (RoxanneException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public static void alterarRoxanne(String txtNome, String replacementValue) throws RoxanneException {
        try {

            String letraDaMusica = LetraDaMusica.getTxt(txtNome);

            //Checar se Roxanne existe no texo, caso não exista da erro
            checarRoxanne(letraDaMusica);

            letraDaMusica = letraDaMusica.replace("Roxanne", replacementValue);
            LetraDaMusica.saveTxt(txtNome, letraDaMusica);

            if (replacementValue.equals("")) {
                System.out.println("Pronto! Você acabou de remover Roxanne da música!");
            } else {
                System.out.println("Pronto! Você acabou de substituir Roxanne da música!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro! " + e.getMessage());
        }
    }

    public static void criarTxt() {
        try {
            LetraDaMusica.ler();
        } catch (IOException e) {
            System.out.println("Erro! " + e.getMessage());
        }
    }

    //Verificar se existe Roxanne na musica
    public static void checarRoxanne(String letraDaMusica) throws RoxanneException {
        if (!letraDaMusica.contains("Roxanne")) {
            throw new RoxanneException();
        }
    }

    public static void contarRoxanne(String txtNome) throws RoxanneException {
        try {

            String letraDaMusica = LetraDaMusica.getTxt(txtNome);

            //Checar se Roxanne existe no texo, caso não exista da erro
            checarRoxanne(letraDaMusica);

            int count = letraDaMusica.length() - letraDaMusica.replace("Roxanne", "").length();
            System.out.println("A palavra Roxanne apareceu " + count + " vezes no codigo!");
        } catch (FileNotFoundException e) {
            System.out.println("Erro! " + e.getMessage());
        }
    }

    public static void mostrarLetra(String txtNome) {
        try {

            String letraDaMusica = LetraDaMusica.getTxt(txtNome);
            System.out.println(letraDaMusica);
        } catch (FileNotFoundException e) {
            System.out.println("Erro! " + e.getMessage());
        }
    }
}
