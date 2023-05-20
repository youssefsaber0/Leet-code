class Solution {
    void buildGraph(List<List<String>> equations, double[] values, Map<String,List<String>> adjList,Map<String,List<Double>> adjWeight){
        for(int i = 0; i < values.length;i++){
            List<String> adjElement1 = adjList.get(equations.get(i).get(0));
            List<String> adjElement2 = adjList.get(equations.get(i).get(1));
            List<Double> values1 = adjWeight.get(equations.get(i).get(0));
            List<Double> values2 = adjWeight.get(equations.get(i).get(1));
            if(adjElement1 == null){
                adjElement1 = new ArrayList<>();
                adjList.put(equations.get(i).get(0) ,adjElement1);
                values1 = new ArrayList<>();
                adjWeight.put(equations.get(i).get(0) ,values1);

            }
            if(adjElement2 == null){
                adjElement2 = new ArrayList<>();
                adjList.put(equations.get(i).get(1) ,adjElement2);
                values2 = new ArrayList<>();
                adjWeight.put(equations.get(i).get(1) ,values2);
            }
            adjElement1.add(equations.get(i).get(1));
            adjElement2.add(equations.get(i).get(0));
            values1.add(values[i]);
            values2.add(1/values[i]);
        }
    }
    public double dfs (Map<String, List<String>> map,Map<String,List<Double>> adjWeight, Set<String> set, String u, String v) {
        if (!map.containsKey (u) || !map.containsKey (v)) {
            return -1;
        }
        else if (u.equals (v)) {
            return 1;
        }
        List<String> adjS = map.get (u);
        List<Double> values = adjWeight.get(u); 
        for (int i =0 ;i<adjS.size() ;i++) {
            String adj = adjS.get(i);
            if (set.contains (adj)) {
                continue;
            }
            else if (adj.equals (v)) {
                return values.get(i);
            }
            
            set.add (u);
            double val = dfs (map, adjWeight,set, adj, v);
            if (val != -1) {
                return val * values.get(i);
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<String>> adjList = new HashMap<>();
        Map<String,List<Double>> adjWeight = new HashMap<>();
        buildGraph(equations, values, adjList, adjWeight);
        double[] answer = new double[queries.size ()];
        for (int i = 0; i < answer.length; i++) {
            List<String> query = queries.get (i);
            answer[i] = dfs (adjList, adjWeight,new HashSet<> (), query.get(0), query.get(1));
        }
        return answer;
    }
}