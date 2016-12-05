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
    
    public void simulacao(int tamanho,double quantidadePacotes,double probabilidade,int semente, String geradorHex){
       long tStart = System.currentTimeMillis();
        String mensagem = "";
        String crcCerto = "";
        String mensagemcorrompida = "";
        String crcErrado = "";
        Auxiliar aux = new Auxiliar();
        double contadorDeColisao = 0;
        mensagem = aux.geradorDeMensagem(tamanho, semente);
        crcCerto = crc(mensagem,tamanho,geradorHex);
        double taxaColisao = 0.0;
        for (int i = 0; i < quantidadePacotes; i++) {
            mensagemcorrompida = aux.geradorDeErro(mensagem, tamanho, probabilidade);
            crcErrado = crc(mensagemcorrompida,tamanho,geradorHex);
            if (crcCerto.equalsIgnoreCase(crcErrado)) {
                contadorDeColisao++;
            }
        }
        
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        taxaColisao = (contadorDeColisao/quantidadePacotes) * 100;
        System.out.println("A taxa de colisão do Checksum é: "+taxaColisao+"%");
        System.out.println("Tempo em segundos: "+elapsedSeconds);
    }
}
