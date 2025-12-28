package com.capgemini.DirectorySizeCalculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                break;
            } else if (input.equals("ls")) {
                fs.ls();
            } else if (input.startsWith("cd ")) {
                fs.cd(input.substring(3));
            } else if (input.equals("size")) {
                fs.size();
            } else {
                System.out.println("Unknown command");
            }
        }
        scanner.close();
    }
}

