package edu.neu.coe.info6205.union_find;

public class HWQUPC_Solution {
    public static void main(String args[]) {

        for (int n = 100; n < 10000; n+=1000) {
            System.out.println("===========================================================");
            System.out.println("Number of nodes: " + n);
            int connections = count(n);
            System.out.println("Number of connections:" + connections);
        }
    }

    private static int count(int n) {

        long averageConnections = 0;
        long averagePairs = 0;
        int runs = 10;


        for(int i =0; i< runs; i++) {
            int pairs = 0;
            int connections = 0;
            UF_HWQUPC uf = new UF_HWQUPC(n);
            while (uf.components() != 1) {
                int x = (int) (Math.random() * (n));
                int y = (int) (Math.random() * (n));
                pairs += 1;
                if (uf.connected(x, y) == false) {
                    uf.union(x, y);
                    connections++;
                }
            }
            averagePairs += pairs;
            averageConnections += connections;
        }

        averagePairs /= runs;
        averageConnections /= runs;

        System.out.println("Number of pairs:" + (int)averagePairs);

        return (int)averageConnections;
    }
}
