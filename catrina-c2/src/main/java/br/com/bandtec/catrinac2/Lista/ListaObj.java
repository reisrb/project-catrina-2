package br.com.bandtec.catrinac2.Lista;

public class ListaObj<T> {
    private T[] vetor;
    private int nroElem;

    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }

    public boolean adiciona(T elem) {
        vetor[nroElem] = elem;
        nroElem++;
        return true;
    }

    public void exibe() {
        for (int i = 0; i < nroElem; i++) {
            System.out.println(vetor[i]);
        }

    }

    public int busca(T elem) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int elem) {
        if (elem < nroElem) {
            for (int i = elem; i < vetor.length - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            nroElem--;
            return true;
        }

        return false;
    }

    public boolean removeElemento(T elem) {

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(elem)) {
                for (int e = i; e < vetor.length - 1; e++) {
                    vetor[e] = vetor[e + 1];
                }
                nroElem--;
                return true;
            }
        }
        return false;
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        } else {
            return vetor[indice];
        }
    }

    public void limpa() {
        nroElem = 0;
    }
}
