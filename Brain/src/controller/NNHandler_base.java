package controller;

import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;

public abstract class NNHandler_base {
	protected MultiLayerPerceptron nn;
	protected DataSet ds;
	
	public NNHandler_base(){
		this.nn=createNN();
	}

	protected abstract MultiLayerPerceptron createNN();
	
	public void loadDataSet(DataSet d){
		this.ds=d;
	}
	
	public void learn(){
		this.ds.shuffle();	
		nn.learnInNewThread(this.ds);
		nn.calculate();
	}
	
	public void toFile(String filename){
		nn.save(filename);
	}
	
	public void toFile(){
		nn.save("default_filename");
	}

}