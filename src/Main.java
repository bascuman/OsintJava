import controller.Controller;
import model.Model;
import view.View;

public class Main {
    public static void main(String[] args) {
        //iniciador
        Controller controller = new Controller();
        Model model = new Model(controller);
        new View(controller,model);
    }
}
