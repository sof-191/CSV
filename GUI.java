import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends Application implements EventHandler<ActionEvent>{
    private Button btnOne;
	private Button btnTwo;

	@Override
	public void start(Stage primaryStage) {
		try {
			HBox hbox = new HBox();
			hbox.setSpacing(10);
			HBox areaBotones = new HBox();
			btnOne = new Button("TIPO A");
            btnOne.setOnAction(this);
			btnTwo = new Button("TIPO B");
            btnTwo.setOnAction(this);
			areaBotones.getChildren().addAll(btnOne, btnTwo);
            hbox.setMaxSize(1000, 400);

            BorderPane root = new BorderPane();
			root.setTop(areaBotones);
			root.setBottom(hbox);
            
            
            Scene scene = new Scene (root,200,50);
            primaryStage.setTitle("GUI");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
			e.printStackTrace();
		}
        
    }

    public static void main(String[] args){
        launch(args);
    }

    public App appA = new App();

    @Override
	public void handle(ActionEvent event) {
		if((Button)event.getSource() == btnOne){
            
            appA.setTipo('A');
            Stage tipoA = new Stage ();
            appA.start(tipoA);
        }
        else if ((Button)event.getSource() == btnTwo) {

            appA.setTipo('B');
            Stage tipoA = new Stage ();
            appA.start(tipoA);
        }
	}

}
