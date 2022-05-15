package org.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PDone;

public class BasicApacheBeam {
    public static void main(String args[]){

        //Read from args
        PipelineOptionsFactory.register(Options.class);
        Options options = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);

        //Create Pipeline
        Pipeline pipeline=Pipeline.create();

        //Extract
        PCollection<String> inputData = pipeline.apply(TextIO.read().from(options.getSource()));


        //Transform (Uppercase)
        PCollection<String> transformData = inputData.apply(ParDo.of(new SimpleFunction()));

        //Load
        transformData.apply(TextIO.write().to(options.getTarget()).withNumShards(1).withSuffix(options.getSufix()));

        pipeline.run();
    }

}