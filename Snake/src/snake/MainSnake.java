package snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainSnake extends Application{

	//TODO restart on wall hit or self hit
	
	public void start(Stage primaryStage){
		Pane root = new Pane();
		
		Text counter = new Text("2");
		counter.setX(20);
		counter.setY(20);
		
		
		int width = 390, height = 390;
		
		Scene scene = new Scene(root, width, height);
		
		Snake snake = new Snake();
		
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> {
			Rectangle rect = snake.frame();
			if(rect != null){
				root.getChildren().add(rect);
				counter.setText(Integer.parseInt(counter.getText()) + 1 + ""); // Increases counter with 1
			}
			
			if(snake.isHit()){
				reset(snake);
				counter.setText("1");
				root.getChildren().clear();
				
				root.getChildren().addAll(snake.getRectangles());
				root.getChildren().add(snake.getFruit());
				root.getChildren().add(counter);
				
			}
			
			
		}));
		
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
		
		scene.setOnKeyPressed(e -> {
			snake.pressed(e);
		});
		
		
		root.getChildren().addAll(snake.getRectangles());
		root.getChildren().add(snake.getFruit());
		root.getChildren().add(counter);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Snake");
		primaryStage.show();
	}
	
	public void reset(Snake snake){
		snake = new Snake();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}