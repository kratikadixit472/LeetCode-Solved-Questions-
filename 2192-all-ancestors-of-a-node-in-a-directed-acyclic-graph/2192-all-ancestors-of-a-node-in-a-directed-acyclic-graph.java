class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        int[] indegree = new int[n];
        
        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        LinkedList<Integer> q = new LinkedList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Set<Integer>> sets = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            sets.add(new HashSet<>());
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int parent = q.poll();
            for(int child : map.getOrDefault(parent, new ArrayList<>())){
                sets.get(child).add(parent);
                sets.get(child).addAll(sets.get(parent));
                if(--indegree[child] == 0) 
                    q.add(child);
            }
        }
        
        for(Set<Integer> set : sets){
            
            List<Integer> al = new ArrayList<>();
            for(int ele : set) al.add(ele);
            Collections.sort(al);
            ans.add(al);
        }
        return ans;
    }
}