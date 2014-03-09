// Semaphore.java
// $Id: Semaphore.java,v 1.1.1.1 2003/06/19 19:00:15 fcardona Exp $

package Semaphore;

/* Esta clase implementa las operaciones básicas 
   de un semáforo. Ver: Bacon, Harris. Operating
   Systems pág: 306.
*/

public interface Semaphore {
    public void semWait();
    public void semSignal();
}
