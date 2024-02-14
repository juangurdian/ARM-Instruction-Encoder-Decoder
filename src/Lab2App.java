import javax.swing.SwingUtilities;

public class Lab2App {
	public static void main(String args[]) {
		Lab2View view = new Lab2View();
		Lab2Model model = new Lab2Model();
		Lab2Controller controller = new Lab2Controller(view, model);
	}

}
