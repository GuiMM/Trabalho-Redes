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
        // TODO code application logic here
        String s ="01100001011000100110001101100100"; 
        String resultado = "";
        
        CheckSum verifica = new CheckSum();
        Auxiliar teste = new Auxiliar();
        
        Random gerador = new Random();
        String vamo = teste.geradorDeMensagem(2,10000);
        System.out.println(vamo);
        System.out.println(verifica.checksum(vamo, vamo.length()/8));
        String VamoErrada = teste.geradorDeErro(vamo, vamo.length()/8, 0.5);
        System.out.println(VamoErrada);
        CRC teste2 = new CRC();
        System.out.println(teste2.crc(vamo,2, "121"));
        
        int aux = Integer.parseInt("12a", 16);//passa um hexadecimal para inteiro
         System.out.println(Integer.toBinaryString(aux));;//passa de decimal para binario
    }
}
