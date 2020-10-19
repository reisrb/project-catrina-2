package br.com.bandtec.catrinac2.Lista;

import br.com.bandtec.catrinac2.dominios.Fabricante;

public class Exportar {
  public static String csv(ListaObj<Fabricante> lista) {
    String arquivo = "";

    arquivo += String.format("%s;%s;%s%n", "ID", "Nome", "Pais"
    );

    for (int i = 0; i < lista.getTamanho(); i++) {
      Fabricante fabricante = lista.getElemento(i);

      arquivo += String.format("%d;%s;%s;%n",
              fabricante.getId(), fabricante.getNome(), fabricante.getPais().getNome()
      );
    }

    return arquivo;
  }

  public static String txt(ListaObj<Fabricante> lista) {

    return "Arquivo txt";
  }
}
