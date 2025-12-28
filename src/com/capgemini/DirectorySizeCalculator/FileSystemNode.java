package com.capgemini.DirectorySizeCalculator;

public abstract class FileSystemNode {
    protected String name;

    public FileSystemNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract long getSize();
}
