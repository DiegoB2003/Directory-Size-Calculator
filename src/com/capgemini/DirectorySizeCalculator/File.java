package com.capgemini.DirectorySizeCalculator;

public class File extends FileSystemNode {
    private long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public long getSize() {
        return size;
    }
}

