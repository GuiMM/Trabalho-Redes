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
public class CheckSum {
    
    
    
    String inverteBits(String mensagem){
        String mensagemInvertida="";
        int inverso = Integer.parseInt(mensagem);
            for (int i = 0; i < mensagem.length(); i++) {
                if (Integer.parseInt(mensagem.substring(i, i+1))==0) {
                    mensagemInvertida +="1";
                }else
                    mensagemInvertida +="0";
            }
        return mensagemInvertida;
    }
    String checksum(String mensagemEnviada, int tamanho){ //tamanho em bytes
        String [] mensagem = new String[tamanho];
        String checksum ="00000000";
        for (int i = 0; i < tamanho; i++) {  
            mensagem[i] = mensagemEnviada.substring(i*8, i*8+8); 
        }  
        for (int j = 0; j < tamanho; j++) {
            checksum = somaBits(checksum,mensagem[j]);
        }
        checksum = inverteBits(checksum);
        return checksum;
    }
    
    String somaBits(String msgm1, String msgm2){
        String resposta="";
        boolean vaiUm = false;
        for (int i = msgm1.length()-1 ; i >= 0; i--) {
            if (msgm1.substring(i, i+1).equalsIgnoreCase("0") & msgm2.substring(i, i+1).equalsIgnoreCase("0") & !vaiUm) {
               resposta="0"+resposta;
               vaiUm=false;
            }else if (msgm1.substring(i, i+1).equalsIgnoreCase("0") & msgm2.substring(i, i+1).equalsIgnoreCase("0") & vaiUm) {
               resposta="1"+resposta; 
               vaiUm=false;
            }else if (msgm1.substring(i, i+1).equalsIgnoreCase("1") & msgm2.substring(i, i+1).equalsIgnoreCase("1") & !vaiUm) {
                vaiUm=true;
                resposta="0"+resposta;
            }else if (msgm1.substring(i, i+1).equalsIgnoreCase("1") & msgm2.substring(i, i+1).equalsIgnoreCase("1") & vaiUm) {
                vaiUm=true;
                resposta="1"+resposta;
            }else if (vaiUm) {
                vaiUm=true;
                resposta="0"+resposta;
            }else{
                resposta="1"+resposta;
            }
        }      
        
    
        return resposta;
    }
    
    public void simulacao(int tamanho,int quantidadePacotes,double probabilidade,int semente){
        String mensagem = "";
        String checksumCerto = "";
        String mensagemcorrompida = "";
        String checksumErrado = "";
        Auxiliar aux = new Auxiliar();
        int contadorDeColisao = 0;
        mensagem = aux.geradorDeMensagem(tamanho, semente);
        checksumCerto = checksum(mensagem,tamanho);
        double taxaColisao = 0.0;
        for (int i = 0; i < quantidadePacotes; i++) {
            mensagemcorrompida = aux.geradorDeErro(mensagem, tamanho, probabilidade);
            checksumErrado = checksum(mensagemcorrompida,tamanho);
            if (checksumCerto.equalsIgnoreCase(checksumErrado)) {
                contadorDeColisao++;
            }
        }
        taxaColisao = contadorDeColisao/quantidadePacotes;
        System.out.println(taxaColisao);
    }
}
