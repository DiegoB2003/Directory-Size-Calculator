package com.capgemini.DirectorySizeCalculator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;

public class Directory extends FileSystemNode {
    private Map<String, FileSystemNode> children = new LinkedHashMap<>();
    private Directory parent;

    public Directory(String name, Directory parent) {
        super(name);
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public void addChild(FileSystemNode node) {
        children.put(node.getName(), node);
    }

    public FileSystemNode getChild(String name) {
        return children.get(name);
    }

    public Collection<FileSystemNode> getChildren() {
        return children.values();
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemNode child : children.values()) {
            totalSize += child.getSize(); // recursion happens here
        }
        return totalSize;
    }
}

