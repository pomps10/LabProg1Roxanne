/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exerciciolab;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FelipePompeuBelinatt
 */
public class LetraDaMusica {

    public static void ler() throws IOException {

        File f = new File("C:\\Users\\FelipePompeuBelinatt\\Documents\\NetBeansProjects\\ExercicioLab\\src\\main\\java\\com\\mycompany\\exerciciolab\\Exercicio.txt");
        Scanner s = new Scanner(f);
        StringBuffer letra = new StringBuffer();

        while (s.hasNextLine()) {
            letra.append(" " + s.nextLine());
        }
        s.close();
        String letraDaMusica = letra.toString();
        salvarDoisFiles(letraDaMusica);

    }

    public static void salvarDoisFiles(String texto) throws IOException {

        /*
		 * A partir do Java 5, temos a classe java.util.Scanner, que facilita 
		 * bastante o trabalho de ler de um InputStream. AleÌ�m disso, a classe 
		 * PrintStream possui um construtor que jaÌ� recebe o nome de um arquivo 
		 * como argumento.
         */
        PrintStream ps = new PrintStream("C:\\Users\\FelipePompeuBelinatt\\Documents\\NetBeansProjects\\ExercicioLab\\src\\main\\java\\com\\mycompany\\exerciciolab\\letraNova.txt");
        PrintStream ps2 = new PrintStream("C:\\Users\\FelipePompeuBelinatt\\Documents\\NetBeansProjects\\ExercicioLab\\src\\main\\java\\com\\mycompany\\exerciciolab\\letraSemRoxanne.txt");
        PrintStream ps3 = new PrintStream("C:\\Users\\FelipePompeuBelinatt\\Documents\\NetBeansProjects\\ExercicioLab\\src\\main\\java\\com\\mycompany\\exerciciolab\\letraOriginal.txt");
        ps.println(texto);
        ps2.println(texto);
        ps3.println(texto);
        ps.close();
        ps2.close();
        ps3.close();
    }

    public static String getTxt(String txtName) throws FileNotFoundException {

        String realPath = "C:\\Users\\FelipePompeuBelinatt\\Documents\\NetBeansProjects\\ExercicioLab\\src\\main\\java\\com\\mycompany\\exerciciolab\\" + txtName;
        File f = new File(realPath);
        Scanner s = new Scanner(f);

        StringBuffer letra = new StringBuffer();

        while (s.hasNextLine()) {
            letra.append(" " + s.nextLine());
        }
        s.close();
        String letraDaMusica = letra.toString();
        return letraDaMusica;

    }

    public static void saveTxt(String txtName, String letraDaMusica) throws FileNotFoundException{
        
        PrintStream ps = new PrintStream("C:\\Users\\FelipePompeuBelinatt\\Documents\\NetBeansProjects\\ExercicioLab\\src\\main\\java\\com\\mycompany\\exerciciolab\\" + txtName);
        ps.println(letraDaMusica);
        ps.close();
    }
    
    

}
