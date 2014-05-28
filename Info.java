public class Info {


    private int id;
    private float f;
    private String nombre;

    public Info(int _id, int _f, int _nombre) {
	id = _id;
	f = _f;
	nombre = _nombre;
    }

    public void setId(int _id) {
	this.id = _id;
    }

    public int getId() {
	return id;
    }
}
