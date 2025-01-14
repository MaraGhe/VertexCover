import graph.Graph;
import algorithms.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Main {
    static String[] inputFiles = {"test_1_null_graph.in", "test_2_isolated_vertexes.in", "test_3_multiple_isolated_vertexes.in", "test_4_separate_components_1.in",
            "test_5_separate_components_2.in", "test_6_separate_components_3.in", "test_7_separate_components_4.in", "test_8_line_graph_small.in",
            "test_9_line_graph_medium.in", "test_10_line_graph_large.in", "test_11_circular_graph_medium.in", "test_12_circular_graph_large.in",
            "test_13_tree_balanced.in", "test_14_tree_unbalanced.in", "test_15_tree_multiple.in", "test_16_connected_graph_small.in",
            "test_17_connected_graph_medium.in", "test_18_connected_graph_large.in", "test_19_complete_graph_small.in", "test_20_complete_graph_large.in"
            };
    static String[] outputFiles = {"test_1_null_graph.out", "test_2_isolated_vertexes.out", "test_3_multiple_isolated_vertexes.out", "test_4_separate_components_1.out",
            "test_5_separate_components_2.out", "test_6_separate_components_3.out", "test_7_separate_components_4.out", "test_8_line_graph_small.out",
            "test_9_line_graph_medium.out", "test_10_line_graph_large.out", "test_11_circular_graph_medium.out", "test_12_circular_graph_large.out",
            "test_13_tree_balanced.out", "test_14_tree_unbalanced.out", "test_15_tree_multiple.out", "test_16_connected_graph_small.out",
            "test_17_connected_graph_medium.out", "test_18_connected_graph_large.out", "test_19_complete_graph_small.out", "test_20_complete_graph_large.out"
            };

    final static int nrOfTests = 20;

    public static void main(String[] args) throws FileNotFoundException {
        Output output;
        for (int i = 0; i < nrOfTests; i++) {
            try {
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

                System.out.println("Testing Backtracking for " + inputFiles[i] + " ....");
                BruteForce bruteForce = new BruteForce(graph);
                output = bruteForce.execute();
                writer.println(output.toString() + "\n");

                System.out.println("Testing Approximation for " + inputFiles[i] + " ....");
                Approximation approximation = new Approximation(graph);
                output = approximation.execute();
                writer.println(output.toString() + "\n");

                System.out.println("Testing Clever Greedy for " + inputFiles[i] + " ....");
                CleverGreedy cleverGreedy = new CleverGreedy(graph);
                output = cleverGreedy.execute();
                writer.println(output.toString() + "\n");

                writer.close();
            } catch (Exception e) {
                System.out.println(e.getMessage() + " for file " + inputFiles[i]);
            }
        }
    }
}