import java.io.*;

class Aplicacion1
{
	int tamano;
	ArchivoDirectoEstudiante ade;
	RegistroEstudiante r;
	
	
	public Aplicacion1()
	{
		tamano=0;
		ade=new ArchivoDirectoEstudiante("datos.txt",RegistroEstudiante.longitudRegistro);
		
		
		
		
			
	}
	
	public String generarNombre()
	{
		char letras[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String Nombre="";
		
		for(int i=0; i<Math.random()*36; i++)
		{
			Nombre=Nombre+letras[(int)(Math.random()*26)];
		}
		return Nombre;
	}
	
	
	public int buscar (String clave)throws IOException
	{	
		
	    System.out.println("clave: " + clave);
		int pos=Integer.parseInt(clave.trim());
		System.out.println("pos: " + pos);
		RegistroEstudiante t=ade.leerUnRegistro(pos);
			
		if(t!=null)
		{
				return 0;	
		}			

		return -1;
	}	
	
		
		
	public int agregar(String clave,String Estudiante)
	{
					
		
		try
		{	
		
			int t = buscar(clave);
			System.out.println(t);
			
			if(t!=0)
			{
				System.out.println("YA ESTA");
				return -1;
			}
			
				RegistroEstudiante re = new RegistroEstudiante(clave, Estudiante);
				ade.escribirUnRegistro(re);
				
			
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
	
		return 0;	
	}
		
/*	
	public int borrar(String clave)
	{
	
		RegistroEstudiante t=buscar(clave);
			
		if(t==null)
		{	
			agregar(clave,"");
			return 0;	
		}
		return -1;	
	}		
		
*/		
		
	
	public static void main(String args[])
	{
		Aplicacion1 apl=new Aplicacion1();
		
		
		apl.agregar("0","Juan");
		apl.agregar("1","Pedro");
		apl.agregar("0","Laura");
	
		
		
		try
		{
			apl.ade.cerrar();	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
			
	}		
}
