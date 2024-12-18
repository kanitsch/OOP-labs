package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SimulationApp extends Application {
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();
        configureStage(primaryStage, viewRoot);
//        GrassField grassField=new GrassField(10);
//        grassField.addObserver(presenter);
//        presenter.setWorldMap(grassField);
//        presenter.drawMap();
//        List<Vector2d> pos = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        String[] args= getParameters().getRaw().toArray(new String[0]);
//        List<MoveDirection> directions1 = OptionsParser.dirs(args);
//        Simulation simulation = new Simulation(pos,directions1,grassField);
//        simulation.run();

        primaryStage.show();
    }
    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
