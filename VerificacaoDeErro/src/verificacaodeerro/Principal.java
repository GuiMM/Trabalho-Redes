/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacaodeerro;

import java.util.Random;

/**
 *
 * @author Guilherme
 */
public class Principal {
     public static void main(String[] args) {  
        CheckSum verificaCheck = new CheckSum();
        CRC verificaCrc = new CRC();
        int tamanhoPacote = 100;
        int quantidadePacotes=10000;
        double probabilidadeDeErro = 0.25;
        int sementeRandom = 222;
        String geradorHex = "9B";
        verificaCheck.simulacao(tamanhoPacote, quantidadePacotes, probabilidadeDeErro, sementeRandom);
        verificaCrc.simulacao(tamanhoPacote, quantidadePacotes, probabilidadeDeErro, sementeRandom, geradorHex);
    }
}
