class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
          Map<String, List<Integer>> employeeAccessMap = new HashMap<>();


        for (List<String>access : access_times) {
            String employeeName = access.get(0);
            int time = Integer.parseInt(access.get(1));

            if (!employeeAccessMap.containsKey(employeeName)) {
                employeeAccessMap.put(employeeName, new ArrayList<>());
            }

            employeeAccessMap.get(employeeName).add(time);
        }

        List<String> highAccessEmployees = new ArrayList<>();

 
        for (Map.Entry<String, List<Integer>> entry : employeeAccessMap.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            for (int i = 0; i < times.size() - 2; i++) {
                if (times.get(i + 2) - times.get(i) < 100) {
                    highAccessEmployees.add(entry.getKey());
                    break;
                }
            }
        }

        return highAccessEmployees;
        
    }
}
