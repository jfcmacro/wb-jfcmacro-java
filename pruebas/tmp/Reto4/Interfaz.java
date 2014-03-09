/*
 * Importamos las clases necesarias para los objetos (botones, campos,
 * sellos...), distribuciones, paneles y control de eventos
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Interfaz extends JFrame{
	
	/*
	 * Inicializacion de variables, en este caso
	 * las partes de la ventana
	 */
	 
	// Botones: uno para cerrar el programa y uno para
	// ejecutar una accion seleccionada
	private JButton b_aceptar = new JButton("Aceptar");
	private JButton b_listar = new JButton("Listar");
	private JButton b_salir = new JButton("Salir");
	
	// Campos de seleccion: marcan manualmente con un clic 
	// la opcion preferida, por defecto se configura
	// el campo agregar como seleccionado
	private JCheckBox c_agregar = new JCheckBox("Agregar",true);
	private JCheckBox c_buscar = new JCheckBox("Buscar");
	private JCheckBox c_borrar = new JCheckBox("Borrar");
	private JCheckBox c_editar = new JCheckBox("Editar");
	
	// Sellos: dan nombre, es decir, marcan alguna parte 
	// de la ventana con un nombre determinado
	private JLabel l_codigo = new JLabel("Codigo");
	private JLabel l_nombre = new JLabel("Nombre");
	
	// Campos de texto: espacios donde el usuario escribe
	// informacion para el programa. Pueden ser editables
	// o no editables
	private JTextField t_clave = new JTextField();
	private JTextField t_nombre = new JTextField();
	
	// Se tiene una instancia de la aplicacion con la que se va a
	// trabajar desde la interfaz, es decir, los metodos de esta clase son 
	// los que se llaman cuando ocurra un evento
	private Aplicacion ap;
	
	// Constructora: inicializa todas las variables nombradas
	// anteriormente, las configura y les agrega los "listeners"
	// necesarios para el buen funcionamiento logico del programa
	public Interfaz(Aplicacion a){
		
		// Se recibe una instancia de la aplicacion a manejar por la
		// constructora, con la que se inicializa la instancia propia de
		// la interfaz
		ap = a;
		
		// Se configura el JFrame con una distribucion
		// en los bordes (BorderLayout)
		getContentPane().setLayout(new BorderLayout());
		
		// Agregamos un "Listener" al boton aceptar, es decir,
		// cuando el boton genere un evento, este metodo dira
		// que es lo que debe hacer el programa
		b_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c_agregar.isSelected()){
					// Comprueba que los espacios esten llenos
					if(t_nombre.getText().trim().equals("") || t_clave.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null,"No puede haber campos vacios");
					}else{
						int resultado = ap.agregar(t_clave.getText(),t_nombre.getText());
						if(resultado == -1){
							JOptionPane.showMessageDialog(null,"Ya existe un estudiante con ese codigo");
						}else{
							JOptionPane.showMessageDialog(null,"Estudiante agregado");
							t_clave.setText("");
							t_nombre.setText("");
						}
					}
				}else if(c_editar.isSelected()){
					// Comprueba que los espacios esten llenos
					if(t_nombre.getText().trim().equals("") || t_clave.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null,"No puede haber campos vacios");
					}else{
						int resultado = ap.editar(t_clave.getText(),t_nombre.getText());
						if(resultado == -1){
							JOptionPane.showMessageDialog(null,"No existe estudiante con ese codigo");
						}else{
							JOptionPane.showMessageDialog(null,"Edicion realizada");
							t_clave.setText("");
							t_nombre.setText("");
						}
					}
				}else if(c_borrar.isSelected()){
					// Comprueba que los espacios esten llenos
					if(t_clave.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null,"Debe poner una clave de busqueda");
					}else{
						int resultado = ap.borrar(t_clave.getText());
						if(resultado == -1){
							JOptionPane.showMessageDialog(null,"No existe un estudiante con ese codigo");
						}else{
							JOptionPane.showMessageDialog(null,"Estudiante borrado");
						}
						t_nombre.setText("");
						t_clave.setText("");
					}
				}else{
					// Comprueba que los espacios esten llenos
					if(t_clave.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null,"Debe poner una clave de busqueda");
					}else{
						Estudiante est = ap.buscar(t_clave.getText());
						if(est != null){
							t_nombre.setText(est.nombre());
						}else{
							t_nombre.setText("");
						}
					}
				}
			}
		});
		
		// Agregamos un "Listener" al boton listar. Este boton
		// genera una nueva ventana que contiene un JTextArea
		// en el que se muestran todos los estudaintes agregados
		b_listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VLista(ap.listar());
			}
		});
		
		// Agregamos un "Listener" al boton salir. Este boton
		// simplemente llama al metodo exit(int) de la clase 
		// java.lang.System para finalizar el programa
		b_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		t_clave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!t_clave.getText().trim().equals("")){
					Estudiante est = ap.buscar(t_clave.getText());
					if(est != null){
						t_nombre.setText(est.nombre());
					}
				}
			}
		});
		
		//------------------------------//---------------------------------//
		
		/*
		 * A continuacion se agregan los "Listeners" de los
		 * JCheckBox, que controlan que no haya menos ni mas de una opcion 
		 * seleccionada
		 */
		c_agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_agregar.setSelected(true);
				c_editar.setSelected(false);
				c_borrar.setSelected(false);
				c_buscar.setSelected(false);
				t_nombre.setEditable(true);
			}
		});
		
		c_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_agregar.setSelected(false);
				c_editar.setSelected(true);
				c_borrar.setSelected(false);
				c_buscar.setSelected(false);
				t_nombre.setEditable(true);
			}
		});
		
		c_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_agregar.setSelected(false);
				c_editar.setSelected(false);
				c_borrar.setSelected(true);
				c_buscar.setSelected(false);
				t_nombre.setEditable(false);
			}
		});
		
		c_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_agregar.setSelected(false);
				c_editar.setSelected(false);
				c_borrar.setSelected(false);
				c_buscar.setSelected(true);	
				t_nombre.setEditable(false);
			}
		});
		
		//------------------------------//---------------------------------//
		
		// Se crea y configura el panel uno con distribucion en grilla
		JPanel pane1 = new JPanel();
		pane1.setLayout(new GridLayout(2,2));
		
		// Se agregan objetos al panel uno
		pane1.add(l_codigo);
		pane1.add(t_clave);
		pane1.add(l_nombre);
		pane1.add(t_nombre);
		
		// Se crea y configura el panel dos con distribucion en grilla
		JPanel pane2 = new JPanel();
		pane2.setLayout(new GridLayout(4,0));
		
		// Se agregan objetos al panel dos
		pane2.add(c_agregar);
		pane2.add(c_editar);
		pane2.add(c_borrar);
		pane2.add(c_buscar);
		
		// Se crea y configura el panel tres con distribucion en grilla
		JPanel pane3 = new JPanel();
		pane3.setLayout(new GridLayout(0,3));
		
		// Se agregan objetos al panel tres
		pane3.add(b_aceptar);
		pane3.add(b_listar);
		pane3.add(b_salir);
		
		/*
		 * Pega los tres paneles en el JFrame, diciendo en que posicion
		 * pone cada uno ( CENTER->Centro, NORTH->Arriba, SOUTH->Abajo,
		 * EAST->Derecha, WEST->Izquierda)
		 */
		getContentPane().add(pane1, BorderLayout.CENTER);
		getContentPane().add(pane2, BorderLayout.EAST);
		getContentPane().add(pane3, BorderLayout.SOUTH);
		
		pack();
		setSize(400,120);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String args[]){
		new Interfaz(new Aplicacion());
	}
}