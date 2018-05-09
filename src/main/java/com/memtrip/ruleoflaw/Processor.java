package com.memtrip.ruleoflaw;

import com.google.auto.service.AutoService;
import com.memtrip.ruleoflaw.model.Source;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.HashSet;
import java.util.Set;

@AutoService(javax.annotation.processing.Processor.class)
public class Processor extends AbstractProcessor {

    private Reporter reporter;

	@Override
	public synchronized void init(ProcessingEnvironment env) {
        reporter = new Reporter(env);
	}

    @Override
	public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment env) {
        Set<? extends Element> elements = env.getElementsAnnotatedWith(Law.class);

        Source source = new Source(reporter);

        if (elements != null && elements.size() > 0) {
			for (Element element : elements) {
		        if (element.getKind() == ElementKind.ANNOTATION_TYPE) {
                    source.verify(element, env);
                } else {
		            throw new IllegalStateException("@Law is marked with @Target(ANNOTATION_TYPE), " +
                            "unless an erroneous change is made to the library, this will never be reached.");
                }
			}
        }

        source.checkResults();

        return true;
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> set = new HashSet<>();
		set.add(Law.class.getCanonicalName());
		return set;
	}
}