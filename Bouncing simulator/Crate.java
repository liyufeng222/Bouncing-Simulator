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


public class Crate{
	Pane body = new Pane();
	Timeline timeline = new Timeline();
	int xSped = (int)(Math.random()*12)+3;
	int ySped = (int)(Math.random()*12)+3;
	ArrayList<Sprite> sprite = new ArrayList<Sprite>();
	//Pane c = new Pane();
	//playField = c;
	
	public ArrayList<Sprite> getSprite(){ return sprite;}
	//public Pane getBody(){return body;}
	
	public Crate(int w,int h,int x, int y, int i){
		body.setPrefSize(w,h);
		//body.setHeight(h);
		body.setLayoutX(x);
		body.setLayoutY(y);
		body.setStyle("-fx-background-color: lemonchiffon;");
		body.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Text text = new Text();
			text.setFont(Font.font("Impact",24));
			//text.setTextAlignment(TextAlignment.CENTER);
			text.setText("Crate" + i);
		//body.setFill(Color.LEMONCHIFFON);
		//body.add(c);
		
		/*Sprite mySprite = new Sprite();
		sprite.add(mySprite);
		body.getChildren().add(mySprite.getBody());*/
		body.getChildren().add(text);
		startAnimation();
	}
	/*public Crate(){
		body = new Rectangle(250,150);
		body.setStroke(Color.BLACK);
		body.setFill(Color.LEMONCHIFFON);
	}*/
	
	public Pane getBody(){return body;}
	
	public int getxSped(){return xSped;}
	public int getySped(){return ySped;}
	
	public void setxSped(int i){this.xSped = i;}
	public void setySped(int i){this.ySped = i;}
	
	private void startAnimation(){
		timeline = new Timeline(new KeyFrame(Duration.millis(25),ae -> doSomething()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private void doSomething(){
	for(Sprite myR : sprite){
		Pane b = myR.getBody();
		b.setLayoutX(b.getLayoutX()+myR.getxSped());
		b.setLayoutY(b.getLayoutY()+myR.getySped());
			//right side
		if(b.getLayoutX() + b.getWidth() + myR.getxSped() >= body.getWidth()){
			int num = - (int)(Math.random()*12)+3;
			myR.setxSped(num);
			
		//left side
		}else if(b.getLayoutX() + myR.getxSped() <= 0){
			int num = (int)(Math.random()*12)+3;
			myR.setxSped(num);
		}
		//bottom side
		if(b.getLayoutY() + b.getHeight() + myR.getySped() >= body.getHeight()){
			int num = -(int)(Math.random()*12)+3;
			myR.setySped(num);
			
			//top side
		}else if(b.getLayoutY() - myR.getySped() <= 0){
			int num = (int)(Math.random()*12)+3;
			myR.setySped(num);
		}
		if(myR.getySped() == 0){ myR.setySped((int)(Math.random()*12)+3);}
		if(myR.getxSped() == 0){ myR.setxSped((int)(Math.random()*12)+3);}
	}
		
	}
}