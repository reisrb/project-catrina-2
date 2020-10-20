package br.com.bandtec.catrinac2.lista;

import br.com.bandtec.catrinac2.dominios.Robo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exportar {
  public static String toCsv(ListaObj<Robo> lista) {
    String arquivoCsv = "";

    arquivoCsv += String.format("%s;%s;%s;%s%n", "ID", "Nome", "Fabricante","Pais");

    for (int i = 0; i < lista.getTamanho(); i++) {
      Robo robo = lista.getElemento(i);

      arquivoCsv += String.format("%d;%s;%s;%s;%n",
              robo.getId(), robo.getNome(), robo.getFabricante().getNome(),
              robo.getFabricante().getPais().getNome()
      );
    }

    return arquivoCsv;
  }

  public static String toTxt(ListaObj<Robo> lista) {
    String arquivoTxt = "";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Date date = new Date();

    arquivoTxt += String.format("00ROBOS%s\n",simpleDateFormat.format(date));

    for (int i = 0; i < lista.getTamanho(); i++) {
      Robo robo = lista.getElemento(i);

      arquivoTxt += String.format("02%-25s%-25s%-20s%n",
              robo.getNome(), robo.getFabricante().getNome(),
              robo.getFabricante().getPais().getNome()
      );
    }

    arquivoTxt += String.format("01%010d\n",lista.getTamanho());

    return arquivoTxt;
  }
}
