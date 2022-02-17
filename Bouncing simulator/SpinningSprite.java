/*
 * Author: Yufeng Li
 * Instructor: Professor Jamal Ashraf
 * Last Modify Date: 2/13/2020
 * Question: Honor project - Bouncer
 * Description: Have the field to show the Bouncing screen, and the field to control the crate and the sprite
 */

import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.*;
import javafx.scene.transform.Rotate;


public class SpinningSprite extends Sprite{
	/*Pane body = new Pane();
	//Timeline timeline = new Timeline();
	int xSped = (int)(Math.random()*12)+3;;
	int ySped = (int)(Math.random()*12)+3;;
	public double angle = 0; */
	
	/*public Sprite(int w,int h,int x, int y){
		body.setWidth(w);
		body.setHeight(h);
		body.setX(x);
		body.setY(y);
		body.setStroke(Color.BLACK);
		body.setFill(Color.GREEN);
	}*/
	public SpinningSprite(){
		body.setPrefSize(50,50);
		body.setLayoutX(50);
		body.setLayoutY(100);
		//body.setStyle("-fx-background-color: green;");
		//body.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		//body.getTransforms().add(new Rotate(0,100,25));
		Circle c= new Circle();
		c.setRadius(25);
		c.setFill(Color.BLUE);
		c.setCenterX(25);
		c.setCenterY(25);
		body.getChildren().add(c);
		/*Text text = new Text();
			text.setFont(Font.font("Impact",24));
			//text.setTextAlignment(TextAlignment.CENTER);
			text.setText("Crate" );
		body.getChildren().add(text);*/
	}
	
	/*public Pane getBody(){return body;}
	
	public void change(){
		if(body.getWidth() < 10){
			body.setPrefSize(50,50);
		}else{
			body.setPrefSize(body.getWidth()-5,body.getWidth()-5);
		}
	}
	
	public int getxSped(){return xSped;}
	public int getySped(){return ySped;}
	
	public void setxSped(int i){this.xSped = i;}
	public void setySped(int i){this.ySped = i;}*/
}