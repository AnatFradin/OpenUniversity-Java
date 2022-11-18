package ou.maman_12_question2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ou.maman_12_question2.shapes.MyLine;
import ou.maman_12_question2.shapes.MyOval;
import ou.maman_12_question2.shapes.MyRectangle;
import ou.maman_12_question2.shapes.MyShape;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Random rand = new Random();
    private static ArrayList<MyShape> initialShapes = new ArrayList<>();
    private static ArrayList<MyShape> clonedShapes = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        createShapes();
        launch();
    }

    private static int randomCoordinate() {
        return rand.nextInt(201);
    }

    private static void createShapes() {
        for (int i = 0; i < 2; i++) {
            initialShapes.add(new MyLine(randomCoordinate(), randomCoordinate(),
                    randomCoordinate(), randomCoordinate(), Color.RED));

            initialShapes.add(new MyOval(randomCoordinate(), randomCoordinate(),
                    randomCoordinate(), randomCoordinate(),
                    Color.RED, true));

            initialShapes.add(new MyRectangle(randomCoordinate(), randomCoordinate(),
                    randomCoordinate(), randomCoordinate(),
                    Color.RED, true));

        }

        for (Iterator<MyShape> iterator = initialShapes.iterator(); iterator.hasNext();) {
            MyShape next = iterator.next();
            try {
                clonedShapes.add((MyShape) next.clone());
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }
            
        }
        for (Iterator<MyShape> iterator = clonedShapes.iterator(); iterator.hasNext();) {
            MyShape shape = iterator.next();
            shape.shift(10,10);
            shape.setColor(Color.GREEN);
            shape.setFill(false);
        }
    }

    private void drawShapes(GraphicsContext gc) {
        for (Iterator<MyShape> iterator = initialShapes.iterator(); iterator.hasNext();) {
            MyShape next = iterator.next();
            next.draw(gc);
        }
        for (Iterator<MyShape> iterator = clonedShapes.iterator(); iterator.hasNext();) {
            MyShape next = iterator.next();
            next.draw(gc);
        }
    }

}
