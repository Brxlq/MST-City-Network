package mst;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class JSONUtils {
    private static final Gson G = new GsonBuilder().setPrettyPrinting().create();

    public static void writeResults(List<MSTResult> list, String filename) throws IOException {
        try (Writer w = new FileWriter(filename)) {
            G.toJson(list, w);
        }
    }
}
