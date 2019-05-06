package uima;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.uima.jcas.JCas;

import de.aitools.ie.uima.feature.IFeatureType;
import de.aitools.ie.uima.feature.content.TokenNGrams;
import de.aitools.ie.uima.feature.length.TextLength;
import de.aitools.ie.uima.feature.style.POSNGrams;

public class ArgumentativeDiscourseUnitFeatures implements IFeatureType {
	
	
	private IFeatureType tokenNgrams;
	
	private IFeatureType posNgrams;
	
	//private IFeatureType textLength;
	
	

	@Override
	public void initializeFeatureDetermination(Properties configurationProps) {
		this.tokenNgrams = new TokenNGrams();
		this.posNgrams = new POSNGrams();
		//this.textLength = new TextLength();
		
		this.tokenNgrams.initializeFeatureDetermination(configurationProps);
		this.posNgrams.initializeFeatureDetermination(configurationProps);
		//this.textLength.initializeFeatureDetermination(configurationProps);
	}

	@Override
	public void updateCandidateFeatures(JCas jcas, int start, int end) {
		this.tokenNgrams.updateCandidateFeatures(jcas, start, end);
		this.posNgrams.updateCandidateFeatures(jcas, start, end);
		//this.textLength.updateCandidateFeatures(jcas, start, end);
	}

	@Override
	public List<String> determineFeatures(Properties configurationProps, Properties normalizationProps) {
		List<String> featureNames = new ArrayList<String>();
		featureNames.addAll(this.tokenNgrams.determineFeatures(configurationProps, normalizationProps));
		featureNames.addAll(this.posNgrams.determineFeatures(configurationProps, normalizationProps));
		//featureNames.addAll(this.textLength.determineFeatures(configurationProps, normalizationProps));
		return featureNames;
	}

	@Override
	public void initializeFeatureComputation(List<String> allFeatureNames, Properties configurationProps, Properties normalizationProps) {
		this.tokenNgrams = new TokenNGrams();
		this.posNgrams = new POSNGrams();
		//this.textLength = new TextLength();
		
		this.tokenNgrams.initializeFeatureComputation(allFeatureNames, configurationProps, normalizationProps);
		this.posNgrams.initializeFeatureComputation(allFeatureNames, configurationProps, normalizationProps);
		//this.textLength.initializeFeatureComputation(allFeatureNames, configurationProps, normalizationProps);
	}

	@Override
	public List<Double> computeNormalizedFeatureValues(JCas jcas, int start, int end) {
		List<Double> featureValues = new ArrayList<Double>();
		
		featureValues.addAll(this.tokenNgrams.computeNormalizedFeatureValues(jcas, start, end));
		featureValues.addAll(this.posNgrams.computeNormalizedFeatureValues(jcas, start, end));
		//featureValues.addAll(this.textLength.computeNormalizedFeatureValues(jcas, start, end));

		return featureValues;
	}

}