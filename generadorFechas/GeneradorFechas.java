import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.util.TimeZone;

public class GeneradorFechas {

    public static boolean fechasIgualesCampo(Calendar fecha1, Calendar fecha2,
					      int campo) {

	return fecha1.get(campo) == fecha2.get(campo);
    }

    public static boolean fechasIguales(Calendar fecha1, Calendar fecha2) {

	return fechasIgualesCampo(fecha1, fecha2, Calendar.MONTH) &&
	    fechasIgualesCampo(fecha1, fecha2, Calendar.DAY_OF_MONTH) &&
	    fechasIgualesCampo(fecha1, fecha2, Calendar.YEAR);

    }

    public static boolean esNoLaborable(Calendar festivos[], 
					Calendar diaActual) {

	int i = 0;
	boolean encontro = false;
	while (!encontro && i < festivos.length) {
	    if (fechasIguales(diaActual, festivos[i])) {
		encontro = true;
	    }
	    i++;
	}

	return encontro;
    }

    public static boolean estaElDia(int dias[], int dia) {

	boolean encontro = false;
	int i = 0;

	while (!encontro && i < dias.length) {

	    if (dias[i] == dia) {
		encontro = true;
	    }
	    i++;
	}

	return encontro;
    }

    public static void imprimirDia(Calendar dia) {
	dia.setTimeZone(TimeZone.getTimeZone("COT"));
	DateFormat plain = DateFormat.getDateInstance();
	System.out.print(" " + plain.format(dia.getTime()));
    }

    public static void main(String []args) {
	
	Calendar festivos[] = {
	    /* La primera fecha no se sabe por que pero le resta 5 horas */
	    new GregorianCalendar(2005, Calendar.MAY, 1), 
	    new GregorianCalendar(2005, Calendar.AUGUST, 15),
	    new GregorianCalendar(2005, Calendar.SEPTEMBER, 19),
	    new GregorianCalendar(2005, Calendar.OCTOBER, 7),
	    new GregorianCalendar(2005, Calendar.OCTOBER, 17),
	    new GregorianCalendar(2005, Calendar.NOVEMBER, 7),
	    new GregorianCalendar(2005, Calendar.NOVEMBER, 14),
	    new GregorianCalendar(2005, Calendar.DECEMBER, 8),
	    new GregorianCalendar(2005, Calendar.DECEMBER, 25),
	    new GregorianCalendar(2005, Calendar.JULY, 20)
	};
	
	int grupo[][] = { {Calendar.MONDAY, Calendar.WEDNESDAY, 
			   Calendar.FRIDAY},
			  {Calendar.TUESDAY,Calendar.THURSDAY,
			   Calendar.FRIDAY}
	};

	Calendar diaActual[] = new GregorianCalendar[] {
	    new GregorianCalendar(2005, Calendar.JULY, 18),
	    new GregorianCalendar(2005, Calendar.JULY, 18)
	};


	int nTotalSesiones = 1;
	
	System.out.println("\\documentclass{article}");
	System.out.println("");
	System.out.println("\\usepackage[spanish]{babel}");
	System.out.println("\\usepackage[latin1]{inputenc}");
	System.out.println("");
	System.out.println("\\title{Sesiones de sistemas operativos ST075 2005-2}");
	System.out.println("\\author{}");
	System.out.println("\\date{}");
	
	System.out.println("\\begin{document}");
	System.out.println("\\maketitle");
	System.out.println("");
	System.out.println("\\begin{tabular}{|c|p{3cm}|c|c|}\\hline");
	System.out.println("\\textbf{Sesión} & \\textbf{Temas} & \\textbf{031} & \\textbf{032}\\\\\\hline");
       
	while (nTotalSesiones <= 45) {
	   
	    System.out.print(" " + nTotalSesiones + " &  & ");
	    for (int i = 0; i < 2; i++) {
		
		while (!(estaElDia(grupo[i], 
				   diaActual[i].get(Calendar.DAY_OF_WEEK)) 
			 &&
			 !esNoLaborable(festivos, diaActual[i]))) {
		    diaActual[i].add(Calendar.DATE, 1);
		}
		imprimirDia(diaActual[i]);
		if (i < 2 - 1)
		    System.out.print(" & ");
		diaActual[i].add(Calendar.DATE, 1);
	    }
	    System.out.println(" \\\\\\hline");
	    nTotalSesiones++;
	}	
	System.out.println("\\end{tabular}");
	System.out.println("\\end{document}");
    }
}
