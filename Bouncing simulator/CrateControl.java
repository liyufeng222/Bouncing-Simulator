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

public class CrateControl{
	public ArrayList<SpriteControl> s=new ArrayList<SpriteControl>();
	public VBox ccBody = new VBox();
	public Timeline timeline;
	public Crate crate;
	public int numOfSprite = 1;
	
	public VBox getCcBody(){return ccBody;}
	public ArrayList<SpriteControl> getControlSprite(){ return s;}
	
	public CrateControl(int i){
		crate = new Crate(250,150,250,200, i);
		
		Text text = new Text();
			text.setFont(Font.font("Impact",30));
			text.setTextAlignment(TextAlignment.CENTER);
			text.setText("Crate" + i);
			text.setFill(Color.PURPLE);
			
		Button b1 = new Button();
			b1.setText("Delete");
			b1.setOnAction(new EventHandler<ActionEvent>(){
	        	public void handle(ActionEvent event){
		    		delete();
        		}
        	});
		
		Button b2 = new Button();
			b2.setText("AddSprite");
			b2.setOnAction(new EventHandler<ActionEvent>(){
	        	public void handle(ActionEvent event){
		    		addSprite(numOfSprite);
					numOfSprite += 1;
        		}
        	});
			
		HBox box = new HBox();
		//box.setAlignment(Pos.CENTER);
		box.getChildren().add(text);
		box.getChildren().add(b1);
		box.getChildren().add(b2);
		/*for(int r = 0; r < s.size(); r++){
			box.getChildren().add(s.get(r).node);
		}
		
		nodes = box;*/
		ccBody.getChildren().add(box);
	}
	
	public void addSprite(int i){
		SpriteControl cs = new SpriteControl(i);
		crate.getSprite().add(cs.sprite);
		crate.getBody().getChildren().add(cs.sprite.getBody());
		ccBody.getChildren().add(cs.getBody());
		s.add(cs);
	}
	
	public void delete(){
		Bouncer.getCrates().remove(crate);
		Bouncer.getPlayField().getChildren().remove(crate.getBody());
		Bouncer.control.getChildren().remove(ccBody);
	}
		
		
	//public Node getNode(){ return nodes;}
	
}