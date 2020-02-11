package animation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    private float WIDTH = 600f, HEIGHT = WIDTH;
    private String TITLE = "Rotating Scooter";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Group root = new Group();

        Viewport userPerspective = new Viewport();
        userPerspective.setupModels(root);
        userPerspective.animateScooter();

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setCamera(userPerspective.getCamera());

        stage.setScene(scene);
        stage.setTitle(TITLE);
        stage.show();
    }
}
