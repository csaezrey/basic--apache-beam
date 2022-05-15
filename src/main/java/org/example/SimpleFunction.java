package org.example;

import org.apache.beam.sdk.transforms.DoFn;

public class SimpleFunction extends DoFn <String, String>{
    @ProcessElement
    public void processElement(ProcessContext context){
        String element = context.element();
        context.output(element.toUpperCase());
    }
}
