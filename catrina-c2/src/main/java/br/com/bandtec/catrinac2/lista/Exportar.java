package br.com.bandtec.catrinac2.lista;

import br.com.bandtec.catrinac2.dominios.Robo;

public class Exportar {
  public static String toCsv(ListaObj<Robo> lista) {
    String arquivo = "";

    arquivo += String.format("%s;%s;%s%n", "ID", "Nome", "Pais");

    for (int i = 0; i < lista.getTamanho(); i++) {
      Robo robo = lista.getElemento(i);

      arquivo += String.format("%d;%s;%s;%n",
              robo.getId(), robo.getNome(), robo.getFabricante().getNome(), robo.getFabricante().getPais().getNome()
      );
    }

    return arquivo;
  }

  public static String toTxt(ListaObj<Robo> lista) {

    return "Arquivo txt";
  }
}
