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
public class Auxiliar {

    /**
     * @param args the command line arguments
     */
    
    
   public String geradorDeMensagem(int tamanho){ //tamanho em bytes
       String mensagemGerada = "";
       Random gerador = new Random();
       for (int i = 0; i < tamanho*8; i++) {    //tamanho em bytes
          mensagemGerada += gerador.nextInt(2);
       }
       return mensagemGerada;
   }
   
   public String geradorDeErro(String mensagem, int tamanho, double p){ //tamanho em bytes
       String mensagemErrada;
       do{
       mensagemErrada = "";
       for (int i = 0; i < tamanho*8; i++) {  //tamanho em bytes
           if (Math.random()<=p) {
               if ( mensagem.substring(i, i+1).equals("0")) {
                   mensagemErrada += "1";
               }else
                   mensagemErrada += "0";
           }else{
               mensagemErrada += mensagem.substring(i, i+1);
           }
       }
       }while(mensagem.equals(mensagemErrada));
       return mensagemErrada;
   }
    
}
