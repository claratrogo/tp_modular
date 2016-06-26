/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_modular;

import java.io.IOException;

/**
 *
 * @author clara
 */
public class Main {
     public static void main(String[] args) throws IOException {
        System.out.println("hello");
        Orcamento orc = new Orcamento(1, 10, 29, 30, false);
        //orc.CriarOrcamento();
        orc.EscreverArquivo("/home/clara/arquivo.txt");
       
    }
}
