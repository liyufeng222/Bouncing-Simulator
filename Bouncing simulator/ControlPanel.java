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

public class ControlPanel{
	public static ArrayList<CrateControl> c=new ArrayList<CrateControl>();
	//public static Node nodes;
	public Timeline timeline;
	public static VBox box;
	Bouncer b;
	
	public static ArrayList<CrateControl> getControlCrate(){ return c;}
	
	public ControlPanel(){
		HBox a = new HBox();
		
		Text text = new Text();
			text.setFont(Font.font("Impact",36));
			text.setTextAlignment(TextAlignment.CENTER);
			text.setText("Control");
			text.setFill(Color.RED);
		
		Button b2 = new Button();
			b2.setText("Add");
			
		a.getChildren().addAll(text,b2);
		
		b2.setOnAction(new EventHandler<ActionEvent>(){
	        	public void handle(ActionEvent event){
		    		addCrate(Bouncer.numOfCrate);
					Bouncer.numOfCrate += 1;
        		}
        	});
			
		box = new VBox();
		box.setStyle("-fx-background-color: greenyellow");
		//box.setAlignment(Pos.CENTER);
		//box.getChildren().add(text);
		box.getChildren().add(a);
		/*for(int i = 0; i < c.size(); i++){
			box.getChildren().add(c.get(i).nodes);
		}*/
		
		//nodes = box;
		//Bouncer.control.getChildren().add(box);
	}
	
	public void addCrate(int i){
		CrateControl cc = new CrateControl(i);
		c.add(cc);
		/*for(int r = 0; r < c.size(); r++){
			box.getChildren().add(c.get(r).nodes);
		}*/
		//Bouncer.getEast().getChildren().remove(this.nodes);
		//Bouncer.getEast().getChildren().add(this.nodes);
		Bouncer.getCrates().add(cc.crate);
		Bouncer.getPlayField().getChildren().add(cc.crate.getBody());
		//Bouncer.east = box;
		//Bouncer.getEast().getChildren().clear();
		//Bouncer.getEast().getChildren().add(cc.nodes);
		Bouncer.control.getChildren().add(cc.getCcBody());
	}
	
	//public ArrayList<Node> getNode(){ return nodes;}
	
	
	
}