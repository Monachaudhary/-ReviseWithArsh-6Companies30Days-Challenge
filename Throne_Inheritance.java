import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> familyTree;
    private Set<String> deadPeople;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.deadPeople = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        familyTree.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        deadPeople.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(king);

        while (!stack.isEmpty()) {
            String person = stack.pop();
            if (!deadPeople.contains(person)) {
                inheritanceOrder.add(person);
            }

            List<String> children = familyTree.getOrDefault(person, new ArrayList<>());
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        return inheritanceOrder;
    }

   
}
