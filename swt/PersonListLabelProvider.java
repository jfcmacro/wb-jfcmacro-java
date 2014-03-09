import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.LabelProvider;

public class PersonListLabelProvider extends LabelProvider {
    public Image getImage(Object element) {
	return null;

    }
    public String getText(Object element) {
	Person person = (Person) element;
	return person.firstName + " " + person.lastName;
    }
}
