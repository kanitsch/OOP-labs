package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.OptionsParser.dirs;


public class SimulationPresenter implements MapChangeListener {
    @FXML
    private GridPane mapGrid;
    @FXML
    private Label moveDescription;
    @FXML
    private TextField enterMoves;
    @FXML
    private Button startButton;
    @FXML
    private Label infoLabel;
    private static final double CELL_WIDTH = 30;
    private static final double CELL_HEIGHT = 30;

    WorldMap map;
    public void setWorldMap(WorldMap map) {
        this.map = map;
    }
    public void drawMap() {
        Platform.runLater(() -> {
            clearGrid();
            Boundary boundary = map.getCurrentBounds();
            int rows = boundary.upperRight().getY() - boundary.lowerLeft().getY() + 1;
            int cols = boundary.upperRight().getX() - boundary.lowerLeft().getX() + 1;

            for (int i = 0; i < rows; i++) {
                mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
            }
            for (int i = 0; i < cols; i++) {
                mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
            }

            for (int x = boundary.lowerLeft().getX(); x <= boundary.upperRight().getX(); x++) {
                Label label = new Label(Integer.toString(x));
                label.setStyle(" -fx-alignment: center;");
                mapGrid.add(label, x - boundary.lowerLeft().getX() + 1, 0);
                GridPane.setHalignment(label, HPos.CENTER);
                GridPane.setValignment(label, VPos.CENTER);
            }


            for (int y = boundary.lowerLeft().getY(); y <= boundary.upperRight().getY(); y++) {
                Label label = new Label(Integer.toString(y));
                label.setStyle(" -fx-alignment: center;");
                mapGrid.add(label, 0, rows - (y - boundary.lowerLeft().getY()));
                GridPane.setHalignment(label, HPos.CENTER);
                GridPane.setValignment(label, VPos.CENTER);
            }
            Label label = new Label("y/x");
            label.setStyle("-fx-alignment: center;");
            mapGrid.add(label, 0, 0);
            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setValignment(label, VPos.CENTER);



            for (int y = boundary.lowerLeft().getY(); y <= boundary.upperRight().getY(); y++) {
                for (int x = boundary.lowerLeft().getX(); x <= boundary.upperRight().getX(); x++) {
                    Vector2d position = new Vector2d(x, y);
                    if (map.isOccupied(position)) {
                        Label element = createMapElement(map.objectAt(position));
                        mapGrid.add(element, x - boundary.lowerLeft().getX()+1, rows - (y - boundary.lowerLeft().getY()));
                    }
                }
            }
        });
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().getFirst());
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    private Label createMapElement(WorldElement element) {
        Label label = new Label(element.toString());
        label.setMinWidth(CELL_WIDTH);
        label.setMinHeight(CELL_HEIGHT);
        label.setStyle(" -fx-alignment: center;");
        return label;
    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        setWorldMap(worldMap);
        Platform.runLater(() -> {
            drawMap();
            this.moveDescription.setText(message);

    });
    }

    public void onSimulationStartClicked() {

        String moves = enterMoves.getText();
        List<MoveDirection> movesList = dirs(moves.split(" "));
        GrassField grassField=new GrassField(10);
        grassField.addObserver(this);
//        this.setWorldMap(grassField);
//        this.drawMap();
        List<Vector2d> pos = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        String[] args= getParameters().getRaw().toArray(new String[0]);
//        List<MoveDirection> directions1 = OptionsParser.dirs(args);
        Simulation simulation = new Simulation(pos,movesList,grassField);
        SimulationEngine engine = new SimulationEngine(List.of(simulation));
        new Thread(engine::runSync).start();
    }
}