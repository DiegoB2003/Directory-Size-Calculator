package com.capgemini.DirectorySizeCalculator;

public class FileSystem {
    private Directory root;
    private Directory current;

    public FileSystem() {
        root = new Directory("/", null);
        current = root;

        // Sample data
        Directory docs = new Directory("docs", root);
        
        Directory school = new Directory("school", docs);
        school.addChild(new File("homework1.pdf", 400));
        school.addChild(new File("homework2.txt", 50));
        
        docs.addChild(school);
        docs.addChild(new File("resume.pdf", 120));
        docs.addChild(new File("notes.txt", 30));

        Directory images = new Directory("images", root);
        images.addChild(new File("photo.jpg", 200));

        root.addChild(docs);
        root.addChild(images);
        root.addChild(new File("readme.md", 10));
    }

    public void ls() {
        for (FileSystemNode node : current.getChildren()) {
            System.out.println(node.getName());
        }
    }

    public void cd(String dirName) {
        if (dirName.equals("..")) {
            if (current.getParent() != null) {
                current = current.getParent();
            }
            return;
        }

        FileSystemNode node = current.getChild(dirName);
        if (node instanceof Directory) {
            current = (Directory) node;
        } else {
            System.out.println("Directory not found: " + dirName);
        }
    }

    public void size() {
        System.out.println("Total size: " + current.getSize());
    }
}

