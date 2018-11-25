import java.util.*;

/**
 * Created by sergii on 25.11.18.
 */
public class Holder {

    private Map<String, Group> groups;

    public Holder(List<Model> list) {
        groups = new HashMap<>();
        for (Model m : list) {
            Group group = groups.get(m.getPackageName());
            if (group == null) {
                group = new Group(m.getPackageName());
                groups.put(m.getPackageName(), group);
            }
            group.add(m);
        }
    }

    public void update(List<Model> alist) {
        List<Model> newItems = new ArrayList<>();
        for (Model m : alist) {
            Group group = groups.get(m.getPackageName());
            if (!group.list.contains(m)) {
                group.list.add(m);
            }
        }

        List<String> p = new ArrayList<>();
        for (Group group : groups.values()) {
            Iterator<Model> iterator = group.list.iterator();
            while (iterator.hasNext()) {
                Model m = iterator.next();
                if (!alist.contains(m)) {
                    iterator.remove();
                    if (group.list.isEmpty()) {
                        p.add(group.packageName);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "holder: " + groups;
    }

    static class Group {
        private String packageName;
        private List<Model> list;

        public Group(String packageName) {
            this.packageName = packageName;
            list = new ArrayList();
        }

        @Override
        public String toString() {
            return "package: " + packageName + ":" + list;
        }

        public void add(Model m) {
            list.add(m);
        }
    }
}
