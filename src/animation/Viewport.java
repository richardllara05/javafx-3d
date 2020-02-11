package animation;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import javafx.animation.AnimationTimer;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

public class Viewport {
    private static Group scooterWrapper;
    private static String SCOOTER_PATH = "src\\Scooter-obj\\Scooter-smgrps.obj";

    public Camera getCamera() {
        Camera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-4);
        camera.setTranslateY(-0.4);

        //Set the clipping planes
        camera.setNearClip(0);
        camera.setFarClip(1000);

        return camera;
    }

    public void setupModels(Group root){
        // Imports Scooter
        ObjModelImporter model = new ObjModelImporter();
        model.read(SCOOTER_PATH);  // Clean this name
        MeshView[] meshView = model.getImport();

        // Creates Cylinder
        Cylinder cylinder = new Cylinder(60f, 40f);
        cylinder.setMaterial(new PhongMaterial(Color.GRAY));
        cylinder.translateXProperty().set(0);
        cylinder.translateYProperty().set(80);
        cylinder.translateZProperty().set(540);

        scooterWrapper  = new Group(meshView);

        root.getChildren().addAll(cylinder, scooterWrapper);
    }

    public void animateScooter() {
        new AnimationTimer() {
            @Override
            public void handle(long now){
                scooterWrapper.getTransforms().add(new Rotate(1.1, Rotate.Y_AXIS));
            }

        }.start();
    }

}
