package dio.listaCircular;

public class ListaCircular<T> {

	

	private No<T> cabeca;
	
	private No<T> cauda;
	
	private int tamanhoLista;
	
	public ListaCircular() {
		this.cabeca = null;
		this.cauda = null;
		this.tamanhoLista = 0;
	}
	
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
	
	// adiciona um item a partir da cauda
	public void add(T conteudo) {
		No<T> novoNo = new No<> (conteudo);
		if (this.tamanhoLista == 0) {
			this.cabeca = novoNo;
			this.cauda = this.cabeca;
			this.cabeca.setNoProximo(cauda);
		}else {
			novoNo.setNoProximo(cauda);
			this.cabeca.setNoProximo(novoNo);
			this.cauda = novoNo;
		}
		this.tamanhoLista++;
	}
	
	// remove um No em determinado indice passado
	public void remove(int index) {
		No<T> noAuxiliar = this.cauda;
		if (index >= this.tamanhoLista) {
			throw new  IndexOutOfBoundsException("O indice é maior que o tamanho da lista.");
			
		}
		if (index == 0) {
			this.cauda = this.cauda.getNoProximo();
			this.cabeca.setNoProximo(this.cauda);
		}
		if (index == 1) {
			this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
		}else {
			for (int i = 0; i < index; i++) {
				noAuxiliar = noAuxiliar.getNoProximo();
			}
			noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
		}
		this.tamanhoLista--;
	}
	
	@Override
	public String toString() {
		String strRetorno = "";
		
		No<T> noAuxiliar = this.cauda;
		for (int i = 0; i < this.size(); i++) {
			strRetorno += "No [ conteudo = " + noAuxiliar.getConteudo() + "] ==> ";
			
			noAuxiliar = noAuxiliar.getNoProximo();
		}
		
		strRetorno += this.isEmpt() ? "[]" : "( Apontando para o Inicio )";
		
		return strRetorno;
	}
	
}
