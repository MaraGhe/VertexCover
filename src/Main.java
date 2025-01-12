import graph.Graph;
import algorithms.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class Main {
    static String[] inputFiles = {"test_1_one_isolated_vertex.in", "test_2_multiple_isolated_vertexes.in",
            "test_3_separate_components.in", "test_4_large_line_graph.in", "test_5_circular_graph.in",
            "test_6_balanced_tree.in", "test_7_unbalanced_tree.in", "test_8_small_connected_graph.in",
            "test_9_medium_connected_graph.in", "test_10_large_connected_graph.in",
            "test_11_small_complete_graph.in", "test_12_large_complete_graph.in"};
    static String[] outputFiles = {"test_1_one_isolated_vertex.out", "test_2_multiple_isolated_vertexes.out",
            "test_3_separate_components.out", "test_4_large_line_graph.out", "test_5_circular_graph.out",
            "test_6_balanced_tree.out", "test_7_unbalanced_tree.out", "test_8_small_connected_graph.out",
            "test_9_medium_connected_graph.out", "test_10_large_connected_graph.out",
            "test_11_small_complete_graph.out", "test_12_large_complete_graph.out"};

    final static int nrOfTests = 12;

    public static void main(String[] args) throws FileNotFoundException {
        Output output;
        for (int i = 0; i < nrOfTests; i++) {
            //try {
                Scanner scanner = new Scanner(new File("input/" + inputFiles[i]));

                int N, M;
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                N = Integer.parseInt(parts[0]);
                M = Integer.parseInt(parts[1]);
                Graph graph = new Graph(N);

                for (int j = 0; j < M; j++) {
                    line = scanner.nextLine();
                    parts = line.split(" ");
                    graph.addEdge(Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[1]) - 1);
                }

                PrintWriter writer = new PrintWriter("output/" + outputFiles[i]);

                System.out.println("Brute force for " + inputFiles[i] + " ....");
                BruteForce bruteForce = new BruteForce(graph);
                output = bruteForce.execute();
                writer.println(output.toString());

                writer.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage() + " for file " + inputFiles[i]);
//            }
        }
    }
}