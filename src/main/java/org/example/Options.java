package org.example;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface Options extends PipelineOptions {

    @Description("Source")
    @Default.String("C:\\beam_result\\input.csv")
    String getSource();
    void setSource(String source);

    @Description("Target")
    @Default.String("C:\\beam_result\\output-")
    String getTarget();
    void setTarget(String target);

    @Description("Sufix")
    @Default.String(".csv")
    String getSufix();
    void setSufix(String sufix);


}
