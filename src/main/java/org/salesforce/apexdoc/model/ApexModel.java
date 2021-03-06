package org.salesforce.apexdoc.model;

import java.util.List;
import java.util.Map;

import org.salesforce.apexdoc.ApexDoc;

public abstract class ApexModel {

    private String nameLine;
    private int inameLine;
    private String description;
    private String author;
    private String date;
    private String returns;
    private String scope;
    
    public String getNameLine() {
        return nameLine;
    }

    public int getInameLine() {
        return inameLine;
    }

    public void setNameLine(String nameLine, int iLine) {
        this.nameLine = nameLine.trim();
        this.inameLine = iLine;
        parseScope();
    }

    public String getDescription() {
        return description == null ? "" : description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author == null ? "" : author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date == null ? "" : date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReturns() {
        return returns == null ? "" : returns;
    }

    public void setReturns(String returns) {
        this.returns = returns;
    }

    public String getScope() {
        return scope == null ? "" : scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    private void parseScope() {
        scope = null;
        if (nameLine != null) {
            String str = ApexDoc.strContainsScope(nameLine);
            if (str != null)
                scope = str;
        }
    }
    
    public abstract void mergeDocBlockData(Map<String, List<String>> data);

}