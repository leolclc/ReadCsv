package readcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ReadCsvMaven {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        try {

            List<Item> listaItens = new ArrayList();

            LerArquivoCSV(listaItens);

            OrdenarListaPorCategoria(listaItens);

            System.out.println("*****Ordenação por Categoria*****");

            for (int i = 0; i < listaItens.size(); i++) {
                System.out.println("Jogo:" + listaItens.get(i).getJogo()
                        + ", Categoria:" + listaItens.get(i).getCategoria()
                        + "Nota:" + listaItens.get(i).getNota());
            }
            System.out.println("*****Ordenação por Categoria e Nota*****");

            OrdenarListaPorNota(listaItens);

            for (int i = 0; i < listaItens.size(); i++) {
                System.out.println("Jogo:" + listaItens.get(i).getJogo()
                        + ", Categoria:" + listaItens.get(i).getCategoria()
                        + "Nota:" + listaItens.get(i).getNota());

            }

            EscreverArquivoCSV(listaItens);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCsvMaven.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Lê o arquivo CSV no diretório

    public static void LerArquivoCSV(List<Item> listaItens) throws Exception {
        try {

            File fileCsv = new File("C:\\Users\\leandro.cardoso\\Documents\\NetBeansProjects\\ReadCsvMaven\\src\\readcsv\\files\\JogosDesordenados.csv");
            String linha = "";
            Scanner leitor = new Scanner(fileCsv);
            while (leitor.hasNext()) {
                linha = leitor.nextLine();

                String[] jogo = linha.split(",");

                listaItens.add(new Item(jogo[0], jogo[1], Double.parseDouble(jogo[2])));

            }
        } catch (FileNotFoundException e) {
            throw e;

        }
    }

    //Escreve o arquivo CSV no diretório
    public static void EscreverArquivoCSV(List<Item> listaItens) throws Exception {

        FileWriter writer = new FileWriter("C:\\Users\\leandro.cardoso\\Documents\\NetBeansProjects\\ReadCsvMaven\\src\\readcsv\\files\\JogosOrdenados.csv");

        String collect = listaItens.stream()
                .map(item -> item.getJogo() + ", " + item.getCategoria() + ", " + item.getNota() + "\n")
                .collect(Collectors.joining(""));

        writer.write(collect);
        writer.close();
    }

    //Ordena os jogos por Categoria
    public static void OrdenarListaPorCategoria(List<Item> listaItens) {
        for (int i = 0; i < listaItens.size(); i++) {
            for (int j = i + 1; j < listaItens.size(); j++) {
                String categoriaA = listaItens.get(j).getCategoria();
                String categoriaB = listaItens.get(i).getCategoria();
                if (categoriaA.compareTo(categoriaB) < 1) {
                    Item temp = listaItens.get(i);
                    listaItens.set(i, listaItens.get(j));
                    listaItens.set(j, temp);
                }
            }
        }
    }

    //Ordena os jogos por Categoria e Nota
    public static void OrdenarListaPorNota(List<Item> listaItens) {
        for (int i = 0; i < listaItens.size(); i++) {
            for (int j = i + 1; j < listaItens.size(); j++) {
                Item itemA = listaItens.get(j);
                Item itemB = listaItens.get(i);
                if (itemA.getNota() < itemB.getNota()
                        && itemA.getCategoria() == itemB.getCategoria()) {
                    Item temp = listaItens.get(i);
                    listaItens.set(i, listaItens.get(j));
                    listaItens.set(j, temp);
                }
            }
        }
    }
}
