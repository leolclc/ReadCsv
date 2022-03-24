
package readcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadCsvMaven {

  
    public static void main(String[] args) {
        // TODO code application logic here
        
       try {
            
            List<Item> listaItens = new ArrayList();
            File fileCsv = new File("\\JogosDesordenados.csv");
            String linha = "";
            Scanner leitor = new Scanner(fileCsv);
                while(leitor.hasNext()){
                    linha = leitor.nextLine();


                    String [] jogo = linha.split(",");

                    listaItens.add(new Item(jogo[0],jogo[1],Double.parseDouble(jogo[2])));


                        for(int i=0; i<listaItens.size(); i++){

                            for(int j = i+1; j<listaItens.size(); j++){
                                String categoriaA = listaItens.get(j).getCategoria();
                                String categoriaB = listaItens.get(i).getCategoria();    
                                    if(categoriaA.compareTo(categoriaB)< 1){
                                        Item temp = listaItens.get(i);
                                        listaItens.set(i, listaItens.get(j));
                                        listaItens.set(j, temp);
                      }
}
     
    }
            
            
}
   for(int t = 0; t < listaItens.size(); t++){
         System.out.println(listaItens.get(t).getJogo());

                     }     
        
    }catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCsvMaven.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}