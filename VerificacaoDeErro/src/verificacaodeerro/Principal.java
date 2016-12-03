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
        int tamanhoPacote = 23;
        int quantidadePacotes=100000;
        double probabilidadeDeErro = 0.5;
        int sementeRandom = 2345;
        String geradorHex = "121";
        verificaCheck.simulacao(tamanhoPacote, quantidadePacotes, probabilidadeDeErro, sementeRandom);
        verificaCrc.simulacao(tamanhoPacote, quantidadePacotes, probabilidadeDeErro, sementeRandom, geradorHex);
    }
}
