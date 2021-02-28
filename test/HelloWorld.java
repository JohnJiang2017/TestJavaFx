package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public HelloWorld() {
		
	}
	
	// helper function to create series data from tuples (each tuple is a (x,y) pair)
	private void addPoints(XYChart.Series series, Tuple[] tuples) {
		int size = tuples.length;
		int i;
		
		for (i=0; i<size; i++) {
			series.getData().add(new XYChart.Data(tuples[i].x, tuples[i].y));
		}
	}

	// helper function to create line chart from two arrays of tuples
	private LineChart createLineChart(Tuple[] firstDataTuples, Tuple[] secondDataTuples) {
		// Define Axis
		NumberAxis xAxis = new NumberAxis(1960, 2020, 10);
		xAxis.setLabel("Years");
		
		NumberAxis yAxis = new NumberAxis(0, 350, 50);
		yAxis.setLabel("No. of Schools");
		
		LineChart lineChart = new LineChart(xAxis, yAxis);
		
		// prepare series of data
		XYChart.Series series1 = new XYChart.Series<>();
		series1.setName("No of Schools in a Year");		
		
		XYChart.Series series2 = new XYChart.Series<>();
		series2.setName("Another No of Schools in a Year");
		
		// call helper method "addPoints", to convert tuples to series data
		addPoints(series1, firstDataTuples);		
		addPoints(series2, secondDataTuples);
		
		// set the data to line chart
		lineChart.getData().addAll(series1, series2);
		return lineChart;		
	}
	
	private LineChart createFirstChart() {
		Tuple[] firstDataTuples = {
				new Tuple(1960, 85), 
				new Tuple(1980, 25),
				new Tuple(1990, 35),
				new Tuple(2000, 175),
				new Tuple(2013, 220),
				new Tuple(2017, 290)				
		};
		
		Tuple[] secondDataTuples = {
				new Tuple(1970, 35), 
				new Tuple(1980, 45),
				new Tuple(1990, 55),
				new Tuple(200, 160),
				new Tuple(2013, 199),
				new Tuple(2017, 270)				
		};		
		
		return createLineChart(firstDataTuples, secondDataTuples);
	}	
	
	private LineChart createSecondChart() {
		Tuple[] firstDataTuples = {
				new Tuple(1960, 85), 
				new Tuple(1980, 25),
				new Tuple(1990, 35),
				new Tuple(2000, 175),
				new Tuple(2013, 220),
				new Tuple(2017, 290)				
		};
		
		Tuple[] secondDataTuples = {
				new Tuple(1970, 35), 
				new Tuple(1980, 45),
				new Tuple(1990, 55),
				new Tuple(200, 160),
				new Tuple(2013, 199),
				new Tuple(2017, 270)				
		};		
		
		return createLineChart(firstDataTuples, secondDataTuples);
	}		
	
	private LineChart createThirdChart() {
		Tuple[] firstDataTuples = {
				new Tuple(1960, 85), 
				new Tuple(1980, 25),
				new Tuple(1990, 35),
				new Tuple(2000, 175),
				new Tuple(2013, 220),
				new Tuple(2017, 290)				
		};
		
		Tuple[] secondDataTuples = {
				new Tuple(1970, 35), 
				new Tuple(1980, 45),
				new Tuple(1990, 55),
				new Tuple(200, 160),
				new Tuple(2013, 199),
				new Tuple(2017, 270)				
		};		
		
		return createLineChart(firstDataTuples, secondDataTuples);
	}	

	private LineChart createFourthChart() {
		Tuple[] firstDataTuples = {
				new Tuple(1960, 85), 
				new Tuple(1980, 25),
				new Tuple(1990, 35),
				new Tuple(2000, 175),
				new Tuple(2013, 220),
				new Tuple(2017, 290)				
		};
		
		Tuple[] secondDataTuples = {
				new Tuple(1970, 35), 
				new Tuple(1980, 45),
				new Tuple(1990, 55),
				new Tuple(200, 160),
				new Tuple(2013, 199),
				new Tuple(2017, 270)				
		};		
		
		return createLineChart(firstDataTuples, secondDataTuples);
	}		

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		// create vertical box, and two horizontal boxes
		VBox vbox = new VBox();
		HBox firstRow = new HBox();
		HBox secondRow = new HBox();
		
		// create 4 charts
		LineChart firstLineChart = this.createFirstChart();		
		LineChart secondLineChart = this.createSecondChart();
		LineChart thirdLineChart = this.createThirdChart();		
		LineChart fourthLineChart = this.createFourthChart();				

		// add charts to the first horizontal box
		firstRow.getChildren().add(firstLineChart);
		firstRow.getChildren().add(secondLineChart);			
		
		// add charts to the second horizontal box
		secondRow.getChildren().add(thirdLineChart);
		secondRow.getChildren().add(fourthLineChart);		
	
		// add two horizontal boxes to the vertical box
		vbox.getChildren().add(firstRow);
		vbox.getChildren().add(secondRow);
		
		// set up the scene
		Scene scene = new Scene(vbox, 1200, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My Charts");
		primaryStage.show();
	}

}
