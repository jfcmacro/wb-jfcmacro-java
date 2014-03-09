/*
 * Esta clase crea una ventana con un area de texto para 
 * mostrar un String que es enviado como parametro de la
 * constructora
 */


/*
 * Se importan los paquetes necesarios para la distribucion,
 * ordenamiento, ubicacion y utilizacion de los objetos
 * necesarios de la interfaz
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class VLista extends JFrame{

	public VLista(String lista) {
		
		getContentPane().setLayout(new BorderLayout());
		
		String fin;
		
		// Si la cadena que llega desde el parametro es una cadena vacia,
		// se mostrara un mensaje predeterminado
		if(lista.length()==0){
			fin = "No hay resultados que mostrar";
		}else{
			fin = lista;
		}
		
		// El JTextArea muestra el contenido del String que se pase por
		// parametro en su constructora
		JTextArea listado = new JTextArea(fin);
		
		// Agregamos el JTextArea en un JScrollPane, que genera automaticamente
		// una barra de desplazamiento vertical u horizontal cuando el 
		// String mostrado en el JTextArea no cabe en el tamaño de la ventana
		JScrollPane desplaza = new JScrollPane(listado);
		
		// Creamos un unico panel para agregar el JScrollPane
		JPanel pane1 = new JPanel();
		pane1.setLayout( new GridLayout(0, 1) );
		
		pane1.add(desplaza);
		
		// Agregamos el panel en la mitad del Frame
		getContentPane().add(pane1, BorderLayout.CENTER);

		pack();
		// Configuramos el JTextArea para que no se pueda editar
		// su contenido
		listado.setEditable(false);
		setSize(200, 300);
		setResizable(false);
		setTitle("Listado de estudiantes");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}