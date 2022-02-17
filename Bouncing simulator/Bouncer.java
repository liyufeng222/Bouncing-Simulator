/*
 * Author: Yufeng Li
 * Instructor: Professor Jamal Ashraf
 * Last Modify Date: 2/13/2020
 * Question: Honor project - Bouncer
 * Description: Have the field to show the Bouncing screen, and the field to control the crate and the sprite
 */

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.animation.*;
import javafx.scene.transform.Rotate;
import java.util.*;
import javafx.scene.text.*;

public class Bouncer extends Application{
	public static Timeline timeline;
	public static ArrayList<Crate> crates = new ArrayList<Crate>();
	public static Pane playField;
	public static Pane control;
	public static ControlPanel co = new ControlPanel();
	public static int numOfCrate = 1;
	
	public static ControlPanel getControl(){ return co;}
	public static ArrayList<Crate> getCrates(){ return crates;} 
	public static Pane getPlayField(){return playField;}
	//public static VBox getEast(){return east;}
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Bouncer");
		
		/*Crate myCrate = new Crate(250,150,250,200);
		crates.add(myCrate);
		//c.getChildren().add(myCrate.getBody());*/
		
		Pane c = new Pane();
		playField = c;
		c.setStyle("-fx-background-color: aqua");
		
		
		/*myCrate = new Crate(250,250,200,200);
		crates.add(myCrate);
		//c.getChildren().add(myCrate.getBody());
		
		for(int i = 0; i<crates.size(); i++){
			c.getChildren().add(crates.get(i).getBody());
		}*/
		
		HBox north = new HBox();
		north.setAlignment(Pos.CENTER);
		north.setStyle("-fx-background-color: gold");
		Text text = new Text();
			text.setFont(Font.font("Impact",60));
			text.setTextAlignment(TextAlignment.CENTER);
			text.setText("Bouncer");
		north.getChildren().add(text);
		//north.getChildren().add(
		
		control = co.box;
		/*east.setStyle("-fx-background-color: greenyellow");
		Text t = new Text();
			t.setFont(Font.font("Impact",24));
			t.setTextAlignment(TextAlignment.CENTER);
			t.setText("Control:");
		east.getChildren().add(t);
		east.getChildren().add(Control.nodes);*/
		
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: skyblue");
		root.setCenter(c);
		//root.setLeft(west);
		root.setTop(north);
		root.setRight(control);
		//root.setBottom(south);
		
		primaryStage.setScene(new Scene(root, 1000, 800));
		primaryStage.show();
		
		startAnimation();
	}
	
	private void startAnimation(){
		timeline = new Timeline(new KeyFrame(Duration.millis(25),ae -> doSomething()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private void doSomething(){
		for(Crate cr:crates){
			Pane body = cr.getBody();
			body.setLayoutX(body.getLayoutX()+cr.getxSped());
			body.setLayoutY(body.getLayoutY()+cr.getySped());
			
			//hit other by left or right
			for(int i = 0; i<crates.size(); i++){
				//hit other by left or right
				if(crates.get(i).getBody().getLayoutX()> body.getLayoutX()+body.getWidth()){
					if(body.getLayoutY()>=crates.get(i).getBody().getLayoutY()-crates.get(i).getBody().getHeight() && body.getLayoutY() <= crates.get(i).getBody().getLayoutY()+crates.get(i).getBody().getHeight()){
						if(body.getLayoutX()+body.getWidth() + cr.getxSped() >= crates.get(i).getBody().getLayoutX() + crates.get(i).getxSped()){
							cr.setxSped(-cr.getxSped());
							crates.get(i).setxSped(-crates.get(i).getxSped());
						}
					}
				}
				//hit other by top or bottom
				if(crates.get(i).getBody().getLayoutY() + crates.get(i).getBody().getHeight() < body.getLayoutY()){
					if(body.getLayoutX() >= crates.get(i).getBody().getLayoutX() - crates.get(i).getBody().getWidth() && body.getLayoutX() <= crates.get(i).getBody().getLayoutX() + crates.get(i).getBody().getWidth()){
						if(body.getLayoutY() + cr.getySped() <= crates.get(i).getBody().getLayoutY() + crates.get(i).getBody().getHeight() + crates.get(i).getySped()){
							cr.setySped(-cr.getySped());
							crates.get(i).setySped(-crates.get(i).getySped());
						}
					}
				}
			}
			
			//right side
			if(body.getLayoutX() + body.getWidth() + cr.getxSped() >= playField.getWidth()){
				int num = - (int)(Math.random()*12)+3;
				cr.setxSped(num);
				
			//left side
			}else if(body.getLayoutX() + cr.getxSped() <= 0){
				int num = (int)(Math.random()*12)+3;
				cr.setxSped(num);
			}
			//bottom side
			if(body.getLayoutY() + body.getHeight() + cr.getySped() >= playField.getHeight()){
				int num = -(int)(Math.random()*12)+3;
				cr.setySped(num);
				
			//top side
			}else if(body.getLayoutY() - cr.getySped() <= 0){
				int num = (int)(Math.random()*12)+3;
				cr.setySped(num);
			}
			if(cr.getySped() == 0){ cr.setySped((int)(Math.random()*12)+3);}
			if(cr.getxSped() == 0){ cr.setxSped((int)(Math.random()*12)+3);}
		}
		
	}
}