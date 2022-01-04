package dio.listaCircular;

public class Exec {

	public static void main(String[] args) {
		
		ListaCircular<String> ListaCircular = new ListaCircular<>();
		
		ListaCircular.add("primeiro-No");
		ListaCircular.add("segundo-No");
		ListaCircular.add("terceiro-No");
		ListaCircular.add("quarto-No");
		ListaCircular.add("quinto-No");
		
		System.out.println(ListaCircular);
		
		ListaCircular.remove(0);
		
		
		System.out.println(ListaCircular);

	}

}
