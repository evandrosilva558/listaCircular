package dio.listaCircular;

public class ListaCircular<T> {

	private No<T> cabeca;
	
	private No<T> cauda;
	
	private int tamanhoLista;
	
	// matodo que retorna o conteudo da lista
	public T get(int index) {
		return getNo(index).getConteudo();
	}
	
	// metodo que retorna a lista
	private No<T> getNo(int index) {
		if (this.isEmpt()) {
			throw new IndexOutOfBoundsException("A lista está vazia.");
		}
		if (index == 0) {
			return this.cauda;
		}
		No<T> noAuxiliar = this.cauda;
		for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
			noAuxiliar = noAuxiliar.getNoProximo();
		}
		return noAuxiliar;
	}
	
	// metodo que testa se a lista esta vazia
	public boolean isEmpt() {
		return this.tamanhoLista == 0 ? true : false;
	}
	
	// retorna o tamanho da lista
	public int size() {
		return this.tamanhoLista;
	}
	
}
