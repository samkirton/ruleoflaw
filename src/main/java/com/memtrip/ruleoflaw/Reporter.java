package com.memtrip.ruleoflaw;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.tools.Diagnostic;

public class Reporter {

    private final Messager messager;

    Reporter(ProcessingEnvironment env) {
        messager = env.getMessager();
    }

    void printNote(String message) {
        messager.printMessage(Diagnostic.Kind.NOTE, message);
    }

    public void terminate(String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message);
    }
}