/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacaodeerro;

/**
 *
 * @author Guilherme
 */
public class CRC {
    public String crc(String mensagem,int tamanho,String gerador){ //tamanho em bytes
        int aux = Integer.parseInt(gerador, 16);//passa um hexadecimal para inteiro
        gerador = Integer.toBinaryString(aux);//passa de decimal para binario
        String crc="00000000";
        mensagem +=crc;
        while(mensagem.length()!= tamanho*8-8) {
            if (mensagem.substring(0,1).equalsIgnoreCase("0")) {
                mensagem=mensagem.substring(1);
            }else{
                mensagem=somaComplementoDois(mensagem,gerador);
            
            }
        }
        crc = mensagem;//só pra ficar mais legível
        return crc;
    }

    public String somaComplementoDois(String mensagem, String gerador) {
        String resposta = "";
        for (int i = 0; i < gerador.length(); i++) {
            if (mensagem.substring(i, i+1).equalsIgnoreCase("0") & gerador.substring(i, i+1).equalsIgnoreCase("0")) {
                resposta +="0";
            }else if (mensagem.substring(i, i+1).equalsIgnoreCase("1") & gerador.substring(i, i+1).equalsIgnoreCase("1")) {
                resposta +="0";
            }else{
                resposta +="1";
            }
        }
        resposta +=mensagem.substring(gerador.length());
        return resposta;
    }
}
