package com.training.stream.tp4;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilter {
    public static void main(String[] args) throws IOException {

//        En passant par l’API Stream et la méthode filter:
//        lister tous les fichiers «.java» dans le répertoire parent et les sous-répertoires

        //récupérer les fichiers du répertoire parent
        final Path path= Paths.get("..");
        final Stream<Path> list = Files.walk(path);
        //on cherche les fichiers avec extention java
        final Predicate<Path> predicate = p -> p.toString().endsWith(".java");

        list.filter(predicate).forEach(System.out::println);
    }
}