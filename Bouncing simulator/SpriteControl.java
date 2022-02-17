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



public class SpriteControl{
	public HBox body = new HBox();
	public Timeline timeline;
	public Sprite sprite = new SpinningSprite();
	//public double angle = 0; 
	
	public HBox getBody(){return body;}
	
	public SpriteControl(int i){
		Text text = new Text();
			text.setFont(Font.font("Impact",24));
			text.setTextAlignment(TextAlignment.CENTER);
			text.setText("Sprite" + i);
			
		Button b1 = new Button();
			b1.setText("Delete");
			
			b1.setOnAction(new EventHandler<ActionEvent>(){
	        	public void handle(ActionEvent event){
		    		delete();
        		}
        	});
			
		Button b2 = new Button();
			b2.setText("Go");
			
			b2.setOnAction(new EventHandler<ActionEvent>(){
	        	public void handle(ActionEvent event){
		    		if(b2.getText().equals("Go")){
			    		b2.setText("Stop");
			    		if(timeline != null){
				 	   	timeline.stop();
		    			}
	    				timeline = new Timeline(new KeyFrame(Duration.millis(25),ae -> morph()));
	    				timeline.setCycleCount(Animation.INDEFINITE);
	    				timeline.play();
	    			}else{
	    				//System.out.println("Bye bye");
	    				b2.setText("Go");
	    				timeline.stop();
	    			}
        		}
        	});
			
		Button b3 = new Button();
			b3.setText("morph");
			b3.setOnAction(new EventHandler<ActionEvent>(){
	        	public void handle(ActionEvent event){
					Crate currentCrate = null;
					for(Crate cr : Bouncer.getCrates()){
						if(cr.getSprite().indexOf(sprite)>=0){
							currentCrate = cr;
							break;
						}
					}
		    		if(sprite instanceof SpinningSprite){
						currentCrate.getBody().getChildren().remove(sprite.getBody());
						currentCrate.getSprite().remove(sprite);
						sprite = new Sprite();
						currentCrate.getBody().getChildren().add(sprite.getBody());	
						currentCrate.getSprite().add(sprite);
					}else{
						currentCrate.getBody().getChildren().remove(sprite.getBody());
						currentCrate.getSprite().remove(sprite);
						sprite = new SpinningSprite();
						currentCrate.getBody().getChildren().add(sprite.getBody());	
						currentCrate.getSprite().add(sprite);
					}
				
        		}
        	});
	
		//HBox box = new HBox();
		//box.setAlignment(Pos.CENTER);
		body.getChildren().addAll(text,b1,b2,b3);
		
		//node = box;
	}
	
	public void delete(){
		Crate currentCrate = null;
		for(Crate cr : Bouncer.getCrates()){
			if(cr.getSprite().indexOf(sprite)>=0){
				currentCrate = cr;
				break;
			}
		}
		if(currentCrate != null){
			currentCrate.getBody().getChildren().remove(sprite.getBody());
			currentCrate.getSprite().remove(sprite);
		}else{
			System.out.println("Crate not found");
		}
		
		CrateControl currentCrateControl = null;
		for(CrateControl crCon : Bouncer.getControl().getControlCrate()){
			if(crCon.getCcBody().getChildren().indexOf(body)>=0){
				currentCrateControl = crCon;
				//crCon.getChildren().remove(body);
				break;
			}
		}
		if(currentCrateControl != null){
			currentCrateControl.getCcBody().getChildren().remove(body);
			currentCrateControl.getControlSprite().remove(sprite);
		}else{
			System.out.println("Crate not found");
		}
	}
	
	
	public void morph(){
		sprite.change();
	}
	//public void 
	//public ArrayList<Node> getNode(){ return nodes;}
	
}