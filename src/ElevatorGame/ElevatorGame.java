package ElevatorGame;

import java.io.File;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.geometry.Insets;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class ElevatorGame extends Application {

    int i = 0;
    double a = 41.4;
    double b = 0;

    Elevator elevators = new Elevator();

    MyStack stack = new MyStack();

    @Override
    public void start(Stage primaryStage) {

        Stage window = primaryStage;
        window.setTitle("Elevator Game");
        BorderPane bp = new BorderPane(); //her sey borderpane uzerine kurulu

        GridPane grid = new GridPane(); // sag taraf gridpanele yazili

        VBox building = new VBox(); // katlar(building) icin vbox

        VBox upAndDown = new VBox(30); // up and down buttonlari icin vbox
        HBox elAndFloors = new HBox(); // elevator ve building icin vbox

        // sagdaki input kismi icin grid
        grid.setPadding(new Insets(30, 90, 50, 90));
        grid.setVgap(9);
        grid.setHgap(8);

        Label nameL = new Label("Name: ");
        Label targetL = new Label("Target: ");

        nameL.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        targetL.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

        TextField nameIn = new TextField();
        nameIn.setPromptText("Ali");
        TextField targetIn = new TextField();
        targetIn.setPromptText("3");

        GridPane.setConstraints(nameL, 0, 0);
        GridPane.setConstraints(targetL, 0, 1);
        GridPane.setConstraints(nameIn, 1, 0);
        GridPane.setConstraints(targetIn, 1, 1);

        Button addB = new Button("Add Person");
        addB.setFont(Font.font("Times New Roman", 12));
        GridPane.setConstraints(addB, 1, 3);
        addB.setPadding(new Insets(5, 10, 5, 10));

        Label personText1 = new Label();
        Label personText2 = new Label();
        personText1.setText("TEXT FROM THE PERSON WHO LEFT LAST: \n\n");
        personText2.setText(" ");
        personText1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        personText2.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 14));
        GridPane.setConstraints(personText1, 1, 15);
        GridPane.setConstraints(personText2, 1, 16);

        Label statusCheck1 = new Label();
        Label statusCheck2 = new Label();
        statusCheck1.setText("STATUS CHECK: \n\n");
        statusCheck2.setText(" ");
        statusCheck1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        statusCheck2.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 14));
        GridPane.setConstraints(statusCheck1, 1, 23);
        GridPane.setConstraints(statusCheck2, 1, 24);

        /////////////////////////////////////////////
        // katlar icin rectangellar
        Rectangle f0 = new Rectangle();
        Text floor0txt = new Text("ground floor(0)");
        StackPane st0 = new StackPane();
        st0.getChildren().addAll(f0, floor0txt);

        //her katta text icin label kare icin rectangle yaptim 
        //ve onlari ust uste olsun diye stackpanede birlestirdim 
        f0.setWidth(200);
        f0.setHeight(40);
        f0.setFill(Color.TRANSPARENT);
        f0.setStroke(Color.BLACK);

        Rectangle f1 = new Rectangle();
        Text floor1txt = new Text("1.floor");
        StackPane st1 = new StackPane();
        st1.getChildren().addAll(f1, floor1txt);

        f1.setWidth(200);
        f1.setHeight(40);
        f1.setFill(Color.TRANSPARENT);
        f1.setStroke(Color.BLACK);

        Rectangle f2 = new Rectangle();
        Text floor2txt = new Text("2.floor");
        StackPane st2 = new StackPane();
        st2.getChildren().addAll(f2, floor2txt);

        f2.setWidth(200);
        f2.setHeight(40);
        f2.setFill(Color.TRANSPARENT);
        f2.setStroke(Color.BLACK);

        Rectangle f3 = new Rectangle();
        Text floor3txt = new Text("3.floor");
        StackPane st3 = new StackPane();
        st3.getChildren().addAll(f3, floor3txt);

        f3.setWidth(200);
        f3.setHeight(40);
        f3.setFill(Color.TRANSPARENT);
        f3.setStroke(Color.BLACK);

        Rectangle f4 = new Rectangle();
        Text floor4txt = new Text("4.floor");
        StackPane st4 = new StackPane();
        st4.getChildren().addAll(f4, floor4txt);

        f4.setWidth(200);
        f4.setHeight(40);
        f4.setFill(Color.TRANSPARENT);
        f4.setStroke(Color.BLACK);

        Rectangle f5 = new Rectangle();
        Text floor5txt = new Text("5.floor");
        StackPane st5 = new StackPane();
        st5.getChildren().addAll(f5, floor5txt);

        f5.setWidth(200);
        f5.setHeight(40);
        f5.setFill(Color.TRANSPARENT);
        f5.setStroke(Color.BLACK);

        Rectangle f6 = new Rectangle();
        Text floor6txt = new Text("6.floor");
        StackPane st6 = new StackPane();
        st6.getChildren().addAll(f6, floor6txt);

        f6.setWidth(200);
        f6.setHeight(40);
        f6.setFill(Color.TRANSPARENT);
        f6.setStroke(Color.BLACK);

        Rectangle f7 = new Rectangle();
        Text floor7txt = new Text("7.floor");
        StackPane st7 = new StackPane();
        st7.getChildren().addAll(f7, floor7txt);

        f7.setWidth(200);
        f7.setHeight(40);
        f7.setFill(Color.TRANSPARENT);
        f7.setStroke(Color.BLACK);

        Rectangle f8 = new Rectangle();
        Text floor8txt = new Text("8.floor");
        StackPane st8 = new StackPane();
        st8.getChildren().addAll(f8, floor8txt);

        f8.setWidth(200);
        f8.setHeight(40);
        f8.setFill(Color.TRANSPARENT);
        f8.setStroke(Color.BLACK);

        Rectangle f9 = new Rectangle();
        Text floor9txt = new Text("9.floor");
        StackPane st9 = new StackPane();
        st9.getChildren().addAll(f9, floor9txt);

        f9.setWidth(200);
        f9.setHeight(40);
        f9.setFill(Color.TRANSPARENT);
        f9.setStroke(Color.BLACK);

        Rectangle f10 = new Rectangle();
        Text floor10txt = new Text("10.floor");
        StackPane st10 = new StackPane();
        st10.getChildren().addAll(f10, floor10txt);

        f10.setWidth(200);
        f10.setHeight(40);
        f10.setFill(Color.TRANSPARENT);
        f10.setStroke(Color.BLACK);

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        // up ve down buttonlari
        Button up = new Button("UP");
        up.setPadding(new Insets(10, 10, 10, 10));
        up.setFont(Font.font("Times New Roman", FontWeight.BOLD, 19));

        Button down = new Button("DOWN");
        down.setPadding(new Insets(10, 10, 10, 10));
        down.setFont(Font.font("Times New Roman", FontWeight.BOLD, 19));

        //////////////////////////////
        grid.getChildren().addAll(nameL, targetL, nameIn, targetIn, addB, personText1, personText2, statusCheck1, statusCheck2);
        building.getChildren().addAll(st10, st9, st8, st7, st6, st5, st4, st3, st2, st1, st0);

        upAndDown.getChildren().addAll(up, down);
        upAndDown.setAlignment(Pos.CENTER);

        StackPane elevator = new StackPane();

        // elevatorun hareket edecegi uzun gri dikdortgen
        Rectangle floors = new Rectangle();
        floors.setWidth(50);
        floors.setHeight(451);
        floors.setFill(Color.GREY);
        floors.setStroke(Color.RED);

        //elevatorun hareker eden kismi 
        elevatorBox.setWidth(51);
        elevatorBox.setHeight(41);
        elevatorBox.setFill(Color.LIGHTBLUE);
        elevatorBox.setTranslateY(411);
        ////////////////////elevator num

        NumberOfPeople.setTranslateY(420);
        NumberOfPeople.setTranslateX(20);

        NumberOfPeople.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 17));
        NumberOfPeople.setTextFill(Color.BLACK);

        //dikdortgenleri stackpanele birlestirdim
        elevator.getChildren().addAll(floors, elevatorBox, NumberOfPeople);
        elevator.setAlignment(Pos.TOP_LEFT);

        // dikdortgenlerin oldugu stackpanele building kismini hboxla birlestirdim
        elAndFloors.getChildren().addAll(elevator, building);
        elAndFloors.setAlignment(Pos.CENTER);
        elAndFloors.setPadding(new Insets(20, 30, 0, 0));

        /////////////////////////////////////////////////
        //ANIMATION TIME
        ////////////////////////////////////////////buton aksiyonları
        //Elevator UP
        up.setOnAction(eventUp -> {
            if (a >= 0 & a <= 415) {
                animEL(a, b);
                int k = stack.getSize();
                i++;
                a += 41.1;
                b += 41.1;
                
                
                if(!elevators.isEmpty()){
                    
                Object c = elevators.getPeople().peek();
                String y = c.toString();
                elevators.goToFloor(i);
                personText2.setText(y);
                 
                statusCheck2.setText("Travel meter = " +Integer.toString(Elevator.getTravelMeter())+ "\n" +
                        "Number of People who reach their target = " + Integer.toString(Elevator.counter));
                
                }else 
                {
                     statusCheck2.setText("Travel meter = " +Integer.toString(Elevator.getTravelMeter())+ "\n" +
                      "Number of People who reach their target = " + Integer.toString(Elevator.counter));
                     
                    elevators.goToFloor(i);
                    personText2.setText("Elevator empty");
                    
                }
              
                
              

                NumberOfPeople.setText(Integer.toString(elevators.getPeople().getSize()));
                

            } else {
                System.out.println(".handle(bbbbbbbbbbbbb)");
            }
        });

        // Elevator Down
        down.setOnAction(eventDown -> {
            if (a >= 50 & a <= 455) {
                b -= 41.1;
                a -= 41.1;
                animEL(b, a);

                int k = stack.getSize();
                i--;
                
                  if(!elevators.isEmpty()){
                    
                Object c = elevators.getPeople().peek();
                String y = c.toString();
                elevators.goToFloor(i);
                personText2.setText(y);
                 
                statusCheck2.setText("Travel meter = " +Integer.toString(Elevator.getTravelMeter())+ "\n" +
                        "Number of People who reach their target = " + Integer.toString(Elevator.counter));
                
                }else 
                {
                    
                    elevators.goToFloor(i);
                    personText2.setText("Elevator empty");
                    
                     statusCheck2.setText("Travel meter = " +Integer.toString(Elevator.getTravelMeter())+ "\n" +
                      "Number of People who reach their target = " + Integer.toString(Elevator.counter));
                    
                }
                NumberOfPeople.setText(Integer.toString(elevators.getPeople().getSize()));

            } else {
                System.out.println(".handle(bbbbbbbbbbbbb)");
            }
        });

        // ADD new Person
        addB.setOnAction(NewPerson -> {
            Person newp = new Person(nameIn.getText());
            ElevatorPerson newep = new ElevatorPerson(newp, elevators.getCurrentFloor(), Integer.parseInt(targetIn.getText()));

            elevators.enter(newp, Integer.parseInt(targetIn.getText()));
            if (elevators.getCurrentFloor() == 0) {
                personText2.setText(newep.getPerson().getName() + " is in the elevator at " + elevators.getCurrentFloor() + ". floor");
                NumberOfPeople.setText(Integer.toString(elevators.getPeople().getSize()));
                
                
            } else {

                personText2.setText(newep.getPerson().getName() + " is in the elevator at " + elevators.getCurrentFloor() + ". floor");
                NumberOfPeople.setText(Integer.toString(elevators.getPeople().getSize()));
            }
        });

        //ELEVATOR MUSIC
        Media music = new Media(new File("src/music/ElevatorMusic.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(music);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.setAutoPlay(true);

        Button stop = new Button("STOP THE MUSIC");
        stop.setOnAction(e -> ElevatorMusic.button());

        HBox musicp = new HBox(50);
        musicp.getChildren().add(stop);
        musicp.setAlignment(Pos.CENTER);

        bp.setRight(grid);
        bp.setLeft(elAndFloors);
        bp.setCenter(upAndDown);
        bp.setPadding(new Insets(80, 0, 30, 100));
        bp.setBottom(musicp);

        Scene sc = new Scene(bp, 1050, 700);
        //window.setFullScreen(true);
        window.setResizable(false);
        window.setScene(sc);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
//elevatorun hareket eden kismi 
    Rectangle elevatorBox = new Rectangle();
    Label NumberOfPeople = new Label();
    

    void animEL(double a, double b) {

        TranslateTransition trans = new TranslateTransition();
        TranslateTransition transNum = new TranslateTransition();
        trans.setNode(elevatorBox);
        transNum.setNode(NumberOfPeople);
        trans.setDuration(Duration.seconds(1));
        transNum.setDuration(Duration.seconds(1));

        trans.setFromY(411 - b);
        transNum.setFromY(420 - b);
        transNum.setToY(420 - a);

        trans.setToY(411 - a);
        trans.play();
        transNum.play();

    }
;

}
